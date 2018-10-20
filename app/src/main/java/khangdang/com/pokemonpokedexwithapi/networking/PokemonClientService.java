package khangdang.com.pokemonpokedexwithapi.networking;

import khangdang.com.pokemonpokedexwithapi.Pokemon;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonClientService implements GetPokemonDataService {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://pokeapi.co")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    PokemonClientService service = retrofit.create(PokemonClientService.class);

    @Override
    public Call<Pokemon> getPokemon(String name) {
        return null;
    }
}
