package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

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
    /*
    public PortalInteract (Character c){
        this.character = c;
    }*/

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
