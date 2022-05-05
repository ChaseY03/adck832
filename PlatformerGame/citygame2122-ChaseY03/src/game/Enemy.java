package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemy extends Walker implements  StepListener{

    private GameLevel world;
    private int hp = 100;
    public EnemyHP hpbar;
    private long attack = 2500;
    public String enemyDirection;
    private final SolidFixture Enemy;
    Shape enemyShape;

    private static final BodyImage enemyRight = new BodyImage("data/SkeletonIdle.gif",4);
    private static final BodyImage enemyLeft = new BodyImage("data/SkeletonIdleLeft.gif",4);
    public Enemy(GameLevel world, Shape shape){
        super(world);
        this.enemyShape = shape;
        Enemy = new SolidFixture(this, shape);
        Enemy.setFriction(50);
        enemyDirection = "right";
        hpbar = new EnemyHP(this);
        EnemyEvent damaged = new EnemyEvent(this,world);
        this.addCollisionListener(damaged);
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public long getAttack() {
        return this.attack;
    }

    public void setAttack(long attack) {
        this.attack = attack;
    }

    private float leftPos, rightPos;
    private final int cover = 5;
    @Override
    public void setPosition(Vec2 pos){
        super.setPosition(pos);
        leftPos = pos.x-cover;
        rightPos = pos.x+cover;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        /*
        if (enemyDirection == "right"){

        }
        else {

        }*/
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }

}
