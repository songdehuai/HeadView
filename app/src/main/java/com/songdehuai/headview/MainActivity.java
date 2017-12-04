package com.songdehuai.headview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.songdehuai.headview.adapter.TestAdapter;
import com.songdehuai.headview.widget.ListHeadView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListHeadView listHeadView;
    Button btn_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btn_type = findViewById(R.id.btn_type);
        listHeadView = findViewById(R.id.main_lv);
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            stringList.add("");
        }
        btn_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_type.setText("你好啊");
            }
        });
        TestAdapter testAdapter = new TestAdapter(MainActivity.this, stringList);
        listHeadView.setAdapter(testAdapter);
        listHeadView.setOnItemClick(new ListHeadView.onItemClick() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "点击:" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
