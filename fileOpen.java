import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class fileOpen {

	//initialzing the scanner
	Scanner input; 
	//page Size
	int pSize; 
	//Grabbing the first three lines of the schema 
	String[] name; 
	String[] type; 
	String   buff;  
	//ArrayList student data
	ArrayList<String> data; 

	public fileOpen(String fileName, int pSize)
	{
		File file = new File("record.txt"); 
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + file + " error: " + e);
		} 

		name = input.nextLine().split(","); 
		type = input.nextLine().split(","); 
		buff = input.nextLine(); 
		this.pSize = pSize; 
	}
	
	public Vector<Record> Next()
	{
		Vector<Record> recordKeeper = new Vector<Record>(); 
		String tempHolder = ""; 
		data = new ArrayList<String>();

		//getting the rest of the records to data to move away from the text file 
		for(int start = 0; start < pSize && input.hasNextLine(); start++)
		{
			String[] parse = input.nextLine().split(","); 

			for(int a = 0; a < parse.length; a++)
			{
				tempHolder = tempHolder + parse[a] + " "; 
			}
			data.add(tempHolder);
			tempHolder = ""; 
		}

		//adding the file names and types to it values and adding that as a record to recordKeeper
		for(int b = 0; b < data.size(); b++)
		{
			Record record = new Record(); 
			String t = ""; 
			String[] p = data.get(b).split(" ");
			for(int c = 0; c < p.length; c++)
			{
				t = t + name[c] + " " + type[c] + " " + p[c] + " "; 
			}
			record.addRecord(t);
			recordKeeper.add(record);
		}
	
		System.out.println(recordKeeper.size()); 

		return recordKeeper;
	}

	public void Close()
	{
		//closing the scanner 
		input.close(); 
	}

	public static void main(String[] args) 
	{
		//		fileOpen fO = new fileOpen("record.txt", 10);
		//		fO.Next(); 
		//		fO.Close(); 
	}
}
