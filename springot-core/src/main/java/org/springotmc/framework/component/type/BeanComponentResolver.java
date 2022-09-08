package org.springotmc.framework.component.type;

import lombok.NonNull;
import org.springotmc.framework.annotation.Bean;
import org.springotmc.framework.component.ComponentHelper;
import org.springotmc.framework.component.creator.ComponentCreator;
import org.springotmc.framework.component.creator.ComponentResolver;
import org.springotmc.framework.component.manifest.BeanManifest;
import org.springotmc.injection.Injector;

import java.lang.reflect.Method;

/**
 * Resolves generic @Component classes.
 * <p>
 * Remember to register last as otherwise {@link #supports(Method)} may interfere
 * with other ComponentResolver implementations that due to being 3rd party
 * extension are not provided with custom annotation.
 */
public class BeanComponentResolver implements ComponentResolver {

    @Override
    public boolean supports(@NonNull Class<?> type) {
        return false;
    }

    @Override
    public boolean supports(@NonNull Method method) {
        return method.getAnnotation(Bean.class) != null;
    }

    @Override
    public Object make(@NonNull ComponentCreator creator, @NonNull BeanManifest manifest, @NonNull Injector injector) {

        long start = System.currentTimeMillis();
        Object result = ComponentHelper.invokeMethod(manifest, injector);

        long took = System.currentTimeMillis() - start;
        if (took > 1) {
            creator.log(ComponentHelper.buildComponentMessage()
                .type("Added generic bean")
                .name(manifest.getName().isEmpty() ? manifest.getMethod().getName() : manifest.getName())
                .took(took)
                .build());
        }
        creator.increaseStatistics("beans", 1);

        return result;
    }
}
