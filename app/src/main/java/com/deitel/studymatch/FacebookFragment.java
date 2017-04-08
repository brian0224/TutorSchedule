package com.deitel.studymatch;

import android.app.Fragment;
import android.content.Intent;
import android.hardware.camera2.params.Face;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by Brian on 3/17/2017.
 */

public class FacebookFragment extends AppCompatActivity {

    TextView studymatch;
    LoginButton loginButton;
    CallbackManager mCallbackManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_main);
        /*

        FacebookSdk.sdkInitialize(getApplicationContext());
        studymatch = (TextView) findViewById(R.id.studymatch);
        loginButton = (LoginButton) findViewById (R.id.facebookButton);


        mCallbackManager = CallbackManager.Factory.create();


        LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                studymatch.setText("Welcome" +
                        loginResult.getAccessToken().getUserId()+
                        "\n"+ loginResult.getAccessToken().getToken());
                Intent facebookact = new Intent(FacebookFragment.this, tuitorsearch_activities.class);
                startActivity(facebookact);

            }

            @Override
            public void onCancel() {
                studymatch.setText("Login Cancelled");
                //Toast.makeText(getApplicationContext(), R.string.cancel_login, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                studymatch.setText("error" + error.getMessage() );
               // Toast.makeText(getApplicationContext(),R.string.error_login, Toast.LENGTH_SHORT).show();
            }
        });

        */

    }

  /*  private void onMainScreen()
    {
        Intent facebookact = new Intent(this, MainActivity.class);
        Intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(facebookact);
    }
*/



    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

}

