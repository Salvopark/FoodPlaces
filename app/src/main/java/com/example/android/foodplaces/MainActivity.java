package com.example.android.foodplaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Restaurant> Stores = new ArrayList<Restaurant>();
    private int index = 0;
    private TextView OR_text;
    private Button place1;
    private TextView place1_text;
    private Button place2;
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
    private Restaurant Dennys = new Restaurant("Dennys", "$$", "Breakfast");
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


        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(null);

        place1 = (Button) findViewById(R.id.place1_button);
        index++;
        place1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if (index < Stores.size()) {
                    place2.setText(Stores.get(index).getName());
                    place2_text.setVisibility(View.VISIBLE);
                    place2_text.setText(Stores.get(index).getAttr());
                    index++;
                } else {
                    place2.setText(R.string.end_of_list);
                    place2_text.setVisibility(View.INVISIBLE);

                }
            }
        });

        place2 = (Button) findViewById(R.id.place2_button);
        index++;
        place2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index < Stores.size()) {
                    place1.setText(Stores.get(index).getName());
                    place1_text.setVisibility(View.VISIBLE);
                    place1_text.setText(Stores.get(index).getAttr());
                    index++;
                } else {
                    place1.setText(R.string.end_of_list);
                    place1_text.setVisibility(View.INVISIBLE);
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
            place1.setText(Stores.get(0).getName());
            place1_text.setVisibility(View.VISIBLE);
            place1_text.setText(Stores.get(0).getAttr());
            place2.setText(Stores.get(1).getName());
            place2_text.setVisibility(View.VISIBLE);
            place2_text.setText(Stores.get(1).getAttr());
            index=2;
        } else if(Stores.size() == 1){
            place1.setText(Stores.get(0).getName());
            place1_text.setVisibility(View.VISIBLE);
            place1_text.setText(Stores.get(0).getAttr());
            place2.setText(R.string.no_match);
            place2_text.setVisibility(View.INVISIBLE);
            index=1;
        } else {
            place1.setText(R.string.no_match);
            place1_text.setVisibility(View.INVISIBLE);
            place2.setText(R.string.no_match);
            place2_text.setVisibility(View.INVISIBLE);
            index=1;
        }
    }
    public void populateList(){
        Stores = new ArrayList<>();
        Stores.add(McD);
        Stores.add(BK);
        Stores.add(Wendys);
        Stores.add(OliveGarden);
        Stores.add(RedLobster);
        Stores.add(TexaxRoadhouse);
        Stores.add(BWW);
        Stores.add(CharcoalGrill);
        Stores.add(Dennys);
        Stores.add(AppleBees);
        Stores.add(MikeAngelos);
        Stores.add(Noodles);
        Stores.add(Hardees);
        Stores.add(Arbys);
        Stores.add(Reefpoint);
        Stores.add(Culvers);
        Stores.add(Subway);
        Stores.add(Derangos);
        Stores.add(Cornerhouse);
        Collections.shuffle(Stores);
    }
}




