public class Player {
    /*  En egen klass för att registrera spelare. 
        För att det ska bli enklare att sortera LowScore-listan. */
    
    private String name;
    private int score;

// Constructor
public Player(String name, int score) {
    this.name = name;
    this.score = score;
}
// Getters & Setters
public String getName() {
    return name;
}
public void setName (String name) {
    this.name = name;
}
public int getScore() {
    return score;
}
public void setScore (int score) {
    this.score = score;
}
}
