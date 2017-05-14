package com.example.pengi.robudget.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pengi.robudget.Entities.Transactions;
import com.example.pengi.robudget.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Pengi on 13/05/2017.
 */

public class TransactionAdapter  extends ArrayAdapter<Transactions> {

    private LayoutInflater mInflater;
    private int mResource;

    public TransactionAdapter (Context context, int resource, List<Transactions> list) {
        super(context,resource, list);
        mResource = resource;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView (int pos, View convertView, ViewGroup parent) {
        View view = convertView == null ? mInflater.inflate( mResource, parent, false ) : convertView;

        TextView category = (TextView) view.findViewById( R.id.transaction_title );
        TextView amount = (TextView) view.findViewById( R.id.transaction_amount);
        TextView date = (TextView) view.findViewById( R.id.transaction_date);
        Transactions transaction = getItem( pos);

        //Formats date
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date d = transaction.getDate();

        category.setText( transaction.getCategory() );
        amount.setText(Double.toString(transaction.getAmount()));
        date.setText(df.format(d));


        return view;
    }
}
