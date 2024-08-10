package be.heh.mysecondapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {
    private static final int NOTIFY_ID=1234;
    private static final String CHANNEL_ID = "my_channel_id";
    NotificationManager noma = null;
    int cpt =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        noma =(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationChannel channel = new NotificationChannel(
                CHANNEL_ID,
                "My Channel",
                NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription("Channel description");
        noma.createNotificationChannel(channel);
        Bundle extratxt=this.getIntent().getExtras();
        if(extratxt !=null){
            Toast.makeText(getApplicationContext(),
                    "Votre login est : "+(extratxt.getString("login"))+"\n"+
                    "Votre pwd est : "+(extratxt.getString("pwd"))+"\n"+
                    "Votre email est : "+(extratxt.getString("email"))+"\n",
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void onMainClickManager(View v) {
// Récupérer la vue et accéder au bouton
        if (v.getId()==R.id.bt_main_children){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Alerte activité")
                    .setMessage("Voulez-vous afficher l'activité Children ?")
                    .setCancelable(false)
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            notifier();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .create().show();
        }
    }
    public void notifier(){
        PendingIntent pi = PendingIntent.getActivity(this,0,new Intent(this,ChildrenActivity.class ), PendingIntent.FLAG_IMMUTABLE);
        BatteryManager bm = (BatteryManager)getSystemService(BATTERY_SERVICE);
        int batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        Notification.Builder notification = new Notification.Builder(this)
                .setAutoCancel(true)
                .setContentTitle("Notification !!!")
                .setContentText("L'activité Children est disponible ! \n Batterie à "+ batLevel +" %")
                .setContentIntent(pi)
                .setDefaults(Notification.DEFAULT_ALL)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setWhen(System.currentTimeMillis())
                .setNumber(++cpt);
        notification.setChannelId(CHANNEL_ID);
        Notification notif= notification.build();
        noma.notify(NOTIFY_ID,notif);
    }
    public void arretNotifier(){
        noma.cancel(NOTIFY_ID);
    }
}