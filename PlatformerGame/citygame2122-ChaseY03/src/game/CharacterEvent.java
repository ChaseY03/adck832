package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class CharacterEvent implements CollisionListener {
    private final Character character;
    private final GameLevel world;
    private final Game game;
    private static SoundClip deathSFX;

    static{
        try{
            deathSFX = new SoundClip("data/characterdeadSFX.wav");
            System.out.println("Death sound loaded");

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException exception) {
            exception.printStackTrace();
        }
    }

    public static SoundClip getDeathSFX() {
        return deathSFX;
    }

    public CharacterEvent(Character character, GameLevel world, Game game) {
        this.character = character;
        this.world = world;
        this.game = game;
    }


    @Override
    public void collide(CollisionEvent e) {
        //enemy attack = - character health
        //if character health = 0, destroy
        if (e.getOtherBody() instanceof Enemy){
            game.setHp((game.getHp() - 1));
            if (game.getHp() == 0){
                character.destroy();
                deathSFX.play();
                game.isDead();
            }
        }
    }
}
