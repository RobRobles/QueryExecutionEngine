import java.util.Vector;


public class Project extends Operator {

	Operator tempOp; 
	fileOpen file; 
	Vector<String> tempVec; 
	boolean fileFound = false;

	public boolean Open(String fileName, Vector<String> fieldNames)
	{
		fileFound = true; 
		tempVec = fieldNames; 
		file = new fileOpen(fileName, pageSize); 
		return true; 
	}

	public boolean Open(Operator op, Vector<String> fieldNames)
	{ 
		fileFound = false; 
		tempVec = fieldNames; 
		tempOp = op; 
		return true;
	}

	public Vector<Record> Next()
	{
		Vector<Record> outPut = new Vector<Record>(); 

		//handling the first Open method
		if(fileFound == true)
		{
			Vector<Record> proj = file.Next(); 
			Record r = null; 

			//grabbing the 
			for(int a = 0; a < proj.size(); a++)
			{
				//System.out.println("proj: " + proj.get(a)); 
				String[] t = proj.get(a).toString().split(" ");
				String hold = "";
				for(int c = 0; c < tempVec.size(); c++)
				{
					for(int b = 0; b < t.length; b++)
					{
						if(tempVec.get(c).equals(t[b]))
						{
							hold = hold + " " + t[b+2]; 
						}
					}
				}
				r = new Record(); 
				r.addRecord(hold);
				outPut.add(r); 
			}
		}
		else 
		{			
			Vector<Record> proj = tempOp.Next(); 
			Record r = null; 

			//grabbing the 
			for(int a = 0; a < proj.size(); a++)
			{
				//System.out.println("proj: " + proj.get(a)); 
				String[] t = proj.get(a).toString().split(" ");
				String hold = "";
				for(int c = 0; c < tempVec.size(); c++)
				{
					for(int b = 0; b < t.length; b++)
					{
						if(tempVec.get(c).equals(t[b]))
						{
							hold = hold + " " + t[b+2]; 
						}
					}
				}
				r = new Record(); 
				r.addRecord(hold);
				outPut.add(r); 
			}
		}

		return outPut;
	}

	public void Close()
	{
		file.Close(); 
	}

	public static void main(String[] args)
	{
		Vector<String> names = new Vector<String>();
		names.add("FirstName");
		names.add("LastName");
		names.add("GPA");
		Project op1 = new Project();
		op1.Open("record.txt", names);
		Vector<Record> page;

		do {
			page = op1.Next();
			for (Record r : page) {
				System.out.println(r.toString());
			}
		}while (page.size() > 0);
		op1.Close();
	}
}