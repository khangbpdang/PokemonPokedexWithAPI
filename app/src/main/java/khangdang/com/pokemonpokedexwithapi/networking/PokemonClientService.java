package khangdang.com.pokemonpokedexwithapi.networking;

import retrofit2.Retrofit;

public class PokemonClientService {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://pokeapi.co")
            .build();

    PokemonClientService service = retrofit.create(PokemonClientService.class);
}
