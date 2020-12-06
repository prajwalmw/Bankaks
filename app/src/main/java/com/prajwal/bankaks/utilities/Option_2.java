package com.prajwal.bankaks.utilities;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.prajwal.bankaks.R;
import com.prajwal.bankaks.model.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prajwal Waingankar
 * on 06-Dec-20.
 * Github: prajwalmw
 */


public class Option_2 {

    public LinearLayout option_2_Screen(Context context, Result result) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //Title...
        TextView title = new TextView(context);
        title.setPadding(20, 50, 10, 80);
        title.setTextSize(16F);
        title.setTextAppearance(context, R.style.TextAppearance_AppCompat_Title);
        title.setText(result.getScreenTitle());

        RelativeLayout r1 = new RelativeLayout(context);
        r1.setId(View.generateViewId());
        //r1.setBackground(getDrawable(R.color.purple_200));
        RelativeLayout.LayoutParams r_L1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        r_L1.setMargins(30, 0, 50, 0);

        //month
        TextView month_text = new TextView(context);
        month_text.setId(View.generateViewId());
        month_text.setText(result.getFields().get(0).getPlaceholder());
        r1.addView(month_text, r_L1);
        //month drop-down
        List<String> month_array = new ArrayList<>();
        for (int i = 0; i < result.getFields().get(0).getUiType().getValues().size(); i++) {
            month_array.add(result.getFields().get(0).getUiType().getValues().get(i).getName());
        }

        Spinner spinner = new Spinner(context);
        spinner.setFocusable(true);
        RelativeLayout r_s = new RelativeLayout(context);
        r1.setId(View.generateViewId());
        //r1.setBackground(getDrawable(R.color.purple_200));
        RelativeLayout.LayoutParams r_L_S = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        r_s.addView(spinner, r_L_S);

        r_L1.addRule(RelativeLayout.BELOW, month_text.getId());
        month_array.add(0, result.getFields().get(0).getHintText());
        spinner.setSelection(0);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>
                (context, android.R.layout.simple_spinner_dropdown_item, month_array);
        spinner.setAdapter(arrayAdapter);

        RelativeLayout b_rel = new RelativeLayout(context);
        RelativeLayout.LayoutParams b_rel_par = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        b_rel_par.setMargins(0, 100, 0, 0);
        b_rel_par.addRule(RelativeLayout.CENTER_HORIZONTAL);
        Button button = new Button(context);
        button.setText("Proceed");
        button.setPadding(0, 50, 0, 50);
        b_rel.addView(button, b_rel_par);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getFields().get(0).getIsMandatory().equalsIgnoreCase("true")) {
                    if(spinner.getSelectedItemPosition() != 0) {
                        Toast.makeText(context, "Month: "+ spinner.getSelectedItem(), Toast.LENGTH_SHORT).show();
                    }
                    else {
                        TextView t = (TextView) spinner.getSelectedView();
                        spinner.requestFocus();
                        t.setError("Select Month");
                        t.setTextColor(Color.RED);
                        Toast.makeText(context, "Please Select Month from DropDown", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        linearLayout.addView(title);
        linearLayout.addView(r1);
        linearLayout.addView(r_s);
        linearLayout.addView(b_rel);


        return linearLayout;
    }
}
