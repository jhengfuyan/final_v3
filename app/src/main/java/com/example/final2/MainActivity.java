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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    SQLiteDataBaseHelper mDBHelper;
    private ArrayList<HashMap<String, String>> gridView;
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

    private class MyAdapter extends RecyclerView.Adapter<MainActivity.MyAdapter.ViewHolder> {//設置Adapter
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
        TextView textView = findViewById(R.id.textView);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,seriesName);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //--------spinner-------------
        mDBHelper = new SQLiteDataBaseHelper(this, DB_NAME
                , null, DB_VERSION, TABLE_NAME);//初始化資料庫
        mDBHelper.chickTable();//確認是否存在資料表，沒有則新增

        mDBHelper.putData("從零從開始的異世界廚房", "m", "frog", "活體丟進去煮");
        mDBHelper.putData("從零從開始的異世界廚房", "m", "dog", "嘴吧纏住剁掉四肢分別煮");
        mDBHelper.putData("從零從開始的異世界廚房", "m", "cat", "手工拔毛油炸");
        mDBHelper.putData("從零從開始的異世界廚房", "v", "lobo", "直接啃就好吃菜還要煮?");
        mDBHelper.putData("從零從開始的異世界廚房", "v", "mushroom", "挑最毒的吃");
        mDBHelper.putData("庫克廚房", "m", "福壽螺", "榨汁");
        mDBHelper.putData("庫克廚房", "v", "義大利香料", "佐義大利麵");
        mDBHelper.putData("擦菜大全", "m", "生鼠肉丼飯", "頭部淋熱油開吃");
        mDBHelper.putData("擦菜大全", "v", "公園雜草", "佐新鮮牛糞");
        gridView = mDBHelper.searchBySeriesName();//撈取資料表內所有資料*/
        myAdapter = new MyAdapter();

        //---------spinner selected--------------
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) adapter.getItem(position);

                gridView = mDBHelper.searchByName(selectedItemText);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //-------spinner selected---------------
        //-------gridview catch ----------------
       /* String[] cubeeNameArray = new String[]{"哭聲","發抖","再見","生氣","昏倒",
                "竊笑","很棒","你好","驚嚇","大笑"};
        int [] cubeePhotoIdArray = new int[]{R.drawable.cubee1,R.drawable.cubee2
                ,R.drawable.cubee3,R.drawable.cubee4,R.drawable.cubee5,R.drawable.cubee6
                ,R.drawable.cubee7,R.drawable.cubee8,R.drawable.cubee9,R.drawable.cubee10
        };
        Data[] cubeeData = new Data[cubeeNameArray.length];
        for (int i = 0 ; i<cubeeData.length;i++){
            cubeeData[i] = new Data();
            cubeeData[i].name = cubeeNameArray[i];
            cubeeData[i].photo = cubeePhotoIdArray[i];
        }

        MyAdapter cubeeAdapter = new MyAdapter(cubeeData,R.layout.cubee_list);

        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(cubeeAdapter);
        gridView.setNumColumns(3);*/

        //-------gridview catch ----------------
    }
}
