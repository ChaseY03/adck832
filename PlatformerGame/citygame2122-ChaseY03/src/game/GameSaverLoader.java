package game;

import java.io.FileWriter;
import java.io.IOException;

public class GameSaverLoader {

    private final String fileName;

    public GameSaverLoader(String fileName) {
        this.fileName = fileName;
    }

    public static void save(String fileName, GameLevel level, Game game, GameView view) throws IOException {
        boolean append = true;
        FileWriter wr =null;
        try{
            wr = new FileWriter(fileName, append);
            //Character
            wr.write(level.getLevel() + " Character location: " + level.getCharacter().getPosition().x + "," +  level.getCharacter().getPosition().y + "\n");
            if (level.getLevel() == "Level 1"){
                if (level.isDone() == true){
                wr.write("Level 1 Time taken: " + view.df.format(view.playTime) + "\n");
                }
            }
            else if (level.getLevel() == "Level 2"){
                if (level.isDone() == true){
                    wr.write( "Level 2 Time taken: " + view.df.format(view.playTime) + "\n");
                }
            }
            else if (level.getLevel() == "Level 3"){
                if (level.isDone() == true){
                    wr.write( "Level 3 Time taken: " + view.df.format(view.playTime) + "\n" +
                            "Player health: " + game.getHp() + "\n" + "Player credits: " + game.getCreds()+ "\n");
                }
            }
            else if (game.gameState == game.finishState){
                wr.write("Player health: " + game.getHp() + "\n" + "Player credits: " + game.getCreds()+ "\n");
            }
        }finally {
            if (wr != null){
                wr.close();
            }
        }


    }

    public static void load(){

    }

}
