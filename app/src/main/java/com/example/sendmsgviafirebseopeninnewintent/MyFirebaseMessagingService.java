package com.example.sendmsgviafirebseopeninnewintent;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String title = remoteMessage.getNotification().getTitle();
        String body = remoteMessage.getNotification().getBody();

        Map<String,String>extraData = remoteMessage.getData();

        String brandID = extraData.get("brandID");
        String category = extraData.get("operatingSYS");

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this ,"BDM")
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.ic_launcher_background);

        Intent intent;
        if (category.equals("ANDROID")){
            intent = new Intent(this,RecieveNotificationActivity.class);

        }
        else{
            intent = new Intent(this,RecieveNotificationActivity.class);
            Toast.makeText(this,"failed", Toast.LENGTH_LONG);
        }
        intent.putExtra("brandID",brandID);
        intent.putExtra("operatingSYS",category);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,10,intent,PendingIntent.FLAG_UPDATE_CURRENT);


        notificationBuilder.setContentIntent(pendingIntent);


        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


        int id =(int)System.currentTimeMillis();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_0_1){
            NotificationChannel channel = new NotificationChannel("BDM","demo",NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);

        }
        notificationManager.notify(id,notificationBuilder.build());


    }
}
