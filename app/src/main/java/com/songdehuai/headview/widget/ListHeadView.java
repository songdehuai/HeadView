package com.songdehuai.headview.widget;


import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * 描述：简单实现ListViewHeadView
 *
 * @author songdehuai
 * @ClassName: com.songdehuai.headview.widget.ListHeadView
 * @date 2017/11/10 9:22
 */
public class ListHeadView extends LinearLayout implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private BaseAdapter mAdapter;

    public ListHeadView(Context context) throws Exception {
        this(context, null, -1);
    }

    public ListHeadView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public ListHeadView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    void initViews(Context context) {
        mListView = new ListView(context);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        mListView.setLayoutParams(layoutParams);
        mListView.setOnItemClickListener(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mAdapter != null) {
            try {
                View view = this.getChildAt(0);
                if (mListView.getHeaderViewsCount() == 0) {
                    this.removeViewAt(0);
                    mListView.addHeaderView(view);
                    this.addView(mListView);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ListView listView() {
        return mListView;
    }

    public void setAdapter(BaseAdapter adapter) {
        initViews(getContext());
        this.mAdapter = adapter;
        mListView.setAdapter(adapter);
    }

    private onItemClick mOnItemClick;

    public void setOnItemClick(onItemClick mOnItemClick) {
        this.mOnItemClick = mOnItemClick;
    }

    public interface onItemClick {
        void onItemClick(AdapterView<?> parent, View view, int position, long id);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        position = position - 1;
        if (mOnItemClick != null) {
            mOnItemClick.onItemClick(parent, view, position, id);
        } else {
            Log.e("ListHeadView", "你没有给ListView设置onItemClick");
        }
    }
}
