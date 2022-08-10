package com.juarez.android.databinding.notifications

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.navigation.NavDeepLinkBuilder
import com.juarez.android.databinding.R

class Notification(
    private val context: Context,
    private val args: Bundle
) {
    private val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun show() {
        val notification = NotificationCompat.Builder(context, "my_notification_id")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("My title")
            .setContentText(("esta es una notificacion que abre una pantalla"))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(createIntentPending())
            .setAutoCancel(true)
            .build()

        notificationManager.notify(1000, notification)
    }

    private fun createIntentPending(): PendingIntent {
        return NavDeepLinkBuilder(context)
            .setGraph(R.navigation.root_nav_graph)
            .setDestination(R.id.thirdFragment)
            .setArguments(args)
            .createPendingIntent()
    }
}