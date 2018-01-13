package pf.aqsa.com.retromvp.Presenter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.squareup.otto.Produce;

import pf.aqsa.com.retromvp.View.HomeScreen;
import pf.aqsa.com.retromvp.Model.ErrorEvent;
import pf.aqsa.com.retromvp.Model.ServerEvent;
import pf.aqsa.com.retromvp.Model.ServerResponse;
import pf.aqsa.com.retromvp.Model.RemoteInterface;
import pf.aqsa.com.retromvp.View.IView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Mahek on 1/12/2018.
 */

public class LoginPresenterCompl implements LoginPresenter {

    Context context;
    IView iv;
    boolean isLogin;
  public   LoginPresenterCompl(Context context){
    //  this.iv = iv;
      this.context=  context;

  }

    @Override
    public boolean doLogin(final String name, String passwd) {

        final RemoteInterface service = RemoteService.getClient().create(RemoteInterface.class);


        Call<ServerResponse> call = service.post(name,passwd);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
             //   BusProvider.getInstance().post(new ServerEvent(response.body()));

          //  ViewPresenterCompl vc = new ViewPresenterCompl(context);

                if (!response.body().getId().isEmpty()){
                    isLogin = true;

             //       IViewClass iv = new IViewClass();
//                    iv.onLoginResult(true,1);


                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
                   SharedPreferences.Editor editor= prefs.edit();
                    editor.putString("userName",response.body().getUsername());
                    editor.putString("email",response.body().getEmail());
                    editor.putString("id",response.body().getId());
                    editor.apply();
                    Intent intent = new Intent(context.getApplicationContext(), HomeScreen.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.getApplicationContext().startActivity(intent);


//                    Toast.makeText(context.getApplicationContext(),String.valueOf(response.body().getEmail()),Toast.LENGTH_SHORT).show();
//                    Toast.makeText(context.getApplicationContext(),String.valueOf(response.body().getId()),Toast.LENGTH_SHORT).show();
//                    Toast.makeText(context.getApplicationContext(),String.valueOf( response.body().getUsername()),Toast.LENGTH_SHORT).show();


                }
                else {

                    Toast.makeText(context.getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
                    isLogin = false;

                }
              //  SharedPreferences preferences = context.



                Log.e(TAG,"Success");

            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                //BusProvider.getInstance().post(new ErrorEvent(-2,t.getMessage()));
                Toast.makeText(context.getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();

            }
        });

        return isLogin;
  }

    @Override
    public void doSignUp(String name, String passwd,String userName) {


        RemoteInterface service = RemoteService.getClient().create(RemoteInterface.class);


        Call<ServerResponse> call = service.signUp(name,passwd,userName);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                //   BusProvider.getInstance().post(new ServerEvent(response.body()));



                if (!response.body().getId().isEmpty()){
                    onLoginResult(true);
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
                    SharedPreferences.Editor editor= prefs.edit();
                    editor.putString("userName",response.body().getUsername());
                    editor.putString("email",response.body().getEmail());
                    editor.putString("id",response.body().getId());
                    editor.apply();
//                    Intent intent = new Intent(context.getApplicationContext(), HomeScreen.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.getApplicationContext().startActivity(intent);


//                    Toast.makeText(context.getApplicationContext(),String.valueOf(response.body().getEmail()),Toast.LENGTH_SHORT).show();
//                    Toast.makeText(context.getApplicationContext(),String.valueOf(response.body().getId()),Toast.LENGTH_SHORT).show();
//                    Toast.makeText(context.getApplicationContext(),String.valueOf( response.body().getUsername()),Toast.LENGTH_SHORT).show();


                }
                else {
                    onLoginResult(false);
                    Toast.makeText(context.getApplicationContext(),"User Name or Email already exist",Toast.LENGTH_SHORT).show();


                }
                //  SharedPreferences preferences = context.



                Log.e(TAG,"Success");
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                //BusProvider.getInstance().post(new ErrorEvent(-2,t.getMessage()));
                Toast.makeText(context.getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onLoginResult(boolean res) {

    }




    @Produce
    public ServerEvent produceServerEvent(ServerResponse serverResponse) {
        return new ServerEvent(serverResponse);
    }

    @Produce
    public ErrorEvent produceErrorEvent(int errorCode, String errorMsg) {
        return new ErrorEvent(errorCode, errorMsg);
    }


}
