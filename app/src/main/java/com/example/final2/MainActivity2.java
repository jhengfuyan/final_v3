package com.example.final2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity2 extends AppCompatActivity {
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView listview = (ListView) findViewById(R.id.list_step);

        String[] str = {"新北市","台北市","台中市","台南市","高雄市","123","456","789","777"};
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,str);
        listview.setAdapter(adapter);



        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}