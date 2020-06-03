package com.example.sendmsgviafirebseopeninnewintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RecieveNotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_notification);

        TextView categoryTv = findViewById(R.id.category);
        TextView brandtv = findViewById(R.id.brandID);


        if(getIntent().hasExtra("operatingSYS")){
            String category = getIntent().getStringExtra("operatingSYS");
            String brand = getIntent().getStringExtra("brandID");
            categoryTv.setText(category);
            brandtv.setText(brand);
        }
    }
}