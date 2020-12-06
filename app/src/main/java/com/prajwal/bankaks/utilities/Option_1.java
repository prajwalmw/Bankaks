package com.prajwal.bankaks.utilities;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.prajwal.bankaks.DynamicScreen;
import com.prajwal.bankaks.R;
import com.prajwal.bankaks.model.Result;

/**
 * Created by Prajwal Waingankar
 * on 06-Dec-20.
 * Github: prajwalmw
 */


public class Option_1 {


    /**
     * @param context The context of the Dyanmic activity class.
     * @param result The instance of the Result api class.
     * @return LinearLayout is the return type for this function.
     */
    public LinearLayout option_1_Screen(Context context, Result result) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

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
        sc_edit.setFocusable(true);
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
        cust_edit.setFocusable(true);
        r_L2.addRule(RelativeLayout.BELOW, cust_id.getId());
        cust_edit.setPadding(10, 120, 10, 30);
        cust_edit.setHint(result.getFields().get(1).getHintText());

        r2.addView(cust_id, r_L2);
        r2.addView(cust_edit, r_L2);

        RelativeLayout b_rel = new RelativeLayout(context);
        RelativeLayout.LayoutParams b_rel_par = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        b_rel_par.setMargins(0, 100, 0, 0);
        b_rel_par.addRule(RelativeLayout.CENTER_HORIZONTAL);
        Button b1 = new Button(context);
        b1.setText("Proceed");
        b1.setPadding(0, 50, 0, 50);
        b_rel.addView(b1, b_rel_par);

        linearLayout.addView(title);
        linearLayout.addView(r1);
        linearLayout.addView(r2);
        linearLayout.addView(b_rel);
        //this.DynamicScreen.setContentView(linearLayout);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getFields().get(0).getIsMandatory().equalsIgnoreCase("true")) {
                    if(sc_edit.getText().toString() == null || sc_edit.getText().toString().isEmpty()) {
                        sc_edit.requestFocus();
                        sc_edit.setError("This field is mandatory");
                        return;
                    }
                    else {
                        Toast.makeText(context, "SC Number: " +sc_edit.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
                if(result.getFields().get(1).getIsMandatory().equalsIgnoreCase("true")) {
                    if(cust_edit.getText().toString() == null || cust_edit.getText().toString().isEmpty()) {
                        cust_edit.requestFocus();
                        cust_edit.setError("This field is mandatory");
                        return;
                    }
                    else {
                        Toast.makeText(context, "Consumer ID: " + cust_edit.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return linearLayout;
    }


}
