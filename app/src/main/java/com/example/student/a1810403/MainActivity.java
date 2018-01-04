package com.example.student.a1810403;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner ,spinner2;
    ArrayList<String> data;
    TextView tv,tv2,tv3;
    EditText ed;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        tv = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        ed = findViewById(R.id.editText);
        data = new ArrayList<>();
        data.add("AA11");
        data.add("BB22");
        data.add("CC33");
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, data);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv.setText(data.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str[] = getResources().getStringArray(R.array.cities);
                tv3.setText(str[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
     public void click1(View v)
     {
         int pos = spinner.getSelectedItemPosition();//將spinner 選擇項目放入 pos
         tv2.setText(data.get(pos)); //由陣列中取出放入 tv2

     }
    public void  clickAdd(View view)
    {
        data.add(ed.getText().toString()); //由陣列data 加一筆資料 ,括號內 ed 取得轉字串
        adapter.notifyDataSetChanged(); //重新整理
    }

    public void clickDelete(View view)
    {
        data.remove(spinner.getSelectedItemPosition());//由陣列data 刪除資料
        adapter.notifyDataSetChanged();//重新整理

    }




}
