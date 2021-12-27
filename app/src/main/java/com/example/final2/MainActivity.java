package com.example.final2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    SQLiteDataBaseHelper mDBHelper;
    private ArrayList<HashMap<String, String>> gridView;
    private final String DB_NAME = "MyList.db";
    private final String TABLE_NAME = "MyTable";
    private final int DB_VERSION = 1;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDBHelper = new SQLiteDataBaseHelper(this, DB_NAME
                , null, DB_VERSION, TABLE_NAME);//初始化資料庫

        mDBHelper.chickTable();//確認是否存在資料表，沒有則新增
        gridView = mDBHelper.searchBySeriesName();//撈取資料表內所有資料*/


        mDBHelper.putData("從零從開始的異世界廚房", "m", "frog", "活體丟進去煮");
        mDBHelper.putData("從零從開始的異世界廚房", "m", "dog", "嘴吧纏住剁掉四肢分別煮");
        mDBHelper.putData("從零從開始的異世界廚房", "m", "cat", "手工拔毛油炸");
        mDBHelper.putData("從零從開始的異世界廚房", "v", "lobo", "直接啃就好吃菜還要煮?");
        mDBHelper.putData("從零從開始的異世界廚房", "v", "mushroom", "挑最毒的吃");
        mDBHelper.putData("庫克廚房", "m", "福壽螺", "榨汁");
        mDBHelper.putData("庫克廚房", "v", "義大利香料", "佐義大利麵");
        mDBHelper.putData("擦菜大全", "m", "生鼠肉丼飯", "頭部淋熱油開吃");
        mDBHelper.putData("擦菜大全", "v", "公園雜草", "佐新鮮牛糞");
        //  myAdapter = new MyAdapter();
    }
}
