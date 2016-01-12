package com.github.joaogouveia.androidanimationspart2.fragment;

import android.animation.Animator;
import android.app.Fragment;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.github.joaogouveia.androidanimationspart2.R;
import com.github.joaogouveia.androidanimationspart2.util.SimpleAnimatorListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrameAnimation extends Fragment {

    @Bind(R.id.view)
    ImageView imageView;

    @Bind(R.id.view2)
    ImageView imageView2;

    private AnimationDrawable frameAnimation;
    private AnimationDrawable frameAnimation2;

    public static FrameAnimation newInstance() {
        FrameAnimation fragment = new FrameAnimation();
        return fragment;
    }

    public FrameAnimation() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frame_animation, container, false);
        ButterKnife.bind(this, view);
        frameAnimation = (AnimationDrawable) imageView.getBackground();
        frameAnimation2 = (AnimationDrawable) imageView2.getBackground();

        frameAnimation2.start();
        return view;
    }

    @OnClick(R.id.button)
    void run() {
        frameAnimation.setOneShot(true);
        frameAnimation.stop();
        frameAnimation.start();
    }


}
