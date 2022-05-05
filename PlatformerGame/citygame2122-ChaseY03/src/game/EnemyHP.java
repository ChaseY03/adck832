package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class EnemyHP extends SolidFixture {

    private static final Shape shapeHP = new BoxShape(0.1f,0.1f);

    public static final BodyImage hpMaxImage = new BodyImage("data/hpmax.png",3f);
    public static final BodyImage hp2Image = new BodyImage("data/hp2.png",3f);
    public static final BodyImage hp3Image = new BodyImage("data/hp3.png",3f);
    public static final BodyImage hp4Image = new BodyImage("data/hp4.png",3f);
    public static final BodyImage hp5Image = new BodyImage("data/hp5.png",3f);
    public static final BodyImage hpDeadImage = new BodyImage("data/hpdead.png",3f);
    public static final BodyImage hpBackground = new BodyImage("data/hpbg.png",3f);


    public AttachedImage currentHP;
    public AttachedImage backHP;

    public EnemyHP(Enemy s){
        super(s, shapeHP);

        currentHP = new AttachedImage(s, hpMaxImage,1f,0f, new Vec2(0,2f));
        backHP = new AttachedImage(s, hpBackground, 1f,0f, new Vec2(0,2f));
    }
}
