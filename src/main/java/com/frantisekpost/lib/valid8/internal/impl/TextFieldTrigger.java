package com.frantisekpost.lib.valid8.internal.impl;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.frantisekpost.lib.valid8.core.Validator;
import com.frantisekpost.lib.valid8.internal.Trigger;

public class TextFieldTrigger implements Trigger<JTextField> {

	private DocumentListener documentListener;
	
	private Validator<?> validator;
	
	private JTextField textField;
	
	public TextFieldTrigger() {
		documentListener = new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				changed();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				changed();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				changed();
			}
			
		};
	}
	
	@Override
	public void register(Validator<?> validator, JTextField textField) {
		this.validator = validator;
		this.textField = textField;
		
		textField.getDocument().addDocumentListener(documentListener);
	}
	
	@Override
	public void unregister(Validator<?> validator, JTextField component) {
		textField.getDocument().removeDocumentListener(documentListener);
	}
	
	private void changed() {
		boolean validated = validator.validate();
		if (validated) {
			//TODO do some reporting
		}
	}

}
