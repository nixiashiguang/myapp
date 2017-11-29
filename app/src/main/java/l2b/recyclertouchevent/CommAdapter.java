package l2b.recyclertouchevent;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * created by link on 2017/10/17 : 48.
 * email : libingyang119@163.com
 */

public  class CommAdapter<T> extends RecyclerView.Adapter<RecyViewHolder> {
    private Context mContext;
    private List<T> mList;
    private LayoutInflater mInflater;
    protected int layoutId;

    //    private List<Integer> mInts;
    public List<T> getDatas() {
        return mList;
    }

    public CommAdapter(Context context, List<T> list, int layoutId) {
        this.mContext = context;
        this.mList = list;
        this.layoutId = layoutId;
        mInflater = LayoutInflater.from(context);
//        mInts = Arrays.asList(R.drawable.ic_fruit_icons_01, R.drawable.ic_fruit_icons_02,
//                R.drawable.ic_fruit_icons_03, R.drawable.ic_fruit_icons_04,
//                R.drawable.ic_fruit_icons_05, R.drawable.ic_fruit_icons_06);
    }

    @Override
    public RecyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyViewHolder recyViewHolder = RecyViewHolder.get(mContext, parent, layoutId);
        return recyViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyViewHolder holder, int position) {
                ImageView img = holder.getView(R.id.rec_img);
                img.setImageResource(((Bean)mList.get(position)).getPic());
                TextView textView = holder.getView(R.id.rec_text);
                textView.setText(((Bean)mList.get(position)).getText());
//        convert(holder, mList.get(position));
    }

//    public abstract void convert(RecyViewHolder viewHolder, T t);

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }
}
