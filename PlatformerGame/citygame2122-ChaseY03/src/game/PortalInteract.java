package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * PortalInteract class is triggered whenever the player touches the portal that is in the game world.
 * It uses collision listeners to check if there is anything touching its hitbox.
 * The class loads the sound effect that will play when it is triggered.
 * The collide method is what actions happen when the event interaction is triggered, in this case it plays the sound
 * and removes the portal as well as start the next game level as this is the completion point checker.
 */
public class PortalInteract implements CollisionListener  {
    GameLevel currentLevel;
    Game game;

    private static SoundClip portalSFX;

    static{
        try{
            portalSFX = new SoundClip("data/portaltpSFX.wav");
            System.out.println("Portal sound loaded");

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException exception) {
            exception.printStackTrace();
        }
    }
    public PortalInteract (GameLevel lv, Game game){
        currentLevel = lv;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        //if player touch portal, then proceed to next level
        if (e.getOtherBody() instanceof Portal){
            //if key  collected then:
            if (currentLevel.isDone()){
                portalSFX.play();
                e.getOtherBody().destroy();
                try {
                    game.startNext();
                    game.saveLevel();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

}
