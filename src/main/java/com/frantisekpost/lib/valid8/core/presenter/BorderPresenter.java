package com.frantisekpost.lib.valid8.core.presenter;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.frantisekpost.lib.valid8.core.Validator;
import com.frantisekpost.lib.valid8.internal.Result;

public class BorderPresenter extends AbstractComponentPresenter {


	public static final BorderPresenter SHARED_INSTANCE = new BorderPresenter();

	private static final Color INVALID_COLOR = Color.RED;

	private static final Border INVALID_BORDER = new LineBorder(INVALID_COLOR, 1);

	private static final String ORIGINAL_VALUE_KEY = "valid8.border.original";

	private BorderPresenter() {
		super();
	}

	public BorderPresenter(JComponent component) {
		super(component);
	}

	@Override
	void saveValidState(Validator<?> validator) {
		JComponent component = getPresentingComponent(validator);
		Border lastBorder = component.getBorder();
		System.out.println("saving border " + lastBorder);
		component.putClientProperty(ORIGINAL_VALUE_KEY, lastBorder);
	}

	@Override
	void loadValidState(Validator<?> validator) {
		JComponent component = getPresentingComponent(validator);
		Border originalBorder = (Border) component.getClientProperty(ORIGINAL_VALUE_KEY);
		System.out.println("loading border " + originalBorder);
		component.setBorder(originalBorder);
	}

	@Override
	void presentInvalidState(Result result) {
		JComponent component = getPresentingComponent(result.getValidator());
		component.setBorder(INVALID_BORDER);
	}

}
