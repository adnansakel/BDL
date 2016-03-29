package com.example.adnansakel.bdl_food_app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Adnan Sakel on 3/29/2016.
 */
public class NewsFeedActivity extends Activity implements View.OnClickListener {
    LinearLayout llNewsFeed;
    View viewNewsFeed;
    LinearLayout llNewPost;
    View viewNewPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);
        initializeComponent();
    }

    private void initializeComponent(){
        llNewsFeed = (LinearLayout)findViewById(R.id.linear_layout_news_feed);
        llNewPost = (LinearLayout)findViewById(R.id.linear_layout_new_post);
        viewNewsFeed = (View)findViewById(R.id.view_news_feed);
        viewNewPost = (View)findViewById(R.id.view_new_post);

        llNewPost.setBackgroundColor(Color.parseColor("#00ffffff"));
        viewNewPost.setBackgroundResource(R.drawable.add_new_black);

        llNewsFeed.setBackgroundColor(Color.parseColor("#33ffffff"));
        viewNewsFeed.setBackgroundResource(R.drawable.home_white);


        llNewPost.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == llNewPost){
            startActivity(new Intent(NewsFeedActivity.this, NewPostActivity.class));
            this.finish();
        }
    }
}
