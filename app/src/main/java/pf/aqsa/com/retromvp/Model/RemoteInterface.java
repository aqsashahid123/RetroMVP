package pf.aqsa.com.retromvp.Model;

import pf.aqsa.com.retromvp.Model.ServerResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Mahek on 1/12/2018.
 */

public interface RemoteInterface {

    @FormUrlEncoded
    @POST("login.php")
    Call<ServerResponse> post(
          //  @Field("method") String method,
            @Field("email") String username,
            @Field("password") String password
    );

    //This method is used for "GET"
//    @GET("api.php")
//    Call<ServerResponse> get(
//            @Query("method") String method,
//            @Query("username") String username,
//            @Query("password") String password
//    );

    @FormUrlEncoded
    @POST("sign_up.php")
    Call<ServerResponse> signUp(
            @Field("userName") String userName,
            @Field("email") String username,
            @Field("password") String password
    );





}
