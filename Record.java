import java.util.ArrayList;

public class Record {

	//Holding Names, Types, and Values
	ArrayList<String> Name  = new ArrayList<String>(); 
	ArrayList<String> Type  = new ArrayList<String>();
	ArrayList<String> Value = new ArrayList<String>(); 
	ArrayList<String> done  = new ArrayList<String>(); 

	public Record(){}
	
	public void add(String name, String type, String value)
	{
		Name.add(name);
		Type.add(type); 
		Value.add(value); 
	}
	
	public void addRecord(String completeRecord)
	{
		done.add(completeRecord); 
	}

	@Override 
	public String toString()
	{
		String temp = ""; 

		for(int a = 0; a < done.size(); a++)
		{
			temp = done.get(a); 
		}
		
		return temp;
	}
}
