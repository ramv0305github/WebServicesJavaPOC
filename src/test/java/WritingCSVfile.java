import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WritingCSVfile 
{

	public static void main(String[] args) throws IOException
	{
		File f = new File("C:\\filewriting\\myTextFile.csv");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bfw = new BufferedWriter(fw);
		
		bfw.write("API Description");
		bfw.newLine();
		bfw.write("Add Place");
		bfw.newLine();
		bfw.write("Get Place");
		bfw.newLine();
		bfw.write("Update Place");
		bfw.newLine();
		bfw.write("Get Place");
		bfw.newLine();
		bfw.write("Delete Place");
		bfw.newLine();
		bfw.write("Get Place");
		bfw.close();
		System.out.println("CSV File created");

	}

}
