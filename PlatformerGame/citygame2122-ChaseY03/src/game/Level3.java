package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level3 extends GameLevel{

    private final Game game;
    Image bgImage3;
    private static final Shape enemyShape = new PolygonShape(-1.1f,0.15f, -1.6f,-2.85f, 1.38f,-2.88f, 1.02f,0.13f);
    private static final BodyImage enemyRight = new BodyImage("data/SlimeKingIdle.gif",6);
    private static final BodyImage enemyLeft = new BodyImage("data/SlimeKingLeftIdle.gif",6);


    public Level3(Game game){
        super(game);
        this.game = game;
        bgImage3 = new ImageIcon("data/background3.png").getImage();
        getCharacter().setPosition(new Vec2(7,-10));

        Shape platformShape = new BoxShape(2,0.5f);
        Portal lv3Portal = new Portal(this);
        lv3Portal.setPosition(new Vec2(9f,7f));

        Platform portalPlat = new Platform(this,platformShape, new Vec2(9f,5f));
        Platform jumpingPlat = new Platform(this,platformShape, new Vec2(6f,-4f));
        Platform jumpingPlat2 = new Platform(this,platformShape, new Vec2(-8f,-7f));
        portalPlat.setFillColor(Color.green);
        MovingPlatform lift = new MovingPlatform(lv3Portal.getWorld());
        lift.setPosition(new Vec2(-2,-10));

        for(int en=0; en<3; en++){
            Enemy enemy = new Enemy(this,enemyShape);
            enemy.addImage(enemyRight);
            enemy.setPosition(new Vec2(en*-3.5f,-10));
        }

        new Coins(this).setPosition(new Vec2(-11f,-11f));
        new Coins(this).setPosition(new Vec2(10f,-11f));
        new Coins(this).setPosition(new Vec2(6f,-3f));
    }

    @Override
    public boolean isDone() {
        return game.getCreds() >= 1;
    }

    @Override
    public String getLevel() {
        return "Level 3";
    }

    @Override
    public Image getBG() {
        return bgImage3;
    }

}
