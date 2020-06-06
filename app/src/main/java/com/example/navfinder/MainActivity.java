package com.example.navfinder;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstName;
    EditText lastName;
    EditText phoneNumber;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        phoneNumber = findViewById(R.id.phone_number);
        email = findViewById(R.id.email);
        Button register = (Button) findViewById(R.id.registered);

        /**
         * This sets an onClickListener on the registered button
         */
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDataEntered();
            }
        });

        /**
         * Find the view that shows the sign up xml
         */

        Button signUp = (Button) findViewById(R.id.sign_up);

        /**
         * set a clickListener that shows the View
         */

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create a intent to open the {@link SignUpActivity}
                Intent signUpIntent = new Intent(MainActivity.this, SignUpActivity.class);
                //Start the new Activity
                startActivity(signUpIntent);
            }
        });
    }

    /**
     * This methods check for a valid email
     * @param text
     * @return
     */
        boolean isEmail(EditText text){
            CharSequence email = text.getText().toString();
            return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        }


        boolean isEmpty(EditText text){
            CharSequence str = text.getText().toString();
            return TextUtils.isEmpty(str);
        }

    /**
     *This method checks for valid firstName and lastName
     */
        void checkDataEntered() {
            if (isEmpty(firstName)) {
                Toast t = Toast.makeText(this, "You must enter the first name to register", Toast.LENGTH_SHORT);
                t.show();
            }
            if (isEmpty(lastName)) {
                lastName.setError("Last name is required!");
            }
            if (isEmail(email) == false) {
                email.setError("Enter valid email");
            }
        }
    }

   



