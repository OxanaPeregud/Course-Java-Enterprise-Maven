package com.peregud.commandpatternver.command;

import com.peregud.commandpatternver.receiver.Engine;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EngineStartCommand implements Command {
    private final Engine engine;

    @Override
    public void execute() {
        engine.start();
    }
}
