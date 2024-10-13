package com.example.layoutinflate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

    ArrayList < HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String, String > hashMap = new HashMap<>();



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

        hMap();
        hMap2();

        listView = findViewById(R.id.listView);
        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);

        if (internetConnection()){
            Toast.makeText(this, "Internet is connected", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Internet is not connected", Toast.LENGTH_SHORT).show();
        }

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

        @SuppressLint("UseCompatLoadingForDrawables")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder") View view = layoutInflater.inflate(R.layout.item, parent, false);



            ImageView image = view.findViewById(R.id.image);
            TextView category = view.findViewById(R.id.category);
            TextView title = view.findViewById(R.id.title);
            TextView description = view.findViewById(R.id.description);

            HashMap<String, String> hashMap = arrayList.get(position);

            String itemImage = hashMap.get("img_url");
            String itemCategory = hashMap.get("category");
            String itemTitle = hashMap.get("title");
            String itemDescription = hashMap.get("description");


            Picasso.get().load(hashMap.get(itemImage))
                    .error(R.drawable.ic_launcher_background)
                    .into(image);

            category.setText(itemCategory);
            title.setText(itemTitle);
            description.setText(itemDescription);

            return view;
        }
    }

    public void hMap(){

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("category","News");
        hashMap.put("title","ShAoN");
        hashMap.put("description","ShAoN");
        hashMap.put("img_url", "https://bcdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/05/rajshahi-1a326a5d6137eaf591d8b554721979e6.jpg?jadewits_media_id=9613");

        arrayList.add(hashMap);

    }

    public void hMap2 () {

        HashMap <String, String > hashMap = new HashMap < > ();

        hashMap.put("category", "TOURISM");
        hashMap.put("title", "রাজশাহীতে পর্যটন নিয়ে কাজ করতে আগ্রহী ইন্দোনেশিয়া");
        hashMap.put("img_url", "https://bcdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/05/rajshahi-1a326a5d6137eaf591d8b554721979e6.jpg?jadewits_media_id=9613");
        hashMap.put("description", "রাজশাহী সিটি কর্পোরেশনের মেয়র এ.এইচ.এম খায়রুজ্জামান লিটনের সঙ্গে বৈঠক করেছেন বাংলাদেশে নিযুক্ত ইন্দোনেশিয়ার রাষ্ট্রদূত হেরু হারতান্তো সুবোলো। \n" +
                "বুধবার (৫ জুন) বিকেল ৩টায় নগর ভবনের মেয়র দপ্তর কক্ষে এ বৈঠক অনুষ্ঠিত হয়। বৈঠকে রাজশাহীতে কৃষি, শিক্ষা, সংস্কৃতি ও পর্যটনখাতে কাজের আগ্রহ প্রকাশ করেছেন ইন্দোনেশীয় রাষ্ট্রদূত। সিটি কর্পোরেশনের সঙ্গে কাজের আগ্রহ প্রকাশ করায় ইন্দোনেশিয়ার রাষ্ট্রদূতকে আন্তরিক ধন্যবাদ জানান রাসিক মেয়র লিটন।\n" +
                "বৈঠকে ইন্দোনেশিয়ার রাষ্ট্রদূত হরু হারতান্তো সুবোলো বলেন, “ইন্দোনেশিয়ায় অনেক উন্নতমানের শিক্ষাপ্রতিষ্ঠান রয়েছে। ইন্দোনেশীয় শিক্ষাপ্রতিষ্ঠানগুলোতে রাজশাহীর শিক্ষার্থীদের এক বছর মেয়াদি বৃত্তি এবং শিল্পকলায় তিন মাস মেয়াদি বৃত্তি দিয়ে উভয় দেশের জ্ঞান ও সংস্কৃতি বিনিময় করতে চাই। এছাড়া রাজশাহী যেহেতু কৃষিপ্রধান অঞ্চল, তাই এ অঞ্চলের উৎপাদিত পণ্য নিয়ে কাজ করতে আমরা আগ্রহী।”\n" +
                "তিনি আরও বলেন, “এটি আমার রাজশাহীতে প্রথম সফর। রাজশাহীর পরিচ্ছন্নতা ও সিটি মেয়রের ভবিষ্যৎ পরিকল্পনা ও ভিশন দেখে মুগ্ধ হয়েছি।”\n" +
                "রাসিক মেয়র খায়রুজ্জামান লিটন বলেন, “ইন্দোনেশিয়া আমাদের বন্ধুপ্রতিম রাষ্ট্র। ইন্দোনেশিয়ার রাষ্ট্রদূতের সাথে দীর্ঘক্ষণ বৈঠক হয়েছে। তিনি রাজশাহীর সঙ্গে কৃষি, শিক্ষা, সংস্কৃতি ও পর্যটন ইত্যাদি খাতে সহযোগিতার আগ্রহ প্রকাশ করেছেন। সোলার প্ল্যান্ট স্থাপন, শিক্ষার্থীদের বৃত্তি ও পর্যটনের কোন কোন ক্ষেত্রে কাজ করা যায়, সেটি আমরা রাষ্ট্রদূতকে সুর্নিদিষ্টভাবে লিখিতভাবে জানাব।”\n" +
                "রাসিক মেয়র লিটন আরও বলেন, রাজশাহী কৃষিপ্রধান অঞ্চল। কৃষিপণ্যভিত্তিক শিল্প প্রতিষ্ঠার বিষয়ে আলোচনা করেছি। এছাড়া শিক্ষানগরী রাজশাহীতে অনেক শিক্ষাপ্রতিষ্ঠান রয়েছে। এখানকার শিক্ষার্থীদের বৃত্তি দেওয়ার বিষয়ে ইন্দোনেশিয়ার রাষ্ট্রদূত আগ্রহী। এটি চালু হলে জ্ঞান বিনিময়ে উভয় দেশ লাভবান হবে।\n.");

        arrayList.add(hashMap);

    }




    public boolean internetConnection(){

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()){
            return true;
        }else {
            return false;
        }

    }



}