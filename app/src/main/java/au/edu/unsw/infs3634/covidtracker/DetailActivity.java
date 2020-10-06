package au.edu.unsw.infs3634.covidtracker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    public static final String INTENT_MESSAGE = "au.edu.unsw.infs36634.covidtracker.intent_message";


    //wk4
    // create variables holds the data
    private TextView mCountry;
    private TextView mNewCases;
    private TextView mTotalCases;
    private TextView mNewDeath;
    private TextView mTotalDeath;
    private TextView mNewRecovered;
    private TextView mTotalRecovered;
    private ImageView mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // initialise variables
        mCountry = findViewById(R.id.tvCountry);
        mNewCases = findViewById(R.id.tvNewCases);
        mTotalCases = findViewById(R.id.tvTotalCases);
        mNewRecovered = findViewById(R.id.tvNewRecovered);
        mTotalRecovered = findViewById(R.id.tvTotalRecovered);
        mNewDeath = findViewById(R.id.tvNewDeath);
        mTotalDeath = findViewById(R.id.tvTotalDeath);
        mSearch = findViewById(R.id.ivSearch);

        // read extra message from explicit intent
        Intent intent = getIntent();
        String countryCode = intent.getStringExtra(INTENT_MESSAGE);
        ImageView tv = findViewById(R.id.ivSearch);



        // create the correct country object using your search method
        ArrayList<Country> countries = Country.getCountries();
        for (final Country country : countries) {
            if (country.getCountryCode().equals(countryCode)) {
                // update the TextViews with the data of the country object
                setTitle(country.getCountryCode());
                mCountry.setText(country.getCountry());
                mNewCases.setText(String.valueOf(country.getNewConfirmed()));
                mTotalCases.setText(String.valueOf(country.getTotalConfirmed()));
                mTotalDeath.setText(String.valueOf(country.getTotalDeaths()));
                mNewDeath.setText(String.valueOf(country.getNewDeaths()));
                mNewRecovered.setText(String.valueOf(country.getNewRecovered()));
                mTotalRecovered.setText(String.valueOf(country.getTotalRecovered()));

                // make a search icon/button google for "covid + country name"
                mSearch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        searchCountry(country.getCountry());
                    }
                });
            }
        }
    }

    private void searchCountry(String country){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com/search?q=covid " + country));
        startActivity(intent);
    }
    //wk4


    /*
    // wk3

    // create variables holds the data
    private TextView mCountry;
    private TextView mNewCases;
    private TextView mTotalCases;
    private TextView mNewDeath;
    private TextView mTotalDeath;
    private TextView mNewRecovered;
    private TextView mTotalRecovered;
    private ImageView mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // initialise variables
        mCountry = findViewById(R.id.tvCountry);
        mNewCases = findViewById(R.id.tvNewCases);
        mTotalCases = findViewById(R.id.tvTotalCases);
        mNewRecovered = findViewById(R.id.tvNewRecovered);
        mTotalRecovered = findViewById(R.id.tvTotalRecovered);
        mNewDeath = findViewById(R.id.tvNewDeath);
        mTotalDeath = findViewById(R.id.tvTotalDeath);
        mSearch = findViewById(R.id.ivSearch);

        // read extra message from explicit intent
        Intent intent = getIntent();
        String countryCode = intent.getStringExtra(INTENT_MESSAGE);
        ImageView iv = findViewById(R.id.ivSearch);


        // create the correct country object using your search method
        ArrayList<Country> countries = Country.getCountries();
        for (final Country country : countries) {
            if (country.getCountryCode().equals(countryCode)) {
                // update the TextViews with the data of the country object
                setTitle(country.getCountryCode());
                mCountry.setText(country.getCountry());
                mNewCases.setText(String.valueOf(country.getNewConfirmed()));
                mTotalCases.setText(String.valueOf(country.getTotalConfirmed()));
                mTotalDeath.setText(String.valueOf(country.getTotalDeaths()));
                mNewDeath.setText(String.valueOf(country.getNewDeaths()));
                mNewRecovered.setText(String.valueOf(country.getNewRecovered()));
                mTotalRecovered.setText(String.valueOf(country.getTotalRecovered()));

                // make a search icon/button google for "covid + country name"
                mSearch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        searchCountry(country.getCountry());
                    }
                });
            }
        }
    }

    private void searchCountry(String country){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com/search?q=covid " + country));
        startActivity(intent);
    }

    // wk3 end
    */


    /*
    // wk2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        if (intent.hasExtra(INTENT_MESSAGE)) {
            TextView detailMessage = findViewById(R.id.tvDetailMessage);
            detailMessage.setText(intent.getStringExtra(INTENT_MESSAGE));
        }

        // define button
        Button b = findViewById(R.id.btShowVideo);

        // link button with intent
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailActivity.this.showVideo("https://www.google.com");
            }
        });

    }

    private void showVideo (String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
    // wk2 end */

}