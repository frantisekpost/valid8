package com.frantisekpost.lib.valid8.core.presenter;

import java.awt.Color;
import java.util.Objects;

import javax.swing.JComponent;

public class BackgroundPresenter extends AbstractPresenter {

	private JComponent component;
	private Color lastBackground;

	private static final Color INVALID_COLOR = Color.RED;

	public BackgroundPresenter(JComponent component) {
		this.component = component;
		Objects.requireNonNull(component, "component can not be null");
	}

	@Override
	void saveValidState() {
		lastBackground = component.getBackground();
	}

	@Override
	void loadValidState() {
		component.setBackground(lastBackground);
	}

	@Override
	void presentInvalidState(String message) {
		component.setBackground(INVALID_COLOR);
	}

}
