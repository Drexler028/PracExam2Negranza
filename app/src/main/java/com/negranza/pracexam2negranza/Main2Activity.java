package com.negranza.pracexam2negranza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    TextView C1, C2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        C1 = findViewById(R.id.textView4);
        C2 = findViewById(R.id.textView5);

        FileInputStream reader = null;
        String data = "";
        try {
            reader = openFileInput("data.txt");
            int token;

            while ((token = reader.read()) !=-1){
                data = data + (char)token;
            }
        }
        catch (FileNotFoundException e){
            Log.d("Error", "No file");
        }
        catch (IOException e){
            Log.d("Error", "IO Error");
        }
        C1.setText(data);

    }

    public void previous(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void saved(View v){
        Toast.makeText(this, "Registration sent!", Toast.LENGTH_LONG).show();
    }


}
