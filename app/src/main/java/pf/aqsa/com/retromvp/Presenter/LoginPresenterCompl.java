package pf.aqsa.com.retromvp.Presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.squareup.otto.Produce;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import pf.aqsa.com.retromvp.Model.ErrorEvent;
import pf.aqsa.com.retromvp.Model.ServerEvent;
import pf.aqsa.com.retromvp.Model.ServerResponse;
import pf.aqsa.com.retromvp.Service.RemoteInterface;
import pf.aqsa.com.retromvp.Service.RemoteService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by Mahek on 1/12/2018.
 */

public class LoginPresenterCompl implements LoginPresenter {

    Context context;
  public   LoginPresenterCompl(Context context){

      this.context=  context;

  }

    @Override
    public void doLogin(String name, String passwd) {
        //Here a logging interceptor is created
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        //The logging interceptor will be added to the http client
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        httpClient.addInterceptor(logging);
//
//        //The Retrofit builder will have the client attached, in order to get connection logs
//        Retrofit retrofit = new Retrofit.Builder()
//                .client(httpClient.build())
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(SERVER_URL)
//                .build();

        RemoteInterface service = RemoteService.getClient().create(RemoteInterface.class);


        Call<ServerResponse> call = service.post("login",name,passwd);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
              //  BusProvider.getInstance().post(new ServerEvent(response.body()));
                Toast.makeText(context.getApplicationContext(),String.valueOf(response.body()),Toast.LENGTH_SHORT).show();
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
    public void doSignUp(String name, String passwd) {

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
