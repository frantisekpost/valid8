package com.frantisekpost.lib.valid8.core.logic;

import com.frantisekpost.lib.valid8.core.Logic;

public class NotEmptyLogic implements Logic<String> {

	public static NotEmptyLogic INSTANCE = new NotEmptyLogic();

	@Override
	public boolean test(String value) {
		return value != null && value.length() > 0;
	}

}
