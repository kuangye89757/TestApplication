package com.kuangye.testapplication.gestureDetector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.kuangye.testapplication.R;

public class GestureActivity extends AppCompatActivity implements View.OnTouchListener {

    private GestureDetector mGestureDetector;
    private Gesturelistener mGesturelistener;
    private SimpleGestureListener mSimpleOnGestureListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);

        /**使用GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener*/
//        mGesturelistener = new Gesturelistener();
//        mGestureDetector = new GestureDetector(this,mGesturelistener);
//        mGestureDetector.setOnDoubleTapListener(mGesturelistener);

        /**使用GestureDetector.SimpleOnGestureListener*/
        mSimpleOnGestureListener = new SimpleGestureListener();
        mGestureDetector = new GestureDetector(this,mSimpleOnGestureListener);

        TextView tv = (TextView)findViewById(R.id.tv);
        tv.setOnTouchListener(this);
        tv.setFocusable(true);
        tv.setClickable(true);
        tv.setLongClickable(true);
    }

    /**
     * 在onTouch()方法中，我们调用GestureDetector的onTouchEvent()方法，
     *      将捕捉到的MotionEvent交给GestureDetector
     */
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    /**
     * 判断左滑还是右滑
     */
    private class SimpleGestureListener extends GestureDetector.SimpleOnGestureListener {

        /*****OnGestureListener的函数*****/
        final int FLING_MIN_DISTANCE = 100, FLING_MIN_VELOCITY = 200;

        // 触发条件 ：     
        // X轴的坐标位移大于FLING_MIN_DISTANCE，且移动速度大于FLING_MIN_VELOCITY个像素/秒     

        // 参数解释：     
        // e1：第1个ACTION_DOWN MotionEvent     
        // e2：最后一个ACTION_MOVE MotionEvent     
        // velocityX：X轴上的移动速度，像素/秒     
        // velocityY：Y轴上的移动速度，像素/秒     
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
                Log.i("MyGesture", "Fling left");
            } else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
                Log.i("MyGesture", "Fling right");
            }
            return true;
        }

    }
}
