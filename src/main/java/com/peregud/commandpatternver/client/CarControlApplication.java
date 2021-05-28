package com.peregud.commandpatternver.client;

import com.peregud.commandpatternver.command.Command;
import com.peregud.commandpatternver.command.MultipleCommand;
import com.peregud.commandpatternver.invoker.CarControl;
import com.peregud.commandpatternver.invoker.SimpleCarControl;
import com.peregud.commandpatternver.receiver.Alarm;
import com.peregud.commandpatternver.receiver.Door;
import com.peregud.commandpatternver.receiver.Engine;
import com.peregud.commandpatternver.receiver.Radio;

import java.util.List;

public class CarControlApplication {
    public static void main(String[] args) {
        CarControl carControl = new CarControl(12);
        SimpleCarControl simpleCarControl = new SimpleCarControl();
        Alarm alarm = new Alarm();
        Door door = new Door();
        Engine engine = new Engine();
        Radio radio = new Radio();

        carControl.setCommand(0, alarm::on, alarm::off);
        carControl.setCommand(1, door::open, door::close);
        carControl.setCommand(2, engine::start, engine::stop);
        carControl.setCommand(3, radio::high, radio::off);

        carControl.onCommand(1);
        carControl.offCommand(0);

        List<Command> commandsOn = List.of(door::open, engine::start, radio::medium);
        List<Command> commandsOff = List.of(radio::low, door::close);
        MultipleCommand multipleCommandsOn = new MultipleCommand(commandsOn);
        MultipleCommand multipleCommandsOff = new MultipleCommand(commandsOff);

        multipleCommandsOn.execute();
        multipleCommandsOff.execute();

        simpleCarControl.setCommand(engine::start);
        simpleCarControl.commandExecute();
    }
}
