package com.ares.recycle.common.base;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareAnnotation;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class AspectJDemo {

    @DeclareParents(value = "com.ares.recycle.common.Describe+", defaultImpl = DefaultDescribe.class)
    public static Unit unit;

}
