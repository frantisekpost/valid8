package com.frantisekpost.lib.valid8.internal;

import javax.swing.JComponent;

import com.frantisekpost.lib.valid8.core.Validator;

/**
 * Validation trigger 
 * 
 * @author Frantisek Post
 *
 */
//TODO make generic, so it could be separated to swing and fx implementation in future
public interface Trigger<T extends JComponent> {

	/**
	 * Connects component with validator, so it gets validated on change
	 * 
	 * @param validator
	 * @param component
	 */
	void register(Validator<?> validator, T component);
	
	void unregister(Validator<?> validator, T component);
	
}
