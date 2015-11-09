package com.frantisekpost.lib.valid8.core;

import javax.swing.JComponent;

import com.frantisekpost.lib.valid8.internal.Data;

public interface DataValidator<T, U extends JComponent> extends Validator<T> {

	void setData(Data<T, U> data);
	
}
