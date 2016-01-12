package com.github.joaogouveia.androidanimationspart2.fragment;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.github.joaogouveia.androidanimationspart2.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TransitionDrawableFragment extends Fragment {

    @Bind(R.id.view)
    ImageView imageView;
    private TransitionDrawable td;
    boolean inEnd = false;

    public static TransitionDrawableFragment newInstance() {
        TransitionDrawableFragment fragment = new TransitionDrawableFragment();
        return fragment;
    }

    public TransitionDrawableFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transition_drawable, container, false);
        ButterKnife.bind(this, view);

        td = new TransitionDrawable(new Drawable[]{
                getActivity().getResources().getDrawable(R.drawable.dog_blur),
                getActivity().getResources().getDrawable(R.drawable.dog)
        });
        imageView.setImageDrawable(td);
        return view;
    }

    @OnClick(R.id.button)
    void run() {
        if (!inEnd) {
            td.startTransition(800);
            inEnd = true;
        } else {
            td.reverseTransition(500);
            inEnd = false;
        }

    }


}
