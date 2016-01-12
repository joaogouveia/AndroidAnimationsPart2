package com.github.joaogouveia.androidanimationspart2.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.joaogouveia.androidanimationspart2.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class TouchViewFeedbackFragment extends Fragment {


    public static TouchViewFeedbackFragment newInstance() {
        TouchViewFeedbackFragment fragment = new TouchViewFeedbackFragment();
        return fragment;
    }

    public TouchViewFeedbackFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_touch_view_feedback, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.layout1)
    void click1() {
    }

    @OnClick(R.id.layout2)
    void click2() {
    }
}
