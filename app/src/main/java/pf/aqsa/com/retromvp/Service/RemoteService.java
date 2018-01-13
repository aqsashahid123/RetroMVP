package pf.aqsa.com.retromvp.Service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mahek on 1/12/2018.
 */

public class RemoteService {
public static final String BASE_URL = "http://192.168.8.102/OneByteTest/";


public static Retrofit getClient(){


    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(HttpLoggingInterceptor.Level.BODY);

    //The logging interceptor will be added to the http client
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    httpClient.addInterceptor(logging);

    //The Retrofit builder will have the client attached, in order to get connection logs
    Retrofit retrofit = new Retrofit.Builder()
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build();

    return retrofit;
}

}
