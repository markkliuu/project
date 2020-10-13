package au.edu.unsw.infs3634.covidtracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder>  implements Filterable {
    // careate variables for sort and filter methods
    public static final int SORT_METHOD_NEW = 1;
    public static final int SORT_METHOD_TOTAL = 2;
    private ArrayList<Country> mCountries;
    private ArrayList<Country> mCountriesFiltered;
    private RecyclerViewClickListener mListener;

    public CountryAdapter(ArrayList<Country> countries, RecyclerViewClickListener listener) {
        mCountries = countries;
        // add countries filtered arraylist
        mCountriesFiltered = countries;
        mListener = listener;
    }

    //override get filter method
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()) {
                    mCountriesFiltered = mCountries;
                } else {
                    ArrayList<Country> filteredList = new ArrayList<>();
                    for (Country country : mCountries) {
                        if (country.getCountry().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(country);
                        }
                    }
                    mCountriesFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mCountriesFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mCountriesFiltered = (ArrayList<Country>) results.values;
                notifyDataSetChanged();

            }
        };
    }



    public interface RecyclerViewClickListener{
        void onClick(View view, String countryCode);
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new CountryViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position){
        Country country = mCountries.get(position);
        DecimalFormat df = new DecimalFormat("#,###,###,###");
        holder.country.setText(country.getCountry());
        holder.totalCases.setText(df.format(country.getTotalConfirmed()));
        holder.newCases.setText("+" + df.format(country.getNewConfirmed()));
        holder.itemView.setTag(country.getCountryCode());
    }

    @Override
    public int getItemCount() {
        return mCountries.size();
    }


    public static class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView country, totalCases, newCases;
        private RecyclerViewClickListener listener;
        public CountryViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);
            country = itemView.findViewById(R.id.tvCountry);
            totalCases = itemView.findViewById(R.id.tvTotalCases);
            newCases = itemView.findViewById(R.id.tvNewCases);
        }
        @Override
        public void onClick(View v){
            listener.onClick(v, (String) v.getTag());}
    }

// implement a sort method that sorts the country list either by new cases or total cases
    public void sort(final int sortMethod){
        if (mCountriesFiltered.size()>0){
            Collections.sort(mCountriesFiltered, new Comparator<Country>(){
                @Override
                        public int compare (Country o1, Country o2){
                    if (sortMethod == SORT_METHOD_NEW) {
                        return o2.getNewConfirmed().compareTo(o1.getNewConfirmed());
                    }else if (sortMethod == SORT_METHOD_TOTAL){
                        return o2.getTotalConfirmed().compareTo(o1.getNewConfirmed());
                        }
                        return o2.getTotalConfirmed().compareTo(o1.getNewConfirmed());
                    }
                }); // update data list
            }notifyDataSetChanged();
    }
    }













