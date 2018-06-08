package com.example.quader.quadersapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class WeightedPrice extends AppCompatActivity {

    EditText txtKG, txtMRP, txtGrams;
    TextView resultView;
    Double dblMRP, dblResult;
    int intKG, intGrams;
    String output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weighted_price);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void btnCalculateOnClick(View v) {

        txtMRP = (EditText) findViewById(R.id.txtMRP);
        if (txtMRP.getText().length() > 0) {
            resultView = (TextView) findViewById(R.id.lblResult);

            txtKG = (EditText) findViewById(R.id.txtKG);
            txtGrams = (EditText) findViewById(R.id.txtGrams);

            dblMRP = Double.valueOf(txtMRP.getText().toString());


            if (txtKG.getText().length() == 0)
                intKG = 0;
            else
                intKG = Integer.valueOf(txtKG.getText().toString());


            if (txtGrams.getText().length() != 0)
                intGrams = Integer.valueOf(txtGrams.getText().toString());
            else
                intGrams = 0;


            dblResult=(dblMRP * intKG) + (dblMRP * (intGrams * 0.001));

            output = "You need to pay Rs. " + String.valueOf(dblResult);

        } else
            output = "Please enter the Rate per KG";

        resultView.setText(output);

        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
