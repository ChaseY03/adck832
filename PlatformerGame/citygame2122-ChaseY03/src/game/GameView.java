package game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class GameView extends UserView{
    private final Image hpmaxImage;
    Character character;
    Game game;
    GameLevel currentLV;
    private final Vec2 Cam = new Vec2(0f,0f);
    Graphics2D gf;

    public GameView(GameLevel w, Game g,Character c, int width, int height) {
        super(w,500,500);
        currentLV = w;
        this.game = g;
        this.character = c;
        hpmaxImage = new ImageIcon("data/heart.png").getImage();
        setLocation(0,0);
        setCentre(Cam);
    }

    @Override
    public void setWorld(World w){
        super.setWorld(w);
        currentLV = (GameLevel) w;
    }


    @Override
    protected void paintBackground(Graphics2D gb) {
        gb.drawImage(currentLV.getBG(), 0, -260, this);

    }

    // timer
    public double playTime;
    public DecimalFormat df = new DecimalFormat("#0.00");

    @Override
    protected void paintForeground(Graphics2D gf) {
        gf.setColor(Color.white);
        gf.scale(1.25,1.25);
        this.gf = gf;
        // display credits, hp, and timer when player is playing
        if (game.gameState == game.playState){
            gf.drawString("Credits: "+game.getCreds(),325,25);
            for (int h = 0; h < game.getHp(); h++){
                gf.drawImage(hpmaxImage, 20+30*h,10,35,35,this);
            }
            //ui.draw(gf);
            playTime +=(double)1/60;
            gf.drawString("Time: "+df.format(playTime),325,40);
        }
        // when paused key is pressed, shows currently elapsed time
        else if(game.gameState == game.pausedState){
            gf.setFont(gf.getFont().deriveFont(Font.PLAIN,20F));
            gf.drawString("PAUSED",150,50);
            gf.setFont(gf.getFont().deriveFont(Font.PLAIN,15F));
            gf.drawString("Time: "+df.format(playTime), 150,75);
        }
        // when player completes lv 3
        else if(game.gameState == game.finishState){
            gf.drawString("Credits: "+game.getCreds(),325,25);
            for (int h = 0; h < game.getHp(); h++){
                gf.drawImage(hpmaxImage, 20+30*h,10,35,35,this);
            }
            gf.setFont(gf.getFont().deriveFont(Font.PLAIN,20F));
            gf.drawString("CONGRATS",150,50);
            gf.setFont(gf.getFont().deriveFont(Font.PLAIN,15F));
            gf.drawString("Time: "+df.format(playTime), 150,75);
        }
        // when hp = 0
        else if (game.gameState == game.deathState){
            gf.setFont(gf.getFont().deriveFont(Font.PLAIN,20F));
            gf.drawString("YOU DIED",150,150);
        }

    }


    //camera
    public void setLocation(Vec2 position) {

    }

    public void updateCharacter(Character character){
        this.character = character;
    }
}

