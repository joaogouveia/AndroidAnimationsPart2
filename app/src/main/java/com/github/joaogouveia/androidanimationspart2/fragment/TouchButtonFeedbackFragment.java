package com.github.joaogouveia.androidanimationspart2.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.joaogouveia.androidanimationspart2.R;

import butterknife.ButterKnife;

public class TouchButtonFeedbackFragment extends Fragment {


    public static TouchButtonFeedbackFragment newInstance() {
        TouchButtonFeedbackFragment fragment = new TouchButtonFeedbackFragment();
        return fragment;
    }

    public TouchButtonFeedbackFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_touch_button_feedback, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


}
