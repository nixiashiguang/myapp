package l2b.recyclertouchevent;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.Collections;

/**
 * created by link on 2017/10/19 : 07.
 * email : libingyang119@163.com
 */

public class RecyItemCallback extends ItemTouchHelper.Callback {
    private CommAdapter mAdapter;
    private boolean isLongPressDrag;
    private boolean isItemSwipe;

    public RecyItemCallback(CommAdapter adapter) {
        this.mAdapter = adapter;
        isItemSwipe = true;
        isLongPressDrag = true;
    }

    public RecyItemCallback(CommAdapter adapter, boolean isLongPressDrag, boolean isItemSwipe) {
        mAdapter = adapter;
        this.isLongPressDrag = isLongPressDrag;
        this.isItemSwipe = isItemSwipe;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            int flag = ItemTouchHelper.DOWN | ItemTouchHelper.UP;
            int swipe = ItemTouchHelper.END | ItemTouchHelper.START;
            return makeMovementFlags(flag, swipe);
        } else if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            int flag = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            int swip = 0;
            return makeMovementFlags(flag, swip);
        }
        return 0;
    }

    /**
     * @param recyclerView
     * @param viewHolder   被用户拖动的viewhodler
     * @param target       拖动到指定位置的viewhodler.
     * @return
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        //拖动item
        int fpos = viewHolder.getAdapterPosition();
        int tpos = target.getAdapterPosition();
        if (fpos > tpos) {
            for (int i = fpos; i > tpos; i--) {
                Collections.swap(mAdapter.getDatas(), i, i - 1);
            }
        } else if (fpos < tpos) {
            for (int i = fpos; i < tpos; i++) {
                Collections.swap(mAdapter.getDatas(), i, i + 1);
            }
        }
        mAdapter.notifyItemMoved(fpos, tpos);
        return true;
    }

    /**
     * 被滑动
     *
     * @param viewHolder
     * @param direction
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            int pos = viewHolder.getAdapterPosition();
            mAdapter.notifyItemRemoved(pos);
            mAdapter.getDatas().remove(pos);
    }

    /**
     * 当viewhodler被拖动或者滑动时调用
     *
     * @param recyclerView
     * @param viewHolder
     */
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setBackgroundColor(Color.WHITE);
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {//空闲状态：没有相关运动事件或者拖动，滑动事件未触发
            viewHolder.itemView.setBackgroundColor(Color.GRAY);
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return isLongPressDrag;//true 可以
    }

    @Override
    public boolean isItemViewSwipeEnabled() {

        return isItemSwipe;//true 可以。
    }
}
