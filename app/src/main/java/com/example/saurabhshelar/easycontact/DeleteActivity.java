package com.example.saurabhshelar.easycontact;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    Button delete;

    EditText name;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        delete = (Button) findViewById(R.id.btnDelete);

        name = (EditText) findViewById(R.id.etNumber);

        databaseHelper = new DatabaseHelper(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder=new AlertDialog.Builder(DeleteActivity.this);
                builder.setMessage("Do You Really Want To Delete?")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,int which) {

                                databaseHelper.deleteData(name.getText().toString());
                                Toast.makeText(DeleteActivity.this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();

                            }
                        }).setNegativeButton("cancel",null);
                AlertDialog alert=builder.create();
                alert.show();


            }
        });


    }
}