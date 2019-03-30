import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class User {

	static boolean isValid = false;
	static ArrayList<User> users = new ArrayList<>();
	static Set<String> userNames = new TreeSet<>();
	private String nickname;
	private int score;

	public User() {

	}

	public User(String nickname, int score) {
		if (!nicknameExist(nickname)) {
			this.nickname = nickname;
			this.score = score;
			users.add(this);
			System.out.println("Your nickname is: " + nickname);
		}
		
	}

	
	public static boolean userIsValid(String name){
		for(int i = 0; i < users.size(); i++){
			if(users.get(i).nickname.equals(name)){
				return true;
			}
		}
		return false;
	}

	public boolean nicknameExist(String name) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).nickname.equals(name)) {
				System.out.println("Sorry, but " + name + " is already in use.");
				return isValid = true;
			}
		}
		return isValid;
	}

	public void printScore(int score) {

		if (score <= 10) {
			System.out.println("Next time, give your best..");
			System.out.println("TOTAL SCORE: " + score);
		} else if (score >= 10 && score < 20) {
			System.out.println("You can do it better!");
			System.out.println("TOTAL SCORE: " + score);
		} else if (score >= 30 && score < 40) {
			System.out.println("Almost perfect!");
			System.out.println("TOTAL SCORE: " + score);
		} else if (score >= 40 && score < 50) {
			System.out.println("WELL DONE!");
			System.out.println("TOTAL SCORE: " + score);
		} else if (score == 50) {
			System.out.println("YOU ARE GENIUS!");
			System.out.println("TOTAL SCORE:  " + score);
		} else if(score > 50){
			System.out.println("TOTAL SCORE: " + score);
		}

	}
	
	public void printAllUsers(){
		for(int i = 0; i < users.size(); i++){
			if(Character.isLetter(users.get(i).nickname.charAt(i))){
				userNames.add(users.get(i).nickname);
			}
		}
		System.out.println(userNames);
	}
	
	public void printUserDetails(String name){
		for(int i = 0; i < users.size(); i++){
			if(users.get(i).nickname.equals(name)){
				System.out.println(users.get(i).toString());
				return;
			}
		}
	}
	
	public static void increaseUserScore(String name, int amount){
		for(int i = 0; i < users.size(); i++){
			if(users.get(i).nickname.equals(name)){
				users.get(i).score += amount;
			}
		}
	}
	
	
	@Override
	public String toString() {
		return "User [nickname=" + nickname + ", score=" + score + "]";
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
