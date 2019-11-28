package jonst.Models;


import java.util.ArrayList;
import java.util.List;

public class Creature extends GenericObject {

    private String race;

    private List<String> inventory = new ArrayList<String>();

    public Creature(String name, String shortName, String description, String location, String race) {
        super(name, shortName, description, location);

        this.race = race;
    }




    public String getRace()
    { return race; }

}
