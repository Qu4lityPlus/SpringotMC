package org.springotmc.framework.component.type;

import lombok.NonNull;
import org.springotmc.framework.annotation.Component;
import org.springotmc.framework.component.ComponentHelper;
import org.springotmc.framework.component.creator.ComponentCreator;
import org.springotmc.framework.component.creator.ComponentResolver;
import org.springotmc.framework.component.manifest.BeanManifest;
import org.springotmc.injection.Injector;

import java.lang.reflect.Method;

/**
 * Resolves generic @Component classes.
 * <p>
 * Remember to register last as otherwise {@link #supports(Class)} may interfere
 * with other ComponentResolver implementations that due to being 3rd party
 * extension are not provided with custom annotation e.g. bukkit's listeners.
 */
public class GenericComponentResolver implements ComponentResolver {

    @Override
    public boolean supports(@NonNull Class<?> type) {
        return type.getAnnotation(Component.class) != null;
    }

    @Override
    public boolean supports(@NonNull Method method) {
        return false;
    }

    @Override
    public Object make(@NonNull ComponentCreator creator, @NonNull BeanManifest manifest, @NonNull Injector injector) {

        long start = System.currentTimeMillis();
        Object result = injector.createInstance(manifest.getType());

        long took = System.currentTimeMillis() - start;
        if (took > 1) {
            creator.log(ComponentHelper.buildComponentMessage()
                .type("Added generic component")
                .name(manifest.getType().getSimpleName())
                .took(took)
                .build());
        }
        creator.increaseStatistics("components", 1);

        return result;
    }
}
