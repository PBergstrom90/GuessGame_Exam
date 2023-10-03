import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

// Klass för att visa och registrera Lowscore.
public class LowScore {
    
    // Skapar en lista av "Player-objekt" från Player-klassen.
    private List<Player> players = new ArrayList<>();

    public void addScore(String playerName, int playerScore) {
        Player player = new Player(playerName, playerScore);
        players.add(player);
    }
    public boolean isEmpty() {
        // Om listan är tom, returnera detta som true.
        return players.isEmpty();
    }
    
    // Printmetod för att skriva ut lowscore-listan.    
    public void scorePrint () {
        // Sorterar poängställningen i playerlistan.
        Collections.sort(players, (p1, p2) -> Integer.compare(p1.getScore(), p2.getScore()));
        System.out.println("\n--- TOP 5 LOWSCORE-LISTA ---");
        System.out.println("1 poäng = 1 försök.");
        
        // Ser till så att Lowscore-listan visar max 5st inlägg.
        int maxEntries = Math.min(5, players.size());
        // Skriver ut spelarna i listan.
        for (int i = 0; i < maxEntries; i++) {
            Player player = players.get(i);
            String playerName = player.getName();
            int score = player.getScore();
        
            System.out.println("\nNAMN: " + playerName);
            System.out.println("POÄNG: " + score);
        }
    }
}