package com.example.quader.quadersapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Quader on 14-06-2016.
 */
public class DiscountPercentage extends AppCompatActivity {

    EditText txtPercent, txtMRP;
    TextView resultView;
    Double dblMRP, dblDiscount, dblResult;
    int intPercent;
    String output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_discounted_price);

    }

    public void btnCalculateOnClick(View v) {

        resultView = (TextView) findViewById(R.id.lblResult);

        txtPercent = (EditText) findViewById(R.id.txtPercent);
        txtMRP = (EditText) findViewById(R.id.txtMRP);

        intPercent = Integer.valueOf(txtPercent.getText().toString());
        dblMRP = Double.valueOf(txtMRP.getText().toString());

        if (intPercent <= 0 || intPercent > 100) {
            output = "You have entered invalid percentage";
        } else if (dblMRP <= 0) {
            output = "You have entered invalid M.R.P";
        } else {
            dblDiscount = dblMRP * (intPercent * 0.01);

            dblResult = dblMRP - dblDiscount;

            output = "You need to pay Rs. " + String.valueOf(dblResult) + " after the Discount of Rs. " + String.valueOf(dblDiscount);
        }

        resultView.setText(output);

        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
