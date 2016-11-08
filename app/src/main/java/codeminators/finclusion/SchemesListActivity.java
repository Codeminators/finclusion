package codeminators.finclusion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SchemesListActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schemes_list);

        // Initializing Toolbar and setting it as the actionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Schemes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        List<Scheme> schemes = new ArrayList<>();
        schemes.add(new Scheme("Pradhan Mantri Sukanya Samriddhi Yojana (PMSSY)",
                "Main Objective: Secure the future of girl child",
                "Eligibility :\n" +
                        "Aadhar card\n" +
                        "Birth certificate\n" +
                        "Minimum investment per year 1000/-\n" +
                        "Under the scheme, a saving account can be opened in the name of girl child and deposits can be made for 14 years. After the girl reach 18 years of age, she can withdraw 50% of the amount for marriage or higher study purposes.\n" +
                        "After the girl completes 21 years of age, the maturity amount can be withdrawn including the interest at rates decided by Government every year.\n" +
                        "The investments and returns are exempt from section 80C of Indian income tax act. The maximum investment of Rs. 1.5 Lakh per year can be made while minimum deposit is Rs. 1000/- per year.\n" +
                        "\n" +
                        "Official Website: http://www.nsiindia.gov.in"));

        schemes.add(new Scheme("Atal Pension Yojana (APY)",
                "Main Objective: Increase the number of people covered under any kind of pension scheme.",
                "Eligibility :\n" +
                        "Age of 18 to 40 years\n" +
                        "Savings account\n" +
                        "The scheme is especially targeted to the private unorganized sector and is open to all Indian citizens between the age of 18 to 40 years.\n" +
                        "Under the scheme, the beneficiary have to make contribution for at least 20 years before he/she can get pension after attaining age of 60 years. The scheme provides a monthly pension of Rs 1000 to Rs. 5000 per month based on the contribution amount.\n" +
                        "\n" +
                        "Official Website: http://www.jansuraksha.gov.in\n"));

        schemes.add(new Scheme("Skill India",
                "Main Objective: Train over 40 crore people in India in different skills by 2022.\n",
                "The main goal of Skill India Program is to create opportunities, space and scope for the development of talents of the Indian youth. The scheme also targeted to identify new sectors for skill development and develop more of those sectors which have already been put under skill development for the last so many years.\n\n" +
                        "Official Website: http://skillindia.gov.in\n"));

        schemes.add(new Scheme("Pradhan Mantri Awas Yojana (PMAY)\n",
                "Main Objective: Achieve housing for all by the year 2022, 2 crore in Urban and 3 Crore homes in Rural areas.\n",
                "Pradhan Mantri Awas Yojana is an ambitious scheme of Narendra Modi Government. Under the PMAY, the government aims to provide about 5 Crore affordable homes to the people belonging to EWS and LIG categories by the year 2022. There is a target of building 2 crore homes in urban area and 3 crore in rural areas across the country.\n" +
                        "\n" +
                        "Under the scheme, the government will provide financial assistance to the poor home buyers, interest subsidy on home loan and direct subsidy on homes bought under the scheme.\n" +
                        "\n" +
                        "Official Website: http://mhupa.gov.in\n"));

        schemes.add(new Scheme("Pradhan Mantri Garib Kalyan Yojanaye (PMGKY)\n",
                "Main Objective: Implement the pro-poor welfare schemes in more effective way and reaches out to more poor population across the country.",
                "Garib Kalyan Yojana is a Poverty Alleviation Scheme, which is primarily a work shop that you can pay and attend. The effort of the campaign and workshop is to motive and appraise the member of parliaments to help them effectively implement the government run schemes for the welfare of poor in the country.\n\n" +
                        "Official Website: http://niti.gov.in\n"));
        SchemeAdapter adapter = new SchemeAdapter(schemes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private class SchemeAdapter extends RecyclerView.Adapter<SchemeAdapter.ViewHolder> {
        private List<Scheme> mDataset;

        public SchemeAdapter(List<Scheme> myDataset) {
            mDataset = myDataset;
        }

        @Override
        public SchemeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.scheme_list_item, parent, false);
            // set the view's size, margins, paddings and layout parameters
            SchemeAdapter.ViewHolder vh = new SchemeAdapter.ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(SchemeAdapter.ViewHolder holder, int position) {

            holder.title.setText(mDataset.get(position).title);
            holder.obj.setText(mDataset.get(position).objective);
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case

            TextView title, obj;


            public ViewHolder(View v) {
                super(v);

                title = (TextView) v.findViewById(R.id.txt_title);
                obj = (TextView) v.findViewById(R.id.txt_obj);

                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(SchemesListActivity.this, SchemeDetailActivity.class);
                        intent.putExtra("detail", mDataset.get(getAdapterPosition()).desc);
                        intent.putExtra("title", mDataset.get(getAdapterPosition()).title);
                        startActivity(intent);
                    }
                });

            }
        }
    }

    private class Scheme {

        public String title, objective, desc;

        public Scheme(String title, String obj, String desc) {
            this.title = title;
            this.objective = obj;
            this.desc = desc;
        }
    }

}
