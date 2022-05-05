package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class MovingPlatform extends StaticBody implements StepListener {
    private static final Shape liftShape = new BoxShape(2,0.5f);
    private final Vec2 startPos;
    private final float top;
    private final float bottom;
    private float delta;

    public MovingPlatform(World w){
        super(w, liftShape);
        startPos = this.getPosition();
        bottom = startPos.y;
        top = startPos.y+8;
        delta = 0.1f;
        w.addStepListener(this);

    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().y < bottom){
            this.setPosition(startPos);
            delta*=-1;
        }
        if (getPosition().y > top){
            delta*=-1;
        }
        this.setPosition(new Vec2(this.getPosition().x, this.getPosition().y+delta));
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
