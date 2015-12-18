package com.frantisekpost.lib.valid8.core.presenter;

import java.awt.Color;

import javax.swing.JComponent;

import com.frantisekpost.lib.valid8.core.Validator;
import com.frantisekpost.lib.valid8.internal.Result;

public class BackgroundPresenter extends AbstractComponentPresenter {

	public static final BackgroundPresenter SHARED_INSTANCE = new BackgroundPresenter();

	private static final Color INVALID_COLOR = Color.RED;

	private static final String ORIGINAL_VALUE_KEY = "valid8.background.original";

	private BackgroundPresenter() {
		super();
	}

	public BackgroundPresenter(JComponent component) {
		super(component);
	}

	@Override
	void saveValidState(Validator<?> validator) {
		JComponent component = getPresentingComponent(validator);
		Color lastBackground = component.getBackground();
		component.putClientProperty(ORIGINAL_VALUE_KEY, lastBackground);
	}

	@Override
	void loadValidState(Validator<?> validator) {
		JComponent component = getPresentingComponent(validator);
		Color originalBackground = (Color) component.getClientProperty(ORIGINAL_VALUE_KEY);
		component.setBackground(originalBackground);
	}

	@Override
	void presentInvalidState(Result result) {
		JComponent component = getPresentingComponent(result.getValidator());
		component.setBackground(INVALID_COLOR);
	}

}
