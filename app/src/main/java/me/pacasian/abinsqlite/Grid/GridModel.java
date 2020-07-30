package me.pacasian.abinsqlite.Grid;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import me.pacasian.abinsqlite.R;

public class GridModel extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private  String[] numberword;
    private  String[] numberimage;

    public GridModel(Context c,String[] numberword,String[] numberimage){
        context=c;
        this.numberword=numberword;
        this.numberimage=numberimage;

    }
    @Override
    public int getCount() {
        return numberword.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null){
            inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView ==null){
            convertView=inflater.inflate(R.layout.grid_layout_model,null);
        }


        TextView imageView=convertView.findViewById(R.id.matter1);
        TextView text= convertView.findViewById(R.id.date1);
        imageView.setText(numberimage[position]);
        text.setText(numberword[position]);
        return convertView;
    }
}