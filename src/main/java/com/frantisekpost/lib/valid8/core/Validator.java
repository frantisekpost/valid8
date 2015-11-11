package com.frantisekpost.lib.valid8.core;

/**
 * Base validator interface
 * 
 * @author Frantisek Post
 *
 */
public interface Validator<T> {

	/**
	 * @return {@code true} if value is valid, or {@code false} if invalid, {@code null} if was not validated yet
	 */
	Boolean isValid();
	
	/**
	 * @return text representation of invalid state
	 */
	String getMessage();
	
	/**
	 * @return {@code true} if validation happened, or {@code false} if validation didn't happen.
	 */
	boolean validate();
	
	void setLogic(Logic<T> logic);
	
}
