package com.frantisekpost.lib.valid8.internal;

/**
 * Data provider for validation 
 * 
 * @author Frantisek Post
 *
 * @param <T>
 */
public interface Data<T> {

	/**
	 * @return value to be validated
	 */
	T getValue();
	
}
