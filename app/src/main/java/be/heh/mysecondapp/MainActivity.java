package be.heh.mysecondapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {
    SharedPreferences prefs_datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs_datas = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if(!prefs_datas.getAll().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Votre login est : "+(prefs_datas.getString("login","NULL"))+"\n"+
                            "Votre pwd est : "+(prefs_datas.getString("pwd","NULL"))+"\n"+
                            "Votre email est : "+(prefs_datas.getString("email","NULL"))+"\n",
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void onMainClickManager(View v) {
// Récupérer la vue et accéder au bouton
        if (v.getId()==R.id.bt_main_children){
            Intent intent = new Intent(this,ChildrenActivity.class);
            startActivity(intent);
        }
    }
}