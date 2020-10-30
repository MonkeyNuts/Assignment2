
import java.io.Serializable;

//code to calculate the users score to be put into the database
public class UserScore implements Serializable{

    
    private int id;
    String playerName;
    
    public UserScore() {
    }
    public UserScore(Character user, String playerName){
        super();
        score = user.hp/100 * user.accuracy * user.inRoom;
        this.playerName = playerName;
    }
        public String getPlayerName(){
        return playerName;
    }
    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }
    
    double score;
    
    public double getScore(){
        return score;
    }
    public void setScore(double score){
        this.score = score;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
