package com.example.ravi.mallapp.activity;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ActionMenuView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import com.example.ravi.mallapp.R;
import com.example.ravi.mallapp.activity.Adapters.AdapterForFourElement;
import com.example.ravi.mallapp.activity.Adapters.AdapterForThreeElement;
import com.example.ravi.mallapp.activity.Adapters.HomePageAdapter;
import com.example.ravi.mallapp.activity.classes.ListItems;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView LV_homepage;
    ScrollView sView;

    HomePageAdapter homePageAdapter;
    AdapterForThreeElement adapterForThreeElement;
    AdapterForFourElement adapterForFourElement;
    String arrayItemname[] = new String[]{"MEN", "WOMEN"
            , "HEALTH & BEAUTY", "JEWELLERY & WATCHES", "KIDS", "FOOTWEAR", "FOOD & DRINK"
            , "TECHNOLOGY", "HOME", "SERVICE", "WHAT'S ON", "OFFER", "ITEM_1", "ITEM_2", "ITEM_3"
            , "ITEM_4", "ITEM_5", "ITEM_6", "ITEM_7"
            , "ITEM_8", "ITEM_9"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseView();
        getScreenHeights();

    }

    static int screenHeight = 0;

    public int getScreenHeights() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        screenHeight = size.y;
        return screenHeight;
    }

    ArrayList<ListItems> List_items;

    public void initialiseView() {
        try {
            List_items = new ArrayList<ListItems>();
            LV_homepage = (ListView) findViewById(R.id.lv_homepage);

            sView = (ScrollView) findViewById(R.id.sv_vertical);
                  sView.setVerticalScrollBarEnabled(false
                  );
            binditemInList();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void binditemInList() {
        if (List_items != null) {
            List_items.clear();
        }
        try {
            for (int i = 0; i < arrayItemname.length; i++) {
                ListItems items = new ListItems();

                items.itemName = arrayItemname[i];
                if (items.itemName.equalsIgnoreCase("home") || items.itemName.equalsIgnoreCase("SERVICE")) {
                    items.imageString = "MyString_" + i;
                } else {
                    items.imageString = "noImage";
                }
                items.itemId = String.valueOf(i);
                List_items.add(items);
            }
            int count_size = getCountValue(List_items.size());
//            homePageAdapter = new HomePageAdapter (this,List_items,count_size);
//            LV_homepage.setAdapter(homePageAdapter);

//            adapterForFourElement = new AdapterForFourElement(this,List_items);
//            LV_homepage.setAdapter(adapterForFourElement);

            adapterForThreeElement = new AdapterForThreeElement(this, List_items);
            LV_homepage.setAdapter(adapterForThreeElement);
            if(adapterForThreeElement!=null)
            {
                sView.setVerticalScrollBarEnabled(true);
//                try {
//                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                            AbsListView.LayoutParams.FILL_PARENT,
//                            AbsListView.LayoutParams.FILL_PARENT
//                    );
//                    params.setMargins(12, 0, 0, 0); //left,top,right,bottom
//
//                    LV_homepage.setLayoutParams(params);
//                }catch (Exception ex)
//                {
//                    ex.toString();
//                }
            }
//


        } catch (Exception ex) {
            ex.toString();
        }
    }

    public int getCountValue(int itemArrayListSize) {
        int count = 0;
        int tempSize = 0;
        try {
            while (true) {
                for (int a : listItemType) {
                    if (tempSize >= itemArrayListSize) {
                        return count;
                    } else {
                        tempSize = tempSize + a;
                        count = count + 1;
                    }
                }
            }
        } catch (Exception ex) {
            ex.toString();
        }
        return count;
    }

    public int[] listItemType = new int[]{2, 3, 4, 3};
}
