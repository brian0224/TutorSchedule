package com.deitel.studymatch;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by Brian on 3/17/2017.
 */

public class FacebookFragment extends AppCompatActivity {

    TextView textView;
    LoginButton loginButton;
    CallbackManager mCallbackManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView (R.layout.activity_main);
        loginButton = (LoginButton) findViewById (R.id.facebookButton);

        mCallbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                textView.setText("Login Sucess\n" +
                        loginResult.getAccessToken().getUserId()+
                        "\n"+ loginResult.getAccessToken().getToken());
            }

            @Override
            public void onCancel() {
                textView.setText("Login Cancelled");
            }

            @Override
            public void onError(FacebookException error) {

            }
        });

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.activity_main, container, false);
    }



    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

}

