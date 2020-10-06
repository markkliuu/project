package au.edu.unsw.infs3634.covidtracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.<Adapter.CountryViewHolder> {
    private ArrayList<Country> mCountries;
    private RecyclerViewClickListner mListner;

    public CountryAdapter(ArrayList <country> countries, ){
        mCountries = countries;
        mListener = listener;
        }
}

    public interface RecyclerViewClickListener{
        void onClick(View view, String countryCode);
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, attachToRoot: false);
        RecyclerViewClickListener mListener;
        return new CountryViewHolder(v, mListener);

    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position){
        Country country = mCountries.get(position);
        DecimalFormat df = new DecimalFormat(pattern: "#,##,###");
        holder.country.setText(country.getCountry());
        holder.totalCases.setText(df.format(country.getTotalConfirmed()));
        holder.newCases.setText("+" + df.format(country.getNewConfirmed()));
        holder.itemView.setTag(Country.getCountryCode());
    }
    @Override
    public int getItemCount(){
        return mCountries.size();
    }


    public static class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView country, totalCases, newCases;
        private RecyclerViewClickListener listener;


        public CountryViewHolder(@NonNull View itemview, RecyclerViewClickListener listener){
            super(itemview);
            this.listener = listener;
            itemView.setOnClickListener(this);
            country = itemview.findViewById(R.id.tvCountry);
            totalCases = itemview.findViewById(R.id.tvTotalCases);
            newCases = itemview.findViewById(R.id.tvNewCases);
        }
        @Override
        public void onClick(View v){listener.onClick(v.(String) v.getTag())}

    }