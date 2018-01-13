package pf.aqsa.com.retromvp.Presenter;

import android.content.Context;
import android.content.Intent;

import pf.aqsa.com.retromvp.HomeScreen;
import pf.aqsa.com.retromvp.View.IView;
import pf.aqsa.com.retromvp.View.ViewPresenter;

/**
 * Created by AQSA SHaaPARR on 1/12/2018.
 */

public class ViewPresenterCompl implements ViewPresenter {


    IView iv;
    Context context;
    public   ViewPresenterCompl(Context context){

        this.context=  context;

    }

    @Override
    public void MoveToTheHomeActivity(Context context) {

        Intent intent = new Intent(context.getApplicationContext(), HomeScreen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);


    }
}
