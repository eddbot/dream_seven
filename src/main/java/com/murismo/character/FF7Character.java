package com.murismo.character;

import com.murismo.memory.MemoryEngine;
import com.murismo.utils.LetterMapper;
import com.sun.jna.Pointer;

public class FF7Character {

    private final long address;
    private final MemoryEngine engine;
    private final LetterMapper letterMapper;

    private final long LEVEL_OFFSET = 0x00;
    private final long NAME_OFFSET = 0x0f;
    private final String defaultName;




    public FF7Character(String defaultName, long address, MemoryEngine engine) {
        this.defaultName = defaultName;
        this.address = address;
        this.engine = engine;
        this.letterMapper = new LetterMapper();
    }
    public String getDefaultName() {
        return defaultName;
    }

    public void setLevel(int level) {
        Pointer address = calculatePointer(LEVEL_OFFSET);
        engine.packAndWrite(new byte[]{(byte) level}, address);
    }

    public int getLevel(){
        Pointer address = calculatePointer(LEVEL_OFFSET);
        return engine.readStatInformation(address);
    }

    private Pointer calculatePointer(long offset){
        return new Pointer(this.address+offset);
    }


    public void setName(String name){
        Pointer address = calculatePointer(NAME_OFFSET);
        byte[] convertedName = this.letterMapper.convertStringToFF7(name);
        engine.packAndWrite(convertedName, address);
    }

    public String getName() {
        Pointer address = calculatePointer(NAME_OFFSET);
        return engine.readNameInformation(address);
    }

//    public void updateStrength(int strength){
//        long offset = 1;
//        Pointer address = new Pointer(CLOUD_CHARACTER+offset);
//        engine.packAndWrite(new byte[]{(byte) strength}, address);
//    }
//
//    public void updateWeapon(int weapon){
//        long offset = 27;
//        Pointer address = new Pointer(CLOUD_CHARACTER+offset);
//        engine.packAndWrite(new byte[]{(byte) weapon}, address);
//    }
}
