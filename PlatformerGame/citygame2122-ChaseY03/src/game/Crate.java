package game;

import city.cs.engine.*;

public class Crate extends DynamicBody{
    //Crates can be shot, drops HP potion
    private static final Shape crateObject = new BoxShape(2,2);

    private static final BodyImage crateImage = new BodyImage("data/crate.png",2);

    public Crate(World w){
        super(w, crateObject);
        addImage(crateImage);
    }
}
