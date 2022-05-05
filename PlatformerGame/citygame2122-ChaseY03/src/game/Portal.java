package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Portal extends StaticBody {
    //Eventually turn into ghostly fixture ^^ using sensors
    private static final Shape portalShape = new CircleShape(0.5f);

    private static final BodyImage portalImage =
            new BodyImage("data/portal.png", 4);

   // public Portal(World w, Vec2 portalPosition) {
    public Portal(World w) {
        super(w,portalShape);
        addImage(portalImage);
        //this.setPosition(portalPosition);
    }


}
