package khangdang.com.pokemonpokedexwithapi.networking;

import khangdang.com.pokemonpokedexwithapi.Pokemon;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonClientService {

    private static Retrofit retrofit = null;
    public static Retrofit getRetrofit (){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        }
        return retrofit;
    }

    //PokemonClientService service = retrofit.create(PokemonClientService.class);


}
