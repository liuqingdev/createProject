package com.lq.testlayoutinflater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<Hero> list = new ArrayList<>();
    private MainActivity context = this;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据
        list.add(new Hero("超人",R.mipmap.d1));
        list.add(new Hero("雷神",R.mipmap.d2));
        list.add(new Hero("浩克",R.mipmap.d3));
        //初始化视图
        listView = findViewById(R.id.listview);
        adapter = new MyAdapter();
        listView.setAdapter(adapter);
        //listview继承adapterview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showToast();
            }
        });
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
            ImageView pic = view.findViewById(R.id.picture);
            TextView info = view.findViewById(R.id.info);
            Hero hero = list.get(position);
            pic.setImageResource(hero.getImgId());
            info.setText(hero.getName());
            return view;
        }
    }

    public void showToast(){
//        Toast toast = Toast.makeText(context,"sdfsdf",Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER,0,0);
//        toast.show();


        LayoutInflater inflater = getLayoutInflater();
//        View layout = inflater.inflate(R.layout.toast_layout,(ViewGroup) findViewById(R.id.toast_layout_roots),false);
        View layout = inflater.inflate(R.layout.toast_layout,null);
        TextView text = layout.findViewById(R.id.text);
        text.setText("蓝牙");

        Toast toast = new Toast(context);
        toast.setGravity(Gravity.BOTTOM,0,100);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();


    }

}
