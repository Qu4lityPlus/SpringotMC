package org.springotmc.framework;

import lombok.NonNull;
import org.springotmc.framework.component.creator.ComponentCreator;
import org.springotmc.framework.plan.ExecutionPlan;
import org.springotmc.injection.Injector;

public interface SpringotFramework {
    // injector
    void setInjector(@NonNull Injector injector);

    Injector getInjector();

    default void registerInjectable(@NonNull String name, @NonNull Object type) {
        this.getInjector().registerInjectable(name, type);
    }

    default <T> T createInstance(@NonNull Class<T> type) {
        return this.getInjector().createInstance(type);
    }

    // creator
    void setCreator(@NonNull ComponentCreator creator);

    ComponentCreator getCreator();

    // logging
    void log(@NonNull String message);

    // setup
    void plan(@NonNull ExecutionPlan plan);
}
