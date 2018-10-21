package khangdang.com.pokemonpokedexwithapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonHolder> {

    private ArrayList<String> mPokemons;

    public PokemonAdapter(ArrayList<String> pokemons) {
        mPokemons = pokemons;
    }


    @Override
    public PokemonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View pokemonView = inflater.inflate(R.layout.list_item_pokemon, parent, false);

        PokemonHolder pokemonHolder = new PokemonHolder(pokemonView);

        return pokemonHolder;
    }

    @Override
    public void onBindViewHolder(PokemonAdapter.PokemonHolder pokemonHolder, int position) {
        String pokemon = mPokemons.get(position);

        TextView pokemonTitleTextView = pokemonHolder.pokemonTitleTextView;
        pokemonTitleTextView.setText(pokemon);


    }

    @Override
    public int getItemCount() {
        return mPokemons.size();
    }

    public class PokemonHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView pokemonTitleTextView;


        public PokemonHolder(View itemView) {
            super(itemView);
            pokemonTitleTextView = (TextView)itemView.findViewById(R.id.pokemon_list_item_titleTextView);
            itemView.setOnClickListener(this);
        }



        @Override
        public void onClick(View v) {
            String pokemon = mPokemons.get(getLayoutPosition());
            Intent intent = new Intent(itemView.getContext(), PokemonDetail.class);
            intent.putExtra(PokemonActivity.EXTRA_POKEMON_ID, pokemon);
            itemView.getContext().startActivity(intent);
        }

    }
}
