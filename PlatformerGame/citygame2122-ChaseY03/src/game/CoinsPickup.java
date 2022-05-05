package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class CoinsPickup implements CollisionListener {

    private Character character;
    private final Game game;
    private static SoundClip coinSFX;

    public static SoundClip getCoinSFX() {
        return coinSFX;
    }


    // loads sound for when player picks up a coin
    {
        try{
            //if soundMuted boolean = true then:
            coinSFX = new SoundClip("data/coinpickupSFX.wav");
            System.out.println("Coin sound loaded");

        } catch (UnsupportedAudioFileException|LineUnavailableException|IOException exception) {
            exception.printStackTrace();
        }
    }

    public CoinsPickup(Game g){
        this.game = g;
    }

    @Override
    public void collide(CollisionEvent e){
        if (e.getOtherBody() instanceof Coins){
            game.addCreds();
            e.getOtherBody().destroy();
            System.out.println("Credits: " + game.getCreds());
           // if (settingsPanel.getSoundMuted() == 1){
            coinSFX.play();
        }
    }

}
