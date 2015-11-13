package com.frantisekpost.lib.valid8.internal;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.stream.Stream;

import javax.swing.event.EventListenerList;

import com.frantisekpost.lib.valid8.core.Validator;

public class Result {

	private static final String NAME = "BooleanProperty";

	private Boolean value;

	private EventListenerList listenerList = new EventListenerList();

	private Validator<?> validator;

	public Result(Validator<?> validator) {
		this.validator = validator;
	}

	public void set(boolean value) {
		Boolean oldValue = this.value;
		this.value = Boolean.valueOf(value);
		if (oldValue == null || !oldValue.equals(value)) {
			fireChange(oldValue, Boolean.valueOf(value));
		}
	}

	public Boolean get() {
		return value;
	}

	public void addListener(PropertyChangeListener listener) {
		listenerList.add(PropertyChangeListener.class, listener);
	}

	public void removeListener(PropertyChangeListener listener) {
		listenerList.remove(PropertyChangeListener.class, listener);
	}

	public Validator<?> getValidator() {
		return validator;
	}

	private void fireChange(Boolean oldValue, Boolean newValue) {
		PropertyChangeEvent event = new PropertyChangeEvent(validator, NAME, oldValue, newValue);
		Stream.of(listenerList.getListeners(PropertyChangeListener.class))
			.forEach(listener -> listener.propertyChange(event));
	}
}
