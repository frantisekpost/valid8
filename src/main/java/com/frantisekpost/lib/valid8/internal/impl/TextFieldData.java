package com.frantisekpost.lib.valid8.internal.impl;

import javax.swing.JTextField;

import com.frantisekpost.lib.valid8.internal.Data;

public class TextFieldData implements Data<String, JTextField> {

	public static final TextFieldData INSTANCE = new TextFieldData();
	
	private TextFieldData() {
	}
	
	@Override
	public String getValue(JTextField textField) {
		return textField.getText();
	}
	
}
