package com.frantisekpost.lib.valid8.internal;

import javax.swing.JComponent;

/**
 * Data provider for validation 
 * 
 * @author Frantisek Post
 *
 * @param <T>
 */
public interface Data<T, U extends JComponent> { //TODO just like Trigger - make it generic

	/**
	 * @return value to be validated
	 */
	T getValue(U component); 
	
}
