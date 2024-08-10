package be.heh.mysecondapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ChildrenActivity extends Activity {
    EditText et_children_login;
    EditText et_children_pwd;
    EditText et_children_email;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children);

        et_children_login = findViewById(R.id.et_children_login);
        et_children_pwd = findViewById(R.id.et_children_pwd);
        et_children_email = findViewById(R.id.et_children_email);
    }
    public void onChildrenClickManager(View v){
        if (v.getId() == R.id.bt_children_main) {
            if (et_children_login.getText().toString().isEmpty()||et_children_pwd.getText().toString().isEmpty()||et_children_email.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Complètez tous les champs !",Toast.LENGTH_SHORT).show();
            }else{
                Intent intxt=new Intent(this,MainActivity.class);
                intxt.putExtra("login",et_children_login.getText().toString());
                intxt.putExtra("pwd",et_children_pwd.getText().toString());
                intxt.putExtra("email",et_children_email.getText().toString());
                startActivity(intxt);
                finish();
            }
        }
        if (v.getId()==R.id.bt_children_list){
            Intent intentList=new Intent(this,ListActivity.class);
            startActivity(intentList);
        }
    }
}