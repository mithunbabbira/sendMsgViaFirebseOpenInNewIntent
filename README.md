//    go to firebase and create a project
//    select add app
//    paste the above package name there
//    download the json file and
//    paste it in (Project > app)


gradleProject > classpath 'com.google.gms:google-services:4.3.3'




gradleApp > implementation 'com.android.volley:volley:1.1.0'
	    implementation 'com.google.firebase:firebase-messaging:20.2.0'
	    apply plugin: 'com.google.gms.google-services'



go to firebase and search "Firebase Cloud Messaging HTTP protocol" 
  -and we get = https://fcm.googleapis.com/fcm/send



get to get the SHA1 key from android studio and paste it in firebase fingerprint SHA1 



go to firebae and search "Receive messages in an Android app"
 and copy the "FirebaseMessagingService" code and paste it in manifest and change the java file name with exsiting one 

go to firebae and search "Receive messages in an Android app"
 and copy the "meta-data" code and paste it in manifest
