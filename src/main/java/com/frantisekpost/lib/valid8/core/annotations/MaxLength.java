package com.frantisekpost.lib.valid8.core.annotations;

import static java.lang.annotation.ElementType.FIELD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

@Target(FIELD)
@Retention(RUNTIME)
public @interface MaxLength {

	int value() default Integer.MAX_VALUE;

}
