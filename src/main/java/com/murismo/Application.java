package com.murismo;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;

import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

import java.util.List;
import java.util.stream.Stream;

import static com.sun.jna.platform.win32.WinNT.*;


public class Application {

    public static final int PROCESS_ALL_ACCESS = 0x1F0FFF;
    public static final long CLOUD_CHARACTER= 0xDBFD8D;

    public final LetterMapper letterMapper = new LetterMapper();

    public HANDLE handle;

    public static void main(String[] args) {

        Application app = new Application();
        Gui gui = new Gui(app);
        gui.start();

    }

    public boolean connectToGame(){

        this.handle = openProcess(PROCESS_ALL_ACCESS, getPid("FINAL FANTASY VII"));

        return this.handle != null;

    }

    public void updateCloudLevel(int level) {
        Pointer address = new Pointer(CLOUD_CHARACTER);
        packAndWrite(new byte[]{(byte) level}, address);
    }

    public void updateCloudStrength(int strength){
        long offset = 1;
        Pointer address = new Pointer(CLOUD_CHARACTER+offset);
        packAndWrite(new byte[]{(byte) strength}, address);
    }

    public void updateCloudWeapon(int weapon){
        long offset = 27;
        Pointer address = new Pointer(CLOUD_CHARACTER+offset);
        packAndWrite(new byte[]{(byte) weapon}, address);
    }

    public void updateCloudName(String name){ // this should be in a Character class please
        long offset = 15;
        Pointer address = new Pointer(CLOUD_CHARACTER+offset);

        byte[] convertedName = this.letterMapper.convertStringToFF7(name);

        packAndWrite(convertedName, address);
    }



    private void packAndWrite(byte[] bytes, Pointer address) {
        int size = bytes.length;
        Memory toWrite = new Memory(size);

        for (int i = 0; i < size; i++) {
            toWrite.setByte(i, bytes[i]);
        }

        if(!Write(handle, address, toWrite, size, null)){
            throw new RuntimeException("Unable to complete write");
        }
    }

    public String readNameInformation(Pointer address){

        long offset = 15; // need to improve this
        int size = 10;

        try (Memory memory = new Memory(size)) {
            if(!Read(handle, address, memory, size, null)){
                throw new RuntimeException("Unable to complete read");
            }

            byte[] rawName = memory.getByteArray(0, size);

            return letterMapper.convertFF7ToString(rawName);
        }
    }



    public int readStatInformation(Pointer address){
        byte[] level = new byte[1];

        int size = level.length;

        try (Memory memory = new Memory(size)) {
            if(!Read(handle, address, memory, size, null)){
            throw new RuntimeException("Unable to complete read");
        }

            return memory.getByteArray(0, size)[0];
        }
    }

    public boolean Write(HANDLE handle, Pointer address, Pointer buffer, int size, IntByReference bytesWritten){
        return Kernel32.INSTANCE.WriteProcessMemory(handle, address, buffer, size, bytesWritten);
    }

    public boolean Read(HANDLE handle, Pointer address, Pointer buffer, int size, IntByReference bytesRead){
        return Kernel32.INSTANCE.ReadProcessMemory(handle, address, buffer, size, bytesRead);
    }

    public HANDLE openProcess(int permissions, int pid) {
        return Kernel32.INSTANCE.OpenProcess(permissions, false, pid);
    }

    public int getPid(String window)
    {
        var hwnd = User32.INSTANCE.FindWindow("DEFAULT CLASS", window );
        var pid = new IntByReference();
        User32.INSTANCE.GetWindowThreadProcessId(hwnd, pid);
        return pid.getValue();
    }

    public boolean isConnected() {
        return this.handle != null;
    }

    public void disconnect() {
        this.handle = null;
    }
}