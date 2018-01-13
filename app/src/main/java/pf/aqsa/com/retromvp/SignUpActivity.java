package pf.aqsa.com.retromvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pf.aqsa.com.retromvp.Presenter.LoginPresenter;
import pf.aqsa.com.retromvp.Presenter.LoginPresenterCompl;
import pf.aqsa.com.retromvp.Presenter.ViewPresenterCompl;
import pf.aqsa.com.retromvp.View.IView;
import pf.aqsa.com.retromvp.View.ViewPresenter;

public class SignUpActivity extends AppCompatActivity {
    EditText etEmail,etPassword;
    Button btnSignup;
    // LoginPresenter presenter;
    LoginPresenter presenter;
    ViewPresenter viewPresenter;
    IView iv;
    //   LoginPresenterCompl l
    EditText etUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSignup = (Button) findViewById(R.id.btnLogin);
        etUserName = (EditText) findViewById(R.id.etUserName);


        presenter = new LoginPresenterCompl(this);
        viewPresenter = new ViewPresenterCompl(this);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.doSignUp(etEmail.getText().toString(),etPassword.getText().toString(),etUserName.getText().toString());



            }
        });

    }


    }

