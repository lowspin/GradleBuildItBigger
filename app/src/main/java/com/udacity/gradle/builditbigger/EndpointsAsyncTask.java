package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

class EndpointsAsyncTask extends AsyncTask<MainActivityFragment, Void, String> {

    private static final String TAG = EndpointsAsyncTask.class.getSimpleName();

    // https://stackoverflow.com/questions/1720346/how-to-get-the-android-emulators-ip-address
    private static final String LOCALHOST_IP_ADDRESS = "http://10.0.2.2:8080/_ah/api/";

    private static MyApi jokesApi = null;
    private MainActivityFragment mFragment;

    @Override
    protected String doInBackground(MainActivityFragment... params) {

        if (jokesApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(LOCALHOST_IP_ADDRESS)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            jokesApi = builder.build();
        }

        // get the fragment handle
        mFragment = params[0];

        // AsyncTask to fetch joke from GCE using API
        try {
            return jokesApi.getJoke().execute().getData();
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
            //return e.getMessage();
            // instead of error message, Return an empty string or null if an exception occurs
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        mFragment.joke2display = result;
        mFragment.progressBar.setVisibility(View.GONE);

        mFragment.displayJoke();
    }
}
