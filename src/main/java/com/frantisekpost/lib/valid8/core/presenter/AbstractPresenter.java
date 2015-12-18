package com.frantisekpost.lib.valid8.core.presenter;

import com.frantisekpost.lib.valid8.core.Presenter;
import com.frantisekpost.lib.valid8.core.Validator;
import com.frantisekpost.lib.valid8.internal.Result;

public abstract class AbstractPresenter implements Presenter {

	@Override
	public void present(Result result) {
		Boolean lastResult = getLastResult(result.getValidator());
		if ((lastResult == null || lastResult.booleanValue()) && Boolean.FALSE.equals(result.get())) {
			saveValidState(result.getValidator());
			presentInvalidState(result);
			saveLastResult(result);
		} else if (Boolean.TRUE.equals(result.get()) && lastResult != null && Boolean.FALSE.equals(lastResult)) {
			loadValidState(result.getValidator());
			saveLastResult(result);
		} else if (Boolean.FALSE.equals(result.get())) { //what if changes only validation message?
			presentInvalidState(result);
		}
	}

	abstract void saveValidState(Validator<?> validator);

	abstract void loadValidState(Validator<?> validator); //TODO rename to restoreValidaState

	abstract void presentInvalidState(Result result);

	abstract Boolean getLastResult(Validator<?> validator);

	abstract void saveLastResult(Result result);

}
