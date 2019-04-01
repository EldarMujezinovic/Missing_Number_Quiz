import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
		if (!nicknameExist(nickname) && nicknameValid(nickname)) {
			this.nickname = nickname;
			this.score = score;
			users.add(this);
			System.out.println("Your nickname is: " + nickname);
		}

	}

	public static boolean nicknameValid(String name) {
		boolean isLetter = false;
		for (int i = 0; i < name.length(); i++) {
			if (Character.isLetter(name.charAt(i))) {
				isLetter = true;
			} else {
				isLetter = false;
				break;
			}
		}
		if (name.length() >= 3 && isLetter) {
			return true;
		} else {
			System.out.println("Nickname must have 3 or more letters and can contain only letters!");
		}
		return false;

	}

	public static boolean userIsValid(String name) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).nickname.equals(name)) {
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

	public void printAllUsers() {
		for (int i = 0; i < users.size(); i++) {
			if (Character.isLetter(users.get(i).nickname.charAt(i))) {
				userNames.add(users.get(i).nickname);
			}
		}
		System.out.println(userNames);
	}

	public void printUserDetails(String name) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).nickname.equals(name)) {
				System.out.println(users.get(i).toString());
				return;
			}
		}
	}

	public static void increaseUserScore(String name, int amount) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).nickname.equals(name)) {
				users.get(i).score += amount;
			}
		}
	}

	public static void scoreList() {
		Map<String, Integer> scoreMap = new HashMap<>();
		for (int i = 0; i < users.size(); i++) {
			scoreMap.put(users.get(i).nickname, users.get(i).score);
		}

		List<Entry<String, Integer>> list = new LinkedList<>(scoreMap.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return -o1.getValue().compareTo(o2.getValue());
			}

		});
		int brojac = 1;
		for(Entry<String, Integer> item : list){
			System.out.println(brojac + ". " + item);
			brojac++;
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
