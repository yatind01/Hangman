
public class gameletter {
	public String word(){
		String[] words = {"HANGMAN", "FERRARI", "HARMONIUM", "MERCEDES", "WRESTLING", "LIBERTY", "HARMONY", "CONSTITUTION", "LETTERBOX", "ACTIVATION", "HIMALAYA", "NUMBSKULL", "ZOMBIE", "MYSTERIOUS", "ADVENTUROUS", "POLKADOTS", "QUADCORE", "FLUFFINESS"};
		int index = (int)(Math.random() * 18);
		String s = words[index];
		return s;
	}
}
