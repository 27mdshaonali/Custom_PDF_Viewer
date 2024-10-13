package com.example.newssoftwer;

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
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ArrayList <HashMap <String, String>> arrayList = new ArrayList<>();
    HashMap <String, String > hashMap = new HashMap<>();

    ListView listView;

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

//        hMap2();
//        hMap3();
//        hMap4();
//        hMap5();
//        hMap6();
//        hMap7();
//        hMap8();
//        hMap9();
//        hMap10();

        listView = findViewById(R.id.listView);
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

        @SuppressLint({"ViewHolder", "UseCompatLoadingForDrawables"})
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.item, parent, false);



            ImageView coverImg = view.findViewById(R.id.itemImage);
            TextView title = view.findViewById(R.id.itemTitle);
            TextView desc = view.findViewById(R.id.itemDescription);

            HashMap <String, String > hashMap = arrayList.get(position);


            String title1 = hashMap.get("title");
            String description = hashMap.get("description");
            String image_url = hashMap.get("img_url");

            Picasso.get().load(image_url).placeholder(getResources().getDrawable(R.drawable.logo)).into(coverImg);
            desc.setText(description);
            title.setText(title1);

            return view;
        }
    }

    public void hMap(){

        hashMap.put("img_url", "https://images.pexels.com/photos/289586/pexels-photo-289586.jpeg");

        hashMap.put("title", "The Truth About Debt Forgiveness");
        hashMap.put("description", "When some people think about credit card debt forgiveness, it goes something like this: Your debt is totally erased, and you live happily ever after with no consequences. That would be amazing.\n" +
                "But the harsh truth lies somewhere short of \"totally erased\" and \"no consequences.\" To be clear, debt forgiveness does exist, and it's possible to settle your debt for less than what you owe. But to get it totally erased is rare, and it usually requires an extreme measure, such as bankruptcy.\n" +
                "Read on to learn everything you need to know about debt forgiveness and what it means for your credit score and your wallet.\n" +
                "What Is Credit Card Debt Forgiveness?\n" +
                "The best way to explain this is with an example. Let's say you have a $14,000 credit card balance and you're six months behind on your payments. At this point, your credit card company has sold your debt to a collection agency, so that's whom you'd be negotiating with.\n" +
                "You reach an agreement with the debt collector to pay back $10,000 in a lump sum or in installments. The amount of debt forgiven in this case is $4,000. This doesn't mean you can forget about the forgiven debt, though. For instance, you might have to pay taxes on it.\n" +
                "But there are some steps you can take to avoid having to deal with a debt collector. If you take action on your delinquent debt as quickly as possible, you have an opportunity to talk to your credit card company before your debt is sold.\n" +
                "\n");

        arrayList.add(hashMap);

    }

