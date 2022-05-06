package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * This class is where all the character's graphics are stored.
 * The class loads all the images of the directions the character can face and the hitbox shape which is the PolgonShape.
 * The startWalking method is what decides which directional image it should use.
 */
public class Character extends Walker {

    private final GameLevel world;
    private final Game game;

    public String direction;
    private final SolidFixture leftChar;

    private static final Shape characterShape = new PolygonShape(-0.85f,1.5f, -0.84f,-1.5f, 1.01f,-1.49f, 1.08f,1.53f);

    private static final BodyImage leftidle =
            new BodyImage("data/dinoidleleft.png", 4);
    private static final BodyImage rightidle =
            new BodyImage("data/dinoidleright.png", 4);
    private static final BodyImage leftWalk =
            new BodyImage("data/dinorunleft.png", 4);
    private static final BodyImage rightWalk =
            new BodyImage("data/dinorunright.png", 4);

    public Character(GameLevel world, Game game) {
        super(world, characterShape);
        this.game = game;
        // hitbox
        leftChar = new SolidFixture(this,characterShape);
        leftChar.setFriction(25);
        addImage(leftidle);
        direction = "left";
        this.world = world;

        CharacterEvent damaged = new CharacterEvent(this,world,game);
        this.addCollisionListener(damaged);

    }

    public void shoot(Vec2 t){
        //left click shooting
        Shoot s = new Shoot(world,this);
    }

    @Override
    public void startWalking(float Speed){
        super.startWalking(Speed);
        if (Speed < 0){
            this.removeAllImages();
            this.addImage(leftWalk);
            direction = "left";
        }
        else{
            this.removeAllImages();
            this.addImage(rightWalk);
            direction = "right";
        }
    }

    @Override
    public void stopWalking(){
        super.stopWalking();
            this.removeAllImages();
            if (direction == "left"){
                this.addImage(leftidle);
            }
            else if (direction == "right"){
                this.addImage(rightidle);
            }
    }
}
