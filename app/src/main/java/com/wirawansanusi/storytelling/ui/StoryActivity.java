package com.wirawansanusi.storytelling.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wirawansanusi.storytelling.R;
import com.wirawansanusi.storytelling.model.Choice;
import com.wirawansanusi.storytelling.model.Page;
import com.wirawansanusi.storytelling.model.Story;


public class StoryActivity extends AppCompatActivity {

    private String mName;
    private Story mStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        // Get "name" String from Intent
        Intent intent = getIntent();
        mName = intent.getStringExtra("name");

        // If it's null we want to give a default value
        if( mName.length() < 1 ) {
            mName = "Friend";
        }

        // Init story & load first page
        mStory = new Story();
        loadPage(0);
    }

    protected void loadPage(int pageNumber) {

        Page page = mStory.getPage(pageNumber);

        // Set Image on ImageView
        ImageView storyImageView = (ImageView)findViewById(R.id.storyImageView);
        Drawable drawable;
        Context context = getApplicationContext();
        drawable = ResourcesCompat.getDrawable(getResources(), page.getPageImageId(), context.getTheme());
        storyImageView.setImageDrawable(drawable);

        // Set Text on TextView
        TextView storyTextView = (TextView)findViewById(R.id.storyTextView);
        String textFormat = String.format(page.getPageText(), mName);
        storyTextView.setText(textFormat);

        // Determine Page type
        if( page.isFinal != true ) {

            // Init button choice 1
            Button storyChoiceButton1 = (Button)findViewById(R.id.storyChoiceButton1);
            final Choice choice1 = page.getPageChoice1();
            storyChoiceButton1.setText(choice1.getChoiceText());
            storyChoiceButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    loadPage(choice1.getPageNumber());
                }
            });

            // init button choice 2
            Button storyChoiceButton2 = (Button)findViewById(R.id.storyChoiceButton2);
            final Choice choice2 = page.getPageChoice2();
            storyChoiceButton2.setText(choice2.getChoiceText());
            storyChoiceButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    loadPage(choice2.getPageNumber());
                }
            });

        } else {

            // Hide button choice 1
            Button storyChoiceButton1 = (Button)findViewById(R.id.storyChoiceButton1);
            storyChoiceButton1.setVisibility(View.INVISIBLE);

            // Init button choice 2
            Button storyChoiceButton2 = (Button)findViewById(R.id.storyChoiceButton2);
            storyChoiceButton2.setText("PLAY AGAIN");
            storyChoiceButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // Return to parent activity
                    finish();
                }
            });
        }
    }
}
