package com.frantisekpost.lib.valid8.core.annotations;

import com.frantisekpost.lib.valid8.core.Logic;
import com.frantisekpost.lib.valid8.internal.Data;
import com.frantisekpost.lib.valid8.internal.Trigger;

public @interface Custom {

	Class<? extends Logic<?>> logicClass();

	Class<? extends Data<?, ?>> dataClass();

	String message() default "";

	Class<? extends Trigger<?>> trigger();

}
