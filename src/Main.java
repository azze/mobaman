import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ListIterator;

public class Main{
	static ManagerFrame start;
	static DataBase database;
	
	public static void main(String[] args) throws IOException{
		
		database= new DataBase();
		loadData();
		start = new ManagerFrame("MOBAmanager",database);
	}

	private static void loadData() throws IOException  {
		List data = Files.readAllLines(Paths.get("her.txt",new String[0]));
		ListIterator dataitr = data.listIterator();
		String temp="";
		int k =0;
		while(dataitr.hasNext()){
			String curr = (String) dataitr.next();
			if(temp=="")
				temp=curr;
			else{
				String[] stat =curr.split(",");
				Hero h=new Hero(k,temp,stat);
				database.heroes.add(h);
				temp="";
			}
			k++;
		}
		List pnameData = Files.readAllLines(Paths.get("pnames", new String[0]));
		ListIterator pnameDataItr = pnameData.listIterator();
		while(pnameDataItr.hasNext()){
			
			database.pnames.add((String) pnameDataItr.next());
		}
		List tnameData = Files.readAllLines(Paths.get("tnames", new String[0]));
		ListIterator tnameDataItr = tnameData.listIterator();
		while(tnameDataItr.hasNext())
			database.tnames.add((String) tnameDataItr.next());	
		
		
	}
}
