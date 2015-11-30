package com.frantisekpost.lib.valid8.core.presenter;

import java.util.Objects;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.text.JTextComponent;

public class TextPresenter extends AbstractPresenter {

	private ComponentWrapper wrapper;
	private String lastText;

	public TextPresenter(JComponent component) {
		wrapper = createWrapper(component);
	}

	@Override
	void saveValidState() {
		lastText = wrapper.getText();
	}

	@Override
	void loadValidState() {
		wrapper.setText(lastText);
	}

	@Override
	void presentInvalidState(String message) {
		wrapper.setText(message);
	}

	private ComponentWrapper createWrapper(JComponent component) {
		Objects.requireNonNull(component, "Presenting component can not be null");
		if (component instanceof JLabel) {
			return new LabelWrapper((JLabel) component);
		} else if (component instanceof JTextComponent) {
			return new TextComponentWrapper((JTextComponent) component);
		} else if (component instanceof AbstractButton) {
			return new ButtonWrapper((AbstractButton) component);
		} else {
			throw new IllegalArgumentException("unsupported component " + component.getClass());
		}
	}

	private static class LabelWrapper implements ComponentWrapper {

		private JLabel label;

		public LabelWrapper(JLabel label) {
			this.label = label;
		}

		@Override
		public void setText(String text) {
			label.setText(text);
		}

		@Override
		public String getText() {
			return label.getText();
		}

	}

	private static class TextComponentWrapper implements ComponentWrapper {

		private JTextComponent textComponent;

		public TextComponentWrapper(JTextComponent textComponent) {
			this.textComponent = textComponent;
		}

		@Override
		public void setText(String text) {
			textComponent.setText(text);
		}

		@Override
		public String getText() {
			return textComponent.getText();
		}

	}

	private static class ButtonWrapper implements ComponentWrapper {

		private AbstractButton button;

		public ButtonWrapper(AbstractButton button) {
			this.button = button;
		}

		@Override
		public void setText(String text) {
			button.setText(text);
		}

		@Override
		public String getText() {
			return button.getText();
		}

	}

	private static interface ComponentWrapper {

		void setText(String text);

		String getText();

	}

}
