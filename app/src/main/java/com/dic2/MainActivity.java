package com.dic2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
        //长按的点击事件
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "长按事件", Toast.LENGTH_SHORT).show();
                return false;
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
    //警告框
    public void jinggao(View view) {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("是否参加会议")
                .setMessage("特别邀请你参加...")
                .setNegativeButton("我马上参加", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("谢谢我不参加", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create().show();//警告框的创建，使用构造者设计模式，最后create()创建，show();是显示对话框

    }
    //关闭当前界面
    public void close(View view) {
        finish();
    }
    //当我们关闭添加单词界面的时候， 在单词显示界面，如何知道我添加过了单词。
    public void callback(View view) {
        Intent intent = new Intent(this, TwoActivity.class);
        startActivity(intent);
    }
    //系统自带的方法
    @Override//刷新界面
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onresume", Toast.LENGTH_SHORT).show();
    }
}
