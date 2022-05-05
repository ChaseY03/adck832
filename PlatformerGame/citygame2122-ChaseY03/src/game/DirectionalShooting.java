package game;

import org.jbox2d.common.Vec2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DirectionalShooting implements MouseListener {
    private Character character;
    private Shoot shoot;
    private GameView view;
    private GameLevel gamelv;
    private final Game game;

       public DirectionalShooting(Character c, GameView v, GameLevel lv, Game g){
           character = c;
           view = v;
           gamelv = lv;
           game = g;
       }
    /*
     public DirectionalShooting(Character c){
           character = c;
       }
*/
    @Override
    public void mouseClicked(MouseEvent e) {
        if (game.gameState == game.playState){
        Vec2 worldPoint = view.viewToWorld(e.getPoint());
        character.shoot(worldPoint);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void updateCharacter(Character character, GameView view, GameLevel level)
    {
        this.character = character;
        this.view = view;
        this.gamelv = level;
    }
}
