package org.springotmc.framework.plan.task;

import lombok.RequiredArgsConstructor;
import org.springotmc.framework.SpringotFramework;
import org.springotmc.framework.plan.ExecutionTask;

@RequiredArgsConstructor
public class CommandsSetupTask implements ExecutionTask<SpringotFramework> {


    @Override
    public void execute(SpringotFramework platform) {
        /*this.commands.registerExtension(new CommandsInjector(platform.getInjector()));
        platform.registerInjectable("commands", this.commands);*/
    }
}
