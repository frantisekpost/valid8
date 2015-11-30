package com.frantisekpost.lib.valid8.core.logic;

import com.frantisekpost.lib.valid8.core.Logic;

public class MinLengthLogic implements Logic<String> {

	private int minLength;

	public MinLengthLogic(int minLength) {
		this.minLength = minLength;
	}

	@Override
	public boolean test(String value) {
		return value != null && value.length() >= minLength;
	}

}
