package com.murismo.core;

import com.murismo.character.FF7Character;
import com.murismo.memory.MemoryEngine;

import java.util.Map;

public class Processor {

    private final MemoryEngine engine;

    public Processor(MemoryEngine engine) {
        this.engine = engine;
    }

    public boolean connect() {
        engine.connect();
        return engine.isConnected();
    }

    public void disconnect() {
        engine.disconnect();
    }
    public boolean isConnected() {
        return engine.isConnected();
    }

    public Map<String, FF7Character> characterList(){
        return Map.ofEntries(
                Map.entry("cloud", new FF7Character("Cloud", 0xDBFD8D, engine))
        );
    }
}
