package com.frantisekpost.lib.valid8.core.impl;

import javax.swing.JComponent;

public class ComponentValidator<T, U extends JComponent> extends AbstractDataValidator<T, U>{

	private U component;

	public ComponentValidator(U component) {
		if (component == null) {
			throw new NullPointerException("component cannot be null");
		}
		this.component = component;
	}

	@Override
	protected boolean canValidate() {
		return component.isEnabled() && component.isVisible();
	}

	@Override
	public U getComponent() {
		return component;
	}

}
