package jonst;

import jonst.Models.Creature;
import jonst.Models.Item;
import jonst.Models.Location;
import jonst.Models.StationaryObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Obsolete {
/*
    @SuppressWarnings("unchecked")
    public static void SaveTest() {

        //Probably don't use this one, it's too complicated. Stick to simpler lists.

        Creature trixie = new Creature("Trixie", "Trixie", "This is Trixie.", "Unicorn");
        trixie.setLocation("The Castle of Friendship");
        Creature pinkie = new Creature("Pinkie Pie", "Pinkie", "This is Pinkie", "Earth pony");
        pinkie.setLocation("The Castle of Friendship");

        Item apple = new Item("A juicy red apple", "apple", "A fresh treat, straight from the Acres.");
        apple.setLocation("The Castle of Friendship");
        Item hat = new Item("Trixie's hat", "wizard hat", "Your great and powerful hat!");
        hat.setLocation("The Castle of Friendship");


        Location castle = new Location("The Castle of Friendship", "the castle", "A big castle.", new ArrayList() {{
            add("Sugarcube Corner");
            add("Carousel Boutique");
        }});

        StationaryObject map = new StationaryObject("The Cutie Map", "map", "The big map that shows friendship emergencies.");
        map.setLocation("The Castle of Friendship");


        List<Creature> creatureList = new ArrayList() {{
            add(trixie);
            add(pinkie);
        }};
        List<Item> itemList = new ArrayList() {{
            add(apple);
            add(hat);
        }};
        List<Location> locationList = new ArrayList() {{
            add(castle);
        }};
        List<StationaryObject> objectList = new ArrayList() {{
            add(map);
        }};

        //Okay, we now have a bunch of lists that hold the things we want to save.

        JSONObject creatures = new JSONObject();    //This will hold every creature as JSONObjects
        //This creates one JSONObject for every creature in the list, populates it with data, and adds it to "creatures"

        for (int i = 0; i < creatureList.size(); i++) {
            int finalI = i;
            creatures.put("Creature " + finalI, new JSONObject() {{
                put("FullName", creatureList.get(finalI).getName());
                put("ShortName", creatureList.get(finalI).getShortName());
                put("Race", creatureList.get(finalI).getRace());
                put("Description", creatureList.get(finalI).getDescription());
                put("Location", creatureList.get(finalI).getLocationName());
            }});
        }


        JSONObject items = new JSONObject();    //This will hold every item as JSONObjects
        //This creates one JSONObject for every item in the list, populates it with data, and adds it to "items"

        for (int i = 0; i < itemList.size(); i++) {
            int finalI = i;
            items.put("Item " + finalI, new JSONObject() {{
                put("FullName", itemList.get(finalI).getName());
                put("ShortName", itemList.get(finalI).getShortName());
                put("Description", itemList.get(finalI).getDescription());
                put("Location", itemList.get(finalI).getLocationName());
            }});
        }


        JSONObject objects = new JSONObject();    //This will hold every stationaryobject as JSONObjects
        //This creates one JSONObject for every object in the list, populates it with data, and adds it to "objects"

        for (int i = 0; i < objectList.size(); i++) {
            int finalI = i;
            objects.put("StationaryObject " + finalI, new JSONObject() {{
                put("FullName", objectList.get(finalI).getName());
                put("ShortName", objectList.get(finalI).getShortName());
                put("Description", objectList.get(finalI).getDescription());
                put("Location", objectList.get(finalI).getLocationName());
            }});
        }

        JSONObject locations = new JSONObject();    //This will hold every creature as JSONObjects
        //This creates one JSONObject for every creature in the list, populates it with data, and adds it to "creatures"

        for (int i = 0; i < locationList.size() ; i++) {
            int finalI = i;
            locations.put("Location " + finalI, new JSONObject() {{
                put("FullName", locationList.get(finalI).getName());
                put("ShortName", locationList.get(finalI).getShortName());
                put("Description", locationList.get(finalI).getDescription());
                put("Location", locationList.get(finalI).getLocationName());
                put("Exits", new JSONObject() {{

                            for (int i = 0; i < locationList.get(finalI).getExits().size(); i++) {   //Puts all exits into an array
                                put(i, locationList.get(finalI).getExits().get(i));
                            }
                        }}
                );
            }});
        }

        JSONArray outputArray = new JSONArray();    //This adds everything to the array we can write out
        outputArray.add(creatures);
        outputArray.add(items);
        outputArray.add(objects);
        outputArray.add(locations);


        try (FileWriter file = new FileWriter("src/main/java/jonst/Assets/JSON/data.json")) {

            file.write(outputArray.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    */
}
