package arkanoid.run;
import arkanoid.animations.*;
import arkanoid.hit_listener.*;
import arkanoid.levels.*;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.List;
/**
 * @author Gal Giladi
 */
public class GameFlow {
    // members
    private AnimationRunner runner;
    private KeyboardSensor ks;
    private GUI gui;
    private Counter scoreCounter;

    /**
     * contructor: creates a GameFlow object.
     * @param runner is a AnimationRunner-type variable.
     * @param ks is a KeyboardSensor-type variable.
     * @param gui is a GUI-type variable.
     * also initialize scoreCounter to be 0.
     */
    public GameFlow(AnimationRunner runner, KeyboardSensor ks, GUI gui) {
        this.runner = runner;
        this.ks = ks;
        this.gui = gui;
        this.scoreCounter = new Counter(0);
    }

    /**
     * runLevels function: run all the levels of the game, according to the list of levels we have.
     * @param levels is a list of levels we need to run in a specified order.
     * @param numberOfArgs is number of arguments we got on command line.
     */
    public void runLevels(List<LevelInformation> levels, int numberOfArgs) {
        LevelInformation lastLevel = levels.get(levels.size() - 1);
        // initialize and run all the levels
        int levelsCounter = 0;
        for (LevelInformation levelInfo : levels) {
            // creating object of GameLevel
            GameLevel level = new GameLevel(levelInfo, this.runner, this.gui, this.scoreCounter,
                    lastLevel, numberOfArgs, levelsCounter);
            // initialize each level in its turn
            level.initialize();

            // if there are still blocks and balls in each level, keep running it
            while (level.getBlockCounter() != 0 && level.getBallCounter() != 0) {
                level.run();
            }

            // if all the balls fell on the floor in one of the levels - break the loop
            // and don't keep playing continued levels ahead
            if (level.getBallCounter() == 0) {
                gui.close();
                break;
            }
            levelsCounter++;
        }
    }
} // end class GameFlow