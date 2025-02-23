package com.wenercastro.projects.financial_app.annotations;

import com.wenercastro.projects.financial_app.model.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequireAuth {
    Role[] value() default {};
}
