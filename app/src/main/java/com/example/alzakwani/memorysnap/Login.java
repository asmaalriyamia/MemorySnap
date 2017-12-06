package com.example.alzakwani.memorysnap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alzakwani.memorysnap.user_home.User_Home;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
EditText editText1;
EditText editText2;
    Spinner spinner;
    List<String> categories;
    ArrayAdapter<String> dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText1 =(EditText)findViewById(R.id.editText1);
        editText2 =(EditText)findViewById(R.id.editText2);


        spinner = (Spinner) findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        categories= new ArrayList<String>();

        categories.add("Female");
        categories.add("Male");

        //categories.add("Female");


        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView)v.findViewById(android.R.id.text1)).setText("Who are you?");
                   // ((TextView)v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                }

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount()-1; // you dont display last item. It is used as hint.
            }

        };



        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter.add("Customer");
        dataAdapter.add("Photographer");
        dataAdapter.add("who are you"); //hint
        spinner.setAdapter(dataAdapter);
        spinner.setSelection(dataAdapter.getCount());

    }

    public void signin(View view)
    {
        editText1 =(EditText)findViewById(R.id.mail);
        editText2 =(EditText)findViewById(R.id.password);

        if(editText1.getText().toString().trim().length()<=0 ||editText2.getText().toString().trim().length()<=0  )
        {
            Toast.makeText(this, "Please Enter name and password", Toast.LENGTH_SHORT).show();

        }
        else
        {
            Intent mainIntent = new Intent(Login.this, User_Home.class);
            Login.this.startActivity(mainIntent);

        }
    }
    public void signup(View view)
    {

            Intent mainIntent = new Intent(Login.this, Registeration.class);
            Login.this.startActivity(mainIntent);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(),"Done ...",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
