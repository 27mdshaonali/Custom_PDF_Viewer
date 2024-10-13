package com.example.newsappmemorize;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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

    HashMap <String, String> hashMap = new HashMap<>();
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    ListView listView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.listView);

        hMap();
        hMap2();
        hMap3();
        hMap4();
        hMap5();
        hMap6();
        hMap7();
        hMap8();
        hMap9();
        hMap10();
        hMap11();
        hMap12();
        hMap13();
        hMap14();
        hMap15();

        MyAdapter MyAdapter = new MyAdapter();
        listView.setAdapter(MyAdapter);



    }

    private class MyAdapter extends BaseAdapter{

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

        @SuppressLint("SetTextI18n")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint({"ViewHolder", "InflateParams"}) View view = layoutInflater.inflate(R.layout.item, null, false);
            ImageView itemImage = view.findViewById(R.id.itemImage);
            TextView itemTitle = view.findViewById(R.id.itemTitle);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView itemDescription = view.findViewById(R.id.itemDescription);

            LinearLayout itemLayout = view.findViewById(R.id.itemLayout);

            HashMap<String, String> hashMap = arrayList.get(position);

            String image_url = hashMap.get("image_url");
            String title = hashMap.get("title");
            String description = hashMap.get("description");

            Picasso.get().load(image_url).into(itemImage);
            itemTitle.setText(title);
            itemDescription.setText(description);



            itemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DetailsNews.TITLE = title;
                    DetailsNews.DESCRIPTION = description;

                    startActivity(new Intent(MainActivity.this, DetailsNews.class));

                }
            });



            return view;
        }
    }

    public void hMap(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("image_url", "https://bcdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/05/rajshahi-1a326a5d6137eaf591d8b554721979e6.jpg?jadewits_media_id=9613");
        hashMap.put("title", "It is Rajshahi");
        hashMap.put("description", "Rajshahi is a clean city in Bangladesh. It also called as Education City.");
        arrayList.add(hashMap);

    }

    public void hMap2(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("image_url", "https://bcdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/05/rajshahi-1a326a5d6137eaf591d8b554721979e6.jpg?jadewits_media_id=9613");
        hashMap.put("title", "Rajshahi");
        hashMap.put("description", "Rajshahi is a clean city in Bangladesh. It also called as Education City.");
        arrayList.add(hashMap);

    }

    public void hMap3(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("image_url", "https://bcdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/05/rajshahi-1a326a5d6137eaf591d8b554721979e6.jpg?jadewits_media_id=9613");
        hashMap.put("title", "Rajshahi");
        hashMap.put("description", "Rajshahi is a clean city in Bangladesh. It also called as Education City.");
        arrayList.add(hashMap);

    }

    public void hMap4(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("image_url", "https://bcdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/05/rajshahi-1a326a5d6137eaf591d8b554721979e6.jpg?jadewits_media_id=9613");
        hashMap.put("title", "Rajshahi");
        hashMap.put("description", "Rajshahi is a clean city in Bangladesh. It also called as Education City.");
        arrayList.add(hashMap);

    }

    public void hMap5(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("image_url", "https://bcdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/05/rajshahi-1a326a5d6137eaf591d8b554721979e6.jpg?jadewits_media_id=9613");
        hashMap.put("title", "Rajshahi");
        hashMap.put("description", "Rajshahi is a clean city in Bangladesh. It also called as Education City.");
        arrayList.add(hashMap);

    }

    public void hMap6(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("image_url", "https://bcdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/05/rajshahi-1a326a5d6137eaf591d8b554721979e6.jpg?jadewits_media_id=9613");
        hashMap.put("title", "Rajshahi");
        hashMap.put("description", "Rajshahi is a clean city in Bangladesh. It also called as Education City.");
        arrayList.add(hashMap);

    }

    public void hMap7(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("image_url", "https://bcdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/05/rajshahi-1a326a5d6137eaf591d8b554721979e6.jpg?jadewits_media_id=9613");
        hashMap.put("title", "Rajshahi");
        hashMap.put("description", "Rajshahi is a clean city in Bangladesh. It also called as Education City.");
        arrayList.add(hashMap);

    }

    public void hMap8(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("image_url", "https://bcdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/05/rajshahi-1a326a5d6137eaf591d8b554721979e6.jpg?jadewits_media_id=9613");
        hashMap.put("title", "Rajshahi");
        hashMap.put("description", "Rajshahi is a clean city in Bangladesh. It also called as Education City.");
        arrayList.add(hashMap);

    }

    public void hMap9(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("image_url", "https://bcdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/05/rajshahi-1a326a5d6137eaf591d8b554721979e6.jpg?jadewits_media_id=9613");
        hashMap.put("title", "Rajshahi");
        hashMap.put("description", "Rajshahi is a clean city in Bangladesh. It also called as Education City.");
        arrayList.add(hashMap);

    }

    public void hMap10(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("image_url", "https://bcdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/05/rajshahi-1a326a5d6137eaf591d8b554721979e6.jpg?jadewits_media_id=9613");
        hashMap.put("title", "Rajshahi");
        hashMap.put("description", "Rajshahi is a clean city in Bangladesh. It also called as Education City.");
        arrayList.add(hashMap);

    }

    public void hMap11(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("image_url", "https://bcdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/05/rajshahi-1a326a5d6137eaf591d8b554721979e6.jpg?jadewits_media_id=9613");
        hashMap.put("title", "Rajshahi");
        hashMap.put("description", "Rajshahi is a clean city in Bangladesh. It also called as Education City.");
        arrayList.add(hashMap);

    }

    public void hMap12(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("image_url", "https://bcdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/05/rajshahi-1a326a5d6137eaf591d8b554721979e6.jpg?jadewits_media_id=9613");
        hashMap.put("title", "Rajshahi");
        hashMap.put("description", "Rajshahi is a clean city in Bangladesh. It also called as Education City.");
        arrayList.add(hashMap);

    }

    public void hMap13(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("image_url", "https://bcdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/05/rajshahi-1a326a5d6137eaf591d8b554721979e6.jpg?jadewits_media_id=9613");
        hashMap.put("title", "Rajshahi");
        hashMap.put("description", "Rajshahi is a clean city in Bangladesh. It also called as Education City.");
        arrayList.add(hashMap);

    }

    public void hMap14(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("image_url", "https://bcdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/05/rajshahi-1a326a5d6137eaf591d8b554721979e6.jpg?jadewits_media_id=9613");
        hashMap.put("title", "Rajshahi");
        hashMap.put("description", "Rajshahi is a clean city in Bangladesh. It also called as Education City.");
        arrayList.add(hashMap);

    }

    public void hMap15(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("image_url", "https://bcdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/05/rajshahi-1a326a5d6137eaf591d8b554721979e6.jpg?jadewits_media_id=9613");
        hashMap.put("title", "Rajshahi");
        hashMap.put("description", "Rajshahi is a clean city in Bangladesh. It also called as Education City.");
        arrayList.add(hashMap);

    }

}