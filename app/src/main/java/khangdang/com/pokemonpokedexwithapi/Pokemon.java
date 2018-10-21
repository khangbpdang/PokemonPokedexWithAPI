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
        /*
        setCategory(category);
        setHP(HP);
        setAttack(att);
        setDefense(def);
        setSpAttack(spatt);
        setSpDefense(spdef);
        setSpeed(speed);*/
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


        public String getCategory() {
            return mCategory;
        }

        public void setCategory(String mCategory) {
            this.mCategory = mCategory;
        }

        public int getHP() {
            return mHP;
        }

        public void setHP(int mHP) {
            this.mHP = mHP;
        }

        public int getAttack() {
            return mAttack;
        }

        public void setAttack(int mAttack) {
            this.mAttack = mAttack;
        }

        public int getDefense() {
            return mDefense;
        }

        public void setDefense(int mDefense) {
            this.mDefense = mDefense;
        }

        public int getSpAttack() {
            return mSpAttack;
        }

        public void setSpAttack(int mSpAttack) {
            this.mSpAttack = mSpAttack;
        }

        public int getSpDefense() {
            return mSpDefense;
        }

        public void setSpDefense(int mSpDefense) {
            this.mSpDefense = mSpDefense;
        }

        public int getSpeed() {
            return mSpeed;
        }

        public void setSpeed(int mSpeed) {
            this.mSpeed = mSpeed;
        }*/

}
