package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Coins extends DynamicBody {

    private static final Shape coinShape = new CircleShape(0.5f);

    private static final BodyImage coinImage =
            new BodyImage("data/coin.png", 1.5f);

    public Coins(World w) {
        super(w,coinShape);
        addImage(coinImage);
    }

    public void onKill(){
        //enemyCoin = new Coin...
    }

}
