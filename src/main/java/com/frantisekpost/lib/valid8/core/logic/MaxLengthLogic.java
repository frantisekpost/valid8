package com.frantisekpost.lib.valid8.core.logic;

import com.frantisekpost.lib.valid8.core.Logic;

public class MaxLengthLogic implements Logic<String>{

	private int maxLength;

	public MaxLengthLogic(int maxLength) {
		this.maxLength = maxLength;
	}

	@Override
	public boolean test(String value) {
		return value == null || value.length() <= maxLength;
	}

}
