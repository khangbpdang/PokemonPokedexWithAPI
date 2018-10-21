package khangdang.com.pokemonpokedexwithapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import khangdang.com.pokemonpokedexwithapi.networking.GetPokemonDataService;
import khangdang.com.pokemonpokedexwithapi.networking.PokemonClientService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonDetail extends AppCompatActivity {

    TextView pokemonTitleTextView;
    TextView pokemonHWTextView;
    GetPokemonDataService service = PokemonClientService.getRetrofit().create(GetPokemonDataService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        pokemonTitleTextView = (TextView)findViewById(R.id.pokemon_title);
        pokemonHWTextView = (TextView) findViewById(R.id.pokemonhw);
        final String pokemon = (String) getIntent().getStringExtra(PokemonActivity.EXTRA_POKEMON_ID);


        Call<Pokemon> call = service.getPokemon(pokemon);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Log.d("onResonse", response.message());
                Pokemon p = response.body();
                pokemonTitleTextView.setText(pokemon);
                pokemonHWTextView.setText(p.getHeight());

            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.d("onFailure", "failed");
                Toast.makeText(getApplicationContext(), "failed to get info from api", Toast.LENGTH_LONG).show();
            }
        });


    }
}
