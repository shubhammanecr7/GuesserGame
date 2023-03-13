package GuesserGame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

abstract class Game{
    protected int range;
    protected int randomNumber;
    protected int tryCount;
    public abstract void playGame();
}

class NumberGuessingGame extends Game {

    private Scanner sc;
    public NumberGuessingGame(int range){
        this.range=range;
        this.sc=new Scanner(System.in);
        this.randomNumber = new Random().nextInt(range) + 1;
        this.tryCount = 0; 
    }

    public void playGame() {
        while(true){
            System.out.println("Enter your guess (1-"+range+") :");
            try{
                int playerGuess = sc.nextInt();
                tryCount++;
                if(playerGuess == randomNumber){
                    System.out.println("Correct! You Win!😎"); 
                    System.out.println("It took "+tryCount+ " tries");
                    break; //Stop the game after win...
                }
                else if(randomNumber > playerGuess){
                    System.out.println("Nope!😏 The number is higher. Guess again");
                }else{
                    System.out.println("Nope!😏 The number is lower. Guess again");
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid input! Please enter a valid Number");
                sc.nextLine();
            }
        }
    }
}

public class GameLauncher{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Select difficuilty level :");
            System.out.println("1. Easy(1-20)");
            System.out.println("2. Medium(1-50)");
            System.out.println("3. Hard(1-100)");
            int choise = sc.nextInt();
                Game game = null;
                switch (choise) {
                    case 1: game = new NumberGuessingGame(20); break;
                    case 2: game = new NumberGuessingGame(50); break;
                    case 3: game = new NumberGuessingGame(100); break;
                    default:
                    System.out.println("Please select appropriate difficulty level...");
                        break;
                }
            if (game != null) {
                game.playGame();
            }else{
                continue;
            }
            System.out.println("Want to play again!🤠 (y/n)");
            String playAgain = sc.next();
                if(!playAgain.equalsIgnoreCase("y")){
                    break;
                }
        }
        sc.close();
    }
}