# Arkanoid-Game  

## **About the game**  
Arkanoid is a known block breaker arcade game.  
Using the paddle that appears at the bottom of the screen, the player is asked to clear a set of colored blocks that appear on the screen by deflecting a ball towards it, without letting the balls leave the bottom edge of the playfield.  
Each level has its own unique difficulty, arrangement of blocks, background, paddle size and speed, balls size, balls speed, balls amount and more.  

## **Gaining points**  
With every block you destroy, you gain 5 points. When all the blocks on the playground are destroyed, you gain another 100 points and also pass to the next level.  
If you managed to pass all four levels, you win. Otherwise, all the balls managed to slip to the bottom of the playground, and you lose.  
**Either way, your final score is shown on the screen.**  

## **Controlling the game**  
In the beginning of each level, a screen of **3... 2... 1...** is displayed, then the game begins.  
You can control the paddle with the left and right arrows on your keyboard.  
When a ball hits the paddle, it bounces back to the playground. Notice that the velocity and direction of the ball change depends on where the paddle hits.  
You can pause the game with the 'p' button, that will display a screen with the message **"paused -- press space to continue"**. 
Once the space buttom is pressed, the screen of "**3... 2... 1..."** will appear again.  

## **Implementation and code packaging**  
The code files are arranged in packages. For example, if you want to see how I implemented the sprites and the animations, go to arkanoid→sprites or arkanoid→animations.  
**The main package list is:**    

**levels** - all stages (currectenly 4, you can add)  
**animations** - all screens (End, Pause, Countdown, etc) and the animation runner  
**geometry** - all required geometry: Velocity, Line, Point, Rectangle  
**hit_listeners** - BallRemover, BlockRemover, Counter, etc    
**sprites** - Ball, Paddle, Block, Background, etc.  
**run** - GameFlow, GameEnvironment, and our main Class: RunTheGame  

In the implementation of the code we can find various **design patterns**: Observer, Decorator, Template and more.  
In addition, **the main basics of OOP principles** are kept: abstraction, encapsuliation, inheritance, polymorphism and more.  

## **Gameplay and screenshots**  
**Level One (Direct Hit):**   
 
![](https://github.com/SlowlyFire/Arkanoid-Game/blob/main/New%20Recording%20-%2010_3_2022%2C%2010_28_02%20AM-high.gif)   

**Level Two (Wide Easy):**     

![](https://github.com/SlowlyFire/Arkanoid-Game/blob/main/New%20Recording%20-%2010_3_2022%2C%2010_56_30%20AM-high.gif)  

**Level Three (Purple Rain):**    

![](https://github.com/SlowlyFire/Arkanoid-Game/blob/main/New%20Recording%20-%2010_3_2022%2C%2011_14_43%20AM-high.gif)  

**Level Four (Final Four):**    

![](https://github.com/SlowlyFire/Arkanoid-Game/blob/main/New%20Recording%20-%2010_3_2022%2C%2011_28_06%20AM-high.gif)  


## **How to run the game?**  

**in order to compile and run the game**, by using ant, enter from the main folder:    
ant compile  
ant run  

**in order to compile and run the game**, without using ant, enter from the 'arkanoid_run_file':  
if you use windows click on the 'ArkanoidGame.exe'  
if you use ubunto enter in the terminal: java -cp biuoop-1.4.jar:bin RunTheGame  
