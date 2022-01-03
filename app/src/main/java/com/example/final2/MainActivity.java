package com.example.final2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    SQLiteDataBaseHelper mDBHelper;

    private final String DB_NAME = "MyList.db";
    private final String TABLE_NAME = "MyTable";
    private final int DB_VERSION = 1;
    private ArrayAdapter adapter;
    private Spinner spinner;
    private String[] seriesName = new String[]{
            "從零開始的異世界廚房","庫克廚房","擦蔡大全"
    };
    //------------------------------------------spinner show

    // 所有資料
    ArrayList<HashMap<String, String>>  fullData = new ArrayList<>();
    // 被選中的資料
    ArrayList<HashMap<String, String>> selectedData = new ArrayList<>();
    MainActivity.MyAdapter myAdapter;

    private class MyAdapter extends RecyclerView.Adapter<MainActivity.MyAdapter.ViewHolder> {
        public MyAdapter(Data[] foodData, int food_list) {
        }//設置Adapter
        @NonNull
        @Override
        public MainActivity.MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_1, null);
            return new MainActivity.MyAdapter.ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull MainActivity.MyAdapter.ViewHolder holder, int position) {
            holder.tvTitle.setText("風格:" + fullData.get(position).get("bookName") +
                    "\t種類:" + fullData.get(position).get("") +
                    "\t品名:" + fullData.get(position).get("press") +
                    "\t料理方式:" + fullData.get(position).get("counter"));
            holder.itemView.setOnClickListener((v) -> {
                selectedData.clear();
                selectedData = mDBHelper.searchBySeriesName();
            });
        }
        @Override
        public int getItemCount() {
            return fullData.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvTitle;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tvTitle = itemView.findViewById(android.R.id.text1);
            }
        }
    }
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
                char[] charSearch = {'擦','庫','從'};
                char chr = selectedItemText.charAt(0);
                for(int j=0; j<charSearch.length; j++)
                {
                    switch (j){
                        case 0 :{//擦菜
                            if (charSearch[j] == chr){
                                String[] FoodArray = new String[]{"筍乾封肉","高麗菜煎餅","蒜蓉蒸蝦","佛跳牆"};
                                int [] FoodPhotoIdArray = new int[]{R.drawable.chinesemeat,R.drawable.chinesevegetable
                                        ,R.drawable.chinesegarlicshirmp,R.drawable.chinesesoup};
                                Data[] foodData = new Data[FoodArray.length];
                                for (int i = 0 ; i<foodData.length;i++){
                                    foodData[i] = new Data();
                                    foodData[i].name = FoodArray[i];
                                    foodData[i].photo =FoodPhotoIdArray[i];
                                }
                                GMyAdapter foodAdapter = new GMyAdapter(foodData,R.layout.food_list);//放入foodData資料array
                                GridView gridView = findViewById(R.id.gridView);
                                gridView.setAdapter(foodAdapter);
                                gridView.setNumColumns(2);
                            }
                            break;
                        }
                        case 1:{//庫克
                            if (charSearch[j] == chr){
                                String[] FoodArray = new String[]{"紅酒燉牛肉","馬鈴薯球","香煎杏仁鱈魚","羅宋湯"};
                                int [] FoodPhotoIdArray = new int[]{R.drawable.redmeat,R.drawable.potato
                                        ,R.drawable.fish,R.drawable.soup};
                                Data[] foodData = new Data[FoodArray.length];
                                for (int i = 0 ; i<foodData.length;i++){
                                    foodData[i] = new Data();
                                    foodData[i].name = FoodArray[i];
                                    foodData[i].photo =FoodPhotoIdArray[i];
                                }
                                GMyAdapter foodAdapter = new GMyAdapter(foodData,R.layout.food_list);//放入foodData資料array
                                GridView gridView = findViewById(R.id.gridView);
                                gridView.setAdapter(foodAdapter);
                                gridView.setNumColumns(2);
                            }
                            break;
                        }
                        case 2:{//RE:0
                            if (charSearch[j] == chr){
                                String[] FoodArray = new String[]{"爆炒熊肉","菜湯","白酒煮藍青口","莫斯科紅菜湯"};
                                int [] FoodPhotoIdArray = new int[]{R.drawable.rebear,R.drawable.revegetablesoup
                                        ,R.drawable.reclams,R.drawable.resoup};
                                Data[] foodData = new Data[FoodArray.length];
                                for (int i = 0 ; i<foodData.length;i++){
                                    foodData[i] = new Data();
                                    foodData[i].name = FoodArray[i];
                                    foodData[i].photo =FoodPhotoIdArray[i];
                                }
                                GMyAdapter foodAdapter = new GMyAdapter(foodData,R.layout.food_list);//放入foodData資料array
                                GridView gridView = findViewById(R.id.gridView);
                                gridView.setAdapter(foodAdapter);
                                gridView.setNumColumns(2);
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
        Button btn_all = findViewById(R.id.btn_all);

    }
}
