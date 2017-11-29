package l2b.recyclertouchevent;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

/**
 * created by link on 2017/10/19 : 23.
 * email : libingyang119@163.com
 */

public class CustomItemDecoration extends RecyclerView.ItemDecoration {
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
    public static final int HORIZONTAL_GRID = LinearLayoutManager.HORIZONTAL;
    private static final int[] ATTR = new int[]{android.R.attr.listDivider};
    private Drawable mDivider;
    private int orientation;
    private Context mContext;

    public CustomItemDecoration(Context context, int orientation) {
        TypedArray ta = context.obtainStyledAttributes(ATTR);
        mDivider = ta.getDrawable(0);
        ta.recycle();
        setOrientation(orientation);
    }

    public CustomItemDecoration(Context context, int orientation, int drawableId) {
        this(context, orientation);
        mDivider = ContextCompat.getDrawable(context, drawableId);
        setOrientation(orientation);
    }

    public void setOrientation(int orientation) {
        if (orientation != VERTICAL_LIST && orientation != HORIZONTAL_GRID) {
            throw new IllegalArgumentException("invalid orientation,you must be set VERTICAL_LIST or HORIZONTAL_GRID");
        }
        this.orientation = orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        drawVertical(c,parent);
    }

    public void drawVertical(Canvas c, RecyclerView parent) {
        final int left = parent.getLeft() + parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();
        int count = parent.getChildCount();

        for (int i = 0; i < count; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom()
                    + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0,0,0,mDivider.getIntrinsicHeight());
    }
}
