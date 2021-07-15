package com.example.cardtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<Model> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new Adapter(this, getList());
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                //outRect.bottom = -330;
                //最後一張牌卡完整顯示
                if (parent.getChildPosition(view) != (models.size() - 1)) {
                    outRect.bottom = -330;
                }
            }
        });
    }

    private ArrayList<Model> getList() {

        Model m = new Model();
        m.setmName("ㄚㄚㄚ");
        m.setmNum("68011");
        m.setmIdNumber("Y123***123");
        m.setmIdBirthday("89/01/20");
        m.setmIdNum("12345667891");
        models.add(m);

        m = new Model();
        m.setmName("ji3ji3");
        m.setmNum("011");
        m.setmIdNumber("Y135***123");
        m.setmIdBirthday("80/04/20");
        m.setmIdNum("1234523451");
        models.add(m);

        m = new Model();
        m.setmName("ㄚㄚㄚ");
        m.setmNum("68011");
        m.setmIdNumber("Y123***123");
        m.setmIdBirthday("89/01/20");
        m.setmIdNum("12345667891");
        models.add(m);

        m = new Model();
        m.setmName("ji3ji3");
        m.setmNum("011");
        m.setmIdNumber("Y135***123");
        m.setmIdBirthday("80/04/20");
        m.setmIdNum("1234523451");
        models.add(m);

        m = new Model();
        m.setmName("ㄚㄚㄚ");
        m.setmNum("68011");
        m.setmIdNumber("Y123***123");
        m.setmIdBirthday("89/01/20");
        m.setmIdNum("12345667891");
        models.add(m);

        m = new Model();
        m.setmName("ji3ji3");
        m.setmNum("011");
        m.setmIdNumber("Y135***123");
        m.setmIdBirthday("80/04/20");
        m.setmIdNum("1234523451");
        models.add(m);

        m = new Model();
        m.setmName("ㄚㄚㄚ");
        m.setmNum("68011");
        m.setmIdNumber("Y123***123");
        m.setmIdBirthday("89/01/20");
        m.setmIdNum("12345667891");
        models.add(m);

        m = new Model();
        m.setmName("ji3ji3");
        m.setmNum("011");
        m.setmIdNumber("Y135***123");
        m.setmIdBirthday("80/04/20");
        m.setmIdNum("1234523451");
        models.add(m);

        return models;
    }
}