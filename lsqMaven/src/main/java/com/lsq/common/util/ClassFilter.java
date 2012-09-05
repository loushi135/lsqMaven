package com.lsq.common.util;

/**
 * A class filter.
 * 
 */
public interface ClassFilter {

    /**
     * If accept the class passed as argument, return true, otherwize false.
     */
    boolean accept(Class<?> clazz);

}
