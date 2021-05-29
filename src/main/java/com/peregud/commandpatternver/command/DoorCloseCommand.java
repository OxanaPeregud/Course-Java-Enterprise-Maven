package com.peregud.commandpatternver.command;

import com.peregud.commandpatternver.receiver.Door;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DoorCloseCommand implements Command {
    private final Door door;

    @Override
    public void execute() {
        door.close();
    }
}
