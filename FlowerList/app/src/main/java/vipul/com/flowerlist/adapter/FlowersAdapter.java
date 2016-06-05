package vipul.com.flowerlist.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import vipul.com.flowerlist.R;
import vipul.com.flowerlist.model.Flower;

public class FlowersAdapter extends BaseAdapter {

    private final Context context;
    private final Flower[] flowers;
    private int mCount;

    public FlowersAdapter(Context context, Flower[] flowers) {
        this.context = context;
        this.flowers = flowers;
        this.mCount = flowers.length;
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public Object getItem(int position) {
        return flowers[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder")
        View view = LayoutInflater.from(context).
                inflate(R.layout.row_flower, null);
        final TextView flowerNameTextView = (TextView) view.findViewById(R.id.flowerName);
        final TextView flowerDescTextView = (TextView) view.findViewById(R.id.flowerDesc);
        final TextView flowerDetailDescTextView = (TextView) view.
                findViewById(R.id.flowerDetailDesc);
        final Button flowerDescButton = (Button) view.findViewById(R.id.showMoreButton);
        final RatingBar flowerRatings = (RatingBar) view.findViewById(R.id.flowerRatings);
        final ImageView flowerImage = (ImageView) view.findViewById(R.id.flowerImage);

        flowerDescButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flowerDetailDescTextView.getVisibility() == View.GONE) {
                    flowerDetailDescTextView.setVisibility(View.VISIBLE);
                    flowerDescButton.setText("Show Less");
                } else {
                    flowerDetailDescTextView.setVisibility(View.GONE);
                    flowerDescButton.setText("Show More");
                }
            }
        });

        Picasso.with(context)
                .load(flowers[position].url)
                .fit()
                .into(flowerImage);

        flowerNameTextView.setText(flowers[position].name);
        flowerDescTextView.setText(flowers[position].desc);
        flowerDetailDescTextView.setText(flowers[position].details);
        flowerRatings.setRating(flowers[position].rating);
        return view;
    }
}
