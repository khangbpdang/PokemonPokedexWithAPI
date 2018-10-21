package khangdang.com.pokemonpokedexwithapi;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class Pokemon {
    @SerializedName("name")
    private String mPokemonName;




    @SerializedName("height")
    private String mHeight;

    @SerializedName("weight")
    private String mWeight;

    //@SerializedName("type")
    //private String mCategory;


    @SerializedName("stats")
    private Stats mStats;
    //private String stats;

    public Pokemon(String name, String height, String weight ) {

        setPokemonName(name);
        setHeight(height);
        setWeight(weight);
      
    }



    public String getPokemonName() {
        return mPokemonName;
    }

    public void setPokemonName(String mPokemonName) {
        this.mPokemonName = mPokemonName;
    }


    public String getHeight() {
        return mHeight;
    }

    public void setHeight(String mHeight) {
        this.mHeight = mHeight;
    }

    public String getWeight() {
        return mWeight;
    }

    public void setWeight(String mWeight) {
        this.mWeight = mWeight;
    }
/*
    public Stats getStats() {
        return mStats;
    }

    public void setStats(Stats mStats) {
        this.mStats = mStats;
    }



*/
}
