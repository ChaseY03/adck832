package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class HealthPickup implements CollisionListener {

    private final Character character;
    private final Game game;
    private static SoundClip hpSFX;


    static {
        try{
            hpSFX = new SoundClip("data/healthSFX.wav");
            System.out.println("Health potion sound loaded");

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException exception) {
            exception.printStackTrace();
        }
    }

    public HealthPickup(Game g, Character c){
        this.game = g;
        this.character = c;
    }

    @Override
    public void collide(CollisionEvent e){
        if (e.getOtherBody() instanceof HealthPotion){
            //character.setHp(character.getHp()+2);
            game.setHp(game.getHp()+2);
            e.getOtherBody().destroy();
            System.out.println("Health point added");
            hpSFX.play();
        }
    }
}
