package com.murismo;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;

import com.sun.jna.ptr.IntByReference;
import java.util.Optional;

import static com.sun.jna.platform.win32.WinNT.*;


public class Main {

    public static final int PROCESS_ALL_ACCESS = 0x1F0FFF;
    public static final long CLOUD_CHARACTER= 0xDBFD8D;

    public static final LetterMapper letterMapper = new LetterMapper();

    public static final HANDLE handle = openProcess(PROCESS_ALL_ACCESS, getPid("FINAL FANTASY VII"))
            .orElseThrow();


    public static void main(String[] args) throws InterruptedException {
        updateCloudLevel(99);
        updateCloudStrength(255);
        updateCloudName("Chungus");

        var masamune = 127;
        updateCloudWeapon(masamune);


//        for (int i = 0; i < 200; i++) {
//            Thread.sleep(100);
//            System.out.println(i);
//
//        }

    }

    public static void updateCloudLevel(int level){
        Pointer address = new Pointer(CLOUD_CHARACTER);
        packAndWriteSingle((byte) level, address);
    }

    public static void updateCloudStrength(int strength){
        long offset = 1;
        Pointer address = new Pointer(CLOUD_CHARACTER+offset);
        packAndWriteSingle((byte) strength, address);
    }

    public static void updateCloudWeapon(int weapon){
        long offset = 27;
        Pointer address = new Pointer(CLOUD_CHARACTER+offset);
        packAndWriteSingle((byte) weapon, address);
    }

    public static void updateCloudName(String name){
        long offset = 15;
        Pointer address = new Pointer(CLOUD_CHARACTER+offset);

        byte[] convertedName = letterMapper.convertStringToFF7(name);

        packAndWriteMulti(convertedName, address);
    }

    private static void packAndWriteMulti(byte[] bytes, Pointer address) {
        int size = bytes.length;
        Memory toWrite = new Memory(size);

        for (int i = 0; i < size; i++) {
            toWrite.setByte(i, bytes[i]);
        }

        if(!Write(handle, address, toWrite, size, null)){
            throw new RuntimeException("Unable to complete write");
        };
    }

    public static void packAndWriteSingle(byte data, Pointer address) {
        byte[] level = new byte[]{data};

        int size = level.length;
        Memory toWrite = new Memory(size);

        for (int i = 0; i < size; i++) {
            toWrite.setByte(i, level[i]);
        }

        if(!Write(handle, address, toWrite, size, null)){
            throw new RuntimeException("Unable to complete write");
        };
    }

    public static boolean Write(HANDLE handle, Pointer address, Pointer buffer, int size, IntByReference bytesWritten){
        return Kernel32.INSTANCE.WriteProcessMemory(handle, address, buffer, size, bytesWritten);
    }

    public static Optional<HANDLE> openProcess(int permissions, int pid) {
        return Optional.of(Kernel32.INSTANCE.OpenProcess(permissions, false, pid));
    }

    public static int getPid(String window)
    {
        var hwnd = User32.INSTANCE.FindWindow("DEFAULT CLASS", window );
        var pid = new IntByReference();
        User32.INSTANCE.GetWindowThreadProcessId(hwnd, pid);
        return pid.getValue();
    }
}