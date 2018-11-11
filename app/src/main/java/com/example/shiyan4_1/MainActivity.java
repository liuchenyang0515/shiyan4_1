package com.example.shiyan4_1;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static ArrayList<Person> arrayList = new ArrayList<>();
    private EditText et_name;
    private EditText et_age;
    private EditText et_height;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = (EditText) findViewById(R.id.et_name);
        et_age = (EditText) findViewById(R.id.et_age);
        et_height = (EditText) findViewById(R.id.et_height);
        Button btn1 = (Button) findViewById(R.id.add);
        Button btn2 = (Button) findViewById(R.id.displayAll);
        Button btn3 = (Button) findViewById(R.id.clearDisplay);
        Button btn4 = (Button) findViewById(R.id.deleteAll);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                String name = et_name.getText().toString();
                String age = et_age.getText().toString();
                String height = et_height.getText().toString();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(age) || TextUtils.isEmpty(height)) {
                    Toast.makeText(this, "数据不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    arrayList.add(new Person(name, age, height));
                    Toast.makeText(this, "数据已保存", Toast.LENGTH_SHORT).show();
                    clear(et_name, et_age, et_height);
                }
                break;
            case R.id.displayAll:
                Intent intent = new Intent(this, Person_ListView.class);
                intent.putParcelableArrayListExtra("a", arrayList);
                startActivity(intent);
                Log.d(TAG, "================displayall ");
                break;
            case R.id.clearDisplay:
                clear(et_name, et_age, et_height);
                break;
            case R.id.deleteAll:
                arrayList.clear();
                Toast.makeText(this, "全部数据已经删除", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void clear(EditText... et) {
        for (EditText t : et) {
            t.setText("");
        }
    }
}
