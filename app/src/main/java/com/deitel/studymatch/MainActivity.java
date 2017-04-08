package com.deitel.studymatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class MainActivity extends AppCompatActivity {
    TextView studymatch;
    LoginButton loginButton;
    CallbackManager mCallbackManager;
    //connect to Aboutus
    public Button aboutus;

    public void aboutusConnection()
    {
        aboutus = (Button)findViewById(R.id.aboutus);
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutusact = new Intent(MainActivity.this, Aboutus_activities.class);
                startActivity(aboutusact);
            }
        });

    }

    //connect to help

    public Button help;

    public void helpConnection()
    {
        help = (Button)findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent helpact = new Intent(MainActivity.this, help_activities.class);
                startActivity(helpact);
            }
        });
    }

    //connect to contactus
    public Button contactus;

    public void contactConnection()
    {
        contactus = (Button)findViewById(R.id.contactus);
        contactus.setOnClickListener(new View.OnClickListener()
        {  @Override
            public void onClick(View v)
        {
            Intent contactact = new Intent(MainActivity.this, contactus_activities.class);
            startActivity(contactact);
        }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        aboutusConnection();
        helpConnection();
        contactConnection();
        InitializeControl();
        loginWithFB();     //facebookConnection();

        //This is a comment by Peter Tran.

    }

    private void InitializeControl() {

        studymatch = (TextView) findViewById(R.id.studymatch);
        loginButton = (LoginButton) findViewById(R.id.facebookButton);
        mCallbackManager = CallbackManager.Factory.create();
        Log.d("Status:","initialized" );
    }

    private void loginWithFB()
    {
        Log.d("Status:","login begin" );
        LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("Status:","login 1" );
                studymatch.setText("Welcome" +
                        loginResult.getAccessToken().getUserId()+
                        "\n"+ loginResult.getAccessToken().getToken());
                Intent aboutusact = new Intent(MainActivity.this, Aboutus_activities.class);
                startActivity(aboutusact);
            }

            @Override
            public void onCancel() {
                Log.d("Status:","login 2" );
                studymatch.setText("Login Cancelled");
                //Toast.makeText(getApplicationContext(), R.string.cancel_login, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("Status:","login 3" );
                studymatch.setText("error" + error.getMessage() );
                // Toast.makeText(getApplicationContext(),R.string.error_login, Toast.LENGTH_SHORT).show();
            }
        });

        Log.d("Status:","login end" );
    }
}


    /*
    connect to facebook
    public Button facebookButton;

    public void facebookConnection()
    {
        facebookButton = (Button)findViewById(R.id.facebookButton);
        facebookButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent facebookact = new Intent(MainActivity.this,tuitorsearch_activities.class);
                startActivity(facebookact);
            }
        }));
    }
*/