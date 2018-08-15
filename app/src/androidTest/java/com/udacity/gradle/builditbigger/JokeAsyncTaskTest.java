package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;
import android.test.AndroidTestCase;
import android.test.ApplicationTestCase;
import android.test.InstrumentationTestCase;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertNotNull;


//@RunWith(AndroidJUnit4.class)
//public class JokeAsyncTaskTest extends AndroidTestCase {
//
//    @Test
//    public void testDoInBackground() throws Exception {
//
//        String result = null;
//        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
//        endpointsAsyncTask.execute();
//        try {
//            result = endpointsAsyncTask.get();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        assertNotNull(result);
//    }
//}

//public class JokeAsyncTaskTest extends InstrumentationTestCase {
//    private final CountDownLatch signal = new CountDownLatch(1);
//
//    public JokeAsyncTaskTest(){}
//
//    public final void testAsync() throws Throwable {
//
//        final EndpointsAsyncTask asynctask = new EndpointsAsyncTask() {
//            @Override
//            protected String doInBackground(MainActivityFragment... params) {
//                return super.doInBackground(params);
//            }
//
//            @Override
//            protected void onPostExecute(String result) {
//                assertNotNull(result);
//                Log.d("ASTEST", "Retrieved a non-empty string successfully: " + result);
//                signal.countDown();
//            }
//        };
//
////        asynctask.isTesting = true;
//
//        runTestOnUiThread(new Runnable() {
//
//            @Override
//            public void run() {
//                asynctask.execute();
//
//            }
//
//        });
//        signal.await(30, TimeUnit.SECONDS);
//    }
//}

@RunWith(AndroidJUnit4.class)
public class JokeAsyncTaskTest extends InstrumentationTestCase{
    private static final String TAG = EndpointsAsyncTask.class.getSimpleName();

    private final CountDownLatch signal = new CountDownLatch(1);

    public JokeAsyncTaskTest() { }
    @Test
    public void asyncJokeTaskTest() {

        // Add functional connected test to test that the Async task successfully retrieves a non-empty string
        String result = null;
        final EndpointsAsyncTask asyncJokeTest = new EndpointsAsyncTask();

//        final MainActivity testActivity = new MainActivity();
//        final MainActivityFragment testFragment = (MainActivityFragment) testActivity.getSupportFragmentManager().findFragmentById(R.id.fragment);

        final MainActivityFragment testFragment = new MainActivityFragment();

        // start async-task, results will be updated in testFragment
//        asyncJokeTest.execute(testFragment);
        try {
            runTestOnUiThread(new Runnable() {

                @Override
                public void run() {
                    signal.countDown();
                    assertNotNull(testFragment);
                    asyncJokeTest.execute(testFragment);
                }

            });

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        // try testing after t secs.
        try {
//            Context mContext = testFragment.getActivity();
            signal.await(2, TimeUnit.SECONDS);
            result = testFragment.joke2display;
//            assertNotNull(result);
//            result = asyncJokeTest.get();
            Log.d("Test", "Retrieved a non-empty string successfully: " + result);
//            if (result.length()>0) {
//                Log.d("Test", "Retrieved a non-empty string successfully: " + result);
//            } else {
//                Log.d("Test", "Retrieved an empty string! ");
////                throw new Exception("empty string");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


// ref: http://marksunghunpark.blogspot.com/2015/05/how-to-test-asynctask-in-android.html
//@RunWith(AndroidJUnit4.class)
//public class JokeAsyncTaskTest extends ApplicationTestCase<Application> {
//
//    private static final String JOKE_TYPE = "technology";
//    private static final String ALERT_JOKE_NULL = "Joke fetched is null";
//    private static final String ALERT_JOKE_EMPTY = "Joke fetched is empty";
//    private static final String ERROR_FETCHING_JOKE = "There was an error fetching the joke!";
//
//    private CountDownLatch mSignal;
//
//    /**
//     * Default constructor
//     */
//    public JokeAsyncTaskTest() {
//        super(Application.class);
//    }
//
//    @Override
//    protected void setUp() throws Exception {
//        super.setUp();
//
//        // signal to indicate when task is completed
//        mSignal = new CountDownLatch(1);
//    }
//
//    @Override
//    protected void tearDown() throws Exception {
//        super.tearDown();
//        mSignal.countDown();
//    }
//
//    @SuppressWarnings("unchecked")
//    @Test
//    public void testJokeIsFetced() throws Throwable {
//        String jokeFetched;
//
//        EndpointsAsyncTask task = new EndpointsAsyncTask();
//
//        try {
//            task.execute(new MainActivityFragment());
//            jokeFetched = task.get();
//            assertNotNull(ALERT_JOKE_NULL, jokeFetched);
//            assertTrue(ALERT_JOKE_EMPTY, !jokeFetched.isEmpty());
//        } catch (InterruptedException ie) {
//            fail(ERROR_FETCHING_JOKE);
//        }
//    }
//}