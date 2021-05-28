package com.peregud.commandpatternver.invoker;

import com.peregud.commandpatternver.command.Command;
import com.peregud.commandpatternver.command.NoCommand;

public class CarControl {
    private final Command[] onCommands;
    private final Command[] offCommands;

    public CarControl() {
        int commands = 12;
        onCommands = new Command[commands];
        offCommands = new Command[commands];
        Command noCommand = new NoCommand();
        for (int i = 0; i < commands; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int choice, Command onCommand, Command offCommand) {
        onCommands[choice] = onCommand;
        offCommands[choice] = offCommand;
    }

    public void onCommand(int choice) {
        onCommands[choice].execute();
    }

    public void offCommand(int choice) {
        offCommands[choice].execute();
    }
}
