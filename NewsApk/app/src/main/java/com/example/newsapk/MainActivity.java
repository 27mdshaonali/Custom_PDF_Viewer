package com.example.newsapk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList < HashMap <String, String> > arrayList = new ArrayList<>();

    HashMap <String, String > hashMap = new HashMap<>();

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

        hMap();

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

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.item, parent, false);

            ImageView image = view.findViewById(R.id.image);
            TextView title = view.findViewById(R.id.title);
            TextView category = view.findViewById(R.id.category);
            TextView description = view.findViewById(R.id.description);
            LinearLayout linearLayout = view.findViewById(R.id.itemLayout);


            HashMap <String, String> hashMap = arrayList.get(position);



            String sTitle = hashMap.get("title");
            String sCategory = hashMap.get("cat");
            String sDescription = hashMap.get("des");
            String sImageUrl = hashMap.get("image_url");

            Picasso.get().load(sImageUrl)
                    .placeholder(R.drawable.tech)
                    .into(image);

            title.setText(sTitle);
            category.setText(sCategory);
            description.setText(sDescription);


            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Details.TITLE = sTitle;
                    Details.DESCRIPTION = sDescription;

                    Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
                    Details.COVER_IMG = bitmap;




                    startActivity(new Intent(MainActivity.this, Details.class));

                }
            });


            return view;
        }
    }

    public void hMap(){

        HashMap <String, String> hashMap = new HashMap<>();
        hashMap.put("cat", "Animal");
        hashMap.put("image_url", "https://dims.apnews.com/dims4/default/bbb7683/2147483647/strip/true/crop/8637x5760+2+0/resize/1360x907!/format/webp/quality/90/?url=https%3A%2F%2Fassets.apnews.com%2F53%2F34%2F8808df0e6826df8b2b2c0011c9ea%2F1ee1686ec38b4c9a8b252aa63fc9a952");
        hashMap.put("title", "A Stockman shows off the Nelore cow known as Viatina-19 at a farm in Uberaba, the Minas Gerais state, Brazil, Friday, April 26, 2024. Viatina-19 is the product of years of efforts to raise meatier cows, and is the most expensive cow ever sold at auction, according to Guinness World Records. (AP Photo/Silvia Izquierdo)");
        hashMap.put("des", "UBERABA, Brazil (AP) — Brazil has hundreds of millions of cows, but one in particular is extraordinary. Her massive, snow-white body is watched over by security cameras, a veterinarian and an armed guard.\n" +
                "\n" +
                "Worth $4 million, Viatina-19 FIV Mara Movéis is the most expensive cow ever sold at auction, according to Guinness World Records. That’s three times more than the last recordholder’s price. And — at 1,100 kilograms (more than 2,400 pounds) — she’s twice as heavy as an average adult of her breed.");
        arrayList.add(hashMap);

    }

}