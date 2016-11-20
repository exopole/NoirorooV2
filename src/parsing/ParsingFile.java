package parsing;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class ParsingFile {
	public static Vector<String> readFile(String nameFile){
		Vector<String> result = new Vector<String>();
		try {
			Scanner scanner = new Scanner(new FileInputStream(nameFile), "UTF-8");
			
			while (scanner.hasNextLine()){ 
				result.addElement(scanner.nextLine());;
				
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
        
        public static String readFileInString(String nameFile){
		String result = "";
		try {
			Scanner scanner = new Scanner(new FileInputStream(nameFile), "UTF-8");
			
			while (scanner.hasNextLine()){ 
				result += scanner.nextLine();
				
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
        
        public static void writeFileWithString(String contenant, String path) throws IOException{
            FileWriter file = new FileWriter(path);
            file.write(contenant);
            file.flush();
            file.close();
        }
}
