package com.learninglanguage.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.learninglanguage.app.Adapters.LevelSliderAdapter;

public class HomeActivity extends AppCompatActivity {

    private ViewPager slideview;
    private LinearLayout slideNav;
    private LevelSliderAdapter adapter;
    private TextView[] mDots;

    public static String user;

    private Button previous, next;
    private int currentPage;

    private FirebaseAuth mAuth;
    private boolean doublePressExit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initComponets();

        adapter = new LevelSliderAdapter(this);
        slideview.setAdapter(adapter);
        dotsViewIndicator(0);

        slideview.addOnPageChangeListener(viewListner);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideview.setCurrentItem(currentPage - 1);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideview.setCurrentItem(currentPage + 1);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logout:
                mAuth.signOut();
                startActivity(new Intent(HomeActivity.this,SplashScreenActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void dotsViewIndicator(int position) {
        mDots = new TextView[3];
        slideNav.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            slideNav.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }

    }

    private void initComponets() {

        mAuth = FirebaseAuth.getInstance();

        slideview = findViewById(R.id.slideView);
        slideNav = findViewById(R.id.slideviewNavigation);
        previous = findViewById(R.id.prevButton);
        next = findViewById(R.id.nextButton);
    }

    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            dotsViewIndicator(position);
            currentPage = position;

            if (position == 0) {

                next.setEnabled(true);
                previous.setEnabled(false);
                previous.setText("");
                next.setText("Next");

            } else if (position == 1) {

                next.setEnabled(true);
                previous.setEnabled(true);
                next.setText("Next");
                previous.setText("Previous");

            } else {

                next.setEnabled(false);
                previous.setEnabled(true);
                next.setText("");
                previous.setText("Previous");

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            user = currentUser.getUid();
        } else {
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        }
    }

    @Override
    public void onBackPressed() {
        if (doublePressExit) {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
        doublePressExit = true;
        Toast.makeText(this, "Please Click BACK again to Exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doublePressExit = false;
            }
        }, 2000);
    }

}
