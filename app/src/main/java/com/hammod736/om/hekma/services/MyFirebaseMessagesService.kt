package com.hammod736.om.hekma.services

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.hammod736.om.hekma.R
import com.hammod736.om.hekma.Splash


const val CHANNEL_ID = "101"
const val CHANNEL_NAME = "NOTIFICATION_NAME"
@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class MyFirebaseMessagesService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        if (message.notification != null){
            generateNotification(message.notification!!.title!!,message.notification!!.body!!)
        }
    }
    private fun getRemoteView(title: String,body: String) : RemoteViews {
        val remoteView = RemoteViews("com.hammod736.om.hekma",R.layout.notification_layout)
        remoteView.setTextViewText(R.id.notificationTitle,title)
        remoteView.setTextViewText(R.id.notificationTitle,body)
        remoteView.setImageViewResource(R.id.notificationImage,R.drawable.logo)

        return remoteView
    }
    @SuppressLint("UnspecifiedImmutableFlag")
    fun generateNotification(title:String, body:String){
        val intent  = Intent(this,Splash::class.java)

        val pendingIntent = PendingIntent.getActivity(applicationContext,0,intent,PendingIntent.FLAG_ONE_SHOT)

        var builder : NotificationCompat.Builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setSmallIcon(R.drawable.logo)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000,1000,1000,1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pendingIntent)

        builder = builder.setContent(getRemoteView(title,body))

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationChannel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        notificationManager.notify(0,builder.build())
    }



}
