package be.heh.mysecondapp;

import android.annotation.SuppressLint;
import android.app.Activity;
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
        if (v.getId()==R.id.bt_children_main){
            Toast.makeText(
                    getApplicationContext(),
                    " Login : "+ et_children_login.getText()+"\n Password : "+ et_children_pwd.getText()+"\n Email : "+ et_children_email.getText(),
                    Toast.LENGTH_SHORT).show();
        }
    }
}