package com.android3.ocabafox.rickyskumpra.KumpraInput;

import android.content.Context;
import android.os.Handler;

import com.android3.ocabafox.rickyskumpra.KumpraInput.KumpraListener.KumpraListener;
import com.android3.ocabafox.rickyskumpra.KumpraLocalDataBase.KumpraDataBase;

/**
 * Created by ocabafox on 7/11/2015.
 */
public class KumpraInteractor implements iKumpraInteractor {

    KumpraDataBase kumpraDataBase;
    Context context;
    public KumpraInteractor(Context context){
        this.context = context;
    }

    public void open(){
        kumpraDataBase = new KumpraDataBase(context);
        kumpraDataBase.opendB();
    }



    @Override
    public void validate(final KumpraListener listener, final String input) {
        open();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(input.equals("")){
                    listener.onError();
                }
                else {
                    kumpraDataBase.insert(input);
                    listener.onSuccess();
                }
            }
        },2000);
    }

}
