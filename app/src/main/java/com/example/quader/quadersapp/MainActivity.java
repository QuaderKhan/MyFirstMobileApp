package com.example.quader.quadersapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.DiscountCaclulatorMenuItem:
                Intent discountperc = new Intent("com.example.quader.quadersapp.DiscountedPrice");
                startActivity(discountperc);
                Toast.makeText(getApplicationContext(), "Here you can calculate your discount", Toast.LENGTH_LONG).show();
                break;

            case R.id.WeightedPriceCaclulatorMenuItem:
                Intent weightedprice = new Intent("com.example.quader.quadersapp.WeightedPrice");
                startActivity(weightedprice);
                Toast.makeText(getApplicationContext(), "Here you can calculate your weighted price", Toast.LENGTH_LONG).show();
                break;

            default:
                return super.onOptionsItemSelected(item);

        }
        return false;
    }

    protected void weightPriceCalculator(View v)
    {
        Intent weightedprice = new Intent("com.example.quader.quadersapp.WeightedPrice");
        startActivity(weightedprice);
        Toast.makeText(getApplicationContext(), "Here you can calculate your weighted price", Toast.LENGTH_LONG).show();

    }

    protected void discountedPriceCalculator(View v)
    {
        Intent discountperc = new Intent("com.example.quader.quadersapp.DiscountedPrice");
        startActivity(discountperc);
        Toast.makeText(getApplicationContext(), "Here you can calculate your discount", Toast.LENGTH_LONG).show();
    }
}


