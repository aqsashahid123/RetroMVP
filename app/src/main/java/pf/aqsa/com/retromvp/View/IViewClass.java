package pf.aqsa.com.retromvp.View;

import android.content.Context;
import android.content.Intent;

import pf.aqsa.com.retromvp.HomeScreen;
import pf.aqsa.com.retromvp.SignUpActivity;

/**
 * Created by AQSA SHaaPARR on 1/12/2018.
 */

public class IViewClass implements IView {

    public boolean onLoginResult(Boolean result) {

        return  result;
    }
    public void onSignUpResult(Boolean result, int code) {

    }

    @Override
    public void LaunchActivity(Context context) {
                Intent intent = new Intent(context.getApplicationContext(), SignUpActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.getApplicationContext().startActivity(intent);
    }
//    public void LaunchActivity(Context context){
//
//        Intent intent = new Intent(context.getApplicationContext(), SignUpActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.getApplicationContext().startActivity(intent);
//
//
//
//    }


}
