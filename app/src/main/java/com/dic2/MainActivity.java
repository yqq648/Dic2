package com.dic2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1文件名，0, , , 相当于一个yq记事本文件
                SharedPreferences sp = getSharedPreferences("yq",0);
                //
                String password = sp.getString("password","");
                Toast.makeText(MainActivity.this, ""+password, Toast.LENGTH_SHORT).show();
            }
        });

    }
    //使用android api保存少量数据
    private void save() {
        //1文件名，0, , , 相当于一个yq记事本文件
        SharedPreferences sp = getSharedPreferences("yq",0);
        //2编辑记事本文件,右击编辑
        SharedPreferences.Editor editor = sp.edit();
        //3在文本编辑器中， 填写key-value的键值对数据
        editor.putString("password","123");
        //4.保存记事本文件数据
        editor.commit();
    }
}
