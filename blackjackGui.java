
/**
 * Write a description of class blackjackGUI here.
 * 
 * @author Jacob Plumb
 * @version 2017.9.27
 */
import java.awt.*;
import java.awt.event.*;
public class blackjackGui extends Frame implements ActionListener{
    Label playerHandLabel;
    Label dealerHandLabel;
    Label flavorText;
    Label dealerBustLabel;
    Label playerBustLabel;
    Button playerHit;
    Button playerStay;
    Button newGame;
    drawNum draw = new drawNum();
    
    int pDraw1 = draw.getRandNum();
    int pDraw2 = draw.getRandNum();
    int playerHand = pDraw1 + pDraw2;;
    int dealerHidden = draw.getRandNum();;
    int dealerShown = draw.getRandNum();
    int dealerHand = dealerHidden + dealerShown;;
    boolean bust = false;
    boolean dealerBust = false;
    String totalPlayerHand = ("Your hand: " + pDraw1 + ", " + pDraw2);
    String totalDealerHand = ("Dealer's hand: [Hidden], " + dealerShown);
    
    blackjackGui(){
        playerHandLabel = new Label();
        playerHandLabel.setBounds(100, 100, 200, 20);
        playerHandLabel.setText(totalPlayerHand);
        
        playerBustLabel = new Label();
        playerBustLabel.setBounds(60, 100, 40, 20);
        
        dealerHandLabel = new Label();
        dealerHandLabel.setBounds(100, 120, 200, 20);
        dealerHandLabel.setText(totalDealerHand);
        
        dealerBustLabel = new Label();
        dealerBustLabel.setBounds(60, 120, 40, 20);
        
        flavorText = new Label();
        flavorText.setBounds(100, 140, 200, 20);
        
        playerHit = new Button("Hit");
        playerHit.setBounds(150, 160, 100, 20);
        playerHit.addActionListener(this);
        
        playerStay = new Button("Stay");
        playerStay.setBounds(150, 180, 100, 20);
        playerStay.addActionListener(this);
        
        newGame = new Button("New Game");
        newGame.setBounds(150, 200, 100, 20);
        newGame.addActionListener(this);
        
        add(playerHandLabel);
        add(dealerHandLabel);
        add(flavorText);
        add(playerHit);
        add(playerStay);
        add(playerBustLabel);
        add(dealerBustLabel);
        
        add(newGame);
        newGame.setEnabled(false);
        //WORKING ON RESETTING / NEW GAME
        setSize(400, 400);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == playerHit){
            int pNewDraw = draw.getRandNum();
            playerHand += pNewDraw;
            totalPlayerHand += (", " + pNewDraw);
            playerHandLabel.setText(totalPlayerHand);
            if (playerHand > 21){
                bust = true;
                playerHand = 0;
                playerBustLabel.setText("BUST |");
            }
            if (bust){
                playerHit.setEnabled(false);
                playerStay.setEnabled(false);
                totalDealerHand = ("Dealer's hand: " + dealerHidden + ", " + dealerShown);
                dealerHandLabel.setText(totalDealerHand);
                while (dealerHand < 17){
                    int dNewDraw = draw.getRandNum();
                    dealerHand += dNewDraw;
                    totalDealerHand += (", " + dNewDraw);
                    dealerHandLabel.setText(totalDealerHand);
                }
                if (dealerHand > 21){
                    dealerBust = true;
                    dealerHand = 0;
                    dealerBustLabel.setText("BUST |");
                }
                if (playerHand > dealerHand){
                    flavorText.setText("You win!");
                } else if(playerHand < dealerHand){
                    flavorText.setText("You lose!");
                }else{
                    flavorText.setText("Both of you go bust.");
                }
            }
        }
        if (e.getSource() == playerStay){
            playerHit.setEnabled(false);
            playerStay.setEnabled(false);
            totalDealerHand = ("Dealer's hand: " + dealerHidden + ", " + dealerShown);
            dealerHandLabel.setText(totalDealerHand);
            while (dealerHand < 17){
                int dNewDraw = draw.getRandNum();
                dealerHand += dNewDraw;
                totalDealerHand += (", " + dNewDraw);
                dealerHandLabel.setText(totalDealerHand);
            }
            if (dealerHand > 21){
                dealerBust = true;
                dealerHand = 0;
                dealerBustLabel.setText("BUST |");
            }
            if (playerHand > dealerHand){
                flavorText.setText("You win!");
            } else if(playerHand < dealerHand){
                flavorText.setText("You lose!");
            }else{
                flavorText.setText("Both of you go bust.");
            }
        }
    }
    public static void main(String[] args) {
        new blackjackGui();
    }
}
