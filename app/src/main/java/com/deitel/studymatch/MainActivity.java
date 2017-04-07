package com.deitel.studymatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.FacebookCallback;


public class MainActivity extends AppCompatActivity {
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


    /*connect to facebook
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView;
        textView =(TextView) findViewById(R.id.studymatch);

        aboutusConnection();
        helpConnection();
        contactConnection();

        //facebookConnection();

        //This is a comment by Peter Tran.

    }
}
