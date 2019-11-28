package jonst;

import jonst.Models.Creature;
import jonst.Models.Item;
import jonst.Models.Location;
import jonst.Models.StationaryObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Builder {


        @SuppressWarnings("unchecked")
        public static void SaveTestMk2() {

            Creature trixie = new Creature("Trixie", "Trixie", "This is Trixie.",  "The Castle of Friendship", "Unicorn");

            Creature pinkie = new Creature("Pinkie Pie", "Pinkie", "This is Pinkie", "The Castle of Friendship","Earth pony");


            Item apple = new Item("A juicy red apple", "apple", "A fresh treat, straight from the Acres.", "The Castle of Friendship");

            Item hat = new Item("Trixie's hat", "wizard hat", "Your great and powerful hat!", "The Castle of Friendship");



            Location castle = new Location("The Castle of Friendship", "the castle", "A big castle.", "The Castle of Friendship", new ArrayList() {{
                add("Sugarcube Corner");
                add("Carousel Boutique");
            }});

            StationaryObject map = new StationaryObject("The Cutie Map", "map", "The big map that shows friendship emergencies.", "The Castle of Friendship");



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

            JSONArray creatureArray = new JSONArray();
            JSONArray itemArray = new JSONArray();
            JSONArray objectArray = new JSONArray();
            JSONArray locationArray = new JSONArray();


            for (Creature crea : creatureList) {        //This creates one JSONObject for every creature in the list, populates it with data, and adds it to "creatures"
                creatureArray.add(new JSONObject() {{
                    put("FullName", crea.getName());
                    put("ShortName", crea.getShortName());
                    put("Race", crea.getRace());
                    put("Description", crea.getDescription());
                    put("Location", crea.getLocationName());
                }});
            }


            JSONObject items = new JSONObject();    //This will hold every item as JSONObjects

            for (Item ite : itemList) {        //This creates one JSONObject for every item in the list, populates it with data, and adds it to "items"
                itemArray.add(new JSONObject() {{
                    put("FullName", ite.getName());
                    put("ShortName", ite.getShortName());
                    put("Description", ite.getDescription());
                    put("Location", ite.getLocationName());
                }});
            }


            JSONObject objects = new JSONObject();    //This will hold every stationaryobject as JSONObjects

            for (StationaryObject sta : objectList) {        //This creates one JSONObject for every object in the list, populates it with data, and adds it to "objects"
                objectArray.add(new JSONObject() {{
                    put("FullName", sta.getName());
                    put("ShortName", sta.getShortName());
                    put("Description", sta.getDescription());
                    put("Location", sta.getLocationName());
                }});
            }

            JSONObject locations = new JSONObject();    //This will hold every creature as JSONObjects

            for (Location loc : locationList) {        //This creates one JSONObject for every creature in the list, populates it with data, and adds it to "creatures"
                locationArray.add(new JSONObject() {{
                    put("FullName", loc.getName());
                    put("ShortName", loc.getShortName());
                    put("Description", loc.getDescription());
                    put("Location", loc.getLocationName());
                    put("Exits", new JSONObject() {{

                                for (int i = 0; i < loc.getExits().size(); i++) {   //Puts all exits into an array
                                    put(i, loc.getExits().get(i));
                                }
                            }}
                    );
                }});
            }


            try (FileWriter file = new FileWriter("src/main/java/jonst/Assets/JSON/creatures.json")) {

                file.write(creatureArray.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }


            try (FileWriter file = new FileWriter("src/main/java/jonst/Assets/JSON/items.json")) {

                file.write(itemArray.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

            try (FileWriter file = new FileWriter("src/main/java/jonst/Assets/JSON/objects.json")) {

                file.write(objectArray.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

            try (FileWriter file = new FileWriter("src/main/java/jonst/Assets/JSON/locations.json")) {

                file.write(locationArray.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }



        public static void LoadTest() {

            FileReader reader;
            JSONParser jsonParser = new JSONParser();

            List<Item> itemList = new ArrayList<>();
            List<Creature> creatureList = new ArrayList<>();
            List<StationaryObject> stationaryObjectList = new ArrayList<>();
            List<Location> locationList = new ArrayList<>();

            try
            {
                reader = new FileReader("src/main/java/jonst/Assets/JSON/items.json");
                JSONArray itemJSON = (JSONArray) jsonParser.parse(reader);

                for (Object obj: itemJSON) {
                    JSONObject jObj = (JSONObject) obj;
                    String fullName = (String) jObj.get("FullName");
                    String shortName = (String) jObj.get("ShortName");
                    String description = (String) jObj.get("Description");
                    String location = (String) jObj.get("Location");

                    Item item = new Item(fullName, shortName, description, location );


                    itemList.add(item);
                }


                reader = new FileReader("src/main/java/jonst/Assets/JSON/creatures.json");
                JSONArray creatureJSON = (JSONArray) jsonParser.parse(reader);

                for (Object obj: creatureJSON) {
                    JSONObject jObj = (JSONObject) obj;
                    String fullName = (String) jObj.get("FullName");
                    String shortName = (String) jObj.get("ShortName");
                    String description = (String) jObj.get("Description");
                    String race = (String) jObj.get("Race");
                    String location = (String) jObj.get("Location");

                    Creature creature = new Creature(fullName, shortName, description, location, race );
                    creature.setLocation(location);

                    creatureList.add(creature);
                }


                reader = new FileReader("src/main/java/jonst/Assets/JSON/objects.json");
                JSONArray stationaryObjectJSON = (JSONArray) jsonParser.parse(reader);

                for (Object obj: stationaryObjectJSON) {
                    JSONObject jObj = (JSONObject) obj;
                    String fullName = (String) jObj.get("FullName");
                    String shortName = (String) jObj.get("ShortName");
                    String description = (String) jObj.get("Description");
                    String location = (String) jObj.get("Location");

                    StationaryObject object = new StationaryObject(fullName, shortName, description, location);
                    object.setLocation(location);

                    stationaryObjectList.add(object);
                }


                reader = new FileReader("src/main/java/jonst/Assets/JSON/locations.json");
                JSONArray locationJSON = (JSONArray) jsonParser.parse(reader);

                for (Object obj: locationJSON) {
                    JSONObject jObj = (JSONObject) obj;
                    String fullName = (String) jObj.get("FullName");
                    String shortName = (String) jObj.get("ShortName");
                    String description = (String) jObj.get("Description");
                    ArrayList<String> exits = new ArrayList<>();

                    JSONObject jsExits = (JSONObject) jObj.get("Exits");

                    for (Object xObj: jsExits.values()) {
                        exits.add((String) xObj);
                    }

                    Location location = new Location(fullName, shortName, description, fullName, exits);
                    location.setLocation(fullName);

                    locationList.add(location);
                }







            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }







            for (Item item: itemList) {
                System.out.println("Full name: " + item.getName() + "; Short name: " + item.getShortName() + "; Description: " + item.getDescription() + "; Location: " + item.getLocationName() + ".");
            }

            for (StationaryObject stat: stationaryObjectList) {
                System.out.println("Full name: " + stat.getName() + "; Short name: " + stat.getShortName() + "; Description: " + stat.getDescription() + "; Location: " + stat.getLocationName() + ".");
            }

            for (Creature creature: creatureList) {
                System.out.println("Full name: " + creature.getName() + "; Short name: " + creature.getShortName() + "; Race: " + creature.getRace() + "; Description: " + creature.getDescription() + "; Location: " + creature.getLocationName() + ".");
            }

            for (Location loc: locationList) {
                System.out.print("Full name: " + loc.getName() + "; Short name: " + loc.getShortName() + "; Description: " + loc.getDescription() + "; Location: " + loc.getLocationName() + ". Exits are: ");
                for (String exit: loc.getExits()) {
                    System.out.print(exit + ", ");
                }

            }

        }








    }


