package com.github.joaogouveia.androidanimationspart2.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;


import com.github.joaogouveia.androidanimationspart2.R;
import com.github.joaogouveia.androidanimationspart2.fragment.TouchButtonFeedbackFragment;
import com.github.joaogouveia.androidanimationspart2.fragment.ColorFragment;
import com.github.joaogouveia.androidanimationspart2.fragment.TransitionAutoAPIFragment;
import com.github.joaogouveia.androidanimationspart2.fragment.TransitionDrawableFragment;
import com.github.joaogouveia.androidanimationspart2.fragment.TouchViewFeedbackFragment;
import com.github.joaogouveia.androidanimationspart2.fragment.FrameAnimation;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.navigation_view)
    NavigationView navigationView;
    @Bind(R.id.drawer)
    DrawerLayout drawerLayout;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);
        initToolbar();
        initNavigationView();
        initDrawer();
        navigationView.setCheckedItem(R.id.touch_button);
        setFragment(TouchButtonFeedbackFragment.newInstance());
    }

    private void initDrawer() {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void initNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.touch_button:
                        setFragment(TouchButtonFeedbackFragment.newInstance());
                        toolbar.setTitle("Touch Button Feedback");
                        return true;
                    case R.id.touch_view:
                        setFragment(TouchViewFeedbackFragment.newInstance());
                        toolbar.setTitle("Touch View Feedback");
                        return true;
                    case R.id.frame_animation:
                        setFragment(FrameAnimation.newInstance());
                        toolbar.setTitle("Frame Animation");
                        return true;
                    case R.id.transition_drawable:
                        setFragment(TransitionDrawableFragment.newInstance());
                        toolbar.setTitle("Transition Drawable");
                        return true;
                    case R.id.color:
                        setFragment(ColorFragment.newInstance());
                        toolbar.setTitle("Color");
                        return true;
                    case R.id.text_change:
                        setFragment(TransitionAutoAPIFragment.newInstance());
                        toolbar.setTitle(getResources().getString(R.string.transition_api_auto));
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

}
