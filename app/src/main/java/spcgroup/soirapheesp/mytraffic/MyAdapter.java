package spcgroup.soirapheesp.mytraffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static spcgroup.soirapheesp.mytraffic.R.id.imageView;

/**
 * Created by soiraphee.sp on 6/12/2558.
 */
public class MyAdapter extends BaseAdapter {
    //Explicit
    private Context objContext;
    private String[] titleStrings, detailStrings;
    private int[] iconInts;

    public MyAdapter(Context objContext, String[] titleStrings, String[] detailStrings, int[] iconInts) {
        this.objContext = objContext;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
        this.iconInts = iconInts;
    }   //Constructor

    @Override
    public int getCount() {

        return titleStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Open Service
        LayoutInflater objInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = objInflater.inflate(R.layout.my_listview, parent, false);

        //Setup TextView

        TextView titleTextView = (TextView)view.findViewById(R.id.textView2);
        titleTextView.setText(titleStrings[position]);

        TextView detailTextView = (TextView)view.findViewById(R.id.textView3);
        detailTextView.setText(detailStrings[position]);

        ImageView iconImageView = (ImageView) view.findViewById(R.id.imageView);
        iconImageView.setImageResource(iconInts[position]);

        return view;
    }
}   //main class
