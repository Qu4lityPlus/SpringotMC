package org.springotmc.commons.matcher;

public interface MatcherCondition<T> {
    boolean matches(T element);
}
