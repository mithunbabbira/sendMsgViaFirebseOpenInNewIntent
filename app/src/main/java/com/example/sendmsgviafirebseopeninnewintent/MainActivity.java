package com.example.sendmsgviafirebseopeninnewintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private RequestQueue mRequestQue;


    private String URL = "https://fcm.googleapis.com/fcm/send";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (getIntent().hasExtra("operatingSYS")){
            Intent intent = new Intent(MainActivity.this,RecieveNotificationActivity.class);
            intent.putExtra("brandID",getIntent().getStringExtra("operatingSYS"));
            intent.putExtra("operatingSYS",getIntent().getStringExtra("brandId"));
            startActivity(intent);
        }

        Button button = findViewById(R.id.btn);
        mRequestQue = Volley.newRequestQueue(this);
        FirebaseMessaging.getInstance().subscribeToTopic("news");


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
        notificationOBJ.put("title","BABBIRA ");
        notificationOBJ.put("body","MSG");

        JSONObject extraData = new JSONObject();
        extraData.put("brandID","ONEPLUS");
        extraData.put("operatingSYS","ANDROID");



        mainObj.put("notification",notificationOBJ);
        mainObj.put("data",extraData);




        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, URL,
                mainObj,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // success

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // error

            }
        }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String,String> header = new HashMap<>();
                header.put("content-type","application/json");
                header.put("authorization","key=AAAAm708nGo:APA91bGSqWOW9PmztijrhICFXuFpAkWfHDyXGnO_6IzjOcq4sZmpEgfZ8IDFOPCupjSGLz__sn-T1zvmOxPOy9xJLCgkP3OUlF9iADIk_eDD_omIJHs39OJI9uGTTM6etGQmu3-LlayR");
                return header;
            }
        };

        mRequestQue.add(request);






    }
}