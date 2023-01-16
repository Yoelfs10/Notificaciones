package com.example.notificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final static String CHANNEL_ID = "23";
    private NotificationManager notificador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button preferencias=findViewById(R.id.prefrences);
        preferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Operacionespreferencia.class);

                startActivity(intent);
            }
        });


        Button obtenerpreferencias=findViewById(R.id.recuperar);
        obtenerpreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                Log.i("","Unico sistema operativo"+pref.getBoolean("primera",false));
                Log.i("","Unico sistema operativo"+pref.getString("segunda","No asignada"));
                Log.i("","Unico sistema operativo"+pref.getString("primera","No asignada"));
            }


        });

        Button abrirtoast=findViewById(R.id.avisos);
        abrirtoast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearnotificacion();




            }

        });



    }
    private void crearnotificacion(){
        notificador=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder= new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(android.R.drawable.stat_sys_warning)
                .setContentTitle("Mensaje de verificacion")
                .setContentText("¿Quieres ir a la activity de los toast?")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setTicker("Aviso notificacion");
        createNotificationChannel();
        Intent intent2= new Intent(this,Activity2.class);
        TaskStackBuilder stackBuilder= TaskStackBuilder.create(MainActivity.this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent2);
        PendingIntent resultPendingIntent= stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(resultPendingIntent);
        builder.setAutoCancel(true);
        notificador.notify(1,builder.build());
    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
