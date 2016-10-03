package com.example.chen_hsi.androidtutnonfregment;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login);

        setMenu();
        setNavigation();



        Button submit=(Button)findViewById(R.id.bSubmit);
        final EditText username=(EditText)findViewById(R.id.ptUsername);
        final EditText password=(EditText)findViewById(R.id.ptPassword);



        TextView register=(TextView)findViewById(R.id.tvRegister);
        // Create the text message with a string

        submit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                String usernameString=username.getText().toString();
                String passwordString=password.getText().toString();
               /* String textMessage = "hi";
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
                sendIntent.setType("text/plain");

                // Verify that the intent will resolve to an activity
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }*/

                Toast.makeText(view.getContext(), "username= "+usernameString+"\n"+"password= "+passwordString, Toast.LENGTH_LONG).show();
            }

        });


        register.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

                Intent toRegister=new Intent();
                toRegister.setClass(LoginActivity.this,RegisterActivity.class);
                startActivity(toRegister);


            }

        });




    }
    private void setNavigation(){
        navigationView=(NavigationView)findViewById(R.id.left_drawer);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                Intent navigate=new Intent();

                switch (item.getItemId())
                {
                    case R.id.mHome:
                        break;
                    case R.id.mBook:
                        navigate.setClass(LoginActivity.this,LoginActivity.class);
                        startActivity(navigate);
                        break;

                    case R.id.mHistory:
                        navigate.setClass(LoginActivity.this,HistoryActivity.class);
                        startActivity(navigate);
                        break;
                    case R.id.mSearch:
                        navigate.setClass(LoginActivity.this,SearchActivity.class);
                        startActivity(navigate);
                        break;
                    case R.id.mLogin:
                        break;

                    case R.id.mRegister:
                        navigate.setClass(LoginActivity.this,RegisterActivity.class);
                        startActivity(navigate);
                        break;
                }
                return false;
            }

        });


    }

    private void setMenu(){

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        ActionBar actionBar=getSupportActionBar();

        if(myToolbar==null){
            Log.e("null","NUlllll,");
        }

        actionBar.setElevation((float) 2.5);
        actionBar.setTitle("LOGIN");
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,myToolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }




}

