package com.proyectofinal.picoplaca.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.proyectofinal.picoplaca.Interfaces.LoginPresenter;
import com.proyectofinal.picoplaca.Interfaces.LoginView;
import com.proyectofinal.picoplaca.Presenters.LoginPresenterImpl;
import com.proyectofinal.picoplaca.Presenters.UsuarioImpl;
import com.proyectofinal.picoplaca.Presenters.daoUsuario;
import com.proyectofinal.picoplaca.R;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener{

    EditText etpass, etusername;
    Button btn1,btn2;
    daoUsuario dao;
    ProgressBar progressBar;
    private LoginPresenter presenter;

    //LOGEO GOOGLE
    int RC_SIGN_IN = 0;
    SignInButton signInButton;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        etusername = (EditText) findViewById(R.id.et_user);
        etpass = (EditText) findViewById(R.id.et_password);
        btn1 = (Button) findViewById(R.id.buttonEntrar);
        btn2 = (Button) findViewById(R.id.buttonRegistrar);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        dao = new daoUsuario(this);
        //Inicio de sesion
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        //implementar implements
        presenter = new LoginPresenterImpl(this);

        //-------------------GOOGLE------------------------
        //Initializing Views
        signInButton = findViewById(R.id.sign_in_button);

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.buttonEntrar:

                String u= etusername.getText().toString();
                String p = etpass.getText().toString();
                if(u.equals("")&&p.equals("")){
                    Toast.makeText(this,"Error, campos vacios", Toast.LENGTH_LONG).show();
                }else if(dao.login(u,p)==1){
                    UsuarioImpl ux = dao.getUsuario(u,p);
                    Toast.makeText(this,"Datos CORRECTOS", Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(LoginActivity.this, HomeActivity.class);
                    i2.putExtra("Id", ux.getId());
                    startActivity(i2);
                    finish();

                }else{
                    Toast.makeText(this,"Usuario O PASSWORD INCORRECTO ", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.buttonRegistrar:
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }



    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }else{
            //Si inicia por el otro metodo
            Log.i("a",null);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI.
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("Google Sign In Error", "signInResult:failed code=" + e.getStatusCode());
            Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStart() {
        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account != null) {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        }
        super.onStart();
    }

    //-------------------GOOGLE------------------------

    public void showProgress(){
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgress(){
        progressBar.setVisibility(View.GONE);
    }

    public void setErrorUser(){
        etusername.setError("CAMPO OBLIGATORIO");
    }

    public void setErrorPassword(){
        etpass.setError("Campo obligatorio");
    }

    public void navigateToHome(){
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void validacion(View v){
        presenter.validarUsuario(etusername.getText().toString(),etpass.getText().toString());
    }
}
