package com.frantisekpost.lib.valid8.core.presenter;

import java.util.Objects;

import javax.swing.JComponent;

import com.frantisekpost.lib.valid8.core.Validator;
import com.frantisekpost.lib.valid8.core.impl.ComponentValidator;
import com.frantisekpost.lib.valid8.internal.Result;

public abstract class AbstractComponentPresenter extends AbstractPresenter {

	private JComponent component;

	private static final String LAST_RESULT_KEY = "valid8.presenter.last.result";

	public AbstractComponentPresenter(JComponent component) {
		Objects.requireNonNull(component, "component can not be null");
		this.component = component;
	}

	AbstractComponentPresenter() {
	}

	protected JComponent getPresentingComponent(Validator<?> validator) {
		if (component != null) {
			return component;
		} else if (validator instanceof ComponentValidator<?,?>) {
			return ((ComponentValidator<?,?>)validator).getComponent();
		} else {
			throw new IllegalArgumentException("missing component, or wrong type of validator");
		}
	}

	@Override
	protected Boolean getLastResult(Validator<?> validator) {
		JComponent component = getPresentingComponent(validator);
		Boolean lastResult = (Boolean) component.getClientProperty(LAST_RESULT_KEY);
		return lastResult;
	}

	@Override
	protected void saveLastResult(Result result) {
		JComponent component = getPresentingComponent(result.getValidator());
		component.putClientProperty(LAST_RESULT_KEY, result.get());
	}

}
