package com.android3.ocabafox.rickyskumpra.KumpraInput;

import android.content.Context;

import com.android3.ocabafox.rickyskumpra.KumpraInput.KumpraListener.KumpraListener;

/**
 * Created by ocabafox on 7/11/2015.
 */
public class KumpraPresenter implements iKumpraPresenter, KumpraListener {

    boolean validate;
    KumpraInteractor interactor;
    KumpraView view;

    public KumpraPresenter(KumpraView loginView, Context context) {
        this.view = loginView;
        this.interactor = new KumpraInteractor(context);
    }

    public void addItem(String add) {
         interactor.validate(this,add);
    }


    @Override
    public void onError() {
        view.InputError();
    }

    @Override
    public void onSuccess() {
        view.AddListActivity();
    }
}
