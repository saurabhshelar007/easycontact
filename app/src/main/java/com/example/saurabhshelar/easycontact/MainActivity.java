package com.example.saurabhshelar.easycontact;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

    DatabaseHelper databaseHelper;

    Button insert;
Button btnviewAll;
    Button searchData;

    Button btnDelete;

    Button update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        btnviewAll = (Button) findViewById(R.id.button_viewAll);

        insert = (Button) findViewById(R.id.btnAdd);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);
            }

        });


        searchData = (Button) findViewById(R.id.btnSearch);

        searchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        btnDelete = (Button) findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DeleteActivity.class);
                startActivity(intent);
            }
        });

        update = (Button) findViewById(R.id.btnUpdate);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(intent);
            }
        });

        btnviewAll.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Cursor res = databaseHelper.getAllData();
                                              if (res.getCount() == 0) {
                                                  // show message
                                                  showMessage("Error", "Nothing found");
                                                  return;
                                              }

                                              StringBuffer buffer = new StringBuffer();
                                              while (res.moveToNext()) {
                                                  buffer.append("NAME :" + res.getString(1) + "\n");
                                                  buffer.append("MOBILE_NO :" + res.getString(2) + "\n");
                                                  buffer.append("EMAIL :" + res.getString(3) + "\n");
                                                  buffer.append("\n**********************\n");
                                              }

                                              // Show all data
                                              showMessage("Data", buffer.toString());
                                          }
                                      }
        );


    }///////////



@Override
public  void onBackPressed(){

    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
    builder.setTitle("Really Exit?")
            .setMessage("Do You Really Want To Exit?")
            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
               MainActivity.super.onBackPressed();

                }
            }).setNegativeButton("cancel",null);
    AlertDialog alert=builder.create();
    alert.show();

}



    public void showMessage(String title, String Message) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}