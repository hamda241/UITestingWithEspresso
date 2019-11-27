package com.example.logintest;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.graphics.ColorSpace.match;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule= new ActivityTestRule<>(
            MainActivity.class);


    @Before
    public void setUP()
    {
        activityRule.getActivity();
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.logintest", appContext.getPackageName());
    }

    //Errornot initially visible
    @Test
    public void ErrorNotVisible()
    {
        onView(withId(R.id.errorMessage)).check(matches(not(isDisplayed())));
    }

    //shortPassword
    @Test
    public void testPasswordLength()
    {
        onView(withId(R.id.edtPassword)).perform(typeText("abc"));
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withId(R.id.errorMessage)).check(matches(isDisplayed()))
         .check(matches(withText("Try a longer Password")));
    }

    //Error Messgae doesnot show on valid password
    @Test
    public void validPasswordDoesnotDisplayErrorMessgae()
    {
        onView(withId(R.id.edtPassword)).perform(typeText("a long valid password like 1234567"));
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withId(R.id.errorMessage)).check(matches(not(isDisplayed())));
    }

}
