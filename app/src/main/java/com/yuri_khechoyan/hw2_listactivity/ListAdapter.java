package com.yuri_khechoyan.hw2_listactivity;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//Created by Yuri Khechoyan on 2/5/2017.


public class ListAdapter extends ArrayAdapter{

    private Activity context_;
    private String[] Stocks_;
    private String[] Stock_logo_ids_;

    //ListAdapter Constructor
    public ListAdapter(Activity context, String[] Stock_logo_ids, String[] Stocks){
        //calls ArrayAdapter Constructor
		super(context, R.layout.row, Stocks);

        //Initializes context variable
		context_ = context;        //initialize private member variable
        //Initializes Stocks variable
		this.Stocks_ = Stocks;
		//Initializes Stock_id_logo variable
        this.Stock_logo_ids_ = Stock_logo_ids;
    }

    //For each row given, row is Inflated from row.xml file
    public View getView(int placeInArray, View convertView, ViewGroup parent){
        if(convertView == null) {
            LayoutInflater inflater = context_.getLayoutInflater();
            convertView = inflater.inflate(R.layout.row, null);
        }

        //Creates view holder object for the rows - limit need for findViewById()
        ViewHolder holder = (ViewHolder) convertView.getTag();

        //Create new object for row if row does not have a view holder
        if(holder == null) {
            holder = new ViewHolder(convertView);
            //Makes sure that tv_link for holder is set to the location in the Array
            holder.tv_link.setText(Stocks_[placeInArray]);
            //Connect the Stock_id_logo element in the array to the respective logo
            int id = context_.getResources().getIdentifier(Stock_logo_ids_[placeInArray],
                    "drawable", context_.getPackageName());
            holder.imageView.setImageResource(id);

            convertView.setTag(holder);
        }
        else{
            //Re-use the view holder if it exists
            holder.tv_link.setText(Stocks_[placeInArray]);

            int id = context_.getResources().getIdentifier(Stock_logo_ids_[placeInArray],
                    "drawable", context_.getPackageName());
            holder.imageView.setImageResource(id);
        }
        //return the row's view object.
        return convertView;
    }

    //ViewHolder class holds the company names, logos, & hyperlinks
    private class ViewHolder{
        TextView tv_link;
        ImageView imageView;

        public ViewHolder(View row){
            tv_link = (TextView) row.findViewById(R.id.tv_link);
            imageView = (ImageView) row.findViewById(R.id.company_logo);
        }
    }
}

