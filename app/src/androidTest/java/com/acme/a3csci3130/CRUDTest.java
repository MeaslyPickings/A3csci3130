package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;

/**
 * Created by Hugh on 2017-07-12.
 */

public class CRUDTest {


    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void createAndUpdateTest(){
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText("Old Boat Den"), closeSoftKeyboard());
        onView(withId(R.id.number)).perform(typeText("9024227878"), closeSoftKeyboard());
        onView(withId(R.id.type)).perform(typeText("Processor"), closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText("123 NewPort Rd."), closeSoftKeyboard());
        onView(withId(R.id.provTer)).perform(typeText("NS"), closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());
    }

    @Test
    public void updateTest(){
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0)
                .check(matches(isCompletelyDisplayed()));
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.name)).perform(replaceText("The Fog Horn"), closeSoftKeyboard());
        onView(withId(R.id.updateButton)).perform(click());
    }

    @Test
    public void deleteTest(){
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0)
                .check(matches(isCompletelyDisplayed()));
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
    }
}
