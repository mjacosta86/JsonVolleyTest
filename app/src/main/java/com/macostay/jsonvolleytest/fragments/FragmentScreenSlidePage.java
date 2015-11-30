package com.macostay.jsonvolleytest.fragments;

/**
 * Created by macostay on 21/10/2015.
 */
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.macostay.jsonvolleytest.R;

public class FragmentScreenSlidePage extends Fragment {

    /**
     * Key to insert the background color into the mapping of a Bundle.
     */
    private static final String BACKGROUND_COLOR = "color";

    /**
     * Key to insert the index page into the mapping of a Bundle.
     */
    private static final String INDEX = "index";

    private static final String PERSON = "person";

    private int color;
    private int index;
    private static final String TAG = "FragmentScreenSlidePage";


    /**
     * Instances a new fragment with a background color and an index page.
     *
     * @param color
     *            background color
     * @param index
     *            index page
     * @return a new page
     */

    public static FragmentScreenSlidePage newInstance(int color, int index) {

        // Instantiate a new fragment
        FragmentScreenSlidePage fragment = new FragmentScreenSlidePage();
        Log.i(TAG, "Method newInstance");
        // Save the parameters
        Bundle bundle = new Bundle();
        bundle.putInt(BACKGROUND_COLOR, color);
        bundle.putInt(INDEX, index);
        fragment.setArguments(bundle);
        fragment.setRetainInstance(true);

        return fragment;

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "Method onCreate");
        // Load parameters when the initial creation of the fragment is done
        this.color = (getArguments() != null) ? getArguments().getInt(BACKGROUND_COLOR) : Color.GRAY;
        this.index = (getArguments() != null) ? getArguments().getInt(INDEX): -1;


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        Log.i(TAG, "Method onCreateView");
        // Show the current page index in the view
        TextView tvIndex = (TextView) rootView.findViewById(R.id.tvIndex);
        tvIndex.setText(String.valueOf(this.index));

        // Change the background color
        rootView.setBackgroundColor(this.color);

        return rootView;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "Method onAttach");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "Method onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "Method onResume");
    }

    @Override
    public void onPause() {
        Log.i(TAG, "Method onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG, "Method onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "Method onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, "Method onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, "Method onDetach");
        super.onDetach();
    }

}
