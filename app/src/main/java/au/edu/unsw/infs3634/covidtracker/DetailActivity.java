package au.edu.unsw.infs3634.covidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

import java.util.ArrayList;


public class DetailActivity extends AppCompatActivity {
    public static final String INTENT_MESSAGE = "au.edu.unsw.infs3634.covidtracker.intent_message";

    private TextView mCountry;
    private TextView mNewcases;
    private TextView mNewDeath;
    private TextView mTotalDeath;
    private TextView mNewRecovered;
    private TextView mTotalRecovered;
    private TextView mSearch;
    private TextView mTotalcases;


    Intent intent = getIntent();
    String countryCode = intent.getStringExtra(INTENT_MESSAGE);
    private Object Intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

// initialise variables
        mCountry = findViewById(R.id.tvCountry);
        mNewcases = findViewById(R.id.tvNewCases);
        mNewRecovered = findViewById(R.id.tvNewRecovered);
        mNewDeath = findViewById(R.id.tvNewDeath);
        mSearch = findViewById(R.id.tvSearch);
        mTotalRecovered = findViewById(R.id.tvTotalRecovered);
        mTotalDeath = findViewById(R.id.tvTotalDeath);
        mTotalcases = findViewById(R.id.tvTotalCases);

    Intent intent = getIntent();
    String countryCode = intent.getStringExtra(INTENT_MESSAGE);


    // detailMessage.setText(intent.getStringExtra(INTENT_MESSAGE));


    ArrayList<Country> countries = Country.getCountries();
    for(final Country country : countries){
        if (country.getCountryCode().equals(countryCode))
        // update the textviews with the data of the country
        setTitle(country.getCountryCode());
        mCountry.setText(country.getCountry());
        mNewcases.setText(String.valueOf(country.getNewConfirmed()));
        mNewDeath.setText(String.valueOf(country.getNewDeaths()));
        mTotalDeath.setText(String.valueOf(country.getTotalDeaths()));
        mTotalRecovered.setText(String.valueOf(country.getTotalRecovered()));
        mNewRecovered.setText(String.valueOf(country.getNewRecovered()));
        mTotalcases.setText(String.valueOf(country.getTotalConfirmed()));

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchCountry(country.getCountry());
            }
        });

    }
    }



    private void searchCountry(String country) {
        Intent intent = new Intent(ACTION_VIEW, Uri.parse("http://google.com/search?q=covid " + country));
        startActivity(intent);
    }
}












