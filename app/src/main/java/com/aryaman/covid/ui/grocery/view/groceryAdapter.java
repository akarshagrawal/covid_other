package com.aryaman.covid.ui.grocery.view;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aryaman.covid.R;
import com.aryaman.covid.data.models.Starship;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class groceryAdapter extends RecyclerView.Adapter<groceryAdapter.ViewHolder> {

    private List<Starship> mgrocery;
    private Context mContext;

    public groceryAdapter(Context context, List<Starship> grocery) {
        mgrocery = grocery;
        mContext = context;
    }

    @Override
    public groceryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View starshipView = inflater.inflate(R.layout.item_starship, parent, false);

        return new ViewHolder(starshipView);
    }

    @Override
    public void onBindViewHolder(groceryAdapter.ViewHolder viewHolder, int position) {
        Starship starship = mgrocery.get(position);

        TextView tvName = viewHolder.nameTextView;
        TextView tvModel = viewHolder.modelTextView;
        TextView tvHyper = viewHolder.hyperdriveTextView;

        tvName.setText(starship.getName());
        tvModel.setText(starship.getModel());
        tvHyper.setText(starship.getHyperdrive_rating());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mgrocery.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_starship_name)
        public TextView nameTextView;

        @BindView(R.id.tv_starship_model)
        public TextView modelTextView;

        @BindView(R.id.tv_starship_hyperdrive_rating)
        public TextView hyperdriveTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}