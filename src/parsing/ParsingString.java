package parsing;
import java.util.Arrays;
import java.util.Vector;

public class ParsingString {
	
	public static Vector<Vector<String>> split2time(String sentence, String firstSplit, String secondSplit){
		String[] stringArray = sentence.split(firstSplit);
		String[] intern;
		Vector<String> vectIntern;
		Vector <Vector<String>> result = new Vector <Vector <String>>();
		for (int i = 0; i < stringArray.length; i++) {
			intern = stringArray[i].split(secondSplit);
			vectIntern = new Vector<String>(Arrays.asList(intern));
			result.add(vectIntern);
		}
		
		return result;
	}
	public static Vector<String> split(String sentence, String split){
		String[] stringArray = sentence.split(split);
		Vector<String> result = new Vector<String>(Arrays.asList(stringArray));
		
		return result;
	}
}
