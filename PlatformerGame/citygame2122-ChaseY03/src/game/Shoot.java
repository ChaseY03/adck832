package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public class Shoot extends DynamicBody {
    private Character character;
    private static final Shape meteorShape = new CircleShape(0.5f);

    private static final BodyImage meteorImage = new BodyImage("data/meteor.png", 1f);

    public Shoot(GameLevel world, Character character){
        super(world, meteorShape);

        if (character.direction == "left"){
            setPosition(new Vec2(character.getPosition().x-2, character.getPosition().y+0.5f));
            setLinearVelocity(new Vec2(-10,3));
            applyForce(new Vec2(-250f,0));
        }
        else{
            setPosition(new Vec2(character.getPosition().x+2, character.getPosition().y+0.5f));
            setLinearVelocity(new Vec2(10,3));
            applyForce(new Vec2(250f,0));
        }
        addImage(meteorImage);
        setBullet(true);

        ShootEvent damaged = new ShootEvent(this,world);
        this.addCollisionListener(damaged);

    }

    public void updateCharacter(Character character) {
        this.character = character;
    }
}
