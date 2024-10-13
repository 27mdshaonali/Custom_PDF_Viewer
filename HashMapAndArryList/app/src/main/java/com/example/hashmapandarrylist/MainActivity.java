package com.example.hashmapandarrylist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;


    ArrayList < HashMap <String, String> > arrayList = new ArrayList<>();
    HashMap < String, String> hashMap = new HashMap<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        listView = findViewById(R.id.listView);

        hashMap = new HashMap<>();
        hashMap.put("name", "Md Shaon Ali");
        hashMap.put("phone", "01796470921");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name", "Md Monirul Islam");
        hashMap.put("phone", "01571509813");
        arrayList.add(hashMap);



        MyAdapter myAdapter = new MyAdapter();

        listView.setAdapter(myAdapter);



    }

    private class MyAdapter extends BaseAdapter {
        LayoutInflater layoutInflater;


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            @SuppressLint("ViewHolder") View view = layoutInflater.inflate(R.layout.item, parent, false);

            TextView myName = view.findViewById(R.id.name);
            TextView myPhone = view.findViewById(R.id.phone);

            HashMap <String, String> hashMap = arrayList.get(position);

            String name = hashMap.get("name");
            String phone = hashMap.get("phone");

            myName.setText(name);
            myPhone.setText(phone);





            return view;
        }
    }

}