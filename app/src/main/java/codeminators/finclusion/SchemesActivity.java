package codeminators.finclusion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

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
        myDataset.add("Employed?");
        myDataset.add("Annual income?");
        mAdapter = new SurveyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
}
