package pf.aqsa.com.retromvp.Presenter;

/**
 * Created by Mahek on 1/12/2018.
 */

public interface LoginPresenter {

    boolean doLogin(String name, String passwd);
    boolean doSignUp(String name, String passwd,String userName);
    void onLoginResult(boolean res);
    //public void moveToHome();

}
