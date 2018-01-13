package pf.aqsa.com.retromvp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import pf.aqsa.com.retromvp.Presenter.HomeScreenPresenter;
import pf.aqsa.com.retromvp.Presenter.HomeScreenPresenterCompl;
import pf.aqsa.com.retromvp.Presenter.LoginPresenter;
import pf.aqsa.com.retromvp.Presenter.LoginPresenterCompl;
import pf.aqsa.com.retromvp.View.IView;
import pf.aqsa.com.retromvp.View.IViewClass;
import pf.aqsa.com.retromvp.View.ViewPresenter;
import pf.aqsa.com.retromvp.Presenter.ViewPresenterCompl;

public class MainActivity extends AppCompatActivity implements HomeScreenPresenter {


    EditText etEmail,etPassword;
    Button btnLogin;
   // LoginPresenter presenter;
    boolean loginStatus;
    LoginPresenter presenter;
    TextView tvSignUp;
    ViewPresenter viewPresenter;
    HomeScreenPresenterCompl presenterCompl;
    IView iv;
    HomeScreenPresenter homeScreenPresenter;
 //   LoginPresenterCompl loginPresenterCompl;
    private final static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvSignUp = (TextView) findViewById(R.id.tvSignUp);
     //  homeScreenPresenter = new HomeScreenPresenterCompl(this);
        final IViewClass iv = new IViewClass();
        presenterCompl = new HomeScreenPresenterCompl(this);
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.LaunchActivity(MainActivity.this);
            }
        });

        presenter = new LoginPresenterCompl(this);
     //   viewPresenter = new ViewPresenterCompl(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               loginStatus=  presenter.doLogin(etEmail.getText().toString(),etPassword.getText().toString());
                if (loginStatus){

                    moveToHome();

                }
                else {
                  //  homeScreenPresenter.moveToHome();
//                    presenterCompl.goToHomeScreen();
                   Toast.makeText(getApplicationContext(),"Die",Toast.LENGTH_SHORT).show();



                }


            }
        });

    }

    @Override
    public void moveToHome() {
        Intent intent = new Intent(getApplicationContext(),HomeScreen.class);
        startActivity(intent);
    }

//    @Override
//    public void onLoginResult(Boolean result, int code) {
//        if (result){
//
//            Intent intent = new Intent(MainActivity.this,HomeScreen.class);
//            startActivity(intent);
//
//        }
//    }

//    @Override
//    public void onSignUpResult(Boolean result, int code) {
//
//    }
////
//    @Override
//    public void onLoginResult(Boolean result, int code) {
//        if (result){
//            viewPresenter.MoveToTheHomeActivity(getApplicationContext());
//
//
//        }
//    }

//    @Override
//    public void onSignUpResult(Boolean result, int code) {
//
//    }


//    @Override
//    public void MoveToTheHomeActivity(Context context) {
//     if (presenter.onLoginResult();)
//    }
}
