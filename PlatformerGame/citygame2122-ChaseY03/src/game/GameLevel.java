package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public abstract class GameLevel extends World {

    private Character character;
    private final Game game;

    public GameLevel(Game game){
        //to do: add a timer system for scoreboard, how long each run takes (timer display in GameView)
        this.game = game;
        // ground
        Shape groundShape = new BoxShape(30, 0.5f);
        BodyImage ground_image = new BodyImage("data/ground.png",8);
        Platform ground = new Platform(this, groundShape,new Vec2(0,-11.5f));
        for (int p = -10; p < 100; p++) {
            new AttachedImage(ground, ground_image, 1f, 0f, new Vec2(p*2,-0.5f));
        }

        // barriers so player cant fall off
        Shape wallShape = new BoxShape(0.5f, 6f);
        StaticBody wallLeft = new StaticBody(this, wallShape);
        wallLeft.setPosition(new Vec2(-13.5f, -6));

        StaticBody wallRight = new StaticBody(this, wallShape);
        wallRight.setPosition(new Vec2(13.5f, -6));

        // character
        character = new Character(this, game);
        CoinsPickup coinsPickup = new CoinsPickup(game);
        character.addCollisionListener(coinsPickup);
        HealthPickup hpPickup = new HealthPickup(game, getCharacter());
        character.addCollisionListener(hpPickup);
        PortalInteract touched = new PortalInteract(this, game);
        character.addCollisionListener(touched);
    }
    public void populate(){
        character = new Character(game.getLV(), game);
    }

    public Character getCharacter() {
        return character;
    }

    public abstract Image getBG();

    public abstract boolean isDone();

    public abstract String getLevel();

}
