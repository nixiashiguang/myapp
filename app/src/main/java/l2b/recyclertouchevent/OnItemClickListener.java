package l2b.recyclertouchevent;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import static android.content.ContentValues.TAG;

/**
 * created by link on 2017/10/19 : 52.
 * email : libingyang119@163.com
 */

public abstract class OnItemClickListener implements RecyclerView.OnItemTouchListener {
    private GestureDetectorCompat mGestureDetectorCompat;
    private RecyclerView mRecyclerView;

    public OnItemClickListener(RecyclerView m) {
        this.mRecyclerView = m;
        mGestureDetectorCompat = new GestureDetectorCompat(mRecyclerView.getContext(), new GuestureListener()
        );
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetectorCompat.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetectorCompat.onTouchEvent(e);

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
    public abstract void onItemClick(RecyclerView.ViewHolder viewHolder);
    public abstract  void onItemLongClick(RecyclerView.ViewHolder viewHolder);


    class GuestureListener extends GestureDetector.SimpleOnGestureListener {
        public GuestureListener() {
            super();
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.i(TAG, "onSingleTapUp: ");
           View child = mRecyclerView.findChildViewUnder(e.getX(),e.getY());
            if(child != null){
              RecyViewHolder v = (RecyViewHolder) mRecyclerView.getChildViewHolder(child);
                onItemClick(v);
            }
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.i(TAG, "onLongPress: ");
             View child = mRecyclerView.findChildViewUnder(e.getX(),e.getY());
            if(child != null){
              RecyViewHolder v = (RecyViewHolder) mRecyclerView.getChildViewHolder(child);
                onItemLongClick(v);
            }

//            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.i(TAG, "onScroll: ");
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.i(TAG, "onFling: ");
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            Log.i(TAG, "onShowPress: ");
            super.onShowPress(e);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            Log.i(TAG, "onDown: ");
            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.i(TAG, "onDoubleTap: ");
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.i(TAG, "onSingleTapConfirmed: ");
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onContextClick(MotionEvent e) {
            Log.i(TAG, "onContextClick: ");
            return super.onContextClick(e);
        }
    }
}
