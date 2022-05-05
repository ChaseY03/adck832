package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level1 extends GameLevel{

    private final Game game;
    Image bgImage;
    private static final BodyImage enemyRight = new BodyImage("data/SkeletonIdle.gif",4);
    private static final BodyImage enemyLeft = new BodyImage("data/SkeletonIdleLeft.gif",4);

    private static final Shape enemyShape = new PolygonShape(-1.48f,1.14f, 0.38f,1.1f, 0.23f,-1.98f, -1.45f,-1.92f);

    // Constructor
    public Level1(Game game){
        super(game);
        this.game = game;
        bgImage = new ImageIcon("data/background.png").getImage();
        getCharacter().setPosition(new Vec2(7,-10));

        Shape platformShape = new BoxShape(2,0.5f);
        Portal lv1Portal = new Portal(this);
        lv1Portal.setPosition(new Vec2(5f,-0.25f));

        Platform portalPlat = new Platform(this,platformShape, new Vec2(5f,-2f));
        Platform jumpingPlat = new Platform(this,platformShape, new Vec2(-6f,-4f));
        Platform jumpingPlat2 = new Platform(this,platformShape, new Vec2(2,-7f));
        portalPlat.setFillColor(Color.green);

        for(int en=0; en<3; en++){
            Enemy enemy = new Enemy(this,enemyShape);
            enemy.addImage(enemyRight);
            enemy.setPosition(new Vec2(en*-3.5f,-10));
        }

        new Coins(this).setPosition(new Vec2(-11,-11));
        new Coins(this).setPosition(new Vec2(-4,-11));
    }

    @Override
    public boolean isDone() {
        return game.getCreds() >= 1;
    }

    @Override
    public String getLevel() {
        return "Level 1";
    }

    @Override
    public Image getBG() {
        return bgImage;
    }
}
