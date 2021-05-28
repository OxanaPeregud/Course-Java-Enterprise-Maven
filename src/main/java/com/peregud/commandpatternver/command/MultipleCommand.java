package com.peregud.commandpatternver.command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MultipleCommand implements Command {
    private final Command[] commands;

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
