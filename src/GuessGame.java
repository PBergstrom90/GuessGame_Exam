import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

//Klass för själva spelet. Spellogiken finns här.
public class GuessGame {
    private int correctNumber;
    private int attempts;
    private int score;
    private LowScore lowScore;  // Lägger till möjlighet att registrera,
                                // spelarpoäng i LowScore-klassen.

    public GuessGame(LowScore lowScore) {
        // Lägger GuessGame-grunden för spelet.
        Random random = new Random();
        // Lägger till +1 för att det inte ska bli 0 eller stanna vid 99.
        correctNumber = random.nextInt(100) + 1;
        attempts = 0;
        score = 0;
        this.lowScore = lowScore;
    }
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean correctGuess = false;

        System.out.print("\nGissa på en siffra mellan 1 till 100: ");
        // Sålänge correctGuess inte är true, fortsätt köra.
        while (!correctGuess) {
            try{
            int guess = scanner.nextInt();
            attempts++;

            if (guess < correctNumber) {
                System.out.print("Du gissade för lågt! Försök igen: ");
            } 
            else if (guess > correctNumber) {
                System.out.print("Du gissade för högt! Försök igen: ");
            }
            else if (guess == correctNumber) {
                System.out.println("\nGrattis! Du har gissat rätt efter " + attempts + " försök.");
                calculateScore();
                scanner.nextLine();
                System.out.print("Ange ditt namn: ");
                String playerName = scanner.nextLine();
                // Överför spelarnamn och poäng till LowScore-klassen.
                lowScore.addScore(playerName, score); 
                correctGuess = true;
            }
            else {
                System.out.print("Felaktig inmatning. Var god försök igen: ");
            }
        } catch (InputMismatchException e) {
            System.out.print("Felaktig inmatning. Vänligen ange ett heltal: ");
            scanner.next();
        }
        }
    }
        // Räknar antal försök. Ju lägre, desto bättre
        private void calculateScore() {
            score = attempts;
        }
        public int getScore() {
            return score;
        }
    }