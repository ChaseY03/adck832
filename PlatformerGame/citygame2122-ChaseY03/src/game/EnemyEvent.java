package game;

import city.cs.engine.AttachedImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

public class EnemyEvent implements CollisionListener {
    private final Enemy enemy;
    private final GameLevel world;

    public EnemyEvent(Enemy enemy, GameLevel world){
        this.enemy = enemy;
        this.world = world;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Shoot){
            //System.out.println("damage taken - enemy");
            enemy.setHp(enemy.getHp() - 20);

            if (enemy.getHp() == 80){
                enemy.removeAttachedImage(enemy.hpbar.currentHP);
                enemy.hpbar.currentHP = new AttachedImage(enemy, EnemyHP.hp2Image,1f,0f,new Vec2(0,2f));
            }
            if (enemy.getHp() == 60){
                enemy.removeAttachedImage(enemy.hpbar.currentHP);
                enemy.hpbar.currentHP = new AttachedImage(enemy, EnemyHP.hp3Image,1f,0f,new Vec2(0,2f));
            }
            if (enemy.getHp() == 40){
                enemy.removeAttachedImage(enemy.hpbar.currentHP);
                enemy.hpbar.currentHP = new AttachedImage(enemy, EnemyHP.hp4Image,1f,0f,new Vec2(0,2f));
            }
            if (enemy.getHp() == 20){
                enemy.removeAttachedImage(enemy.hpbar.currentHP);
                enemy.hpbar.currentHP = new AttachedImage(enemy, EnemyHP.hp5Image,1f,0f,new Vec2(0,2f));
            }
            if (enemy.getHp() <= 0){
                //spawn coin on death
               enemy.destroy();
            }
        }
    }
}
