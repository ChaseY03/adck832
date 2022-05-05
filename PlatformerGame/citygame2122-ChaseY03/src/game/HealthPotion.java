package game;

import city.cs.engine.*;

public class HealthPotion extends StaticBody {

    private static final Shape healthpotShape = new BoxShape(0.2f,0.2f);
    private static final BodyImage healthpotImage = new BodyImage("data/healthpotion.png",1.5f);

    public HealthPotion(World w){
        super(w, healthpotShape);
        addImage(healthpotImage);
    }
}
