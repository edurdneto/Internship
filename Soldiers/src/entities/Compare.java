package entities;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Compare {
	
	ArrayList<Soldier>listSoldierS;
	ArrayList<Soldier>listSoldierC;
	int hints;

	public Compare() {
		this.setHints(0);
		// TODO Auto-generated constructor stub
	}
	
	
	public ArrayList<Soldier> getListSoldierS() {
		return listSoldierS;
	}


	public void setListSoldierS(ArrayList<Soldier> listSoldierS) {
		this.listSoldierS = listSoldierS;
	}


	public ArrayList<Soldier> getListSoldierC() {
		return listSoldierC;
	}


	public void setListSoldierC(ArrayList<Soldier> listSoldierC) {
		this.listSoldierC = listSoldierC;
	}


	public int getHints() {
		return hints;
	}


	public void setHints(int hints) {
		this.hints = hints;
	}
	
	public void createSoldierListS(){
		String csvFile = "/Users/eduardo/Downloads/soldiers-2files/soldiers.csv";
		BufferedReader br = null;
		
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<Soldier>myArray=new ArrayList<Soldier>();
		
		try{
			br = new BufferedReader(new FileReader(csvFile));
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] temp= line.split(cvsSplitBy);
				Soldier s=new Soldier();	
				s.setLname(temp[0]);
				s.setFname(temp[1]);
				s.setRegimental(temp[4]);
				myArray.add(s);
				this.setListSoldierS(myArray);
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
	}

	
	public void createSoldierListC(){
		String csvFile = "/Users/eduardo/Downloads/soldiers-2files/casualties.csv";
		BufferedReader br = null;
		
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<Soldier>myArray=new ArrayList<Soldier>();
		
		try{
			br = new BufferedReader(new FileReader(csvFile));
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] temp= line.split(cvsSplitBy);
				Soldier s=new Soldier();	
				s.setLname(temp[0]);
				s.setFname(temp[1]);
				s.setRegimental(temp[3]);
				myArray.add(s);
				this.setListSoldierC(myArray);
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
	}
	
	public void startCompare() throws IOException{
		String FILE_HEADER = "Lname,Fname,Freq,Times,Rank,Regiment";
		//String NEW_LINE_SEPARATOR = "\n";
		PrintWriter outputStream = null;
		this.createSoldierListS();
		this.createSoldierListC();
		int i=0;
		//FileWriter fileWriter = null;
		try {
			//fileWriter = new FileWriter("ListMatch.csv");
			//Write the CSV file header
			//fileWriter.append(FILE_HEADER.toString());
			//Add a new line separator after the header
			//fileWriter.append(NEW_LINE_SEPARATOR);
			outputStream= new PrintWriter(new FileOutputStream("match.txt"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outputStream.println(FILE_HEADER);
		while(i<this.listSoldierC.size()){
			findmatch(listSoldierC.get(i), this.getListSoldierS(),outputStream);
			i++;
			System.out.println(i);
		}
		outputStream.close();
		
	}


	public static int compare(Soldier s1, Soldier s2){
		int m=0;
		//Just checking Lname and Fname
		if(s1.getLname().equals(s2.getLname())&&s1.getFname().equals(s2.getFname())&&s1.getRegimental().equals(s2.getRegimental()))m=1;
		return m;
	}
	
	public void findmatch(Soldier s, ArrayList<Soldier> listSoldier, PrintWriter outputStream) throws IOException {
		String COMMA_DELIMITER = ",";
		String NEW_LINE_SEPARATOR = "\n";
		//String FILE_HEADER = "Lname,Fname,Freq,Times,Rank,Regiment";
		//FileWriter fileWriter = null;
		
		
			//fileWriter = new FileWriter("ListMatch.csv");
			 
			//Write the CSV file header
			//fileWriter.append(FILE_HEADER.toString());
			//Add a new line separator after the header
			//fileWriter.append(NEW_LINE_SEPARATOR);
			
			int i=0,found=-1;
			int count=this.getHints();
			
			String firstletter=String.valueOf(s.getLname().charAt(0));
			System.out.println(s.getLname());
			
			while(!(String.valueOf(listSoldier.get(i).getLname().charAt(0)).equals(firstletter))){
				i++;
			}
			System.out.println(firstletter);
			while((String.valueOf(listSoldier.get(i).getLname().charAt(0)).equals(firstletter))&&found==-1&&i<listSoldier.size()-1){
				if(listSoldier.get(i).getLname().equals(s.getLname())&&listSoldier.get(i).getFname().equals(s.getFname())&&listSoldier.get(i).getRegimental().equals(s.getRegimental())){
					found=1;
					count++;
					this.setHints(count);
					System.out.println("soldier:"+s.getLname()+","+s.getFname()+","+s.getRegimental());
					//outputStream.append(s.getLname());
					//outputStream.append(COMMA_DELIMITER);
					//outputStream.append(s.getFname());
					//outputStream.append(COMMA_DELIMITER);
					//outputStream.append(String.valueOf(s.getRegimental()));
					//outputStream.append(NEW_LINE_SEPARATOR);
					outputStream.println(s.getLname()+","+s.getFname()+","+String.valueOf(s.getRegimental()));
				}
				i++;
			}

			
		

		
	}

}
