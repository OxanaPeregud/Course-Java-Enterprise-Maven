package com.peregud.commandpatternver.command;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MultipleCommand implements Command {
    private final List<Command> commands;

    @Override
    public void execute() {
        commands.forEach(Command::execute);
    }
}
