package com.peregud.commandpatternver.command;

import com.peregud.commandpatternver.receiver.Radio;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RadioOffCommand implements Command {
    private final Radio radio;

    @Override
    public void execute() {
        radio.off();
    }
}
