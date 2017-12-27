package com.example.saurabhshelar.easycontact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText number,email,name;

    Button update;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        number= (EditText) findViewById(R.id.etNumber);

        email= (EditText) findViewById(R.id.etEmail);

        name= (EditText) findViewById(R.id.etName);

        update = (Button) findViewById(R.id.btnUpdate);

        databaseHelper = new DatabaseHelper(this);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseHelper.updateData(number.getText().toString(),name.getText().toString(),email.getText().toString());
                Toast.makeText(UpdateActivity.this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();

            }
        });




    }
}