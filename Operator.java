import java.util.Vector;

public abstract class Operator 
{
	public boolean Open(String fileName, Vector<String> fieldNames) {return false;}
	public boolean Open(Operator op,     Vector<String> fieldNames) {return false;}

	public abstract Vector<Record> Next(); 
	public abstract void Close(); 

	protected int pageSize = 10; 
}
