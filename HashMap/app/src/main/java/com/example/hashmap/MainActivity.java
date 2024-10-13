package com.example.hashmap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
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

    HashMap <String,String> hashMap = new HashMap<>();
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();

    GridView listView;


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
        hMap3();
        hMap4();

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
            @SuppressLint("ViewHolder") View view = inflater.inflate(R.layout.item,parent, false);


            ImageView coverImage = view.findViewById(R.id.cover_image);
            TextView title = view.findViewById(R.id.title);
            TextView description = view.findViewById(R.id.description);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout itemLayout = view.findViewById(R.id.itemLayout);


            HashMap <String,String> hashMap = arrayList.get(position);

            String image_url = hashMap.get("image_url");
            String newTitle = hashMap.get("title");
            String newDescription = hashMap.get("description");


            Picasso.get().load(image_url)
                    .placeholder(R.drawable.background)
                    .into(coverImage);
            title.setText(newTitle);
            description.setText(newDescription);


            itemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    NewsDetails.TITLE = newTitle;
                    NewsDetails.LONG_DESCRIPTION = newDescription;

                    Bitmap bitmap = ((BitmapDrawable) coverImage.getDrawable()).getBitmap();
                    NewsDetails.BITMAP = bitmap;

                    startActivity(new Intent(MainActivity.this, NewsDetails.class));

                }
            });





            return view;
        }
    }

    public void hMap(){

        HashMap <String, String> hashMap = new HashMap<>();

        hashMap.put("image_url", "https://cdn.pixabay.com/photo/2017/08/10/00/40/stars-2616537_1280.jpg");
        hashMap.put("title", "4 big takeaways from Day 5 of Hunter Biden's federal gun trial");
        hashMap.put("description", "Hunter Biden's criminal gun trial abruptly ended for the week on Friday after his daughter Naomi Biden testified that her dad \"seemed great, he seemed hopeful\" just days after he purchased a Colt revolver in October of 2018, bolstering the defense claim that he was not abusing drugs around the time he procured the gun.\n" +
                "But the value of her testimony for the defense waivered under intense cross-examination, where prosecutors elicited testimony suggesting that drug remnants and paraphernalia found in his truck days after he reclaimed it from his daughter -- just days before his then-girlfriend Hallie Biden discovered them in the vehicle alongside the firearm -- were likely placed there by him.\n" +
                "Whether Hunter Biden will testify in his own defense remains an open question, as his attorneys suggested they needed the weekend to make that \"last decision\" before resting their case. The president's son is accused of lying on a federal form when he said he wasn't using drugs at the time he purchased the gun on Oct. 12, 2018.\n" +
                "If the defense opts not to call him to the stand, closing statements could begin as soon as Monday. The parties will be back in court Monday at 8:15 am. ET.\n" +
                "Here are four big takeaways from Day 5 of the trial.\n" +
                "Naomi Biden said her dad seemed 'great'\n" +
                "Naomi Biden, the 30-year-old daughter of Hunter Biden, testified that she twice saw her father during the timeframe in 2018 when Hunter Biden's attorneys said he was not actively using drugs, and each time, she testified, he \"seemed great.\"\n" +
                "\"He seemed like the clearest that I had seen him since my uncle died, and he just seemed really great,\" she said of an August 2018 visit to Los Angeles to see her father.\n" +
                "The next time she saw him, in New York, just days after he had purchased the firearm, \"He seemed great, he seemed hopeful,\" she said.\n" +
                "It was important testimony for the defense, which is attempting to convince jurors that, despite his on-again-off-again addiction in the months prior to and after his gun purchase, Hunter Biden was not actively using drugs in October 2018.\n" +
                "Text messages suggest Naomi Biden was worried\n" +
                "But Naomi Biden's testimony later provided some favorable moments for the government's case, particularly when prosecutor Leo Wise read aloud from text messages that seemed to run contrary to her claim that Hunter Biden was doing \"great.\"\n" +
                "In mid-October 2018, both Naomi and her father were in New York, attempting to exchange cars. Naomi Biden had used her father's vehicle -- the one in which, days later, Hallie Biden would find the Colt Cobra firearm -- to move from Washington, D.C., to New York.\n" +
                "In messages he sent in the early hours of the morning of Oct. 18, 2018, Hunter Biden suggested he and Naomi Biden's then-boyfriend meet to exchange cars at the Manhattan intersection of Fifth Avenue and West 57th Street -- the intersection where, coincidentally, Trump Tower sits.\n" +
                "\"Do you know what your father was doing at 2 o'clock in the morning and why he was asking you for the car then?\" Wise asked.\n" +
                "\"No,\" she replied.\n" +
                "Those messages clearly upset her at the time, according to her responses, which prosecutors read aloud to jurors.\n" +
                "\"I'm sorry daddy, I can't take this,\" she wrote. \"I just miss you and want to hang out with you.\"\n" +
                "At the conclusion of his cross-examination, Wise established that any drug residue found in the truck days later were not left there by Naomi Biden or her then-boyfriend.\n" +
                "\"No drug remnants on the car when you had it on the 19th, right?\" he asked.\n" +
                "\"No,\" Naomi Biden said.\n" +
                "\"And that's when you gave it back to your father and left with it, right?\" he said.\n" +
                "\"Yes,\" she replied.\n" +
                "Days later, Hallie Biden testified that she discovered drug remnants and drug paraphernalia in the car.\n" +
                "Naomi Biden's testimony draws emotion from father\n" +
                "Naomi Biden acknowledged early in her testimony that she was \"nervous\" on the witness stand -- and discussing her father's addiction in such a public and high-stakes setting clearly distressed the 30-year-old attorney.\n" +
                "Her testimony visibly affected her father, who appeared to wipe tears from his eyes as she fielded questions about his efforts to overcome addiction.\n" +
                "Naomi Biden at times appeared timid on the stand, pausing for long periods before answering questions -- particularly during cross-examination.\n" +
                "When her testimony concluded, she and her father embraced before she turned toward the courtroom exit.\n" +
                "The 'last decision': Will Hunter Biden testify?\n" +
                "After a week of testimony, the major outstanding question remains the same as it was before the trial: Will Hunter Biden take the stand in his own defense?\n" +
                "It would be a high-stakes gamble for the defense, and expose Hunter Biden to what would undoubtedly be a grueling cross-examination. Defense attorney Abbe Lowell said before court concluded that he needed the weekend to make this \"last decision\" before resting his case.\n" +
                "If Hunter Biden doesn't testify, and the defense rests on Monday morning, the parties would likely deliver closing arguments that day and the case would then go to the jury.\n");

        arrayList.add(hashMap);

    }


    public void hMap2(){

        HashMap <String, String> hashMap = new HashMap<>();

        hashMap.put("image_url", "https://cdn.pixabay.com/photo/2017/08/10/00/40/stars-2616537_1280.jpg");
        hashMap.put("title", "4 big takeaways from Day 5 of Hunter Biden's federal gun trial");
        hashMap.put("description", "Hunter Biden's criminal gun trial abruptly ended for the week on Friday after his daughter Naomi Biden testified that her dad \"seemed great, he seemed hopeful\" just days after he purchased a Colt revolver in October of 2018, bolstering the defense claim that he was not abusing drugs around the time he procured the gun.\n" +
                "But the value of her testimony for the defense waivered under intense cross-examination, where prosecutors elicited testimony suggesting that drug remnants and paraphernalia found in his truck days after he reclaimed it from his daughter -- just days before his then-girlfriend Hallie Biden discovered them in the vehicle alongside the firearm -- were likely placed there by him.\n" +
                "Whether Hunter Biden will testify in his own defense remains an open question, as his attorneys suggested they needed the weekend to make that \"last decision\" before resting their case. The president's son is accused of lying on a federal form when he said he wasn't using drugs at the time he purchased the gun on Oct. 12, 2018.\n" +
                "If the defense opts not to call him to the stand, closing statements could begin as soon as Monday. The parties will be back in court Monday at 8:15 am. ET.\n" +
                "Here are four big takeaways from Day 5 of the trial.\n" +
                "Naomi Biden said her dad seemed 'great'\n" +
                "Naomi Biden, the 30-year-old daughter of Hunter Biden, testified that she twice saw her father during the timeframe in 2018 when Hunter Biden's attorneys said he was not actively using drugs, and each time, she testified, he \"seemed great.\"\n" +
                "\"He seemed like the clearest that I had seen him since my uncle died, and he just seemed really great,\" she said of an August 2018 visit to Los Angeles to see her father.\n" +
                "The next time she saw him, in New York, just days after he had purchased the firearm, \"He seemed great, he seemed hopeful,\" she said.\n" +
                "It was important testimony for the defense, which is attempting to convince jurors that, despite his on-again-off-again addiction in the months prior to and after his gun purchase, Hunter Biden was not actively using drugs in October 2018.\n" +
                "Text messages suggest Naomi Biden was worried\n" +
                "But Naomi Biden's testimony later provided some favorable moments for the government's case, particularly when prosecutor Leo Wise read aloud from text messages that seemed to run contrary to her claim that Hunter Biden was doing \"great.\"\n" +
                "In mid-October 2018, both Naomi and her father were in New York, attempting to exchange cars. Naomi Biden had used her father's vehicle -- the one in which, days later, Hallie Biden would find the Colt Cobra firearm -- to move from Washington, D.C., to New York.\n" +
                "In messages he sent in the early hours of the morning of Oct. 18, 2018, Hunter Biden suggested he and Naomi Biden's then-boyfriend meet to exchange cars at the Manhattan intersection of Fifth Avenue and West 57th Street -- the intersection where, coincidentally, Trump Tower sits.\n" +
                "\"Do you know what your father was doing at 2 o'clock in the morning and why he was asking you for the car then?\" Wise asked.\n" +
                "\"No,\" she replied.\n" +
                "Those messages clearly upset her at the time, according to her responses, which prosecutors read aloud to jurors.\n" +
                "\"I'm sorry daddy, I can't take this,\" she wrote. \"I just miss you and want to hang out with you.\"\n" +
                "At the conclusion of his cross-examination, Wise established that any drug residue found in the truck days later were not left there by Naomi Biden or her then-boyfriend.\n" +
                "\"No drug remnants on the car when you had it on the 19th, right?\" he asked.\n" +
                "\"No,\" Naomi Biden said.\n" +
                "\"And that's when you gave it back to your father and left with it, right?\" he said.\n" +
                "\"Yes,\" she replied.\n" +
                "Days later, Hallie Biden testified that she discovered drug remnants and drug paraphernalia in the car.\n" +
                "Naomi Biden's testimony draws emotion from father\n" +
                "Naomi Biden acknowledged early in her testimony that she was \"nervous\" on the witness stand -- and discussing her father's addiction in such a public and high-stakes setting clearly distressed the 30-year-old attorney.\n" +
                "Her testimony visibly affected her father, who appeared to wipe tears from his eyes as she fielded questions about his efforts to overcome addiction.\n" +
                "Naomi Biden at times appeared timid on the stand, pausing for long periods before answering questions -- particularly during cross-examination.\n" +
                "When her testimony concluded, she and her father embraced before she turned toward the courtroom exit.\n" +
                "The 'last decision': Will Hunter Biden testify?\n" +
                "After a week of testimony, the major outstanding question remains the same as it was before the trial: Will Hunter Biden take the stand in his own defense?\n" +
                "It would be a high-stakes gamble for the defense, and expose Hunter Biden to what would undoubtedly be a grueling cross-examination. Defense attorney Abbe Lowell said before court concluded that he needed the weekend to make this \"last decision\" before resting his case.\n" +
                "If Hunter Biden doesn't testify, and the defense rests on Monday morning, the parties would likely deliver closing arguments that day and the case would then go to the jury.\n");

        arrayList.add(hashMap);

    }

    public void hMap3(){

        HashMap <String, String> hashMap = new HashMap<>();

        hashMap.put("image_url", "https://cdn.pixabay.com/photo/2017/08/10/00/40/stars-2616537_1280.jpg");
        hashMap.put("title", "4 big takeaways from Day 5 of Hunter Biden's federal gun trial");
        hashMap.put("description", "Hunter Biden's criminal gun trial abruptly ended for the week on Friday after his daughter Naomi Biden testified that her dad \"seemed great, he seemed hopeful\" just days after he purchased a Colt revolver in October of 2018, bolstering the defense claim that he was not abusing drugs around the time he procured the gun.\n" +
                "But the value of her testimony for the defense waivered under intense cross-examination, where prosecutors elicited testimony suggesting that drug remnants and paraphernalia found in his truck days after he reclaimed it from his daughter -- just days before his then-girlfriend Hallie Biden discovered them in the vehicle alongside the firearm -- were likely placed there by him.\n" +
                "Whether Hunter Biden will testify in his own defense remains an open question, as his attorneys suggested they needed the weekend to make that \"last decision\" before resting their case. The president's son is accused of lying on a federal form when he said he wasn't using drugs at the time he purchased the gun on Oct. 12, 2018.\n" +
                "If the defense opts not to call him to the stand, closing statements could begin as soon as Monday. The parties will be back in court Monday at 8:15 am. ET.\n" +
                "Here are four big takeaways from Day 5 of the trial.\n" +
                "Naomi Biden said her dad seemed 'great'\n" +
                "Naomi Biden, the 30-year-old daughter of Hunter Biden, testified that she twice saw her father during the timeframe in 2018 when Hunter Biden's attorneys said he was not actively using drugs, and each time, she testified, he \"seemed great.\"\n" +
                "\"He seemed like the clearest that I had seen him since my uncle died, and he just seemed really great,\" she said of an August 2018 visit to Los Angeles to see her father.\n" +
                "The next time she saw him, in New York, just days after he had purchased the firearm, \"He seemed great, he seemed hopeful,\" she said.\n" +
                "It was important testimony for the defense, which is attempting to convince jurors that, despite his on-again-off-again addiction in the months prior to and after his gun purchase, Hunter Biden was not actively using drugs in October 2018.\n" +
                "Text messages suggest Naomi Biden was worried\n" +
                "But Naomi Biden's testimony later provided some favorable moments for the government's case, particularly when prosecutor Leo Wise read aloud from text messages that seemed to run contrary to her claim that Hunter Biden was doing \"great.\"\n" +
                "In mid-October 2018, both Naomi and her father were in New York, attempting to exchange cars. Naomi Biden had used her father's vehicle -- the one in which, days later, Hallie Biden would find the Colt Cobra firearm -- to move from Washington, D.C., to New York.\n" +
                "In messages he sent in the early hours of the morning of Oct. 18, 2018, Hunter Biden suggested he and Naomi Biden's then-boyfriend meet to exchange cars at the Manhattan intersection of Fifth Avenue and West 57th Street -- the intersection where, coincidentally, Trump Tower sits.\n" +
                "\"Do you know what your father was doing at 2 o'clock in the morning and why he was asking you for the car then?\" Wise asked.\n" +
                "\"No,\" she replied.\n" +
                "Those messages clearly upset her at the time, according to her responses, which prosecutors read aloud to jurors.\n" +
                "\"I'm sorry daddy, I can't take this,\" she wrote. \"I just miss you and want to hang out with you.\"\n" +
                "At the conclusion of his cross-examination, Wise established that any drug residue found in the truck days later were not left there by Naomi Biden or her then-boyfriend.\n" +
                "\"No drug remnants on the car when you had it on the 19th, right?\" he asked.\n" +
                "\"No,\" Naomi Biden said.\n" +
                "\"And that's when you gave it back to your father and left with it, right?\" he said.\n" +
                "\"Yes,\" she replied.\n" +
                "Days later, Hallie Biden testified that she discovered drug remnants and drug paraphernalia in the car.\n" +
                "Naomi Biden's testimony draws emotion from father\n" +
                "Naomi Biden acknowledged early in her testimony that she was \"nervous\" on the witness stand -- and discussing her father's addiction in such a public and high-stakes setting clearly distressed the 30-year-old attorney.\n" +
                "Her testimony visibly affected her father, who appeared to wipe tears from his eyes as she fielded questions about his efforts to overcome addiction.\n" +
                "Naomi Biden at times appeared timid on the stand, pausing for long periods before answering questions -- particularly during cross-examination.\n" +
                "When her testimony concluded, she and her father embraced before she turned toward the courtroom exit.\n" +
                "The 'last decision': Will Hunter Biden testify?\n" +
                "After a week of testimony, the major outstanding question remains the same as it was before the trial: Will Hunter Biden take the stand in his own defense?\n" +
                "It would be a high-stakes gamble for the defense, and expose Hunter Biden to what would undoubtedly be a grueling cross-examination. Defense attorney Abbe Lowell said before court concluded that he needed the weekend to make this \"last decision\" before resting his case.\n" +
                "If Hunter Biden doesn't testify, and the defense rests on Monday morning, the parties would likely deliver closing arguments that day and the case would then go to the jury.\n");

        arrayList.add(hashMap);

    }

    public void hMap4(){

        HashMap <String, String> hashMap = new HashMap<>();

        hashMap.put("image_url", "https://cdn.pixabay.com/photo/2017/08/10/00/40/stars-2616537_1280.jpg");
        hashMap.put("title", "4 big takeaways from Day 5 of Hunter Biden's federal gun trial");
        hashMap.put("description", "Hunter Biden's criminal gun trial abruptly ended for the week on Friday after his daughter Naomi Biden testified that her dad \"seemed great, he seemed hopeful\" just days after he purchased a Colt revolver in October of 2018, bolstering the defense claim that he was not abusing drugs around the time he procured the gun.\n" +
                "But the value of her testimony for the defense waivered under intense cross-examination, where prosecutors elicited testimony suggesting that drug remnants and paraphernalia found in his truck days after he reclaimed it from his daughter -- just days before his then-girlfriend Hallie Biden discovered them in the vehicle alongside the firearm -- were likely placed there by him.\n" +
                "Whether Hunter Biden will testify in his own defense remains an open question, as his attorneys suggested they needed the weekend to make that \"last decision\" before resting their case. The president's son is accused of lying on a federal form when he said he wasn't using drugs at the time he purchased the gun on Oct. 12, 2018.\n" +
                "If the defense opts not to call him to the stand, closing statements could begin as soon as Monday. The parties will be back in court Monday at 8:15 am. ET.\n" +
                "Here are four big takeaways from Day 5 of the trial.\n" +
                "Naomi Biden said her dad seemed 'great'\n" +
                "Naomi Biden, the 30-year-old daughter of Hunter Biden, testified that she twice saw her father during the timeframe in 2018 when Hunter Biden's attorneys said he was not actively using drugs, and each time, she testified, he \"seemed great.\"\n" +
                "\"He seemed like the clearest that I had seen him since my uncle died, and he just seemed really great,\" she said of an August 2018 visit to Los Angeles to see her father.\n" +
                "The next time she saw him, in New York, just days after he had purchased the firearm, \"He seemed great, he seemed hopeful,\" she said.\n" +
                "It was important testimony for the defense, which is attempting to convince jurors that, despite his on-again-off-again addiction in the months prior to and after his gun purchase, Hunter Biden was not actively using drugs in October 2018.\n" +
                "Text messages suggest Naomi Biden was worried\n" +
                "But Naomi Biden's testimony later provided some favorable moments for the government's case, particularly when prosecutor Leo Wise read aloud from text messages that seemed to run contrary to her claim that Hunter Biden was doing \"great.\"\n" +
                "In mid-October 2018, both Naomi and her father were in New York, attempting to exchange cars. Naomi Biden had used her father's vehicle -- the one in which, days later, Hallie Biden would find the Colt Cobra firearm -- to move from Washington, D.C., to New York.\n" +
                "In messages he sent in the early hours of the morning of Oct. 18, 2018, Hunter Biden suggested he and Naomi Biden's then-boyfriend meet to exchange cars at the Manhattan intersection of Fifth Avenue and West 57th Street -- the intersection where, coincidentally, Trump Tower sits.\n" +
                "\"Do you know what your father was doing at 2 o'clock in the morning and why he was asking you for the car then?\" Wise asked.\n" +
                "\"No,\" she replied.\n" +
                "Those messages clearly upset her at the time, according to her responses, which prosecutors read aloud to jurors.\n" +
                "\"I'm sorry daddy, I can't take this,\" she wrote. \"I just miss you and want to hang out with you.\"\n" +
                "At the conclusion of his cross-examination, Wise established that any drug residue found in the truck days later were not left there by Naomi Biden or her then-boyfriend.\n" +
                "\"No drug remnants on the car when you had it on the 19th, right?\" he asked.\n" +
                "\"No,\" Naomi Biden said.\n" +
                "\"And that's when you gave it back to your father and left with it, right?\" he said.\n" +
                "\"Yes,\" she replied.\n" +
                "Days later, Hallie Biden testified that she discovered drug remnants and drug paraphernalia in the car.\n" +
                "Naomi Biden's testimony draws emotion from father\n" +
                "Naomi Biden acknowledged early in her testimony that she was \"nervous\" on the witness stand -- and discussing her father's addiction in such a public and high-stakes setting clearly distressed the 30-year-old attorney.\n" +
                "Her testimony visibly affected her father, who appeared to wipe tears from his eyes as she fielded questions about his efforts to overcome addiction.\n" +
                "Naomi Biden at times appeared timid on the stand, pausing for long periods before answering questions -- particularly during cross-examination.\n" +
                "When her testimony concluded, she and her father embraced before she turned toward the courtroom exit.\n" +
                "The 'last decision': Will Hunter Biden testify?\n" +
                "After a week of testimony, the major outstanding question remains the same as it was before the trial: Will Hunter Biden take the stand in his own defense?\n" +
                "It would be a high-stakes gamble for the defense, and expose Hunter Biden to what would undoubtedly be a grueling cross-examination. Defense attorney Abbe Lowell said before court concluded that he needed the weekend to make this \"last decision\" before resting his case.\n" +
                "If Hunter Biden doesn't testify, and the defense rests on Monday morning, the parties would likely deliver closing arguments that day and the case would then go to the jury.\n");

        arrayList.add(hashMap);

    }

}