package com.example.anjana.event_manager;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import static com.example.anjana.event_manager.R.id.loginBtn;


public class Main3Activity extends Activity     //implements View.OnClickListener
 {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newuser);
        //Button loginBtn = (Button) findViewById(R.id.loginBtn);
        addListenerOnButton();


    }

     public void addListenerOnButton() {

         final Context context = this;

         button = (Button) findViewById(loginBtn);

         button.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View arg0) {

                 Intent intent = new Intent(context, Main2Activity.class);
                 startActivity(intent);

             }

         });
     }
     public void onClick (View v) {
        final String username = (((EditText) findViewById(R.id.usernameET)).getText()).toString();
        final String password = (((EditText) findViewById(R.id.passwordET)).getText()).toString();;
        final String email = (((EditText) findViewById(R.id.passET)).getText()).toString();;
        final String mob = (((EditText) findViewById(R.id.passdET)).getText()).toString();;
        final String eventdate = (((EditText) findViewById(R.id.dateentryET)).getText()).toString();;

         ContentValues content = new ContentValues();
        content.put(DbHelper.COLUMN_NAME_UNAME, username);
        content.put(DbHelper.COLUMN_NAME_PASS, password);
        content.put(DbHelper.COLUMN_NAME_EMAIL,email);
        content.put(DbHelper.COLUMN_NAME_MOBL, mob);
        content.put(DbHelper.COLUMN_NAME_DATE, eventdate);

        if ( username.isEmpty() && password.isEmpty() && email.isEmpty() && mob.isEmpty() && eventdate.isEmpty() ) {
            Toast.makeText(Main3Activity.this, "All fields are empty!", Toast.LENGTH_SHORT).show();
        } else if( username.isEmpty() || email.isEmpty() || mob.isEmpty() ) {
            Toast.makeText(Main3Activity.this, "Name, Email and mobile are required fields!", Toast.LENGTH_SHORT).show();
        } else{
            //db.insert(DbHelper.TABLE_NAME, null, content);
            Toast.makeText(Main3Activity.this, "Thank you for your response!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }



        public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
        }

        public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

