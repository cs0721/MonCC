import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileDataController 
{
	
	public FileDataController()
	{
		
	
	}
	
	public String readFile(String filename)
	{
		StringBuilder texts = new StringBuilder();
		
		try 
		{
			FileReader inputFile = new FileReader(filename);
			Scanner parser = new Scanner(inputFile);
			
			while (parser.hasNextLine())
            {
                String line = parser.nextLine();
                texts.append(line + ";");
            }
            
            inputFile.close();
            parser.close();
            return texts.toString();
			
		}
		
		catch(FileNotFoundException exception) 
		{
			String error = filename + " not found";
            System.out.println(error);
            return error;
		}
		
		catch(IOException exception) 
        {
            String error = "Unexpected I/O error occured";
            System.out.println(error); 
            return error;
        }    
	}
}

