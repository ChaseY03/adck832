package game;

import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

public class Platform extends StaticBody {

    private final GameLevel world;

    //public Platform(GameWorld world, Shape platformShape, BodyImage platformImage, Vec2 platformPosition){
    public Platform(GameLevel world, Shape platformShape, Vec2 platformPosition){
        super(world,platformShape);
        //this.addImage(platformImage);
        this.setPosition(platformPosition);
        this.world = world;
    }

}
