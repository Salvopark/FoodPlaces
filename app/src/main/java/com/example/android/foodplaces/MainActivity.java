package com.example.android.foodplaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Restaurant> Stores = new ArrayList<Restaurant>();
    private Map<String, Integer> imageMap = new HashMap<String, Integer>();
    private int index = 0;
    private TextView OR_text;
    private ImageButton place1;
    private TextView place1_text;
    private ImageButton place2;
    private TextView place2_text;
    private Toolbar myToolbar;

    private Restaurant McD = new Restaurant("McDonald's", "$", "Burgers");
    private Restaurant BK = new Restaurant("Burger King", "$", "Burgers");
    private Restaurant Wendys = new Restaurant("Wendy's", "$", "Burgers");
    private Restaurant OliveGarden = new Restaurant("Olive Garden", "$$$", "Pasta");
    private Restaurant RedLobster = new Restaurant("Red Lobster", "$$$", "Seafood");
    private Restaurant TexaxRoadhouse = new Restaurant("Texas Roadhouse", "$$", "Steakhouse");
    private Restaurant BWW = new Restaurant("Buffalo Wild Wings", "$$", "Wings");
    private Restaurant CharcoalGrill = new Restaurant("Charcoal Grill", "$$", "Steakhouse");
    private Restaurant Dennys = new Restaurant("Denny's", "$$", "Breakfast");
    private Restaurant AppleBees = new Restaurant("AppleBees", "$$", "Steakhouse");
    private Restaurant MikeAngelos = new Restaurant("Mike & Angelos", "$$$", "Pizza");
    private Restaurant Noodles = new Restaurant("Noodles and Company", "$", "Pasta");
    private Restaurant Hardees = new Restaurant("Hardee's", "$", "Sandwiches");
    private Restaurant Arbys = new Restaurant("Arby's", "$", "Sandwiches");
    private Restaurant Reefpoint = new Restaurant("Reefpoint Brewhouse", "$$", "Steakhouse");
    private Restaurant Culvers = new Restaurant("Culver's", "$", "Burgers");
    private Restaurant Subway = new Restaurant("Subway", "$", "Sandwiches");
    private Restaurant Derangos = new Restaurant("Derango The Pizza King", "$$", "Pizza");
    private Restaurant Cornerhouse = new Restaurant("CornerHouse", "$$$$", "Steakhouse");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            populateList();
        }


        myToolbar = (Toolbar) findViewById(R.id.top_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(null);

        place1 = (ImageButton) findViewById(R.id.place1_button);
        place1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if (index < Stores.size()) {
                    place2.setImageResource(imageMap.get(Stores.get(index).getName()));
                    place2_text.setText(Stores.get(index).getAttr());
                    index++;
                } else {
                    place2.setImageResource(android.R.drawable.ic_delete);
                    place2_text.setText(R.string.end_of_list);

                }
            }
        });

        place2 = (ImageButton) findViewById(R.id.place2_button);
        place2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index < Stores.size()) {
                    place1.setImageResource(imageMap.get(Stores.get(index).getName()));
                    place1_text.setText(Stores.get(index).getAttr());
                    index++;
                } else {
                    place1.setImageResource(android.R.drawable.ic_delete);
                    place1_text.setText(R.string.end_of_list);
                }
            }
        });

        OR_text = (TextView) findViewById(R.id.OR_text);
        place1_text = (TextView) findViewById(R.id.place1_text);
        place2_text = (TextView) findViewById(R.id.place2_text);

        setButtonTexts();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.action_bar_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.price_selector_clear:
                populateList();
                setButtonTexts();
                return true;

            case R.id.price_selector_1:
                populateList();
                for (int i = 0; i < Stores.size(); i++) {
                    if (Stores.get(i).getPrice() != "$") {
                        Stores.remove(i);
                        i--;
                    }
                }
                setButtonTexts();
                return true;

            case R.id.price_selector_2:
                populateList();
                for (int i = 0; i < Stores.size(); i++) {
                    if (Stores.get(i).getPrice() != "$$") {
                        Stores.remove(i);
                        i--;
                    }
                }
                setButtonTexts();
                return true;

            case R.id.price_selector_3:
                populateList();
                for (int i = 0; i < Stores.size(); i++) {
                    if (Stores.get(i).getPrice() != "$$$") {
                        Stores.remove(i);
                        i--;
                    }
                }
                setButtonTexts();
                return true;

            case R.id.price_selector_4:
                populateList();
                for (int i = 0; i < Stores.size(); i++) {
                    if (Stores.get(i).getPrice() != "$$$$") {
                        Stores.remove(i);
                        i--;
                    }
                }
                setButtonTexts();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setButtonTexts(){
        if (Stores.size() > 1) {
            place1.setImageResource(imageMap.get(Stores.get(0).getName()));
            place1_text.setText(Stores.get(0).getAttr());
            place2.setImageResource(imageMap.get(Stores.get(1).getName()));
            place2_text.setText(Stores.get(1).getAttr());
            index=2;
        } else if(Stores.size() == 1){
            place1.setImageResource(imageMap.get(Stores.get(0).getName()));
            place1_text.setVisibility(View.VISIBLE);
            place1_text.setText(Stores.get(0).getAttr());
            place2.setImageResource(android.R.drawable.ic_delete);
            place2_text.setText(R.string.end_of_list);
            index=1;
        } else {
            place1.setImageResource(android.R.drawable.ic_delete);
            place1_text.setText(R.string.no_match);
            place2.setImageResource(android.R.drawable.ic_delete);
            place2_text.setText(R.string.no_match);
            index=1;
        }
    }
    public void populateList(){
        Stores = new ArrayList<>();
        imageMap = new HashMap<>();
        Stores.add(McD);
        imageMap.put("McDonald's",R.drawable.mcdonalds);
        Stores.add(BK);
        imageMap.put("Burger King",R.drawable.burgerking);
        Stores.add(Wendys);
        imageMap.put("Wendy's",R.drawable.wendys);
        Stores.add(OliveGarden);
        imageMap.put("Olive Garden",R.drawable.olivegarden);
        Stores.add(RedLobster);
        imageMap.put("Red Lobster",R.drawable.redlobster);
        Stores.add(TexaxRoadhouse);
        imageMap.put("Texas Roadhouse",R.drawable.texasroadhouse);
        Stores.add(BWW);
        imageMap.put("Buffalo Wild Wings",R.drawable.bww);
        Stores.add(CharcoalGrill);
        imageMap.put("Charcoal Grill",R.drawable.charcoalgrill);
        Stores.add(Dennys);
        imageMap.put("Denny's",R.drawable.dennys);
        Stores.add(AppleBees);
        imageMap.put("AppleBees",R.drawable.applebees);
        Stores.add(MikeAngelos);
        imageMap.put("Mike & Angelos",R.drawable.mikeangelos);
        Stores.add(Noodles);
        imageMap.put("Noodles and Company",R.drawable.noodles);
        Stores.add(Hardees);
        imageMap.put("Hardee's",R.drawable.hardees);
        Stores.add(Arbys);
        imageMap.put("Arby's",R.drawable.arbys);
        Stores.add(Reefpoint);
        imageMap.put("Reefpoint Brewhouse",R.drawable.reefpoint);
        Stores.add(Culvers);
        imageMap.put("Culver's",R.drawable.culvers);
        Stores.add(Subway);
        imageMap.put("Subway",R.drawable.subway);
        Stores.add(Derangos);
        imageMap.put("Derango The Pizza King",R.drawable.derangos);
        Stores.add(Cornerhouse);
        imageMap.put("CornerHouse",R.drawable.cornerhouse);
        Collections.shuffle(Stores);
    }
}




