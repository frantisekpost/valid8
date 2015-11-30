package com.frantisekpost.lib.valid8.core.presenter;

import com.frantisekpost.lib.valid8.core.Presenter;
import com.frantisekpost.lib.valid8.internal.Result;

public abstract class AbstractPresenter implements Presenter {

	private Boolean lastResult;

	@Override
	public void present(Result result) {
		if ((lastResult == null || lastResult.booleanValue()) && Boolean.FALSE.equals(result.get())) {
			saveValidState();
			presentInvalidState(result.getValidator().getMessage());
			lastResult = Boolean.FALSE;
		} else if (Boolean.TRUE.equals(result.get()) && lastResult != null && Boolean.FALSE.equals(lastResult)) {
			loadValidState();
			lastResult = Boolean.TRUE;
		} else if (Boolean.FALSE.equals(result.get())) { //what if changes only validation message?
			presentInvalidState(result.getValidator().getMessage());
		}
	}

	abstract void saveValidState();

	abstract void loadValidState();

	abstract void presentInvalidState(String message);

}
