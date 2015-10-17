package com.piotr.weatherforpoznan.espresso;

/**
 * Created by Piotr on 16.10.2015.
 */

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.piotr.weatherforpoznan.MainActivity_;
import com.piotr.weatherforpoznan.R;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity_> mRule = new ActivityTestRule<>(MainActivity_.class);

    @Test
    public void check_01_IfAppNameIsDisplayed() throws InterruptedException {
        Thread.sleep(20000);
        onView(withText(R.string.app_name)).check(matches(isDisplayed()));
    }

    @Test
    public void check_02_IfSettingsAreDisplayed() throws InterruptedException {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.title_activity_settings)).check(matches(isDisplayed()));
    }

    @Test
    public void check_03_IfSettingsAreClickable() throws InterruptedException {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.title_activity_settings)).perform(click());
    }

    @Test
    public void check_04_IfSwipeToRefreshIsDisplayed() throws InterruptedException {
        onView(withId(R.id.listview_forecast)).check(matches(isDisplayed()));
    }

    @Test
    public void check_05_IfListViewIsDisplayed() throws InterruptedException {
        onView(withId(R.id.listview_forecast)).check(matches(isDisplayed()));
    }

    @Test
    public void check_06_IfSwipeToRefreshIsWorking() throws InterruptedException {
        onView(withId(R.id.swiperefresh)).perform(swipeDown());
    }

    @Test
    public void check_07_IfSwipeToRefreshIsWorking() throws InterruptedException {
        onView(withId(R.id.action_bar)).check(matches(isDisplayed()));
    }
}

