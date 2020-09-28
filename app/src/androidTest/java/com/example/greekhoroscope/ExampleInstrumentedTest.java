package com.example.greekhoroscope;

import androidx.test.espresso.PerformException;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.After;
import com.microsoft.appcenter.espresso.Factory;
import com.microsoft.appcenter.espresso.ReportHelper;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    @Rule
    public ReportHelper reportHelper = Factory.getReportHelper();

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void itemWithText_checkListElement() {
        reportHelper.label("itemWithText_checkListElement");

        onView(withText("Aries")).check(matches(isDisplayed()));
        onView(withText("Taurus")).check(matches(isDisplayed()));
        onView(withText("Gemini")).check(matches(isDisplayed()));
        onView(withText("Cancer")).check(matches(isDisplayed()));
        onView(withText("Leo")).check(matches(isDisplayed()));
        onView(withText("Virgo")).check(matches(isDisplayed()));
        onView(withText("Libra")).check(matches(isDisplayed()));
        onView(withText("Scorpio")).check(matches(isDisplayed()));
        onView(withText("Sagittarius")).check(matches(isDisplayed()));
        onView(withText("Capricorn")).check(matches(isDisplayed()));
        onView(withText("Aquarius")).check(matches(isDisplayed()));
        onView(withText("Pisces")).check(matches(isDisplayed()));
    }

    @Test(expected = PerformException.class)
    public void itemWithText_doesNotExist() {
        reportHelper.label("itemWithText_doesNotExist");
        onView(ViewMatchers.withId(R.id.horo_recycler))
                .perform(RecyclerViewActions.scrollTo(
                        hasDescendant(withText("Aries1"))
                ));
    }

    @Test
    public void addToFavourite() {
        reportHelper.label("addToFavourite (index == 0)");
        int checkPos = 0;

        onView(withId(R.id.horo_recycler)).perform(
                RecyclerViewActions.actionOnItemAtPosition(checkPos, FavouriteButtonClickAction.clickChildViewWithId(R.id.iv_icon))).check(matches(new RedImageMatcher(checkPos)));
    }

    @After
    public void TearDown(){
        reportHelper.label("Stopping App");
    }
}