
public class gameletter {
	public String word(){
		String[] words = {"HANGMAN", "FERRARI", "HARMONIUM", "MERCEDES", "WRESTLING", "LIBERTY", "HARMONY", "CONSTITUTION", "LETTERBOX", "ACTIVATION", "HIMALAYA"};
		int index = (int)(Math.random() * 11);
		String s = words[index];
		return s;
	}
}
