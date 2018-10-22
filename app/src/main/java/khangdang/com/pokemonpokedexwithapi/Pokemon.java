package khangdang.com.pokemonpokedexwithapi;

import com.google.gson.annotations.SerializedName;

public class Pokemon {
    @SerializedName("name")
    private String mPokemonName;

    @SerializedName("height")
    private Integer mHeight;

    @SerializedName("weight")
    private Integer mWeight;

    @SerializedName("stats")
    private Stats[] mStats;

    @SerializedName("types")
    private PokemonTypes[] mTypes;

    @SerializedName("sprites")
    private Sprites mSprites;

    public String getPokemonName() {
        return mPokemonName;
    }

    public Integer getHeight() {
        return mHeight;
    }

    public Integer getWeight() {
        return mWeight;
    }

    public Stats[] getStats() { return mStats; }

    public PokemonTypes[] getTypes() { return mTypes; }

    public Sprites getSprites() { return mSprites; }
}
