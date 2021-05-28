package com.peregud.commandpatternver.command;

import com.peregud.commandpatternver.receiver.Alarm;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AlarmOffCommand implements Command {
    private final Alarm alarm;

    @Override
    public void execute() {
        alarm.off();
    }
}
