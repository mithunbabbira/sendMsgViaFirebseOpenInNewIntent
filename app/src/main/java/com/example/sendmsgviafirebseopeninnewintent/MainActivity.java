package com.example.sendmsgviafirebseopeninnewintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    private RequestQueue mRequestQue;


    private String URL = "https://fcm.googleapis.com/fcm/send";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn);
        mRequestQue = Volley.newRequestQueue(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    sendNotification();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void sendNotification() throws JSONException {

        JSONObject mainObj = new JSONObject();
        //add main/parent/root name
        mainObj.put("to","/topics/"+"news");



        //below content is sent to other device
        JSONObject notificationOBJ = new JSONObject();
        notificationOBJ.put("title","any title");
        notificationOBJ.put("body","any .. body");

        mainObj.put("notification",notificationOBJ);






    }
}