package com.example.final2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter adapter;
    private Spinner spinner;
    private int flag;
    private String[] seriesName = new String[]{
            "從零開始的異世界廚房","庫克廚房","台客私廚"
    };
    private String[] FoodArray  ;
    private int[] FoodPhotoArray ;
    //-----------------chinese food ------------------------
    private String[] chineseArray = new String[]{
            "筍乾封肉","高麗菜煎肉",
            "蒜蓉蒸蝦","佛跳牆"};
    private int [] chinesePhotoIdArray = new int[]{
            R.drawable.chinesemeat, R.drawable.chinesevegetable,
            R.drawable.chinesegarlicshirmp,R.drawable.chinesesoup};
    //-----------------chinese food ------------------------
    //-----------------cooker food ------------------------
    private String[] cookerArray = new String[]{
            "紅酒燉牛肉","馬鈴薯球",
            "香煎杏仁鱈魚","羅宋湯"};
    private int [] cookerPhotoIdArray = new int[]{
            R.drawable.redmeat,R.drawable.potato,
            R.drawable.fish,R.drawable.soup};
    //-----------------cooker food ------------------------
    //-----------------re0 food ------------------------
    private String[] reArray = new String[]{
            "基輔雞肉","雜拌湯","馬鈴薯沙拉菜","烏哈湯"};
    private int [] rePhotoIdArray = new int[]{
            R.drawable.re_meat,R.drawable.re_soup
            ,R.drawable.re_veg,R.drawable.re_seafood};
    //-----------------re0 food ------------------------


    //-----------gridview catch ---------------
    class Data{
        int photo;
        String name;

    }
    public class GMyAdapter extends BaseAdapter {
        private MainActivity.Data[] data;
        private int view;


        public  GMyAdapter (MainActivity.Data[] data, int view){
            this.data = data;
            this.view = view;
        }
        @Override
        public int getCount () {
            return data.length;
        }
        @Override
        public  Object getItem (int position) {
            return data[position];
        }
        @Override
        public  long getItemId (int position) {
            return  0 ;
        }
        @Override
        public View getView (int position, View convertView, ViewGroup parent){
            convertView = getLayoutInflater().inflate(view,parent, false);
            TextView name = convertView.findViewById(R.id.name);
            name.setText(data[position].name);
            ImageView imageView = convertView.findViewById(R.id.imageView);
            imageView.setImageResource(data[position].photo);
            return convertView;
        }
    }
    //-----------gridview catch ---------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        //---------spinner------------
        spinner = findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,seriesName);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //--------spinner-------------
        //---------spinner selected--------------
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) adapter.getItem(position);
                char[] charSearch = {'台','庫','從'};
                char chr = selectedItemText.charAt(0);
                for(int j=0; j<charSearch.length; j++)
                {
                    switch (j){
                        case 0 :{//擦菜
                            if (charSearch[j] == chr){
                                flag = 0;
                                Data[] foodData = new Data[chineseArray.length];
                                FoodArray = new String[chineseArray.length];
                                FoodPhotoArray = new int[chinesePhotoIdArray.length];
                                for (int i = 0 ; i<foodData.length;i++){
                                    FoodArray[i]= chineseArray[i];
                                    FoodPhotoArray[i]=chinesePhotoIdArray[i];
                                    foodData[i] = new Data();
                                    foodData[i].name = chineseArray[i];
                                    foodData[i].photo =chinesePhotoIdArray[i];
                                }

                                secondImage.setImageResource(R.drawable.image1);

                                GMyAdapter foodAdapter = new GMyAdapter(foodData,R.layout.food_list);//放入foodData資料array
                                GridView gridView = findViewById(R.id.gridView);
                                gridView.setAdapter(foodAdapter);
                                gridView.setNumColumns(2);
                                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                        Intent intent = new Intent();
                                        Bundle b = new Bundle();
                                        b.putInt("kitchen",0);
                                        b.putInt("btn_sel",flag);
                                        b.putInt("pos",position);
                                        intent.putExtras(b);

                                        intent.setClass(MainActivity.this, MainActivity2.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                            break;
                        }
                        case 1:{//庫克
                            if (charSearch[j] == chr){
                                flag = 0;
                                Data[] foodData = new Data[cookerArray.length];
                                FoodArray = new String[cookerArray.length];
                                FoodPhotoArray = new int[cookerPhotoIdArray.length];
                                for (int i = 0 ; i<foodData.length;i++){
                                    FoodArray[i] = cookerArray[i];
                                    FoodPhotoArray[i] = cookerPhotoIdArray[i];
                                    foodData[i] = new Data();
                                    foodData[i].name = cookerArray[i];
                                    foodData[i].photo =cookerPhotoIdArray[i];
                                }

                                secondImage.setImageResource(R.drawable.cooker);

                                GMyAdapter foodAdapter = new GMyAdapter(foodData,R.layout.food_list);//放入foodData資料array
                                GridView gridView = findViewById(R.id.gridView);
                                gridView.setAdapter(foodAdapter);
                                gridView.setNumColumns(2);
                                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                        Intent intent = new Intent();
                                        Bundle b = new Bundle();
                                        b.putInt("kitchen",1);
                                        b.putInt("btn_sel",flag);
                                        b.putInt("pos",position);
                                        intent.putExtras(b);

                                        intent.setClass(MainActivity.this, MainActivity2.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                            break;
                        }
                        case 2:{//RE:0
                            if (charSearch[j] == chr){
                                flag = 0;
                                Data[] foodData = new Data[reArray.length];
                                FoodArray = new String[reArray.length];
                                FoodPhotoArray = new int[rePhotoIdArray.length];
                                for (int i = 0 ; i<foodData.length;i++){
                                    FoodArray[i] = reArray[i];
                                    FoodPhotoArray[i] = rePhotoIdArray[i];
                                    foodData[i] = new Data();
                                    foodData[i].name = reArray[i];
                                    foodData[i].photo =rePhotoIdArray[i];
                                }
                                secondImage.setImageResource(R.drawable.re);

                                GMyAdapter foodAdapter = new GMyAdapter(foodData,R.layout.food_list);//放入foodData資料array
                                GridView gridView = findViewById(R.id.gridView);
                                gridView.setAdapter(foodAdapter);
                                gridView.setNumColumns(2);
                                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                        Intent intent = new Intent();
                                        Bundle b = new Bundle();
                                        b.putInt("kitchen",2);
                                        b.putInt("btn_sel",flag);
                                        b.putInt("pos",position);
                                        intent.putExtras(b);

                                        intent.setClass(MainActivity.this, MainActivity2.class);
                                        startActivity(intent);

                                    }
                                });
                            }
                            break;
                        }
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //-------spinner selected End---------------
        //-------btn_all click ---------------
        Button btn_all = findViewById(R.id.btn_all);

        btn_all.setOnClickListener(v -> {
            flag = 0;
            Data[] foodData = new Data[FoodArray.length];
            for (int i = 0 ; i<FoodArray.length;i++){
                foodData[i] = new Data();
                foodData[i].name = FoodArray[i];
                foodData[i].photo = FoodPhotoArray[i];
            }
            GMyAdapter foodAdapter = new GMyAdapter(foodData,R.layout.food_list);//放入foodData資料array
            GridView gridView = findViewById(R.id.gridView);
            gridView.setAdapter(foodAdapter);
            gridView.setNumColumns(2);
        });
        //-------btn_all click End---------------

        //-------btn_meats click---------------
        Button btn_meat = findViewById(R.id.btn_meat);
        btn_meat.setOnClickListener(v -> {
            flag = 1;
            int j = 0;
            for (int i = 0 ; i<FoodArray.length;i++){
                if(FoodArray[i].indexOf("肉") != -1||FoodArray[i].contains("佛跳牆")) {
                    j++;
                }
            }
            Data[] foodData = new Data[j];
            j = 0;
            //    try{
            for (int i = 0 ; i < FoodArray.length;i++){
                if(FoodArray[i].contains("肉")||FoodArray[i].contains("佛跳牆")) {
                    foodData[j] = new Data();
                    foodData[j].name = FoodArray[i];
                    foodData[j].photo = FoodPhotoArray[i];
                    j++;
                }
            }

            //    } catch (Exception e) {
            //        e.printStackTrace();
            //    }
            GMyAdapter foodAdapter = new GMyAdapter(foodData,R.layout.food_list);//放入foodData資料array
            GridView gridView = findViewById(R.id.gridView);
            gridView.setAdapter(foodAdapter);
            gridView.setNumColumns(2);
        });
        //-------btn_meats click end---------------

        //-------btn_vegetable click ---------------
        Button btn_vegetable = findViewById(R.id.btn_vegetable);

        btn_vegetable.setOnClickListener(v -> {
            flag = 2;
            int j = 0;
            for (int i = 0 ; i<FoodArray.length;i++){
                if(FoodArray[i].indexOf("菜") != -1||FoodArray[i].contains("薯")||FoodArray[i].contains("佛跳牆")) {
                    j++;
                }
            }
            Data[] foodData = new Data[j];
            j = 0;
            //    try{
            for (int i = 0 ; i < FoodArray.length;i++){
                if(FoodArray[i].contains("菜")||FoodArray[i].contains("薯")||FoodArray[i].contains("佛跳牆")) {
                    foodData[j] = new Data();
                    foodData[j].name = FoodArray[i];
                    foodData[j].photo = FoodPhotoArray[i];
                    j++;
                }
            }

            //    } catch (Exception e) {
            //        e.printStackTrace();
            //    }
            GMyAdapter foodAdapter = new GMyAdapter(foodData,R.layout.food_list);//放入foodData資料array
            GridView gridView = findViewById(R.id.gridView);
            gridView.setAdapter(foodAdapter);
            gridView.setNumColumns(2);
        });
        //-------btn_vegetable click end ---------------

        //-------btn_soup click ---------------
        Button btn_soup = findViewById(R.id.btn_soup);

        btn_soup.setOnClickListener(v -> {
            flag = 3;
            int j = 0;
            for (int i = 0 ; i<FoodArray.length;i++){
                if(FoodArray[i].indexOf("湯") != -1||FoodArray[i].contains("佛跳牆")) {
                    j++;
                }
            }
            Data[] foodData = new Data[j];
            j = 0;
            //    try{
            for (int i = 0 ; i < FoodArray.length;i++){
                if(FoodArray[i].contains("湯")||FoodArray[i].contains("佛跳牆")) {
                    foodData[j] = new Data();
                    foodData[j].name = FoodArray[i];
                    foodData[j].photo = FoodPhotoArray[i];
                    j++;
                }
            }

            //    } catch (Exception e) {
            //        e.printStackTrace();
            //    }
            GMyAdapter foodAdapter = new GMyAdapter(foodData,R.layout.food_list);//放入foodData資料array
            GridView gridView = findViewById(R.id.gridView);
            gridView.setAdapter(foodAdapter);
            gridView.setNumColumns(2);
        });
        //-------btn_soup click end ---------------

        //-------btn_seafood click---------------
        Button btn_seafood = findViewById(R.id.btn_seafood);

        btn_seafood.setOnClickListener(v -> {
            flag = 4;
            int j = 0;
            for (int i = 0 ; i<FoodArray.length;i++){
                if(FoodArray[i].indexOf("魚") != -1||FoodArray[i].contains("蝦")||FoodArray[i].contains("烏哈湯")) {
                    j++;
                }
            }
            Data[] foodData = new Data[j];
            j = 0;
            //    try{
            for (int i = 0 ; i < FoodArray.length;i++){
                if(FoodArray[i].indexOf("魚") != -1||FoodArray[i].contains("蝦")||FoodArray[i].contains("烏哈湯")) {
                    foodData[j] = new Data();
                    foodData[j].name = FoodArray[i];
                    foodData[j].photo = FoodPhotoArray[i];
                    j++;
                }
            }

            //    } catch (Exception e) {
            //        e.printStackTrace();
            //    }
            GMyAdapter foodAdapter = new GMyAdapter(foodData,R.layout.food_list);//放入foodData資料array
            GridView gridView = findViewById(R.id.gridView);
            gridView.setAdapter(foodAdapter);
            gridView.setNumColumns(1);
        });
        //-------btn_seafood click end---------------

    }
    private ImageView secondImage;
    private void findViews() {
        secondImage = (ImageView) findViewById(R.id.imageView2);
    }
}
