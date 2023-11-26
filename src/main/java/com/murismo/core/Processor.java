package com.murismo.core;

import com.murismo.character.FF7Character;
import com.murismo.memory.MemoryEngine;

import java.util.List;
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

    public List<FF7Character> characterList(){
        return List.of(
                new FF7Character("Cloud", 0xDBFD8D, engine),
                new FF7Character("Barret", 0xDBFE11, engine),
                new FF7Character("Tifa", 0xDBFE95, engine),
                new FF7Character("Aeris", 0xDBFF19, engine),
                new FF7Character("RedXII", 0xDBFF9D, engine),
                new FF7Character("Yuffie", 0xDC0021, engine),
                new FF7Character("CaitSith", 0xDC00A5, engine),
                new FF7Character("Vincent", 0xDC0129, engine),
                new FF7Character("Cid", 0xDC01AD, engine)
        );
    }
}