//    public void hMap2(){
//
//        hashMap.put("Image", "https://images.pexels.com/photos/268533/pexels-photo-268533.jpeg?auto=compress&cs=tinysrgb&w=600");
//        hashMap.put("Title", "The Truth About Debt Forgiveness");
//        hashMap.put("Description", "When some people think about credit card debt forgiveness, it goes something like this: Your debt is totally erased, and you live happily ever after with no consequences. That would be amazing.\n" +
//                "But the harsh truth lies somewhere short of \"totally erased\" and \"no consequences.\" To be clear, debt forgiveness does exist, and it's possible to settle your debt for less than what you owe. But to get it totally erased is rare, and it usually requires an extreme measure, such as bankruptcy.\n" +
//                "Read on to learn everything you need to know about debt forgiveness and what it means for your credit score and your wallet.\n" +
//                "What Is Credit Card Debt Forgiveness?\n" +
//                "The best way to explain this is with an example. Let's say you have a $14,000 credit card balance and you're six months behind on your payments. At this point, your credit card company has sold your debt to a collection agency, so that's whom you'd be negotiating with.\n" +
//                "You reach an agreement with the debt collector to pay back $10,000 in a lump sum or in installments. The amount of debt forgiven in this case is $4,000. This doesn't mean you can forget about the forgiven debt, though. For instance, you might have to pay taxes on it.\n" +
//                "But there are some steps you can take to avoid having to deal with a debt collector. If you take action on your delinquent debt as quickly as possible, you have an opportunity to talk to your credit card company before your debt is sold.\n" +
//                "\n");
//
//        arrayList.add(hashMap);
//
//    }
//
//    public void hMap3(){
//
//        hashMap.put("Image", "https://images.pexels.com/photos/531880/pexels-photo-531880.jpeg?auto=compress&cs=tinysrgb&w=600");
//        hashMap.put("Title", "The Truth About Debt Forgiveness");
//        hashMap.put("Description", "When some people think about credit card debt forgiveness, it goes something like this: Your debt is totally erased, and you live happily ever after with no consequences. That would be amazing.\n" +
//                "But the harsh truth lies somewhere short of \"totally erased\" and \"no consequences.\" To be clear, debt forgiveness does exist, and it's possible to settle your debt for less than what you owe. But to get it totally erased is rare, and it usually requires an extreme measure, such as bankruptcy.\n" +
//                "Read on to learn everything you need to know about debt forgiveness and what it means for your credit score and your wallet.\n" +
//                "What Is Credit Card Debt Forgiveness?\n" +
//                "The best way to explain this is with an example. Let's say you have a $14,000 credit card balance and you're six months behind on your payments. At this point, your credit card company has sold your debt to a collection agency, so that's whom you'd be negotiating with.\n" +
//                "You reach an agreement with the debt collector to pay back $10,000 in a lump sum or in installments. The amount of debt forgiven in this case is $4,000. This doesn't mean you can forget about the forgiven debt, though. For instance, you might have to pay taxes on it.\n" +
//                "But there are some steps you can take to avoid having to deal with a debt collector. If you take action on your delinquent debt as quickly as possible, you have an opportunity to talk to your credit card company before your debt is sold.\n" +
//                "\n");
//
//        arrayList.add(hashMap);
//
//    }
//
//    public void hMap4(){
//
//        hashMap.put("Image", "https://images.pexels.com/photos/531880/pexels-photo-531880.jpeg?auto=compress&cs=tinysrgb&w=600");
//        hashMap.put("Title", "The Truth About Debt Forgiveness");
//        hashMap.put("Description", "When some people think about credit card debt forgiveness, it goes something like this: Your debt is totally erased, and you live happily ever after with no consequences. That would be amazing.\n" +
//                "But the harsh truth lies somewhere short of \"totally erased\" and \"no consequences.\" To be clear, debt forgiveness does exist, and it's possible to settle your debt for less than what you owe. But to get it totally erased is rare, and it usually requires an extreme measure, such as bankruptcy.\n" +
//                "Read on to learn everything you need to know about debt forgiveness and what it means for your credit score and your wallet.\n" +
//                "What Is Credit Card Debt Forgiveness?\n" +
//                "The best way to explain this is with an example. Let's say you have a $14,000 credit card balance and you're six months behind on your payments. At this point, your credit card company has sold your debt to a collection agency, so that's whom you'd be negotiating with.\n" +
//                "You reach an agreement with the debt collector to pay back $10,000 in a lump sum or in installments. The amount of debt forgiven in this case is $4,000. This doesn't mean you can forget about the forgiven debt, though. For instance, you might have to pay taxes on it.\n" +
//                "But there are some steps you can take to avoid having to deal with a debt collector. If you take action on your delinquent debt as quickly as possible, you have an opportunity to talk to your credit card company before your debt is sold.\n" +
//                "\n");
//
//        arrayList.add(hashMap);
//
//    }
//
//    public void hMap5(){
//
//        hashMap.put("Image", "https://images.pexels.com/photos/531880/pexels-photo-531880.jpeg?auto=compress&cs=tinysrgb&w=600");
//        hashMap.put("Title", "The Truth About Debt Forgiveness");
//        hashMap.put("Description", "When some people think about credit card debt forgiveness, it goes something like this: Your debt is totally erased, and you live happily ever after with no consequences. That would be amazing.\n" +
//                "But the harsh truth lies somewhere short of \"totally erased\" and \"no consequences.\" To be clear, debt forgiveness does exist, and it's possible to settle your debt for less than what you owe. But to get it totally erased is rare, and it usually requires an extreme measure, such as bankruptcy.\n" +
//                "Read on to learn everything you need to know about debt forgiveness and what it means for your credit score and your wallet.\n" +
//                "What Is Credit Card Debt Forgiveness?\n" +
//                "The best way to explain this is with an example. Let's say you have a $14,000 credit card balance and you're six months behind on your payments. At this point, your credit card company has sold your debt to a collection agency, so that's whom you'd be negotiating with.\n" +
//                "You reach an agreement with the debt collector to pay back $10,000 in a lump sum or in installments. The amount of debt forgiven in this case is $4,000. This doesn't mean you can forget about the forgiven debt, though. For instance, you might have to pay taxes on it.\n" +
//                "But there are some steps you can take to avoid having to deal with a debt collector. If you take action on your delinquent debt as quickly as possible, you have an opportunity to talk to your credit card company before your debt is sold.\n" +
//                "\n");
//
//        arrayList.add(hashMap);
//
//    }
//
//    public void hMap6(){
//
//        hashMap.put("Image", "https://images.pexels.com/photos/531880/pexels-photo-531880.jpeg?auto=compress&cs=tinysrgb&w=600");
//        hashMap.put("Title", "The Truth About Debt Forgiveness");
//        hashMap.put("Description", "When some people think about credit card debt forgiveness, it goes something like this: Your debt is totally erased, and you live happily ever after with no consequences. That would be amazing.\n" +
//                "But the harsh truth lies somewhere short of \"totally erased\" and \"no consequences.\" To be clear, debt forgiveness does exist, and it's possible to settle your debt for less than what you owe. But to get it totally erased is rare, and it usually requires an extreme measure, such as bankruptcy.\n" +
//                "Read on to learn everything you need to know about debt forgiveness and what it means for your credit score and your wallet.\n" +
//                "What Is Credit Card Debt Forgiveness?\n" +
//                "The best way to explain this is with an example. Let's say you have a $14,000 credit card balance and you're six months behind on your payments. At this point, your credit card company has sold your debt to a collection agency, so that's whom you'd be negotiating with.\n" +
//                "You reach an agreement with the debt collector to pay back $10,000 in a lump sum or in installments. The amount of debt forgiven in this case is $4,000. This doesn't mean you can forget about the forgiven debt, though. For instance, you might have to pay taxes on it.\n" +
//                "But there are some steps you can take to avoid having to deal with a debt collector. If you take action on your delinquent debt as quickly as possible, you have an opportunity to talk to your credit card company before your debt is sold.\n" +
//                "\n");
//
//        arrayList.add(hashMap);
//
//    }
//
//    public void hMap7(){
//
//        hashMap.put("Image", "https://images.pexels.com/photos/531880/pexels-photo-531880.jpeg?auto=compress&cs=tinysrgb&w=600");
//        hashMap.put("Title", "The Truth About Debt Forgiveness");
//        hashMap.put("Description", "When some people think about credit card debt forgiveness, it goes something like this: Your debt is totally erased, and you live happily ever after with no consequences. That would be amazing.\n" +
//                "But the harsh truth lies somewhere short of \"totally erased\" and \"no consequences.\" To be clear, debt forgiveness does exist, and it's possible to settle your debt for less than what you owe. But to get it totally erased is rare, and it usually requires an extreme measure, such as bankruptcy.\n" +
//                "Read on to learn everything you need to know about debt forgiveness and what it means for your credit score and your wallet.\n" +
//                "What Is Credit Card Debt Forgiveness?\n" +
//                "The best way to explain this is with an example. Let's say you have a $14,000 credit card balance and you're six months behind on your payments. At this point, your credit card company has sold your debt to a collection agency, so that's whom you'd be negotiating with.\n" +
//                "You reach an agreement with the debt collector to pay back $10,000 in a lump sum or in installments. The amount of debt forgiven in this case is $4,000. This doesn't mean you can forget about the forgiven debt, though. For instance, you might have to pay taxes on it.\n" +
//                "But there are some steps you can take to avoid having to deal with a debt collector. If you take action on your delinquent debt as quickly as possible, you have an opportunity to talk to your credit card company before your debt is sold.\n" +
//                "\n");
//
//        arrayList.add(hashMap);
//
//    }
//
//    public void hMap8(){
//
//        hashMap.put("Image", "https://images.pexels.com/photos/531880/pexels-photo-531880.jpeg?auto=compress&cs=tinysrgb&w=600");
//        hashMap.put("Title", "The Truth About Debt Forgiveness");
//        hashMap.put("Description", "When some people think about credit card debt forgiveness, it goes something like this: Your debt is totally erased, and you live happily ever after with no consequences. That would be amazing.\n" +
//                "But the harsh truth lies somewhere short of \"totally erased\" and \"no consequences.\" To be clear, debt forgiveness does exist, and it's possible to settle your debt for less than what you owe. But to get it totally erased is rare, and it usually requires an extreme measure, such as bankruptcy.\n" +
//                "Read on to learn everything you need to know about debt forgiveness and what it means for your credit score and your wallet.\n" +
//                "What Is Credit Card Debt Forgiveness?\n" +
//                "The best way to explain this is with an example. Let's say you have a $14,000 credit card balance and you're six months behind on your payments. At this point, your credit card company has sold your debt to a collection agency, so that's whom you'd be negotiating with.\n" +
//                "You reach an agreement with the debt collector to pay back $10,000 in a lump sum or in installments. The amount of debt forgiven in this case is $4,000. This doesn't mean you can forget about the forgiven debt, though. For instance, you might have to pay taxes on it.\n" +
//                "But there are some steps you can take to avoid having to deal with a debt collector. If you take action on your delinquent debt as quickly as possible, you have an opportunity to talk to your credit card company before your debt is sold.\n" +
//                "\n");
//
//        arrayList.add(hashMap);
//
//    }
//
//    public void hMap9(){
//
//        hashMap.put("Image", "https://images.pexels.com/photos/531880/pexels-photo-531880.jpeg?auto=compress&cs=tinysrgb&w=600");
//        hashMap.put("Title", "The Truth About Debt Forgiveness");
//        hashMap.put("Description", "When some people think about credit card debt forgiveness, it goes something like this: Your debt is totally erased, and you live happily ever after with no consequences. That would be amazing.\n" +
//                "But the harsh truth lies somewhere short of \"totally erased\" and \"no consequences.\" To be clear, debt forgiveness does exist, and it's possible to settle your debt for less than what you owe. But to get it totally erased is rare, and it usually requires an extreme measure, such as bankruptcy.\n" +
//                "Read on to learn everything you need to know about debt forgiveness and what it means for your credit score and your wallet.\n" +
//                "What Is Credit Card Debt Forgiveness?\n" +
//                "The best way to explain this is with an example. Let's say you have a $14,000 credit card balance and you're six months behind on your payments. At this point, your credit card company has sold your debt to a collection agency, so that's whom you'd be negotiating with.\n" +
//                "You reach an agreement with the debt collector to pay back $10,000 in a lump sum or in installments. The amount of debt forgiven in this case is $4,000. This doesn't mean you can forget about the forgiven debt, though. For instance, you might have to pay taxes on it.\n" +
//                "But there are some steps you can take to avoid having to deal with a debt collector. If you take action on your delinquent debt as quickly as possible, you have an opportunity to talk to your credit card company before your debt is sold.\n" +
//                "\n");
//
//        arrayList.add(hashMap);
//
//    }
//
//    public void hMap10(){
//
//        hashMap.put("Image", "https://images.pexels.com/photos/531880/pexels-photo-531880.jpeg?auto=compress&cs=tinysrgb&w=600");
//        hashMap.put("Title", "The Truth About Debt Forgiveness");
//        hashMap.put("Description", "When some people think about credit card debt forgiveness, it goes something like this: Your debt is totally erased, and you live happily ever after with no consequences. That would be amazing.\n" +
//                "But the harsh truth lies somewhere short of \"totally erased\" and \"no consequences.\" To be clear, debt forgiveness does exist, and it's possible to settle your debt for less than what you owe. But to get it totally erased is rare, and it usually requires an extreme measure, such as bankruptcy.\n" +
//                "Read on to learn everything you need to know about debt forgiveness and what it means for your credit score and your wallet.\n" +
//                "What Is Credit Card Debt Forgiveness?\n" +
//                "The best way to explain this is with an example. Let's say you have a $14,000 credit card balance and you're six months behind on your payments. At this point, your credit card company has sold your debt to a collection agency, so that's whom you'd be negotiating with.\n" +
//                "You reach an agreement with the debt collector to pay back $10,000 in a lump sum or in installments. The amount of debt forgiven in this case is $4,000. This doesn't mean you can forget about the forgiven debt, though. For instance, you might have to pay taxes on it.\n" +
//                "But there are some steps you can take to avoid having to deal with a debt collector. If you take action on your delinquent debt as quickly as possible, you have an opportunity to talk to your credit card company before your debt is sold.\n" +
//                "\n");
//
//        arrayList.add(hashMap);
//
//    }

}