package com.example.hashmap;

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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap <String, String > hashMap = new HashMap<>();
    ArrayList < HashMap <String, String>> arrayList = new ArrayList<>();

    ListView listView;

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

        hMap();
        hMap2();

        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);

    }

    private class MyAdapter extends BaseAdapter {
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

            HashMap <String, String> hashMap = arrayList.get(position);

            inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            @SuppressLint("ViewHolder") View view = inflater.inflate(R.layout.item, parent, false);

            ImageView itemImage = view.findViewById(R.id.itemImage);
            TextView itemName = view.findViewById(R.id.title);
            TextView itemPrice = view.findViewById(R.id.description);

            Picasso.get().load(hashMap.get("image_url")).into(itemImage);

            itemName.setText(hashMap.get("title"));
            itemPrice.setText(hashMap.get("description"));





            return view;
        }
    }

    public void hMap(){

        HashMap <String, String> hashMap = new HashMap<>();

        hashMap.put("image_url", "https://media-cldnry.s-nbcnews.com/image/upload/t_fit-1240w,f_auto,q_auto:best/rockcms/2024-06/240603-Hunter-Biden-profile-ac-939p-0f5c70.jpg");
        hashMap.put("title", "Hunter Biden to drop lawsuit against Rudy Giuliani");
        hashMap.put("description", "By Gary Grumbach and Megan Lebowitz\n" +
                "Hunter Biden is agreeing to drop a civil lawsuit against Rudy Giuliani and Giuliani's former lawyer Robert Costello, according to a court filing Thursday.\n" +
                "The president's son last year formally accused Giuliani and Costello of violating computer fraud and data access laws, alleging they manipulated data from his \"devices or storage platforms.\"\n" +
                "Attorneys for all three parties filed the agreement, which stipulates that Biden agrees to drop the lawsuit and that each man will pay his own legal fees.\n" +
                "The lawsuit initially sought more than $75,000 in damages, as well as attorneys’ fees and other penalties.\n" +
                "“As Giuliani is in bankruptcy and agreed to have the case waiting for when he is done, it made no sense to continue it in a non-bankruptcy court until that happens,\" a person familiar with the filing told NBC News on Thursday.\n" +
                "Giuliani filed for bankruptcy protection in December after he was hit with a $148 million verdict for defaming two former Georgia election workers.\n" +
                "Biden’s lawyers, Giuliani’s representative and Costello did not immediately respond to requests for comment on Thursday's court filing, which U.S. District Judge Jessica Clarke must review before it is finalized.\n" +
                "\n");
        arrayList.add(hashMap);

    }
    public void hMap2(){

        HashMap <String, String> hashMap = new HashMap<>();

        hashMap.put("image_url", "https://media-cldnry.s-nbcnews.com/image/upload/t_fit-1240w,f_auto,q_auto:best/rockcms/2024-06/240603-Hunter-Biden-profile-ac-939p-0f5c70.jpg");
        hashMap.put("title", "Hunter Biden to drop lawsuit against Rudy Giuliani");
        hashMap.put("description", "By Gary Grumbach and Megan Lebowitz\n" +
                "Hunter Biden is agreeing to drop a civil lawsuit against Rudy Giuliani and Giuliani's former lawyer Robert Costello, according to a court filing Thursday.\n" +
                "The president's son last year formally accused Giuliani and Costello of violating computer fraud and data access laws, alleging they manipulated data from his \"devices or storage platforms.\"\n" +
                "Attorneys for all three parties filed the agreement, which stipulates that Biden agrees to drop the lawsuit and that each man will pay his own legal fees.\n" +
                "The lawsuit initially sought more than $75,000 in damages, as well as attorneys’ fees and other penalties.\n" +
                "“As Giuliani is in bankruptcy and agreed to have the case waiting for when he is done, it made no sense to continue it in a non-bankruptcy court until that happens,\" a person familiar with the filing told NBC News on Thursday.\n" +
                "Giuliani filed for bankruptcy protection in December after he was hit with a $148 million verdict for defaming two former Georgia election workers.\n" +
                "Biden’s lawyers, Giuliani’s representative and Costello did not immediately respond to requests for comment on Thursday's court filing, which U.S. District Judge Jessica Clarke must review before it is finalized.\n" +
                "\n");
        arrayList.add(hashMap);

    }

}