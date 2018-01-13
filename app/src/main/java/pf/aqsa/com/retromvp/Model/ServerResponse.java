package pf.aqsa.com.retromvp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mahek on 1/12/2018.
 */

public class ServerResponse implements ServerResponseInterface{

//    @SerializedName("id")
//    private int id;
//    @SerializedName("name")
//    private String username;
//    @SerializedName("email")
//    private String email;
//    @SerializedName("password")
//    private String message;
@SerializedName("id")
@Expose
private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("date")
    @Expose
    private String date;


    public ServerResponse(String username, String password, String message, String responseCode){
        this.name = username;
        this.email = password;
//        this.message = message;
        this.id = responseCode;
    }



    /////////////////////////
    @Override
    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



}
