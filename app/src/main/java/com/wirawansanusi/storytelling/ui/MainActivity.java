package com.wirawansanusi.storytelling.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wirawansanusi.storytelling.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init EditText & Button
        final EditText titleEditText = (EditText)findViewById(R.id.titleEditText);
        Button titleButton = (Button)findViewById(R.id.titleButton);
        titleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get EditText value and put it in Intent for future use
                String name = titleEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, StoryActivity.class);
                intent.putExtra("name", name);

                // Start child activity
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // On resume we want to set EditText text value to blank
        EditText titleEditText = (EditText)findViewById(R.id.titleEditText);
        titleEditText.setText("");
    }
}
