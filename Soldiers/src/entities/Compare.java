package entities;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
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
				s.setRank(temp[3]);
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
				s.setRank(temp[4]);
				s.setRegimental(temp[3]);
				myArray.add(s);
				this.setListSoldierC(myArray);
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
	}
	
	public void createSoldierListC_noMatch(){
		String csvFile = "/Users/eduardo/Desktop/Internship/Soldiers/NotMatch.csv";
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
				s.setRank(temp[3]);
				s.setRegimental(temp[2]);
				myArray.add(s);
				this.setListSoldierC(myArray);
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
	}
	
	public void createSoldierListC_noMatch2(){
		String csvFile = "/Users/eduardo/Desktop/Internship/Soldiers/NotMatch_2sdLvl.csv";
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
				s.setRank(temp[3]);
				s.setRegimental(temp[2]);
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
		PrintWriter outputStream = null;
		PrintWriter outputStream2 = null;
		this.createSoldierListS();
		//this.createSoldierListC(); //Full file comparetion
		//this.createSoldierListC_noMatch(); //compare only with noMatch
		this.createSoldierListC_noMatch2();
		int i=0;
		try {
			outputStream= new PrintWriter(new FileOutputStream("match_3sLvl.csv"));
			outputStream2= new PrintWriter(new FileOutputStream("NotMatch_3sdLvl.csv"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outputStream.println(FILE_HEADER);
		outputStream2.println(FILE_HEADER);
		while(i<this.listSoldierC.size()){
			findmatch(listSoldierC.get(i), this.getListSoldierS(),outputStream,outputStream2,2); //first name compare
			System.out.println(i);
			i++;
		
		}
		outputStream.close();
		outputStream2.close();
		
	}


	public static int compare(Soldier s1, Soldier s2){
		int m=0;
		//Just checking Lname and Fname
		if(s1.getLname().equals(s2.getLname())&&s1.getFname().equals(s2.getFname())&&s1.getRegimental().equals(s2.getRegimental()))m=1;
		return m;
	}
	
	public void findmatch(Soldier s, ArrayList<Soldier> listSoldier, PrintWriter outputStream,PrintWriter outputStream2) throws IOException {
		int i=0,found=-1;
		String COMMA_DELIMITER = ",";
		String NEW_LINE_SEPARATOR = "\n";
		
		int count=this.getHints();
			
		String firstletter=String.valueOf(s.getLname().charAt(0));
			
		while(!(String.valueOf(listSoldier.get(i).getLname().charAt(0)).equals(firstletter))){
			i++;
		}
		while((String.valueOf(listSoldier.get(i).getLname().charAt(0)).equals(firstletter))&&found==-1&&i<listSoldier.size()-1){
			if(listSoldier.get(i).getLname().equals(s.getLname())&&listSoldier.get(i).getFname().equals(s.getFname())&&listSoldier.get(i).getRegimental().equals(s.getRegimental())){
				found=1;
				count++;
				this.setHints(count);
				//outputStream.println(s.getLname()+","+s.getFname()+","+String.valueOf(s.getRegimental()));
				outputStream.append(s.getLname());
				outputStream.append(COMMA_DELIMITER);
				outputStream.append(s.getFname());
				outputStream.append(COMMA_DELIMITER);
				outputStream.append(s.getRegimental());
				outputStream.append(COMMA_DELIMITER);
				outputStream.append(s.getRank());
				outputStream.append(COMMA_DELIMITER);
				outputStream.append("0");
				outputStream.append(NEW_LINE_SEPARATOR);
			} 
			i++;
		}
		if(found==-1) {
			outputStream2.append(s.getLname());
			outputStream2.append(COMMA_DELIMITER);
			outputStream2.append(s.getFname());
			outputStream2.append(COMMA_DELIMITER);
			outputStream2.append(s.getRegimental());
			outputStream2.append(COMMA_DELIMITER);
			outputStream2.append(s.getRank());
			outputStream2.append(COMMA_DELIMITER);
			outputStream2.append("0");
			outputStream2.append(NEW_LINE_SEPARATOR);
		}

	}
	
	public void findmatch(Soldier s, ArrayList<Soldier> listSoldier, PrintWriter outputStream, PrintWriter outputStream2, int type) throws IOException {
		int i=0,found=-1;
		String COMMA_DELIMITER = ",";
		String NEW_LINE_SEPARATOR = "\n";
		
		int count=this.getHints();
			
		String firstletter=String.valueOf(s.getLname().charAt(0));
		String soldier1="";
		String soldier2="";
			
		while(!(String.valueOf(listSoldier.get(i).getLname().charAt(0)).equals(firstletter))){
			i++;
		}
		switch (type){
			case 1:
				while((String.valueOf(listSoldier.get(i).getLname().charAt(0)).equals(firstletter))&&found==-1&&i<listSoldier.size()-1){
					soldier1=listSoldier.get(i).getFname();
					String temp[]=soldier1.split(" ");
					soldier2=s.getFname();
					String temp2[]=soldier2.split(" ");
					if(listSoldier.get(i).getLname().equals(s.getLname())&&listSoldier.get(i).getRegimental().equals(s.getRegimental())){
						if(temp[0].equals(temp2[0])){
							found=1;
							count++;
							this.setHints(count);
							//outputStream.println(s.getLname()+","+s.getFname()+","+String.valueOf(s.getRegimental()));
							outputStream.append(s.getLname());
							outputStream.append(COMMA_DELIMITER);
							outputStream.append(s.getFname());
							outputStream.append(COMMA_DELIMITER);
							outputStream.append(s.getRegimental());
							outputStream.append(COMMA_DELIMITER);
							outputStream.append(s.getRank());
							outputStream.append(COMMA_DELIMITER);
							outputStream.append("0");
							outputStream.append(NEW_LINE_SEPARATOR);
						}
					}
					i++;
				}
				if(found==-1) {
					outputStream2.append(s.getLname());
					outputStream2.append(COMMA_DELIMITER);
					outputStream2.append(s.getFname());
					outputStream2.append(COMMA_DELIMITER);
					outputStream2.append(s.getRegimental());
					outputStream2.append(COMMA_DELIMITER);
					outputStream2.append(s.getRank());
					outputStream2.append(COMMA_DELIMITER);
					outputStream2.append("0");
					outputStream2.append(NEW_LINE_SEPARATOR);
				}

			break;
			case 2:
				while((String.valueOf(listSoldier.get(i).getLname().charAt(0)).equals(firstletter))&&found==-1&&i<listSoldier.size()-1){
					soldier1=listSoldier.get(i).getFname();
					String temp[]=soldier1.split(" ");
					soldier2=s.getFname();
					String temp2[]=soldier2.split(" ");
					if(listSoldier.get(i).getLname().equals(s.getLname())&&listSoldier.get(i).getRegimental().equals(s.getRegimental())){
						if(!(temp[0].equals("")||temp2[0].equals(""))) {
							String FL_1=String.valueOf(temp[0].charAt(0));
							String FL_2=String.valueOf(temp2[0].charAt(0));
							if(FL_1.equals(FL_2)){
								found=1;
								count++;
								this.setHints(count);
								//outputStream.println(s.getLname()+","+s.getFname()+","+String.valueOf(s.getRegimental()));
								outputStream.append(s.getLname());
								outputStream.append(COMMA_DELIMITER);
								outputStream.append(s.getFname());
								outputStream.append(COMMA_DELIMITER);
								outputStream.append(s.getRegimental());
								outputStream.append(COMMA_DELIMITER);
								outputStream.append(s.getRank());
								outputStream.append(COMMA_DELIMITER);
								outputStream.append("0");
								outputStream.append(NEW_LINE_SEPARATOR);
							}
						}
					}
					i++;
				}
				if(found==-1) {
					outputStream2.append(s.getLname());
					outputStream2.append(COMMA_DELIMITER);
					outputStream2.append(s.getFname());
					outputStream2.append(COMMA_DELIMITER);
					outputStream2.append(s.getRegimental());
					outputStream2.append(COMMA_DELIMITER);
					outputStream2.append(s.getRank());
					outputStream2.append(COMMA_DELIMITER);
					outputStream2.append("0");
					outputStream2.append(NEW_LINE_SEPARATOR);
				}

			break;

		}
	}


}
