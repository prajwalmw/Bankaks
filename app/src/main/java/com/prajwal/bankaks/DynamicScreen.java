package com.prajwal.bankaks;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.prajwal.bankaks.model.Main;
import com.prajwal.bankaks.model.Result;
import com.prajwal.bankaks.network.ApiClient;
import com.prajwal.bankaks.network.ApiInterface;

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
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(LinearLayout.VERTICAL);
//                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams().LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

                    //Title...
                    TextView title = new TextView(context);
                    title.setPadding(10, 50, 10, 80);
                    title.setTextSize(16F);
                    title.setTextAppearance(context, R.style.TextAppearance_AppCompat_Title);
                    title.setText(result.getScreenTitle());


                    //sc number for e-bill
                    RelativeLayout r1 = new RelativeLayout(context);
                    r1.setId(View.generateViewId());
                    //r1.setBackground(getDrawable(R.color.purple_200));
                    RelativeLayout.LayoutParams r_L1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    r_L1.setMargins(30, 0, 50, 0);

                    TextView sc_no = new TextView(context);
                    sc_no.setId(View.generateViewId());
                    sc_no.setText(result.getFields().get(0).getPlaceholder());

                    EditText sc_edit = new EditText(context);
                    r_L1.addRule(RelativeLayout.BELOW, sc_no.getId());
                    sc_edit.setPadding(10, 80, 10, 30);
                    sc_edit.setHint(result.getFields().get(0).getHintText());

                    r1.addView(sc_no, r_L1);
                    r1.addView(sc_edit, r_L1);



                    //customer field...
                    RelativeLayout r2 = new RelativeLayout(context);
                    //r2.setBackground(getDrawable(R.color.purple_200));
                    RelativeLayout.LayoutParams r_L2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    r_L2.addRule(RelativeLayout.BELOW, r1.getId());
                    r_L2.setMargins(30, 0, 50, 0);

                    TextView cust_id = new TextView(context);
                    cust_id.setId(View.generateViewId());
                    cust_id.setPadding(0, 50, 0, 0);
                    cust_id.setText(result.getFields().get(1).getPlaceholder());

                    EditText cust_edit = new EditText(context);
                    r_L2.addRule(RelativeLayout.BELOW, cust_id.getId());
                    cust_edit.setPadding(10, 120, 10, 30);
                    cust_edit.setHint(result.getFields().get(1).getHintText());

                    r2.addView(cust_id, r_L2);
                    r2.addView(cust_edit, r_L2);

                    Button b1 = new Button(context);
                    b1.setText("Proceed");
                    b1.setPadding(0, 50, 0, 50);

                    linearLayout.addView(title);
                    linearLayout.addView(r1);
                    linearLayout.addView(r2);
                    linearLayout.addView(b1);
                    DynamicScreen.this.setContentView(linearLayout);

                }}

            @Override
            public void onFailure(Call<Main> call, Throwable t) {

            }
        });

        }
}