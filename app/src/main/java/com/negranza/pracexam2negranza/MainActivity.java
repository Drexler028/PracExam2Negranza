package com.negranza.pracexam2negranza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    CheckBox cb1, cb2, cb3, cb4,cb5, cb6, cb7, cb8;
    EditText string1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.checkBox);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        cb4 = findViewById(R.id.checkBox4);
        cb5 = findViewById(R.id.checkBox5);
        cb6 = findViewById(R.id.checkBox6);
        cb7 = findViewById(R.id.checkBox7);
        cb8 = findViewById(R.id.checkBox8);
        string1 = findViewById(R.id.editText3);
    }

    public void next(View v) {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }

    public void saveData(View v) {
        String data1 = cb1.getText().toString()+ " \n";
        String data2 = cb2.getText().toString()+ " \n";
        String data3 = cb3.getText().toString()+ " \n";
        String data4 = cb4.getText().toString()+ " \n";
        String data5 = cb5.getText().toString()+ " \n";
        String data6 = cb6.getText().toString()+ " \n";
        String data7 = cb7.getText().toString()+ " \n";
        String data8 = cb8.getText().toString()+ " \n";
        String BigData = "";
        if (cb1.isChecked()) {
            BigData = BigData + data1;
        }
        if (cb2.isChecked()) {
            BigData = BigData + data2;
        }
        if (cb3.isChecked()) {
            BigData = BigData + data3;
        }
        if (cb4.isChecked()) {
            BigData = BigData + data4;
        }
        if (cb5.isChecked()) {
            BigData = BigData + data5;
        }
        if (cb6.isChecked()) {
            BigData = BigData + data6;
        }
        if (cb7.isChecked()) {
            BigData = BigData + data7;
        }
        if (cb8.isChecked()) {
            BigData = BigData + data8;
        }

        String string = string1.getText().toString();

        FileOutputStream writer = null;
        FileOutputStream writer2 = null;
        try {
            writer = openFileOutput("data.txt", MODE_PRIVATE);
            writer2 = openFileOutput("data2.txt", MODE_PRIVATE);
            writer.write(BigData.getBytes());
            writer2.write(string.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("Error", "File not found");
        } catch (IOException e){
            Log.d("Error", "IO Error");
        } finally {
            try {
                writer.close();
                writer2.close();
            } catch (IOException e) {
                Log.d("Error", "File not found");
            }
        }
        Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show();
    }


    }


