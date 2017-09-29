
/**
 * Write a description of class blackjack here.
 * 
 * @author Jacob Plumb 
 * @version 2017.9.25
 */
import java.util.Scanner;
public class blackjack{
    int playerHand = 0;
    int dealerHand = 0;
    int dealerHidden = 0;
    int dealerShown = 0;
    boolean bust = false;
    boolean dealerBust = false;
    boolean continuous = true;
    drawNum draw = new drawNum();
    Scanner scanner = new Scanner(System.in);
    
    public void main(){
        int pDraw1 = draw.getRandNum();
        int pDraw2 = draw.getRandNum();
        playerHand = pDraw1 + pDraw2;
        dealerHidden = draw.getRandNum();
        dealerShown = draw.getRandNum();
        dealerHand = dealerHidden + dealerShown;
        
        System.out.println("Your draw: " + pDraw1 + " and " + pDraw2 + ".");
        System.out.println("Dealer's draw: (Hidden) and " + dealerShown);
        while (continuous && !bust){
            System.out.print("Do you want to hit? (y/n): ");
            String playerAnswer = scanner.nextLine();
            if (playerAnswer.equals("y")){
                int pNewDraw = draw.getRandNum();
                playerHand += pNewDraw;
                System.out.println("You draw a " + pNewDraw + ", making your total " + playerHand + ".");
                if (playerHand > 21){
                    bust = true;
                    playerHand = 0;
                    System.out.println("You go bust!");
                }
            }else{
                System.out.println("The dealer has " + dealerHidden + " and " + dealerShown + ".");
                while (dealerHand < 17){
                    int dNewDraw = draw.getRandNum();
                    dealerHand += dNewDraw;
                    System.out.println("The dealer draws a " + dNewDraw + ", making his total " + dealerHand + ".");
                }
                if (dealerHand > 21){
                    dealerBust = true;
                    dealerHand = 0;
                    System.out.println("The dealer goes bust!");
                }
                continuous = false;
            }
        }
        if (playerHand > dealerHand){
            System.out.println("The player wins.");
        }else if (playerHand < dealerHand){
            System.out.println("The dealer wins.");
        }else{
            System.out.println("Both of you go bust.");
        }
    }
}
