package com.example.saurabhshelar.easycontact;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.opengl.EGLExt;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    private Button button;

    EditText searchText;
    Button search;
    TextView name, email,mobileno;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);



        databaseHelper = new DatabaseHelper(this);

        searchText = (EditText) findViewById(R.id.etSearch);

        search = (Button) findViewById(R.id.btSearch);

        name = (TextView) findViewById(R.id.tvName);
        email = (TextView) findViewById(R.id.tvEmail);
        mobileno=(TextView)findViewById(R.id.tvMobileNo);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = databaseHelper.getData(searchText.getText().toString());

                name.setText(" ");
                email.setText(" ");
                mobileno.setText(" ");
                boolean flag=false;
                while(cursor.moveToNext())
                {
                    flag=true;
                    name.setText(cursor.getString(1));
                    mobileno.setText(cursor.getString(2));
                    String phone =cursor.getString(2);
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                    startActivity(intent);
                    email.setText(cursor.getString(3));
                }
                if(flag==false)
                    Toast.makeText(SearchActivity.this, "No Data Belonging To This Contact", Toast.LENGTH_SHORT).show();



            }


        }


        );


       /*
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String phone = "+919156926643";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });



*/

    }
}