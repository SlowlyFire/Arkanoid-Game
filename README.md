# Arkanoid-Game  

## **About the game**  
Arkanoid is a known block breaker arcade game.  
Using the paddle that appears at the bottom of the screen, the player is asked to clear a set of colored blocks that appear on the screen by deflecting a ball towards it, without letting the balls leave the bottom edge of the playfield.  
Each level has its own unique difficulty, arrangement of blocks, background, paddle size and speed, balls size, balls speed, balls amount and more.  

## **Gaining points**  
With every block you destroy, you gain 5 points. When all the blocks on the playground are destroyed, you gain another 100 points and also pass to the next level.  
If you managed to pass all four levels, you win. Otherwise, all the balls managed to slip to the bottom of the playground, and you lose.  
Either way, your final score is shown on the screen.

## **Controlling the game**  
In the beginning of each level, a screen of **3... 2... 1... GO** is displayed.  
When the message reaches 'GO', the game begins.  
You can control the paddle with the left and right arrows on your keyboard.  
When a ball hits the paddle, it bounces back to the playground. Notice that the velocity and direction of the ball change depends on where the paddle hits.  
You can pause the game with the 'p' button, that will display a screen with the message **"paused -- press space to continue"**. Once the space buttom is pressed, the screen of "**3... 2... 1... GO"** will appear again.  

## **Implementation and code packaging**  
The code files are arranged in packages. For example, if you want to see how I implemented the sprites and graphics, go to arkanoid→Sprites.  
**The main package list is:**    

Levels- all stages  
Animations- all screens (end, pause, countdown and more) and the animation runner  
Geometry- all geometry required: velocity, line, point and more  
HitListeners- ball remover, counter and more  
Sprites- all sprites and graphics  
Run- game flow  

In the implementation of the code we can find various **design patterns**: Observer, Decorator, Template and more.  
In addition, **the main basics of OOP principles** are kept: abstraction, encapsuliation, inheritance, polymorphism and more.  

## **Gameplay and screenshots**  
**Level One (Direct Hit):**   
 
![](https://github.com/SlowlyFire/Arkanoid-Game/blob/main/New%20Recording%20-%2010_3_2022%2C%2010_28_02%20AM-high.gif)   

**Level Two (Wide Easy):**     

![](https://github.com/SlowlyFire/Arkanoid-Game/blob/main/New%20Recording%20-%2010_3_2022%2C%2010_56_30%20AM-high.gif)  

**Level Three (Purple Rain):**    

![](https://github.com/SlowlyFire/Arkanoid-Game/blob/main/New%20Recording%20-%2010_3_2022%2C%2011_14_43%20AM-high.gif)  

**Level Foure (Final Four):**    

![]()  
