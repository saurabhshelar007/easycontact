package com.example.saurabhshelar.easycontact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText name, mobile_number, email;
    Button save;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        databaseHelper = new DatabaseHelper(this);

        name = (EditText) findViewById(R.id.etName);

        mobile_number = (EditText) findViewById(R.id.etMobileNumber);

        email = (EditText) findViewById(R.id.etEmail);

        save = (Button) findViewById(R.id.btnSave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = databaseHelper.insertData(name.getText().toString(), mobile_number.getText().toString(),
                        email.getText().toString());
                if(result)
                    Toast.makeText(AddActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AddActivity.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
            }
        });


    }
}