package codeminators.finclusion;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class SchemesActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private SurveyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schemes);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Scheme Survey");

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // specify an adapter (see also next example)
        ArrayList<String> myDataset = new ArrayList<>();
        myDataset.add("Daughter under 10 years?");
        myDataset.add("Woman in the household?");
        myDataset.add("LPG connection?");
        myDataset.add("Job?");
        myDataset.add("Annual income below poverty line?");
        mAdapter = new SurveyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_show_schemes);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SchemesActivity.this, SchemesListActivity.class));
            }
        });
    }
}
