package be.heh.mysecondapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            Intent intent = new Intent(this,ChildrenActivity.class);
            startActivity(intent);
        }
    }
}