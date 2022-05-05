package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class ShootEvent implements CollisionListener {

    private final Shoot shoot;
    private final GameLevel world;

    public ShootEvent(Shoot s, GameLevel world){
        this.shoot = s;
        this.world = world;
    }

    @Override
    public void collide(CollisionEvent e){
        if (e.getOtherBody() instanceof Enemy){
            shoot.destroy();
        }
        if (e.getOtherBody() instanceof Platform) {
            shoot.destroy();
        }

    }
}

