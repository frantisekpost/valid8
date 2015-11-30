package com.frantisekpost.lib.valid8.core.logic;

import com.frantisekpost.lib.valid8.core.Logic;

public class NotNullLogic<T> implements Logic<T> {

	public static final NotNullLogic<String> STRING_INSTANCE = new NotNullLogic<>();

	private NotNullLogic() {
	}

	@Override
	public boolean test(T value) {
		return value != null;
	}

}
