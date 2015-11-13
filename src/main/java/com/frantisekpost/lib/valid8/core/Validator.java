package com.frantisekpost.lib.valid8.core;

import com.frantisekpost.lib.valid8.internal.Result;
/**
 * Base validator interface
 *
 * @author Frantisek Post
 *
 */
public interface Validator<T> {

	/**
	 * @return text representation of invalid state
	 */
	String getMessage();

	/**
	 * @return {@code true} if validation happened, or {@code false} if validation didn't happen.
	 */
	boolean validate();

	void setLogic(Logic<T> logic);

	Result getResult();

}
