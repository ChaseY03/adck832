package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Game {

    public SoundClip bgMusic;
    private final GameView view;
    private GameLevel level;
    private int credits;
    public int hp = 5;
    private final Character character;
    private final CharacterController controller;
    private final PausedController pController;
    private final DirectionalShooting shooting;
    public final JFrame frame;
    private boolean guiOn;
    public ControlPanel GUImain;
    public SettingsPanel GUIsettings;
    public StartingPanel GUIstart;
    public TutorialPanel GUIhelp;
    public String GUIstates;
    public int gameState;
    public final int menuState = 0;
    public final int playState = 1;
    public final int pausedState = 2;
    public final int deathState = 3;
    public final int finishState = 4;
    public int soundMuted = 1; //1 is no, 2 is yes

    /** Initialise a new Game. */
    public Game() {
        level = new Level1(this);
        view = new GameView(level,this, level.getCharacter(), 500,500);
        view.addMouseListener(new GiveFocus(view));
        character = level.getCharacter();
        controller = new CharacterController(level.getCharacter(),view,this,level);
        pController = new PausedController(level.getCharacter(),view,this);
        shooting = new DirectionalShooting(level.getCharacter(), view,level,this);
        view.addKeyListener(controller);
        view.addKeyListener(pController);
        view.addMouseListener(shooting);
        level.addStepListener(new Tracker(view, level.getCharacter()));

        frame = new JFrame("Dino platformer");

        // GUI items
        GUImain = new ControlPanel(this,view, view.currentLV);
        GUIsettings = new SettingsPanel(this);
        GUIstart = new StartingPanel(this);
        GUIhelp = new TutorialPanel(this);

        frame.add(GUIstart.getMainPanel()); // start screen

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

    }
    public void gameStart(){
        frame.remove(GUIstart.getMainPanel());
        frame.add(view);
        level.start();
        guiOn = false;
        if (soundMuted == 1){
        try{
            // bg music
            bgMusic = new SoundClip("data/BGMusic.wav");
            System.out.println("BG music 1 loaded");
            bgMusic.stop();
            bgMusic.loop();

        } catch (UnsupportedAudioFileException|LineUnavailableException|IOException exception) {
            exception.printStackTrace();
        }
        }
        gameState = playState;
        frame.repaint();
        frame.pack();
    }


    public void gamePaused(){
        // pause state, opens GUI menu and stops player from playing game
        view.repaint();
        view.removeMouseListener(shooting);
        view.removeKeyListener(controller);
        if (gameState == pausedState)
            level.stop();
        else if (gameState == playState){
            level.start();
            view.addMouseListener(shooting);
            view.addKeyListener(controller);
        }
    }

    public void startNext() throws IOException {
        // transitions to new level
        System.out.println("start next lv");
        bgMusic.close();
        // changes music on each new level
       runMusic();
        if (level instanceof Level1) {
            runMusic();
            System.out.println("end lv 1");
            level.stop();
            level = new Level2(this);
            updateWorld();
            //JFrame debugView = new DebugViewer(level, 500, 500);

        }
        else if (level instanceof Level2){
            runMusic();
            System.out.println("end lv 2");
            level.stop();
            level = new Level3(this);
            updateWorld();

        }
        else if (level instanceof Level3){
            gameState = finishState;
            runMusic();
            // lets player jump around freely without dying/picking up items
            view.removeMouseListener(shooting);
            view.removeKeyListener(pController);
            level.getCharacter().removeAllCollisionListeners();
            frame.add(GUImain.getMainPanel(), BorderLayout.EAST);
            guiOn = true;
            frame.pack();
            System.out.println("Game completed");
            System.out.println("Score saved");
            GameSaverLoader.save("data/finalStats.txt",level,this,view);
        }
    }

    private void runMusic() {
        //loads music
            try{
                if (level instanceof Level1){
                    bgMusic = new SoundClip("data/BGMusic2.wav");
                    System.out.println("BG music 2 loaded");
                }

                else if(level instanceof Level2){
                    bgMusic = new SoundClip("data/BGMusic3.wav");
                    System.out.println("BG music 3 loaded");
                }
                bgMusic.loop();
            } catch (UnsupportedAudioFileException|LineUnavailableException|IOException exception) {
                exception.printStackTrace();
        }
    }

    public void setLV(GameLevel setLV) {
        level.stop();
        bgMusic.stop();
        level = setLV;
        bgMusic.loop();
        gameStart();
    }

    public void updateWorld(){
        // everything that needs to get transferred over to new level from restart
        view.setWorld(level);
        view.removeMouseListener(shooting);
        view.removeKeyListener(controller);
        view.removeKeyListener(pController);
        view.updateCharacter(level.getCharacter());
        controller.updateCharacter(level.getCharacter());
        pController.updateCharacter(level.getCharacter());
        shooting.updateCharacter(level.getCharacter(),view,level);
        view.addMouseListener(shooting);
        view.addKeyListener(controller);
        view.addKeyListener(pController);
        level.start();
    }

    public void saveLevel() throws IOException {
        GameSaverLoader.save("data/levelSave.txt",level,this,view);
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }

    public void addCreds() {
        credits++;
    }

    public int getCreds() {
        return credits;
    }

    public int setCreds(int credits) {
        this.credits = credits;
        return credits;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public GameLevel getLV(){
        return level;
    }

    public void isDead(){
        // run if player dies
        gameState = deathState;
        level.stop();
        bgMusic.stop();
        try{
                bgMusic = new SoundClip("data/deathBGMusic.wav");
                System.out.println("Game over music loaded");
                bgMusic.loop();}
        catch (UnsupportedAudioFileException|LineUnavailableException|IOException exception) {
            exception.printStackTrace();
        }
        // stops player from pressing any keys and using mouse
        view.removeMouseListener(shooting);
        view.removeKeyListener(controller);
        view.removeKeyListener(pController);
        view.repaint();
        // opens gui menu for restart button
        frame.add(GUImain.getMainPanel(),BorderLayout.EAST);
        frame.pack();
    }


    public void setGuiOn(boolean guiOn) {
        this.guiOn = guiOn;
    }

    public void toggleGUI() {
        // toggles/disables gui
        if (guiOn){
            frame.remove(GUImain.getMainPanel());
            guiOn = false;
        }
        else{
            //show
            frame.add(GUImain.getMainPanel(), BorderLayout.EAST);
            guiOn = true;
        }
        frame.pack();
    }

    public void settingsGUI(){
        // go to settings gui
        frame.remove(GUImain.getMainPanel());
        frame.add(GUIsettings.getMainPanel(), BorderLayout.EAST);
        frame.pack();
    }

    public void mainGUI(){
        // go back to the main gui
        frame.remove(GUIsettings.getMainPanel());
        frame.add(GUImain.getMainPanel(), BorderLayout.EAST);
        frame.pack();
    }

    public void keybindsGUI(){
        frame.remove(GUIstart.getMainPanel());
        frame.add(GUIhelp.getMainPanel());
        frame.pack();
    }
}
