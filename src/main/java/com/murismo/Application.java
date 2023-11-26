package com.murismo;

import com.murismo.core.Processor;
import com.murismo.memory.MemoryEngine;
import com.murismo.gui.Gui;


public class Application {

    public static void main(String[] args) {
        MemoryEngine engine = new MemoryEngine("FINAL FANTASY VII");
        Processor processor = new Processor(engine);
        Gui gui = new Gui(processor);
        gui.start();
    }
}