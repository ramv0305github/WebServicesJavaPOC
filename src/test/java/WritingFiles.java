import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WritingFiles {

	public static void main(String[] args) throws IOException 
	{
		File f = new File("C:\\filewriting\\myTextFile.txt");
		FileWriter fw = new FileWriter(f,true);
		BufferedWriter bfw = new BufferedWriter(fw);
		
		bfw.newLine();
		bfw.write("First Line");
		bfw.newLine();
		bfw.write("India");
		bfw.close();
		System.out.println("File created");
 
	}

}
