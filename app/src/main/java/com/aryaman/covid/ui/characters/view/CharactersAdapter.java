package com.aryaman.covid.ui.characters.view;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aryaman.covid.R;
import com.aryaman.covid.data.models.Character;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.ViewHolder> {

    private List<Character> mCharacters;
    private Context mContext;

    public CharactersAdapter(Context context, List<Character> characters) {
        mCharacters = characters;
        mContext = context;
    }

    @Override
    public CharactersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View characterView = inflater.inflate(R.layout.item_character, parent, false);

        return new ViewHolder(characterView);
    }

    @Override
    public void onBindViewHolder(CharactersAdapter.ViewHolder viewHolder, int position) {
        Character character = mCharacters.get(position);

        TextView tvName = viewHolder.nameTextView;
        TextView tvGender = viewHolder.genderTextView;
        TextView tvHair = viewHolder.hairTextView;

        tvName.setText(character.getName());
        tvGender.setText(character.getGender());
        tvHair.setText(character.getHair_color());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mCharacters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_character_name)
        public TextView nameTextView;

        @BindView(R.id.tv_character_gender)
        public TextView genderTextView;

        @BindView(R.id.tv_character_hair)
        public TextView hairTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}