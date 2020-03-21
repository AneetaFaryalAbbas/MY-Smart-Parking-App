package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.manojbhadane.PaymentCardView;

public class CheckOutActivity extends AppCompatActivity {
    PaymentCardView paymentCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         //paymentCard = (PaymentCardView) findViewById(R.id.creditCard);
        setContentView(R.layout.check_out_activity);


    }
}
