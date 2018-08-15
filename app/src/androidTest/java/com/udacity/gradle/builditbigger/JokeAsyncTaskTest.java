package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;
import android.util.Log;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

@RunWith(AndroidJUnit4.class)
public class JokeAsyncTaskTest extends InstrumentationTestCase{
    private static final String TAG = JokeAsyncTaskTest.class.getSimpleName();

    public JokeAsyncTaskTest() { }

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void init(){
        mActivityTestRule.getActivity()
                .getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void asyncJokeTaskTest() {
        String jokeFetched = null;

        // declare instance of AsyncTask
        EndpointsAsyncTask task = new EndpointsAsyncTask();

        // get handle to the fragment created for this test
        final MainActivityFragment testFragment = (MainActivityFragment) mActivityTestRule.getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment);

        // execute asynctask
        task.execute(testFragment);

        // inspect results
        try {
            jokeFetched = task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // assertions to test if fetched joke is empty.
        assertNotNull(jokeFetched);
        assertTrue(!jokeFetched.isEmpty());

        // all assertions passed. Print out response to console.
        Log.d(TAG,"Test Passed. Fetched Joke: " + jokeFetched);

    }

}
