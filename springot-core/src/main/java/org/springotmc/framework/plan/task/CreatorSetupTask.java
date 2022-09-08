package org.springotmc.framework.plan.task;

import lombok.RequiredArgsConstructor;
import org.springotmc.framework.SpringotFramework;
import org.springotmc.framework.component.creator.ComponentCreator;
import org.springotmc.framework.component.creator.ComponentCreatorRegistry;
import org.springotmc.framework.plan.ExecutionTask;

@RequiredArgsConstructor
public class CreatorSetupTask implements ExecutionTask<SpringotFramework> {

    private final Class<? extends ComponentCreator> creatorType;
    private final Class<? extends ComponentCreatorRegistry> registryType;

    @Override
    public void execute(SpringotFramework platform) {

        ComponentCreatorRegistry registry = platform.createInstance(this.registryType);
        platform.registerInjectable("creatorRegistry", registry);

        ComponentCreator componentCreator = platform.createInstance(this.creatorType);
        platform.registerInjectable("creator", componentCreator);

        platform.setCreator(componentCreator);
    }
}
