package org.springotmc.framework.component;

import lombok.NonNull;

@FunctionalInterface
public interface ExternalResourceProvider {
    Object provide(@NonNull String name, @NonNull Class<?> type, @NonNull Class<?> of);
}
