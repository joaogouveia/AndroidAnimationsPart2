package com.github.joaogouveia.androidanimationspart2.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.joaogouveia.androidanimationspart2.R;
import com.transitionseverywhere.AutoTransition;
import com.transitionseverywhere.TransitionManager;
import com.transitionseverywhere.TransitionSet;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TransitionAutoAPIFragment extends Fragment {

    @Bind(R.id.view)
    View view;

    @Bind(R.id.text)
    TextView text;


    public static TransitionAutoAPIFragment newInstance() {
        TransitionAutoAPIFragment fragment = new TransitionAutoAPIFragment();
        return fragment;
    }

    public TransitionAutoAPIFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_color, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    private int getRandomColor() {
        int R = (int) (Math.random() * 256);
        int G = (int) (Math.random() * 256);
        int B = (int) (Math.random() * 256);
        return Color.rgb(R, G, B); //random color, but can be bright or dull
    }

    @OnClick(R.id.button)
    void run() {
        TransitionManager.beginDelayedTransition((ViewGroup) text.getParent());
        if (view.getVisibility() == View.VISIBLE)
            view.setVisibility(View.GONE);
        else
            view.setVisibility(View.VISIBLE);
        int color = getRandomColor();
        view.setBackgroundColor(color);
        text.setTextColor(color);
    }


}
