package org.springotmc.framework.plan;

import org.springotmc.framework.SpringotFramework;

@FunctionalInterface
public interface ExecutionTask<T extends SpringotFramework> {
    void execute(T platform);
}
