import java.util.Scanner;
import java.util.InputMismatchException;

// Klass för meny-logiken.
public class Menu {
    
private Scanner scanner = new Scanner (System.in);
private boolean isRunning = true;
private LowScore lowScore = new LowScore();

public void runMenu() {
int choice;

while(isRunning) {
try {
System.out.println("\n--- Välkommen till gissningsspelet! ---");
System.out.println("1. Spela spelet");
System.out.println("2. Lowscore lista");
System.out.println("3. Avsluta");
System.out.print("Välj: ");
if (scanner.hasNextInt()) {
    choice = scanner.nextInt();
    scanner.nextLine();

    switch(choice) {
        // Spela spelet.
        case 1:
        GuessGame guessGame = new GuessGame(lowScore);
        guessGame.startGame();
        break;
    
        // Visar Lowscore.
        case 2:
        if (lowScore.isEmpty()) {
            System.out.println("\nLowscore-listan är tom. Spela spelet!");
        }
        else {
            lowScore.scorePrint();
        }
        break;
        
        // Avslutar programmet.
        case 3:
        System.out.println("\nProgrammet avslutas, välkommen åter!");
        scanner.close();
        isRunning = false;
        break;
        
        // Felhantering (default, else och catch).
        default:
        System.out.println("\nFelaktig inmatning. Vänligen försök igen.");
        break;
    }
} else {
    System.out.println("\nFelaktig inmatning. Vänligen ange ett heltal: ");
    scanner.nextLine();
}
} catch (InputMismatchException e) {
    System.out.println("\nFelaktig inmatning. Vänligen ange ett heltal: ");
    scanner.nextLine();
}
}
}
}