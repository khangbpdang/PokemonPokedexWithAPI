package khangdang.com.pokemonpokedexwithapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class PokemonActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<String> mPokemons = new ArrayList<String>();
    public static final String EXTRA_POKEMON_ID = "com.khangdang.pokemonpokedexwithapi.pokemon_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
        mRecyclerView = (RecyclerView) findViewById(R.id.pokemon_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(PokemonActivity.this));

        pokemonInitializer();
    }
    private void pokemonInitializer() {
        mPokemons.add("bulbasaur");
        mPokemons.add("charmander");
        mPokemons.add("squirtle");
        mPokemons.add("pikachu");
        mPokemons.add("groudon");
        mPokemons.add("kyogre");
        mPokemons.add("rayquaza");
        mPokemons.add("ho-oh");
        mPokemons.add("lugia");
        mPokemons.add("lapras");
        mPokemons.add("ditto");
        mPokemons.add("eevee");
        mPokemons.add("spiritomb");
        PokemonAdapter pokemonAdapter = new PokemonAdapter(mPokemons);
        mRecyclerView.setAdapter(pokemonAdapter);

    }
}
