package com.kuangye.testapplication.gestureDetector;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * 一般使用GestureDetector.SimpleOnGestureListener
 * 用到哪个函数就重写哪个函数，
 * 因为SimpleOnGestureListener类本身已经实现了这两个接口的所有函数，
 * 只是里面全是空的而已
 */
public class Gesturelistener implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private static final String TAG = "Gesturelistener";

    /**
     * 轻轻单击屏幕:
     *      onDown->onSingleTapUp->onSingleTapConfirmed
     *
     * 稍微长按屏幕:
     *      onDown->onShowPress->onSingleTapUp->onSingleTapConfirmed
     *
     * 长按屏幕:
     *      onDown->onShowPress->onLongPress
     *
     * 滑屏:
     *      onDown->onScroll->onScroll->onScroll->………----->onFling
     *
     * 双击: 0--ACTION_DOWN 2--ACTION_MOVE 1--ACTION_UP
     *      onDown->onSingleTapUp->onDoubleTap->onDoubleTapEvent:0
     *    ->onDown->onDoubleTapEvent:2->...onDoubleTapEvent:1
     */

    /**只要按下屏幕*/
    public boolean onDown(MotionEvent e) {
        Log.d(TAG, "onDown() called with: " + "e = [" + e + "]");
        return false;
    }

    /**按下未松开或拖动时触发*/
    public void onShowPress(MotionEvent e) {
        Log.d(TAG, "onShowPress() called with: " + "e = [" + e + "]");
    }

    /**长按屏幕超过一定时长*/
    public void onLongPress(MotionEvent e) {
        Log.d(TAG, "onLongPress() called with: " + "e = [" + e + "]");
    }

    /**轻击屏幕立刻抬起来*/
    public boolean onSingleTapUp(MotionEvent e) {
        Log.d(TAG, "onSingleTapUp() called with: " + "e = [" + e + "]");
        return false;
    }

    /**
     * 单击确认
     */
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.d(TAG, "onSingleTapConfirmed() called with: " + "e = [" + e + "]");
        return false;
    }


    /**滑屏 按下触摸屏、快速移动后松开
     *   由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE, 1个ACTION_UP触发
     */
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {
        Log.d(TAG, "onFling() called with: " + "e1 = [" + e1 + "], e2 = [" + e2 + "], velocityX = [" + velocityX + "], velocityY = [" + velocityY + "]");
        return false;
    }

    /** 滑屏/拖动：
     onDown-----》onScroll----》onScroll----》onScroll----》………----->onFling
     */

    /**屏幕上拖动  用手拖动/以抛的动作滚动(都会多次触发) */
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.d(TAG, "onScroll() called with: " + "e1 = [" + e1 + "], e2 = [" + e2 + "], distanceX = [" + distanceX + "], distanceY = [" + distanceY + "]");
        return false;
    }


    /**双击事件*/
    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.d(TAG, "onDoubleTap() called with: " + "e = [" + e + "]");
        return false;
    }

    /**双击间隔中发生的动作
     * 触发onDoubleTap以后，在双击之间发生的其它动作，包含down、up和move事件
     */
    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Log.d(TAG, "onDoubleTapEvent() called with: " + "e = [" + e + "]");
        return false;
    }
}
