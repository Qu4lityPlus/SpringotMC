package org.springotmc.framework.plan.task;

import org.springotmc.framework.SpringotFramework;
import org.springotmc.framework.plan.ExecutionTask;
import org.springotmc.injection.SpringotInjector;

public class InjectorSetupTask implements ExecutionTask<SpringotFramework> {

    @Override
    public void execute(SpringotFramework platform) {
        SpringotInjector injector = SpringotInjector.create(true);
        platform.setInjector(injector);
        platform.registerInjectable("injector", injector);
    }
}
