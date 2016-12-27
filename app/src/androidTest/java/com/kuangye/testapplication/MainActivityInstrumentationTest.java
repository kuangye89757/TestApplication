package com.kuangye.testapplication;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by shijie9 on 2016/12/26.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentationTest {

    private static final String STRING_TO_BE_TYPED = "Peter";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void sayHello() {
        /**找到ID为editText的view，
         * 输入Peter，然后关闭键盘*/
        onView(withId(R.id.editText))
                .perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard());

        /**点击Say hello!的View，由于这个Button没有设id，
         * 因此，通过搜索它上面的文字来找到它*/
        onView(withText("Say hello!"))
                .perform(click()); //line 2

        String expectedText = "Hello, " + STRING_TO_BE_TYPED + "!";

        /**将TextView上的文本同预期结果对比，如果一致则测试通过*/
        onView(withId(R.id.textView))
                .check(matches(withText(expectedText))); //line 3
    }

}
