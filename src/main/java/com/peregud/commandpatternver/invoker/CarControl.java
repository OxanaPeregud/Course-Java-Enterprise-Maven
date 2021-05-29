package com.peregud.commandpatternver.invoker;

import com.peregud.commandpatternver.command.Command;
import com.peregud.commandpatternver.command.NoCommand;

import java.util.Arrays;
import java.util.List;

public class CarControl {
    private final List<Command> onCommands;
    private final List<Command> offCommands;

    public CarControl(int numberOfCommands) {
        onCommands = Arrays.asList(new Command[numberOfCommands]);
        offCommands = Arrays.asList(new Command[numberOfCommands]);
        Command noCommand = new NoCommand();
        for (int i = 0; i < numberOfCommands; i++) {
            onCommands.set(i, noCommand);
            offCommands.set(i, noCommand);
        }
    }

    public void setCommand(int choice, Command onCommand, Command offCommand) {
        onCommands.set(choice, onCommand);
        offCommands.set(choice, offCommand);
    }

    public void onCommand(int choice) {
        onCommands.get(choice).execute();
    }

    public void offCommand(int choice) {
        offCommands.get(choice).execute();
    }
}
