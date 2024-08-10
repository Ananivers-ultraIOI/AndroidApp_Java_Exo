package be.heh.mysecondapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileActivity extends Activity {
    TextView tv_files_datas;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        tv_files_datas = (TextView) findViewById(R.id.tv_file_datas);
        tv_files_datas.setText("Contenu du fichier texte : \n");
        try {
            FileInputStream ins = openFileInput("monfichier.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
            StringBuilder out = new StringBuilder();
            String line;
            while ((line = reader.readLine())!=null){
                out.append(line);
            }
            reader.close();
            ins.close();
            String[] items = out.toString().split("#");
            int i = 0;
            int j = 0;
            String keyword="";
            for (String item : items){
                if (i==3){
                    j++;
                    i=0;
                }
                switch (i){
                    case 0:
                        keyword=" Login ";
                        break;
                    case 1:
                        keyword=" Password ";
                        break;
                    case 2:
                        keyword=" Email ";
                        break;
                    default:
                        break;
                }
                tv_files_datas.setText(tv_files_datas.getText().toString()
                        + Integer.toString(j+1)+"."+keyword+" = "+item+"\n");
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}