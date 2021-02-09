package com.example.storytale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //get the list of stories titles and contents in string array

        String[] titles = getResources().getStringArray(R.array.stories_title);
        String[] contents = getResources().getStringArray(R.array.story_content);

       recyclerView = findViewById(R.id.storiesListsView);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
       adapter = new Adapter(this, titles, contents); //our adapter takes 2 string array
       recyclerView.setAdapter(adapter);

    }
}
