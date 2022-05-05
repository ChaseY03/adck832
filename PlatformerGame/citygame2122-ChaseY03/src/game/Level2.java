package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level2 extends GameLevel{

    private final Game game;
    Image bgImage2;
    private static final Shape enemyShape = new PolygonShape(-0.92f,0.78f, 0.62f,0.78f, 1.04f,-3.24f, -1.34f,-3.28f);
    private static final BodyImage enemyRight = new BodyImage("data/DemonIdle.gif",8);
    public Level2(Game game){
        super(game);
        this.game = game;
        bgImage2 = new ImageIcon("data/background2.png").getImage();

        getCharacter().setPosition(new Vec2(7,-10));
        Shape platformShape = new BoxShape(2,0.5f);
        Portal lv2Portal = new Portal(this);
        lv2Portal.setPosition(new Vec2(-8f,-0.15f));

        Platform jumpingPlat = new Platform(this,platformShape, new Vec2(3,-7f));
        Platform portalPlat = new Platform(this,platformShape, new Vec2(-8f,-2f));
        portalPlat.setFillColor(Color.green);

        for(int en=0; en<3; en++){
            Enemy enemy = new Enemy(this,enemyShape);
            enemy.addImage(enemyRight);
            enemy.setPosition(new Vec2(en*-3.5f,-9));
        }

        new Coins(this).setPosition(new Vec2(9,-11));
        new Coins(this).setPosition(new Vec2(-6,-11));
        new Coins(this).setPosition(new Vec2(-2,-11));

        new HealthPotion(this).setPosition(new Vec2(3,-5.75f));

    }

    @Override
    public boolean isDone() {
        //if credits = spawned amount
        return game.getCreds() >= 1;
    }

    @Override
    public String getLevel() {
        return "Level 2";
    }

    @Override
    public Image getBG() {
        return bgImage2;
    }
}
