package com.songdehuai.headview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.songdehuai.headview.R;

import java.util.List;

/**
 * Created by songdehuai on 2017/11/10.
 */

public class TestAdapter extends BaseAdapter {

    private List<String> stringList;
    private Context context;

    public TestAdapter(Context context,List<String> stringList){
        this.context = context;
        this.stringList = stringList;
    }
    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(null==viewHolder){
            view = View.inflate(context, R.layout.item_test,null);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        return view;
    }

     class ViewHolder{

      ViewHolder(View itemView){

      }
    }
}
