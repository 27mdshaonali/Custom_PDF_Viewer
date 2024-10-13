package com.example.customlistview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList <HashMap <String, String> > arrayList = new ArrayList<>();
    HashMap <String, String> hashMap;

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
        hashMap.put("mobile", "01796470921");
        arrayList.add(hashMap);

        HashMap <String, String > hashMap = new HashMap<>();
        hashMap.put("name", "Md Monirul Islam");
        hashMap.put("mobile", "01571509813");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Saiful Islam Mohon");
        hashMap.put("mobile", "01950859402");
        arrayList.add(hashMap);



        MyAdapter myAdapter = new MyAdapter();

        listView.setAdapter(myAdapter);


    }

    private class MyAdapter extends BaseAdapter{

        LayoutInflater inflater;

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

            inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder") View view = inflater.inflate(R.layout.item, parent, false);

            ImageView imageView = view.findViewById(R.id.image);
            TextView textView = view.findViewById(R.id.name);
            TextView mobile = view.findViewById(R.id.number);


            HashMap <String, String > hashMap = arrayList.get(position);
            textView.setText( hashMap.get("name") );
            mobile.setText(hashMap.get("mobile"));




            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(MainActivity.this, "This is " + (position + 1) + " number image", Toast.LENGTH_SHORT).show();

                }
            });

            return view;
        }
    }



}