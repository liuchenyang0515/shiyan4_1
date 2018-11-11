package com.example.shiyan4_1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Person_ListView extends AppCompatActivity {

    private ListView lv;
    private ArrayList<Person> arrayList;
    private static final String TAG = "Person_ListView";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listview);
        Log.d(TAG, "==================onCreate: ");
        lv = (ListView) findViewById(R.id.lv);
        Intent intent = getIntent();
        arrayList = intent.getParcelableArrayListExtra("a");
        lv.setAdapter(new MyAdapter(this, R.layout.item, arrayList));
        Log.d(TAG, "==========arraylist.size()=" + arrayList.size());
    }

    private class MyAdapter extends ArrayAdapter {

        public MyAdapter(@NonNull Context context, int resource, @NonNull List objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Log.d(TAG, "================getView: ");
            Person person = (Person) getItem(position);
            View view = null;
            ViewHolder viewHolder = null;
            if (convertView == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.name = (TextView) view.findViewById(R.id.id_text_name);
                viewHolder.age = (TextView) view.findViewById(R.id.id_text_age);
                viewHolder.height = (TextView) view.findViewById(R.id.id_text_height);
                view.setTag(viewHolder);
            } else {
                view = convertView;
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.name.setText(person.getName());
            viewHolder.age.setText(person.getAge());
            viewHolder.height.setText(person.getHeight());
            return view;
        }

        class ViewHolder {
            TextView name, age, height;
        }
    }
}
