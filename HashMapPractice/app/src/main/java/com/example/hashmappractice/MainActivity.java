package com.example.hashmappractice;

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
    HashMap <String, String> hashMap = new HashMap<>();
    ArrayList < HashMap <String, String>> arrayList = new ArrayList<>();


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


        listView = findViewById(R.id.listView);
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

            ImageView image = view.findViewById(R.id.itemImage);
            TextView title = view.findViewById(R.id.itemTitle);
            TextView description = view.findViewById(R.id.itemDescription);
            LinearLayout itemLayout = view.findViewById(R.id.itemLayout);

            HashMap <String, String> hashMap = arrayList.get(position);

            String titleText = hashMap.get("title");
            String descriptionText = hashMap.get("description");
            String imageUrl = hashMap.get("image_url");


            title.setText(titleText);
            description.setText(descriptionText);

            Picasso.get().load(imageUrl)
                    .placeholder(R.drawable.background)
                    .into(image);


            itemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DetailsNews.TITLE = titleText;
                    DetailsNews.DESCRIPTION = descriptionText;

                    Bitmap bitMap = ((BitmapDrawable) image.getDrawable()).getBitmap();
                    DetailsNews.IMAGE = bitMap;

                    startActivity(new Intent(MainActivity.this, DetailsNews.class));

                }
            });


            return view;
        }
    }

    public void hMap(){

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("title", "Russell's Viper: How did it get its name?");
        hashMap.put("description", "In recent days, a species of snake has become a hot topic on social media in the country. The discussion about the venomous Russell's Viper has not only flooded the internet but also tea stalls and casual conversations.\n" +
                "Recently, panic has spread about this species of snake in several districts, especially in areas along the Padma River. The situation has escalated to such an extent that some people in these regions are even campaigning to kill the Russell's Viper snakes.\n" +
                "Many are curious about the name Russell's Viper. This venomous snake is locally known as Chandra Bora and Ulubora. It looks somewhat like a baby python.\n" +
                "\n" +
                "\n" +
                "Scottish surgeon Patrick Russell came to work in India during British rule. He was a herpetologist who first described many of India’s snakes in the 1790s. \n" +
                "In 1796, he researched this snake, and it was named after him. Hence, the snake is called Russell's Viper after Patrick Russell.\n" +
                "It is a venomous snake primarily found in India, Taiwan, and Indonesia, but it is also present in Bangladesh.\n" +
                "\n" +
                "\n" +
                "Russell’s Viper is a venomous snake in the family Viperidae native to the Indian subcontinent and one of the big four snakes in India.\n" +
                "It thrives in open environments such as farmlands, where human interaction is frequent due to the abundance of its rodent prey.\n" +
                "The snake can grow up to 1.5 meters and is identified by its distinctive reddish-brown spots outlined in black and white.\n" +
                "Contrary to popular belief, Russell’s Viper is not the most venomous snake in the world.\n" +
                "The Black Mamba and Puff Adder are among the world’s most dangerous snakes due to their potent venom and aggressive nature.\n" +
                "Russell’s Viper, while also highly venomous and responsible for numerous snake bite incidents in India, is considered less aggressive.\n" +
                "In 2002, the International Union for Conservation of Nature (IUCN) declared the Russell's Viper extinct in Bangladesh.\n" +
                "Although the snake primarily inhabits dry regions, particularly the Barind area, it has now spread to at least 35 districts, including several coastal areas, according to experts and relevant authorities.\n" +
                "There are frequent reports of deaths from Russell's Viper bites in these areas. Consequently, there is widespread discussion and significant fear and panic about the snake among the public.\n" +
                "However, snake researchers and experts say that there is treatment available for bites from this species, and timely medical intervention can reduce the risk of death.\n");

        hashMap.put("image_url", "https://ecdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/20/Russell-s-Viper-ad60e582c62b173fcf973b336d02c900.jpg?jadewits_media_id=22859");

        arrayList.add(hashMap);

    }

    public void hMap2(){

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("title", "Russell's Viper: How did it get its name?");
        hashMap.put("description", "In recent days, a species of snake has become a hot topic on social media in the country. The discussion about the venomous Russell's Viper has not only flooded the internet but also tea stalls and casual conversations.\n" +
                "Recently, panic has spread about this species of snake in several districts, especially in areas along the Padma River. The situation has escalated to such an extent that some people in these regions are even campaigning to kill the Russell's Viper snakes.\n" +
                "Many are curious about the name Russell's Viper. This venomous snake is locally known as Chandra Bora and Ulubora. It looks somewhat like a baby python.\n" +
                "\n" +
                "\n" +
                "Scottish surgeon Patrick Russell came to work in India during British rule. He was a herpetologist who first described many of India’s snakes in the 1790s. \n" +
                "In 1796, he researched this snake, and it was named after him. Hence, the snake is called Russell's Viper after Patrick Russell.\n" +
                "It is a venomous snake primarily found in India, Taiwan, and Indonesia, but it is also present in Bangladesh.\n" +
                "\n" +
                "\n" +
                "Russell’s Viper is a venomous snake in the family Viperidae native to the Indian subcontinent and one of the big four snakes in India.\n" +
                "It thrives in open environments such as farmlands, where human interaction is frequent due to the abundance of its rodent prey.\n" +
                "The snake can grow up to 1.5 meters and is identified by its distinctive reddish-brown spots outlined in black and white.\n" +
                "Contrary to popular belief, Russell’s Viper is not the most venomous snake in the world.\n" +
                "The Black Mamba and Puff Adder are among the world’s most dangerous snakes due to their potent venom and aggressive nature.\n" +
                "Russell’s Viper, while also highly venomous and responsible for numerous snake bite incidents in India, is considered less aggressive.\n" +
                "In 2002, the International Union for Conservation of Nature (IUCN) declared the Russell's Viper extinct in Bangladesh.\n" +
                "Although the snake primarily inhabits dry regions, particularly the Barind area, it has now spread to at least 35 districts, including several coastal areas, according to experts and relevant authorities.\n" +
                "There are frequent reports of deaths from Russell's Viper bites in these areas. Consequently, there is widespread discussion and significant fear and panic about the snake among the public.\n" +
                "However, snake researchers and experts say that there is treatment available for bites from this species, and timely medical intervention can reduce the risk of death.\n");
        hashMap.put("image_url", "https://images.pexels.com/photos/177598/pexels-photo-177598.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");

        arrayList.add(hashMap);

    }

    public void hMap3(){

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("title", "Russell's Viper: How did it get its name?");
        hashMap.put("description", "In recent days, a species of snake has become a hot topic on social media in the country. The discussion about the venomous Russell's Viper has not only flooded the internet but also tea stalls and casual conversations.\n" +
                "Recently, panic has spread about this species of snake in several districts, especially in areas along the Padma River. The situation has escalated to such an extent that some people in these regions are even campaigning to kill the Russell's Viper snakes.\n" +
                "Many are curious about the name Russell's Viper. This venomous snake is locally known as Chandra Bora and Ulubora. It looks somewhat like a baby python.\n" +
                "\n" +
                "\n" +
                "Scottish surgeon Patrick Russell came to work in India during British rule. He was a herpetologist who first described many of India’s snakes in the 1790s. \n" +
                "In 1796, he researched this snake, and it was named after him. Hence, the snake is called Russell's Viper after Patrick Russell.\n" +
                "It is a venomous snake primarily found in India, Taiwan, and Indonesia, but it is also present in Bangladesh.\n" +
                "\n" +
                "\n" +
                "Russell’s Viper is a venomous snake in the family Viperidae native to the Indian subcontinent and one of the big four snakes in India.\n" +
                "It thrives in open environments such as farmlands, where human interaction is frequent due to the abundance of its rodent prey.\n" +
                "The snake can grow up to 1.5 meters and is identified by its distinctive reddish-brown spots outlined in black and white.\n" +
                "Contrary to popular belief, Russell’s Viper is not the most venomous snake in the world.\n" +
                "The Black Mamba and Puff Adder are among the world’s most dangerous snakes due to their potent venom and aggressive nature.\n" +
                "Russell’s Viper, while also highly venomous and responsible for numerous snake bite incidents in India, is considered less aggressive.\n" +
                "In 2002, the International Union for Conservation of Nature (IUCN) declared the Russell's Viper extinct in Bangladesh.\n" +
                "Although the snake primarily inhabits dry regions, particularly the Barind area, it has now spread to at least 35 districts, including several coastal areas, according to experts and relevant authorities.\n" +
                "There are frequent reports of deaths from Russell's Viper bites in these areas. Consequently, there is widespread discussion and significant fear and panic about the snake among the public.\n" +
                "However, snake researchers and experts say that there is treatment available for bites from this species, and timely medical intervention can reduce the risk of death.\n");

        hashMap.put("image_url", "https://ecdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/20/Russell-s-Viper-ad60e582c62b173fcf973b336d02c900.jpg?jadewits_media_id=22859");

        arrayList.add(hashMap);

    }

    public void hMap4(){

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("title", "Russell's Viper: How did it get its name?");
        hashMap.put("description", "In recent days, a species of snake has become a hot topic on social media in the country. The discussion about the venomous Russell's Viper has not only flooded the internet but also tea stalls and casual conversations.\n" +
                "Recently, panic has spread about this species of snake in several districts, especially in areas along the Padma River. The situation has escalated to such an extent that some people in these regions are even campaigning to kill the Russell's Viper snakes.\n" +
                "Many are curious about the name Russell's Viper. This venomous snake is locally known as Chandra Bora and Ulubora. It looks somewhat like a baby python.\n" +
                "\n" +
                "\n" +
                "Scottish surgeon Patrick Russell came to work in India during British rule. He was a herpetologist who first described many of India’s snakes in the 1790s. \n" +
                "In 1796, he researched this snake, and it was named after him. Hence, the snake is called Russell's Viper after Patrick Russell.\n" +
                "It is a venomous snake primarily found in India, Taiwan, and Indonesia, but it is also present in Bangladesh.\n" +
                "\n" +
                "\n" +
                "Russell’s Viper is a venomous snake in the family Viperidae native to the Indian subcontinent and one of the big four snakes in India.\n" +
                "It thrives in open environments such as farmlands, where human interaction is frequent due to the abundance of its rodent prey.\n" +
                "The snake can grow up to 1.5 meters and is identified by its distinctive reddish-brown spots outlined in black and white.\n" +
                "Contrary to popular belief, Russell’s Viper is not the most venomous snake in the world.\n" +
                "The Black Mamba and Puff Adder are among the world’s most dangerous snakes due to their potent venom and aggressive nature.\n" +
                "Russell’s Viper, while also highly venomous and responsible for numerous snake bite incidents in India, is considered less aggressive.\n" +
                "In 2002, the International Union for Conservation of Nature (IUCN) declared the Russell's Viper extinct in Bangladesh.\n" +
                "Although the snake primarily inhabits dry regions, particularly the Barind area, it has now spread to at least 35 districts, including several coastal areas, according to experts and relevant authorities.\n" +
                "There are frequent reports of deaths from Russell's Viper bites in these areas. Consequently, there is widespread discussion and significant fear and panic about the snake among the public.\n" +
                "However, snake researchers and experts say that there is treatment available for bites from this species, and timely medical intervention can reduce the risk of death.\n");
        hashMap.put("image_url", "https://images.pexels.com/photos/177598/pexels-photo-177598.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");

        arrayList.add(hashMap);

    }

    public void hMap5(){

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("title", "Russell's Viper: How did it get its name?");
        hashMap.put("description", "In recent days, a species of snake has become a hot topic on social media in the country. The discussion about the venomous Russell's Viper has not only flooded the internet but also tea stalls and casual conversations.\n" +
                "Recently, panic has spread about this species of snake in several districts, especially in areas along the Padma River. The situation has escalated to such an extent that some people in these regions are even campaigning to kill the Russell's Viper snakes.\n" +
                "Many are curious about the name Russell's Viper. This venomous snake is locally known as Chandra Bora and Ulubora. It looks somewhat like a baby python.\n" +
                "\n" +
                "\n" +
                "Scottish surgeon Patrick Russell came to work in India during British rule. He was a herpetologist who first described many of India’s snakes in the 1790s. \n" +
                "In 1796, he researched this snake, and it was named after him. Hence, the snake is called Russell's Viper after Patrick Russell.\n" +
                "It is a venomous snake primarily found in India, Taiwan, and Indonesia, but it is also present in Bangladesh.\n" +
                "\n" +
                "\n" +
                "Russell’s Viper is a venomous snake in the family Viperidae native to the Indian subcontinent and one of the big four snakes in India.\n" +
                "It thrives in open environments such as farmlands, where human interaction is frequent due to the abundance of its rodent prey.\n" +
                "The snake can grow up to 1.5 meters and is identified by its distinctive reddish-brown spots outlined in black and white.\n" +
                "Contrary to popular belief, Russell’s Viper is not the most venomous snake in the world.\n" +
                "The Black Mamba and Puff Adder are among the world’s most dangerous snakes due to their potent venom and aggressive nature.\n" +
                "Russell’s Viper, while also highly venomous and responsible for numerous snake bite incidents in India, is considered less aggressive.\n" +
                "In 2002, the International Union for Conservation of Nature (IUCN) declared the Russell's Viper extinct in Bangladesh.\n" +
                "Although the snake primarily inhabits dry regions, particularly the Barind area, it has now spread to at least 35 districts, including several coastal areas, according to experts and relevant authorities.\n" +
                "There are frequent reports of deaths from Russell's Viper bites in these areas. Consequently, there is widespread discussion and significant fear and panic about the snake among the public.\n" +
                "However, snake researchers and experts say that there is treatment available for bites from this species, and timely medical intervention can reduce the risk of death.\n");

        hashMap.put("image_url", "https://ecdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/20/Russell-s-Viper-ad60e582c62b173fcf973b336d02c900.jpg?jadewits_media_id=22859");

        arrayList.add(hashMap);

    }

    public void hMap6(){

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("title", "Russell's Viper: How did it get its name?");
        hashMap.put("description", "In recent days, a species of snake has become a hot topic on social media in the country. The discussion about the venomous Russell's Viper has not only flooded the internet but also tea stalls and casual conversations.\n" +
                "Recently, panic has spread about this species of snake in several districts, especially in areas along the Padma River. The situation has escalated to such an extent that some people in these regions are even campaigning to kill the Russell's Viper snakes.\n" +
                "Many are curious about the name Russell's Viper. This venomous snake is locally known as Chandra Bora and Ulubora. It looks somewhat like a baby python.\n" +
                "\n" +
                "\n" +
                "Scottish surgeon Patrick Russell came to work in India during British rule. He was a herpetologist who first described many of India’s snakes in the 1790s. \n" +
                "In 1796, he researched this snake, and it was named after him. Hence, the snake is called Russell's Viper after Patrick Russell.\n" +
                "It is a venomous snake primarily found in India, Taiwan, and Indonesia, but it is also present in Bangladesh.\n" +
                "\n" +
                "\n" +
                "Russell’s Viper is a venomous snake in the family Viperidae native to the Indian subcontinent and one of the big four snakes in India.\n" +
                "It thrives in open environments such as farmlands, where human interaction is frequent due to the abundance of its rodent prey.\n" +
                "The snake can grow up to 1.5 meters and is identified by its distinctive reddish-brown spots outlined in black and white.\n" +
                "Contrary to popular belief, Russell’s Viper is not the most venomous snake in the world.\n" +
                "The Black Mamba and Puff Adder are among the world’s most dangerous snakes due to their potent venom and aggressive nature.\n" +
                "Russell’s Viper, while also highly venomous and responsible for numerous snake bite incidents in India, is considered less aggressive.\n" +
                "In 2002, the International Union for Conservation of Nature (IUCN) declared the Russell's Viper extinct in Bangladesh.\n" +
                "Although the snake primarily inhabits dry regions, particularly the Barind area, it has now spread to at least 35 districts, including several coastal areas, according to experts and relevant authorities.\n" +
                "There are frequent reports of deaths from Russell's Viper bites in these areas. Consequently, there is widespread discussion and significant fear and panic about the snake among the public.\n" +
                "However, snake researchers and experts say that there is treatment available for bites from this species, and timely medical intervention can reduce the risk of death.\n");
        hashMap.put("image_url", "https://images.pexels.com/photos/177598/pexels-photo-177598.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");

        arrayList.add(hashMap);

    }

    public void hMap7(){

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("title", "Russell's Viper: How did it get its name?");
        hashMap.put("description", "In recent days, a species of snake has become a hot topic on social media in the country. The discussion about the venomous Russell's Viper has not only flooded the internet but also tea stalls and casual conversations.\n" +
                "Recently, panic has spread about this species of snake in several districts, especially in areas along the Padma River. The situation has escalated to such an extent that some people in these regions are even campaigning to kill the Russell's Viper snakes.\n" +
                "Many are curious about the name Russell's Viper. This venomous snake is locally known as Chandra Bora and Ulubora. It looks somewhat like a baby python.\n" +
                "\n" +
                "\n" +
                "Scottish surgeon Patrick Russell came to work in India during British rule. He was a herpetologist who first described many of India’s snakes in the 1790s. \n" +
                "In 1796, he researched this snake, and it was named after him. Hence, the snake is called Russell's Viper after Patrick Russell.\n" +
                "It is a venomous snake primarily found in India, Taiwan, and Indonesia, but it is also present in Bangladesh.\n" +
                "\n" +
                "\n" +
                "Russell’s Viper is a venomous snake in the family Viperidae native to the Indian subcontinent and one of the big four snakes in India.\n" +
                "It thrives in open environments such as farmlands, where human interaction is frequent due to the abundance of its rodent prey.\n" +
                "The snake can grow up to 1.5 meters and is identified by its distinctive reddish-brown spots outlined in black and white.\n" +
                "Contrary to popular belief, Russell’s Viper is not the most venomous snake in the world.\n" +
                "The Black Mamba and Puff Adder are among the world’s most dangerous snakes due to their potent venom and aggressive nature.\n" +
                "Russell’s Viper, while also highly venomous and responsible for numerous snake bite incidents in India, is considered less aggressive.\n" +
                "In 2002, the International Union for Conservation of Nature (IUCN) declared the Russell's Viper extinct in Bangladesh.\n" +
                "Although the snake primarily inhabits dry regions, particularly the Barind area, it has now spread to at least 35 districts, including several coastal areas, according to experts and relevant authorities.\n" +
                "There are frequent reports of deaths from Russell's Viper bites in these areas. Consequently, there is widespread discussion and significant fear and panic about the snake among the public.\n" +
                "However, snake researchers and experts say that there is treatment available for bites from this species, and timely medical intervention can reduce the risk of death.\n");

        hashMap.put("image_url", "https://ecdn.dhakatribune.net/contents/cache/images/1100x618x1/uploads/media/2024/06/20/Russell-s-Viper-ad60e582c62b173fcf973b336d02c900.jpg?jadewits_media_id=22859");

        arrayList.add(hashMap);

    }

    public void hMap8(){

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("title", "Russell's Viper: How did it get its name?");
        hashMap.put("description", "In recent days, a species of snake has become a hot topic on social media in the country. The discussion about the venomous Russell's Viper has not only flooded the internet but also tea stalls and casual conversations.\n" +
                "Recently, panic has spread about this species of snake in several districts, especially in areas along the Padma River. The situation has escalated to such an extent that some people in these regions are even campaigning to kill the Russell's Viper snakes.\n" +
                "Many are curious about the name Russell's Viper. This venomous snake is locally known as Chandra Bora and Ulubora. It looks somewhat like a baby python.\n" +
                "\n" +
                "\n" +
                "Scottish surgeon Patrick Russell came to work in India during British rule. He was a herpetologist who first described many of India’s snakes in the 1790s. \n" +
                "In 1796, he researched this snake, and it was named after him. Hence, the snake is called Russell's Viper after Patrick Russell.\n" +
                "It is a venomous snake primarily found in India, Taiwan, and Indonesia, but it is also present in Bangladesh.\n" +
                "\n" +
                "\n" +
                "Russell’s Viper is a venomous snake in the family Viperidae native to the Indian subcontinent and one of the big four snakes in India.\n" +
                "It thrives in open environments such as farmlands, where human interaction is frequent due to the abundance of its rodent prey.\n" +
                "The snake can grow up to 1.5 meters and is identified by its distinctive reddish-brown spots outlined in black and white.\n" +
                "Contrary to popular belief, Russell’s Viper is not the most venomous snake in the world.\n" +
                "The Black Mamba and Puff Adder are among the world’s most dangerous snakes due to their potent venom and aggressive nature.\n" +
                "Russell’s Viper, while also highly venomous and responsible for numerous snake bite incidents in India, is considered less aggressive.\n" +
                "In 2002, the International Union for Conservation of Nature (IUCN) declared the Russell's Viper extinct in Bangladesh.\n" +
                "Although the snake primarily inhabits dry regions, particularly the Barind area, it has now spread to at least 35 districts, including several coastal areas, according to experts and relevant authorities.\n" +
                "There are frequent reports of deaths from Russell's Viper bites in these areas. Consequently, there is widespread discussion and significant fear and panic about the snake among the public.\n" +
                "However, snake researchers and experts say that there is treatment available for bites from this species, and timely medical intervention can reduce the risk of death.\n");
        hashMap.put("image_url", "https://images.pexels.com/photos/177598/pexels-photo-177598.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");

        arrayList.add(hashMap);

    }

    public void hMap9(){

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("title", "Russell's Viper: How did it get its name?");
        hashMap.put("description", "In recent days, a species of snake has become a hot topic on social media in the country. The discussion about the venomous Russell's Viper has not only flooded the internet but also tea stalls and casual conversations.\n" +
                "Recently, panic has spread about this species of snake in several districts, especially in areas along the Padma River. The situation has escalated to such an extent that some people in these regions are even campaigning to kill the Russell's Viper snakes.\n" +
                "Many are curious about the name Russell's Viper. This venomous snake is locally known as Chandra Bora and Ulubora. It looks somewhat like a baby python.\n" +
                "\n" +
                "\n" +
                "Scottish surgeon Patrick Russell came to work in India during British rule. He was a herpetologist who first described many of India’s snakes in the 1790s. \n" +
                "In 1796, he researched this snake, and it was named after him. Hence, the snake is called Russell's Viper after Patrick Russell.\n" +
                "It is a venomous snake primarily found in India, Taiwan, and Indonesia, but it is also present in Bangladesh.\n" +
                "\n" +
                "\n" +
                "Russell’s Viper is a venomous snake in the family Viperidae native to the Indian subcontinent and one of the big four snakes in India.\n" +
                "It thrives in open environments such as farmlands, where human interaction is frequent due to the abundance of its rodent prey.\n" +
                "The snake can grow up to 1.5 meters and is identified by its distinctive reddish-brown spots outlined in black and white.\n" +
                "Contrary to popular belief, Russell’s Viper is not the most venomous snake in the world.\n" +
                "The Black Mamba and Puff Adder are among the world’s most dangerous snakes due to their potent venom and aggressive nature.\n" +
                "Russell’s Viper, while also highly venomous and responsible for numerous snake bite incidents in India, is considered less aggressive.\n" +
                "In 2002, the International Union for Conservation of Nature (IUCN) declared the Russell's Viper extinct in Bangladesh.\n" +
                "Although the snake primarily inhabits dry regions, particularly the Barind area, it has now spread to at least 35 districts, including several coastal areas, according to experts and relevant authorities.\n" +
                "There are frequent reports of deaths from Russell's Viper bites in these areas. Consequently, there is widespread discussion and significant fear and panic about the snake among the public.\n" +
                "However, snake researchers and experts say that there is treatment available for bites from this species, and timely medical intervention can reduce the risk of death.\n");
        hashMap.put("image_url", "https://images.pexels.com/photos/177598/pexels-photo-177598.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");

        arrayList.add(hashMap);

    }

    public void hMap10(){

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("title", "Russell's Viper: How did it get its name?");
        hashMap.put("description", "In recent days, a species of snake has become a hot topic on social media in the country. The discussion about the venomous Russell's Viper has not only flooded the internet but also tea stalls and casual conversations.\n" +
                "Recently, panic has spread about this species of snake in several districts, especially in areas along the Padma River. The situation has escalated to such an extent that some people in these regions are even campaigning to kill the Russell's Viper snakes.\n" +
                "Many are curious about the name Russell's Viper. This venomous snake is locally known as Chandra Bora and Ulubora. It looks somewhat like a baby python.\n" +
                "\n" +
                "\n" +
                "Scottish surgeon Patrick Russell came to work in India during British rule. He was a herpetologist who first described many of India’s snakes in the 1790s. \n" +
                "In 1796, he researched this snake, and it was named after him. Hence, the snake is called Russell's Viper after Patrick Russell.\n" +
                "It is a venomous snake primarily found in India, Taiwan, and Indonesia, but it is also present in Bangladesh.\n" +
                "\n" +
                "\n" +
                "Russell’s Viper is a venomous snake in the family Viperidae native to the Indian subcontinent and one of the big four snakes in India.\n" +
                "It thrives in open environments such as farmlands, where human interaction is frequent due to the abundance of its rodent prey.\n" +
                "The snake can grow up to 1.5 meters and is identified by its distinctive reddish-brown spots outlined in black and white.\n" +
                "Contrary to popular belief, Russell’s Viper is not the most venomous snake in the world.\n" +
                "The Black Mamba and Puff Adder are among the world’s most dangerous snakes due to their potent venom and aggressive nature.\n" +
                "Russell’s Viper, while also highly venomous and responsible for numerous snake bite incidents in India, is considered less aggressive.\n" +
                "In 2002, the International Union for Conservation of Nature (IUCN) declared the Russell's Viper extinct in Bangladesh.\n" +
                "Although the snake primarily inhabits dry regions, particularly the Barind area, it has now spread to at least 35 districts, including several coastal areas, according to experts and relevant authorities.\n" +
                "There are frequent reports of deaths from Russell's Viper bites in these areas. Consequently, there is widespread discussion and significant fear and panic about the snake among the public.\n" +
                "However, snake researchers and experts say that there is treatment available for bites from this species, and timely medical intervention can reduce the risk of death.\n");
        hashMap.put("image_url", "https://images.pexels.com/photos/177598/pexels-photo-177598.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");

        arrayList.add(hashMap);

    }

    public void hMap11(){

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("title", "Russell's Viper: How did it get its name?");
        hashMap.put("description", "In recent days, a species of snake has become a hot topic on social media in the country. The discussion about the venomous Russell's Viper has not only flooded the internet but also tea stalls and casual conversations.\n" +
                "Recently, panic has spread about this species of snake in several districts, especially in areas along the Padma River. The situation has escalated to such an extent that some people in these regions are even campaigning to kill the Russell's Viper snakes.\n" +
                "Many are curious about the name Russell's Viper. This venomous snake is locally known as Chandra Bora and Ulubora. It looks somewhat like a baby python.\n" +
                "\n" +
                "\n" +
                "Scottish surgeon Patrick Russell came to work in India during British rule. He was a herpetologist who first described many of India’s snakes in the 1790s. \n" +
                "In 1796, he researched this snake, and it was named after him. Hence, the snake is called Russell's Viper after Patrick Russell.\n" +
                "It is a venomous snake primarily found in India, Taiwan, and Indonesia, but it is also present in Bangladesh.\n" +
                "\n" +
                "\n" +
                "Russell’s Viper is a venomous snake in the family Viperidae native to the Indian subcontinent and one of the big four snakes in India.\n" +
                "It thrives in open environments such as farmlands, where human interaction is frequent due to the abundance of its rodent prey.\n" +
                "The snake can grow up to 1.5 meters and is identified by its distinctive reddish-brown spots outlined in black and white.\n" +
                "Contrary to popular belief, Russell’s Viper is not the most venomous snake in the world.\n" +
                "The Black Mamba and Puff Adder are among the world’s most dangerous snakes due to their potent venom and aggressive nature.\n" +
                "Russell’s Viper, while also highly venomous and responsible for numerous snake bite incidents in India, is considered less aggressive.\n" +
                "In 2002, the International Union for Conservation of Nature (IUCN) declared the Russell's Viper extinct in Bangladesh.\n" +
                "Although the snake primarily inhabits dry regions, particularly the Barind area, it has now spread to at least 35 districts, including several coastal areas, according to experts and relevant authorities.\n" +
                "There are frequent reports of deaths from Russell's Viper bites in these areas. Consequently, there is widespread discussion and significant fear and panic about the snake among the public.\n" +
                "However, snake researchers and experts say that there is treatment available for bites from this species, and timely medical intervention can reduce the risk of death.\n");
        hashMap.put("image_url", "https://images.pexels.com/photos/177598/pexels-photo-177598.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");

        arrayList.add(hashMap);

    }

    public void hMap12(){

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("title", "Russell's Viper: How did it get its name?");
        hashMap.put("description", "In recent days, a species of snake has become a hot topic on social media in the country. The discussion about the venomous Russell's Viper has not only flooded the internet but also tea stalls and casual conversations.\n" +
                "Recently, panic has spread about this species of snake in several districts, especially in areas along the Padma River. The situation has escalated to such an extent that some people in these regions are even campaigning to kill the Russell's Viper snakes.\n" +
                "Many are curious about the name Russell's Viper. This venomous snake is locally known as Chandra Bora and Ulubora. It looks somewhat like a baby python.\n" +
                "\n" +
                "\n" +
                "Scottish surgeon Patrick Russell came to work in India during British rule. He was a herpetologist who first described many of India’s snakes in the 1790s. \n" +
                "In 1796, he researched this snake, and it was named after him. Hence, the snake is called Russell's Viper after Patrick Russell.\n" +
                "It is a venomous snake primarily found in India, Taiwan, and Indonesia, but it is also present in Bangladesh.\n" +
                "\n" +
                "\n" +
                "Russell’s Viper is a venomous snake in the family Viperidae native to the Indian subcontinent and one of the big four snakes in India.\n" +
                "It thrives in open environments such as farmlands, where human interaction is frequent due to the abundance of its rodent prey.\n" +
                "The snake can grow up to 1.5 meters and is identified by its distinctive reddish-brown spots outlined in black and white.\n" +
                "Contrary to popular belief, Russell’s Viper is not the most venomous snake in the world.\n" +
                "The Black Mamba and Puff Adder are among the world’s most dangerous snakes due to their potent venom and aggressive nature.\n" +
                "Russell’s Viper, while also highly venomous and responsible for numerous snake bite incidents in India, is considered less aggressive.\n" +
                "In 2002, the International Union for Conservation of Nature (IUCN) declared the Russell's Viper extinct in Bangladesh.\n" +
                "Although the snake primarily inhabits dry regions, particularly the Barind area, it has now spread to at least 35 districts, including several coastal areas, according to experts and relevant authorities.\n" +
                "There are frequent reports of deaths from Russell's Viper bites in these areas. Consequently, there is widespread discussion and significant fear and panic about the snake among the public.\n" +
                "However, snake researchers and experts say that there is treatment available for bites from this species, and timely medical intervention can reduce the risk of death.\n");
        hashMap.put("image_url", "https://images.pexels.com/photos/177598/pexels-photo-177598.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");

        arrayList.add(hashMap);

    }

    public void hMap13(){

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("title", "Russell's Viper: How did it get its name?");
        hashMap.put("description", "In recent days, a species of snake has become a hot topic on social media in the country. The discussion about the venomous Russell's Viper has not only flooded the internet but also tea stalls and casual conversations.\n" +
                "Recently, panic has spread about this species of snake in several districts, especially in areas along the Padma River. The situation has escalated to such an extent that some people in these regions are even campaigning to kill the Russell's Viper snakes.\n" +
                "Many are curious about the name Russell's Viper. This venomous snake is locally known as Chandra Bora and Ulubora. It looks somewhat like a baby python.\n" +
                "\n" +
                "\n" +
                "Scottish surgeon Patrick Russell came to work in India during British rule. He was a herpetologist who first described many of India’s snakes in the 1790s. \n" +
                "In 1796, he researched this snake, and it was named after him. Hence, the snake is called Russell's Viper after Patrick Russell.\n" +
                "It is a venomous snake primarily found in India, Taiwan, and Indonesia, but it is also present in Bangladesh.\n" +
                "\n" +
                "\n" +
                "Russell’s Viper is a venomous snake in the family Viperidae native to the Indian subcontinent and one of the big four snakes in India.\n" +
                "It thrives in open environments such as farmlands, where human interaction is frequent due to the abundance of its rodent prey.\n" +
                "The snake can grow up to 1.5 meters and is identified by its distinctive reddish-brown spots outlined in black and white.\n" +
                "Contrary to popular belief, Russell’s Viper is not the most venomous snake in the world.\n" +
                "The Black Mamba and Puff Adder are among the world’s most dangerous snakes due to their potent venom and aggressive nature.\n" +
                "Russell’s Viper, while also highly venomous and responsible for numerous snake bite incidents in India, is considered less aggressive.\n" +
                "In 2002, the International Union for Conservation of Nature (IUCN) declared the Russell's Viper extinct in Bangladesh.\n" +
                "Although the snake primarily inhabits dry regions, particularly the Barind area, it has now spread to at least 35 districts, including several coastal areas, according to experts and relevant authorities.\n" +
                "There are frequent reports of deaths from Russell's Viper bites in these areas. Consequently, there is widespread discussion and significant fear and panic about the snake among the public.\n" +
                "However, snake researchers and experts say that there is treatment available for bites from this species, and timely medical intervention can reduce the risk of death.\n");
        hashMap.put("image_url", "https://images.pexels.com/photos/177598/pexels-photo-177598.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");

        arrayList.add(hashMap);

    }

    public void hMap14(){

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("title", "Russell's Viper: How did it get its name?");
        hashMap.put("description", "In recent days, a species of snake has become a hot topic on social media in the country. The discussion about the venomous Russell's Viper has not only flooded the internet but also tea stalls and casual conversations.\n" +
                "Recently, panic has spread about this species of snake in several districts, especially in areas along the Padma River. The situation has escalated to such an extent that some people in these regions are even campaigning to kill the Russell's Viper snakes.\n" +
                "Many are curious about the name Russell's Viper. This venomous snake is locally known as Chandra Bora and Ulubora. It looks somewhat like a baby python.\n" +
                "\n" +
                "\n" +
                "Scottish surgeon Patrick Russell came to work in India during British rule. He was a herpetologist who first described many of India’s snakes in the 1790s. \n" +
                "In 1796, he researched this snake, and it was named after him. Hence, the snake is called Russell's Viper after Patrick Russell.\n" +
                "It is a venomous snake primarily found in India, Taiwan, and Indonesia, but it is also present in Bangladesh.\n" +
                "\n" +
                "\n" +
                "Russell’s Viper is a venomous snake in the family Viperidae native to the Indian subcontinent and one of the big four snakes in India.\n" +
                "It thrives in open environments such as farmlands, where human interaction is frequent due to the abundance of its rodent prey.\n" +
                "The snake can grow up to 1.5 meters and is identified by its distinctive reddish-brown spots outlined in black and white.\n" +
                "Contrary to popular belief, Russell’s Viper is not the most venomous snake in the world.\n" +
                "The Black Mamba and Puff Adder are among the world’s most dangerous snakes due to their potent venom and aggressive nature.\n" +
                "Russell’s Viper, while also highly venomous and responsible for numerous snake bite incidents in India, is considered less aggressive.\n" +
                "In 2002, the International Union for Conservation of Nature (IUCN) declared the Russell's Viper extinct in Bangladesh.\n" +
                "Although the snake primarily inhabits dry regions, particularly the Barind area, it has now spread to at least 35 districts, including several coastal areas, according to experts and relevant authorities.\n" +
                "There are frequent reports of deaths from Russell's Viper bites in these areas. Consequently, there is widespread discussion and significant fear and panic about the snake among the public.\n" +
                "However, snake researchers and experts say that there is treatment available for bites from this species, and timely medical intervention can reduce the risk of death.\n");
        hashMap.put("image_url", "https://images.pexels.com/photos/177598/pexels-photo-177598.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");

        arrayList.add(hashMap);

    }

    public void hMap15(){

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("title", "Russell's Viper: How did it get its name?");
        hashMap.put("description", "In recent days, a species of snake has become a hot topic on social media in the country. The discussion about the venomous Russell's Viper has not only flooded the internet but also tea stalls and casual conversations.\n" +
                "Recently, panic has spread about this species of snake in several districts, especially in areas along the Padma River. The situation has escalated to such an extent that some people in these regions are even campaigning to kill the Russell's Viper snakes.\n" +
                "Many are curious about the name Russell's Viper. This venomous snake is locally known as Chandra Bora and Ulubora. It looks somewhat like a baby python.\n" +
                "\n" +
                "\n" +
                "Scottish surgeon Patrick Russell came to work in India during British rule. He was a herpetologist who first described many of India’s snakes in the 1790s. \n" +
                "In 1796, he researched this snake, and it was named after him. Hence, the snake is called Russell's Viper after Patrick Russell.\n" +
                "It is a venomous snake primarily found in India, Taiwan, and Indonesia, but it is also present in Bangladesh.\n" +
                "\n" +
                "\n" +
                "Russell’s Viper is a venomous snake in the family Viperidae native to the Indian subcontinent and one of the big four snakes in India.\n" +
                "It thrives in open environments such as farmlands, where human interaction is frequent due to the abundance of its rodent prey.\n" +
                "The snake can grow up to 1.5 meters and is identified by its distinctive reddish-brown spots outlined in black and white.\n" +
                "Contrary to popular belief, Russell’s Viper is not the most venomous snake in the world.\n" +
                "The Black Mamba and Puff Adder are among the world’s most dangerous snakes due to their potent venom and aggressive nature.\n" +
                "Russell’s Viper, while also highly venomous and responsible for numerous snake bite incidents in India, is considered less aggressive.\n" +
                "In 2002, the International Union for Conservation of Nature (IUCN) declared the Russell's Viper extinct in Bangladesh.\n" +
                "Although the snake primarily inhabits dry regions, particularly the Barind area, it has now spread to at least 35 districts, including several coastal areas, according to experts and relevant authorities.\n" +
                "There are frequent reports of deaths from Russell's Viper bites in these areas. Consequently, there is widespread discussion and significant fear and panic about the snake among the public.\n" +
                "However, snake researchers and experts say that there is treatment available for bites from this species, and timely medical intervention can reduce the risk of death.\n");
        hashMap.put("image_url", "https://images.pexels.com/photos/177598/pexels-photo-177598.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");

        arrayList.add(hashMap);

    }

}