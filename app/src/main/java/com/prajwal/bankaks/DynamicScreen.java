package com.prajwal.bankaks;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.prajwal.bankaks.model.Main;
import com.prajwal.bankaks.model.Result;
import com.prajwal.bankaks.network.ApiClient;
import com.prajwal.bankaks.network.ApiInterface;
import com.prajwal.bankaks.utilities.Option_1;
import com.prajwal.bankaks.utilities.Option_2;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DynamicScreen extends AppCompatActivity {
    int selected_spinner_text;
    Result result;
    ApiInterface apiInterface;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_dynamic_screen);
        context = DynamicScreen.this;

        Intent intent = this.getIntent();
        selected_spinner_text = intent.getIntExtra("spinner", 1);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Main> mainCall = apiInterface.getDynamicUI(selected_spinner_text);

        mainCall.enqueue(new Callback<Main>() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onResponse(Call<Main> call, Response<Main> response) {
                result = response.body().getResult();
                //dynamic ui starts here...
                if(selected_spinner_text == 1 && response.isSuccessful()) {
                    LinearLayout linearLayout = new Option_1().option_1_Screen(context, result);
                    DynamicScreen.this.setContentView(linearLayout);
                }
                else if(selected_spinner_text == 2 && response.isSuccessful()) {
                    LinearLayout linearLayout = new Option_2().option_2_Screen(context, result);
                    DynamicScreen.this.setContentView(linearLayout);
                }


            }

            @Override
            public void onFailure(Call<Main> call, Throwable t) {
                Log.d("tag", "tag");
                Toast.makeText(context, "Check your internet connection...", Toast.LENGTH_SHORT).show();
            }
        });

        }
}