package org.springotmc.framework.component.creator;

import lombok.NonNull;
import org.springotmc.framework.component.manifest.BeanManifest;
import org.springotmc.injection.Injector;

import java.lang.reflect.Method;

public interface ComponentResolver {

    boolean supports(@NonNull Class<?> type);

    boolean supports(@NonNull Method method);

    Object make(@NonNull ComponentCreator creator, @NonNull BeanManifest manifest, @NonNull Injector injector);
}
