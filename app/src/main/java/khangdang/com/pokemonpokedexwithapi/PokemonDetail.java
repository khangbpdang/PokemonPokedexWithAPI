package khangdang.com.pokemonpokedexwithapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import khangdang.com.pokemonpokedexwithapi.networking.PokemonClientService;

public class PokemonDetail extends AppCompatActivity {
    TextView pokemonTitleTextView;
    PokemonClientService pokemonClientService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        pokemonTitleTextView = (TextView)findViewById(R.id.pokemon_title);


        /*
        //String desc = getIntent().getStringExtra(NewsActivity.NEWS_EXTRA);
        //descTextView.setText(desc);
        News news = (News) getIntent().getParcelableExtra(NewsActivity.NEWS_EXTRA);
        titleTextView.setText(news.title);
        dateTextView.setText(news.pubDate);
        descTextView.setText(news.desc);*/

    }
}
