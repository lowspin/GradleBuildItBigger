package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.teachableapps.gradlebuilditbigger.javajokes.Joker;
import com.teachableapps.gradlebuilditbigger.jokeshow.JokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public String joke2display = null;
    ProgressBar progressBar = null;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        progressBar = root.findViewById(R.id.progressbar_joke);

        // Set onClickListener for the button
        Button button = root.findViewById(R.id.btn_joke);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                tellJoke();
            }
        });

        progressBar.setVisibility(View.GONE);

        return root;
    }

    public void tellJoke() {
        // Step 2: local Android Library
//        displayJoke();
        // Step 3: Google Cloud Endpoints
        new EndpointsAsyncTask().execute(this);
    }

    public void displayJoke() {
        Joker myJoker = new Joker();
        // Step 1: show joke locally
//        String joke2display = myJoker.getJoke();
//        Toast.makeText(this, joke2display, Toast.LENGTH_SHORT).show();

        joke2display = myJoker.getJoke();

        Intent intent = new Intent(getActivity(), JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_KEY, joke2display);
        startActivity(intent);
    }
}
