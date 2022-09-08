package org.springotmc.framework.plan.task;

import org.springotmc.framework.SpringotFramework;
import org.springotmc.framework.component.manifest.BeanManifest;
import org.springotmc.framework.plan.ExecutionTask;

public class BeanManifestCreateTask implements ExecutionTask<SpringotFramework> {

    @Override
    public void execute(SpringotFramework platform) {

        // create manifest of the platform
        ClassLoader classLoader = platform.getClass().getClassLoader();
        BeanManifest beanManifest = BeanManifest.of(classLoader, platform.getClass(), platform.getCreator(), true);
        beanManifest.setObject(platform);

        // register injectable
        platform.registerInjectable("manifest", beanManifest);
    }
}
