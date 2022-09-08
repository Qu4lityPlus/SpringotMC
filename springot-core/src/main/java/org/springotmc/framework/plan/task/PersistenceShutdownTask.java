package org.springotmc.framework.plan.task;

import org.springotmc.framework.SpringotFramework;
import org.springotmc.framework.component.ComponentHelper;
import org.springotmc.framework.plan.ExecutionTask;

public class PersistenceShutdownTask implements ExecutionTask<SpringotFramework> {

    @Override
    public void execute(SpringotFramework platform) {
        //TODO
        //ComponentHelper.closeAllOfType(Persistence.class, platform.getInjector());
    }
}
