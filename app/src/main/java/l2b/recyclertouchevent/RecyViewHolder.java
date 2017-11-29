package l2b.recyclertouchevent;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * created by link on 2017/10/17 : 49.
 * email : libingyang119@163.com
 * 学习封装ViewHolder。
 */

public class RecyViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mSparseArray;
    private View mConvertView;
    private Context mContext;

    public RecyViewHolder(Context context,View itemView, ViewGroup parent)
    {
        super(itemView);
        mConvertView = itemView;
        mContext = context;
        mSparseArray = new SparseArray<>();
    }
    public static RecyViewHolder get(Context context,ViewGroup parent,int layout_id){
        View itemView = LayoutInflater.from(context).inflate(layout_id,parent,false);
        RecyViewHolder viewHolder = new RecyViewHolder(context,itemView,parent);
        return viewHolder;
    }
    public <T extends View> T getView(int viewId){
        View view = mSparseArray.get(viewId);
        if(view == null){
            view = mConvertView.findViewById(viewId);
            mSparseArray.put(viewId,view);
        }
        return (T) view;
    }
}
