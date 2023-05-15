import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGame implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JLabel instructionsLabel, resultLabel;
    private JTextField guessTextField;
    private JButton guessButton;
    private int secretNumber;
    private int count=0;
    public NumberGuessingGame() {
        Random rand = new Random();
        secretNumber = rand.nextInt(100) + 1;
        instructionsLabel = new JLabel("Guess the secret number between 1 and 100:");
        guessTextField = new JTextField(10);
        guessButton = new JButton("Guess");
        resultLabel = new JLabel("");
        guessButton.addActionListener(this);
        instructionsLabel.setBounds(100,50,500,20);
        guessTextField.setBounds(100,150,50,20);
        guessButton.setBounds(100,150,100,20);
        resultLabel.setBounds(100,250,500,20);
        panel = new JPanel();
        panel.setLayout(null);
        panel.add(instructionsLabel);
        panel.add(guessTextField);
        panel.add(guessButton);
        panel.add(resultLabel);
        panel.setBackground(Color.yellow);
        guessButton.setLocation(100, 100);
        frame = new JFrame("Number Guessing Game");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String guessString = guessTextField.getText();
        count=count+1;
        if(count>3)
        {
            resultLabel.setText("You have No more chances the number is "+ secretNumber);
            return ;
        }
        int guess = Integer.parseInt(guessString);
        if (guess == secretNumber) {
            if(count==1)
            {
                resultLabel.setText("Congratulations, you guessed the secret number!\n Your score is 100");
            }
            else if(count==2)
            {
                resultLabel.setText("Congratulations, you guessed the secret number!\n Your score is 50");
            }
            else
            {
                resultLabel.setText("Congratulations, you guessed the secret number!\n Your score is 25");
            }
            
        } else if (guess < secretNumber) {
            resultLabel.setText("Too low, try again.");
        } else {
            resultLabel.setText("Too high, try again.");
        }
        
    }

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
    }
}
