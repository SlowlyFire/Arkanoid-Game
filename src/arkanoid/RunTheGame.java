import arkanoid.animations.*;
import arkanoid.levels.*;
import arkanoid.run.*;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Gal Giladi
 */
public class RunTheGame {

    /**
     * main function : creates a Game object, initialize the game and runs it.
     * @param args -- no needed right now.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Gal Arknoid Game", 800, 600);
        KeyboardSensor ks = gui.getKeyboardSensor();
        AnimationRunner runner = new AnimationRunner(gui);

        // create GameFlow object
        GameFlow gameFlow = new GameFlow(runner, ks, gui);

        // create 4 levels to the game
        LevelInformation directHit = new DirectHit();
        LevelInformation wideEasy = new WideEasy();
        LevelInformation purpleRain = new PurpleRain();
        LevelInformation finalFour = new FinalFour();

        // add all levels to one List
        List<LevelInformation> levelInformationList = new ArrayList<>();
        levelInformationList.add(directHit);
        levelInformationList.add(wideEasy);
        levelInformationList.add(purpleRain);
        levelInformationList.add(finalFour);

        int numberOfArgs = 0;
        int numberOfAllKindsOfArgs = args.length;
        // if there are no arguments passed by, run the game with all the levels above
        if (numberOfAllKindsOfArgs == 0) {
            // run all the levels
            gameFlow.runLevels(levelInformationList, numberOfAllKindsOfArgs);
        } else {
            // otherwise, treat arguments as a list of levels we wish to play, in a specified order
            List<LevelInformation> specifiedLevelList = new ArrayList<>();
            for (int i = 0; i < numberOfAllKindsOfArgs; i++) {
                if (args[i].equals("1")) {
                    specifiedLevelList.add(directHit);
                    numberOfArgs++;
                } else if (args[i].equals("2")) {
                    specifiedLevelList.add(wideEasy);
                    numberOfArgs++;
                } else if (args[i].equals("3")) {
                    specifiedLevelList.add(purpleRain);
                    numberOfArgs++;
                } else if (args[i].equals("4")) {
                    specifiedLevelList.add(finalFour);
                    numberOfArgs++;
                }
            }
            if (numberOfArgs == 0) {
                gameFlow.runLevels(levelInformationList, numberOfArgs);
            }
            gameFlow.runLevels(specifiedLevelList, numberOfArgs);
        }
    } // end main
} // end class RunTheGame
