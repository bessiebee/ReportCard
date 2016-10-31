package com.example.bessie.reportcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DataBaseHelper myDb;
     Button registerbtn;
    EditText etname , etusername ,etpassword , etnumbers ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

     registerbtn = (Button)findViewById(R.id.registerbtn);
        etname = (EditText)findViewById(R.id.etName);
        etnumbers =(EditText)findViewById(R.id.etnumbers);
        etusername=(EditText) findViewById(R.id.etUsername);
        etpassword=(EditText)findViewById(R.id.etPassword);

    }





}
