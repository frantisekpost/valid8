package com.frantisekpost.lib.valid8.core;

/**
 * Base validator interface
 * 
 * @author Frantisek Post
 *
 */
public interface Validator {

	/**
	 * @return {@code true} if value is valid, or {@code false} if invalid
	 */
	boolean isValid();
	
	/**
	 * @return text representation of invalid state
	 */
	String getMessage();
	
	/**
	 * @return {@code true} if validation happened, or {@code false} if validation didn't happen.
	 */
	boolean validate();
	
}
