package com.prajwal.bankaks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.prajwal.bankaks.model.Main;
import com.prajwal.bankaks.model.Result;
import com.prajwal.bankaks.network.ApiClient;
import com.prajwal.bankaks.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    Spinner spinner;
    Button button;
    int selected_option;
    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.option_spinner);
        button = findViewById(R.id.proceed_main_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spinner_text = spinner.getSelectedItem().toString();
                if(spinner_text.equalsIgnoreCase("Option 1")) selected_option = 1;
                else if(spinner_text.equalsIgnoreCase("Option 2")) selected_option = 2;
                else if(spinner_text.equalsIgnoreCase("Option 3")) selected_option = 3;

                Intent intent = new Intent(MainActivity.this, DynamicScreen.class);
                intent.putExtra("spinner", selected_option);
                startActivity(intent);
            }
        });


    }
}