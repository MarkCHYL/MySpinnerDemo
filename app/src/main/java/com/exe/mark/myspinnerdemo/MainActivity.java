package com.exe.mark.myspinnerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PopupButton btn,btn2;
    private LayoutInflater inflater;
    private  PopupAdapter adapter,adapter2;
    private List<String> cValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (PopupButton) findViewById(R.id.btn);
        btn2 = (PopupButton) findViewById(R.id.btn2) ;
        inflater = LayoutInflater.from(this);

        View view = inflater.inflate(R.layout.popup,null);
        GridView lv = (GridView) view.findViewById(R.id.lv);
        final String[] arr = {"item01","item02","item03","item04","item05","item06"};
        adapter = new PopupAdapter(this,R.layout.popup_item,arr,R.drawable.normal,R.drawable.press);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.setPressPostion(position);
                adapter.notifyDataSetChanged();
                btn.setText(arr[position]);
                btn.hidePopup();
            }
        });
        btn.setPopupView(view,btn);


        View view2 = inflater.inflate(R.layout.popup,null);
        GridView lv2 = (GridView) view2.findViewById(R.id.lv);
        final String[] arr2 = {"item012","item022","item032","item042","item052","item062"};
        adapter2 = new PopupAdapter(this,R.layout.popup_item,arr2,R.drawable.normal,R.drawable.press);
        lv2.setAdapter(adapter2);
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter2.setPressPostion(position);
                adapter2.notifyDataSetChanged();
                btn2.setText(arr2[position]);
                btn2.hidePopup();
            }
        });
        btn2.setPopupView(view2,btn2);

    }

}
