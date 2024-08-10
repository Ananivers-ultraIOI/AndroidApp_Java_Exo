package be.heh.mysecondapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ChildrenActivity extends Activity {
    EditText et_children_login;
    EditText et_children_pwd;
    EditText et_children_email;
    SharedPreferences prefs_datas;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children);

        et_children_login = findViewById(R.id.et_children_login);
        et_children_pwd = findViewById(R.id.et_children_pwd);
        et_children_email = findViewById(R.id.et_children_email);

        prefs_datas = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    }
    public void onChildrenClickManager(View v){
        if (v.getId() == R.id.bt_children_main) {
            if (et_children_login.getText().toString().isEmpty()||et_children_pwd.getText().toString().isEmpty()||et_children_email.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Complètez tous les champs !",Toast.LENGTH_SHORT).show();
            }else{
                SharedPreferences.Editor editeur_datas = prefs_datas.edit();
                editeur_datas.putString("login",et_children_login.getText().toString());
                editeur_datas.putString("pwd",et_children_pwd.getText().toString());
                editeur_datas.putString("email",et_children_email.getText().toString());
                editeur_datas.commit();
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
        if (v.getId()==R.id.bt_children_list){
            Intent intentList=new Intent(this,ListActivity.class);
            startActivity(intentList);
        }
    }
}