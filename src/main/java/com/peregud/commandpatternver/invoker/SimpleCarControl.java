package com.peregud.commandpatternver.invoker;

import com.peregud.commandpatternver.command.Command;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class SimpleCarControl {
    private Command command;

    public void commandExecute() {
        command.execute();
    }
}
