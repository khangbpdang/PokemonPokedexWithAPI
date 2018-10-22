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
    TextView pokemonTypeTextView;
    TextView pokemonHWTextView;
    TextView pokemonHPTextView;
    TextView pokemonAttTextView;
    TextView pokemonDefTextView;
    TextView pokemonSpAttTextView;
    TextView pokemonSpDefTextView;
    TextView pokemonSpdTextView;
    String pokemonType = new String();

    GetPokemonDataService service = PokemonClientService.getRetrofit().create(GetPokemonDataService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        pokemonTitleTextView = (TextView) findViewById(R.id.pokemon_title);
        pokemonTypeTextView = (TextView) findViewById(R.id.pokemon_type);
        pokemonHWTextView = (TextView) findViewById(R.id.pokemon_hw);
        pokemonHPTextView = (TextView) findViewById(R.id.pokemon_HP);
        pokemonAttTextView = (TextView) findViewById(R.id.pokemon_Attack);
        pokemonDefTextView = (TextView) findViewById(R.id.pokemon_Defense);
        pokemonSpAttTextView = (TextView) findViewById(R.id.pokemon_SpAtt);
        pokemonSpDefTextView = (TextView) findViewById(R.id.pokemon_SpDef);
        pokemonSpdTextView = (TextView) findViewById(R.id.pokemon_Speed);
        final String pokemon = (String) getIntent().getStringExtra(PokemonActivity.EXTRA_POKEMON_ID);


        Call<Pokemon> call = service.getPokemon(pokemon);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Log.d("onResonse", response.message());
                Pokemon p = response.body();
                pokemonTitleTextView.setText(pokemon);
                pokemonType += p.getTypes()[0].getPokemonType().getName();
                for (int i = 1; i < p.getTypes().length; i++) {
                    pokemonType += " - " + p.getTypes()[i].getPokemonType().getName();
                }
                pokemonTypeTextView.setText("Type: " + pokemonType.toUpperCase());
                pokemonHWTextView.setText("Height: " + p.getHeight().doubleValue()/10 + " m\nWeight: " + p.getWeight().doubleValue()/10 + " kg");
                pokemonHPTextView.setText(p.getStats()[5].getStat().getName() + " : " + p.getStats()[5].getBase_stat());
                pokemonAttTextView.setText(p.getStats()[4].getStat().getName() + " : " + p.getStats()[4].getBase_stat());
                pokemonDefTextView.setText(p.getStats()[3].getStat().getName() + " : " + p.getStats()[3].getBase_stat());
                pokemonSpAttTextView.setText(p.getStats()[2].getStat().getName() + " : " + p.getStats()[2].getBase_stat());
                pokemonSpDefTextView.setText(p.getStats()[1].getStat().getName() + " : " + p.getStats()[1].getBase_stat());
                pokemonSpdTextView.setText(p.getStats()[0].getStat().getName() + " : " + p.getStats()[0].getBase_stat());

            }



            
            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.d("onFailure", "failed");
                Toast.makeText(getApplicationContext(), "failed to get info from api", Toast.LENGTH_LONG).show();
            }
        });


    }
}
