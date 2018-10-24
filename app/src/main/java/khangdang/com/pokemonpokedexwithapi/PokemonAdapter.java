package khangdang.com.pokemonpokedexwithapi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import khangdang.com.pokemonpokedexwithapi.networking.GetPokemonDataService;
import khangdang.com.pokemonpokedexwithapi.networking.PokemonClientService;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonHolder> {
    ViewGroup parent;
    private ArrayList<String> mPokemons;
    GetPokemonDataService service = PokemonClientService.getRetrofit().create(GetPokemonDataService.class);
    public PokemonAdapter(ArrayList<String> pokemons) {
        mPokemons = pokemons;
    }
    OkHttpClient client = new OkHttpClient();


    @Override
    public PokemonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View pokemonView = inflater.inflate(R.layout.list_item_pokemon, parent, false);
        this.parent = parent;

        PokemonHolder pokemonHolder = new PokemonHolder(pokemonView);

        return pokemonHolder;
    }

    @Override
    public void onBindViewHolder(PokemonAdapter.PokemonHolder pokemonHolder, int position) {
        final String pokemon = mPokemons.get(position);
        final TextView pokemonTitleTextView = pokemonHolder.pokemonTitleTextView;
        final ImageView pokemonImageView = pokemonHolder.pokemonImageView;

        Call<Pokemon> call = service.getPokemon(pokemon);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Log.d("onResonse", response.message());
                Pokemon p = response.body();

                Picasso picasso = new Picasso.Builder(parent.getContext())
                        .downloader(new OkHttp3Downloader(client))
                        .build();
                picasso.load(p.getSprites().getFront_default()).into(pokemonImageView);
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.d("onFailure", "failed");

            }
        });
        pokemonTitleTextView.setText(pokemon);


    }

    @Override
    public int getItemCount() {
        return mPokemons.size();
    }

    public class PokemonHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView pokemonTitleTextView;
        public ImageView pokemonImageView;

        public PokemonHolder(View itemView) {
            super(itemView);
            pokemonTitleTextView = (TextView)itemView.findViewById(R.id.pokemon_list_item_titleTextView);
            pokemonImageView = (ImageView) itemView.findViewById(R.id.pokemon_list_item_pokemonImage);
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
