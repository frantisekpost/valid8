package com.frantisekpost.lib.valid8.core.impl;

import javax.swing.JComponent;

import com.frantisekpost.lib.valid8.core.DataValidator;
import com.frantisekpost.lib.valid8.core.Logic;
import com.frantisekpost.lib.valid8.internal.Data;

public abstract class AbstractDataValidator<T, U extends JComponent> implements DataValidator<T, U> {

	private Data<T, U> data;
	
	private Logic<T> logic;
	
	private String message;
	
	private Boolean result;
	
	@Override
	public void setData(Data<T, U> data) {
		this.data = data;
	}
	
	@Override
	public boolean validate() {
		if (canValidate()) {
			boolean res = validateInternal();
			result = Boolean.valueOf(res);
			return res;
		} else {
			return false;
		}
	}
	
	@Override
	public Boolean isValid() {
		return result;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	@Override
	public void setLogic(Logic<T> logic) {
		this.logic = logic;
	}
	
	protected abstract boolean canValidate();
	
	protected abstract U getComponent();
	
	protected T getData() {
		return data.getValue(getComponent());
	}
	
	protected boolean validateInternal() {
		if (data == null) {
			throw new NullPointerException("No DataValidator provided");
		}
		
		if (logic == null) {
			throw new NullPointerException("No validation logic provided");
		}
		
		return logic.test(getData());
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
