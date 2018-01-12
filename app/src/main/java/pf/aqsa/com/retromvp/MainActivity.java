package pf.aqsa.com.retromvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pf.aqsa.com.retromvp.Presenter.LoginPresenter;
import pf.aqsa.com.retromvp.Presenter.LoginPresenterCompl;
import pf.aqsa.com.retromvp.View.IView;

public class MainActivity extends AppCompatActivity implements IView{


    EditText etEmail,etPassword;
    Button btnLogin;
   // LoginPresenter presenter;
    LoginPresenter presenter;
 //   LoginPresenterCompl loginPresenterCompl;
    private final static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);



        presenter = new LoginPresenterCompl(this);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.doLogin(etEmail.getText().toString(),etPassword.getText().toString());



            }
        });

    }

    @Override
    public void onLoginResult(Boolean result, int code) {

    }

    @Override
    public void onSignUpResult(Boolean result, int code) {

    }
}
