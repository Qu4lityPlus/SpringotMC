package org.springotmc.framework.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(SpringotApplication.List.class)
public @interface SpringotApplication {
    String value() default "";

    String[] exclusions() default {};

    boolean deep() default false;

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        SpringotApplication[] value();
    }
}
