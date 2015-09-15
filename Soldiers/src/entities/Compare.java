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
	
	public void selectBsoldiers(){
		String csvFile = "/Users/eduardo/Desktop/Internship/Soldiers/bin/res/casualties.csv";
		String FILE_HEADER = "Surname,Given Name(s),Initials,Service #,Rank,Regiment,Death Date,Cemetery";
		String COMMA_DELIMITER = ",";
		String NEW_LINE_SEPARATOR = "\n";
		BufferedReader br = null;
		PrintWriter outputStream = null;
		
		
		String line = "";
		String cvsSplitBy = ",";
		
		try{
			br = new BufferedReader(new FileReader(csvFile));
			line = br.readLine();
			outputStream= new PrintWriter(new FileOutputStream("casualties_B.csv"));
			outputStream.println(FILE_HEADER);
			
			while ((line = br.readLine()) != null) {
				String[] temp= line.split(cvsSplitBy);
				String firstletter;
				
				if(!(temp[0].equals(""))){
					firstletter=String.valueOf(temp[0].charAt(0));
					if(firstletter.equals("B")||firstletter.equals("b")){
						outputStream.append(temp[0]);
						outputStream.append(COMMA_DELIMITER);
						outputStream.append(temp[1]);
						outputStream.append(COMMA_DELIMITER);
						outputStream.append(temp[2]);
						outputStream.append(COMMA_DELIMITER);
						outputStream.append(temp[3]);
						outputStream.append(COMMA_DELIMITER);
						outputStream.append(temp[4]);
						outputStream.append(COMMA_DELIMITER);
						outputStream.append(temp[5]);
						outputStream.append(COMMA_DELIMITER);
						outputStream.append(temp[6]);
						outputStream.append(COMMA_DELIMITER);
						outputStream.append(temp[7]);
						outputStream.append(NEW_LINE_SEPARATOR);
					}
				}
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		outputStream.close();
		
	}
	
	public void createSoldierListS(){
		String csvFile = "/Users/eduardo/Desktop/Internship/Soldiers/bin/res/soldiers.csv";
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
		String csvFile = "/Users/eduardo/Desktop/Internship/Soldiers/bin/res/casualties_B.csv";
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
	
	public void createSoldierListCM(){
		String csvFile = "/Users/eduardo/Desktop/Internship/Soldiers/match_B_2Lvl.csv";
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
				//s.setRank(temp[4]);
				s.setRegimental(temp[2]);
				myArray.add(s);
				this.setListSoldierC(myArray);
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
	}
	
	public void createSoldierListK(){
		String csvFile = "/Users/eduardo/Desktop/Linked Casualties Bnames Aug 25 2014-MOD.csv";
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
				s.setLname(temp[20]);
				s.setFname(temp[21]);
				//s.setRank(temp[4]);
				s.setRegimental(temp[23]);
				myArray.add(s);
				this.setListSoldierS(myArray);
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
	}
	
	public void createSoldierListC_noMatch(){
		String csvFile = "/Users/eduardo/Desktop/Internship/Soldiers/NotMatch_B_1Lvl.csv";
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
		String csvFile = "/Users/eduardo/Desktop/Internship/Soldiers/NotMatch_B_2Lvl.csv";
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
	
	public void createSoldierListC_noMatch3(){
		String csvFile = "/Users/eduardo/Desktop/Internship/Soldiers/NotMatch_B_3Lvl.csv";
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
		String FILE_HEADER = "Lname,Fname,Regiment,RankCasualtie,RankSoldier,Junk";
		PrintWriter outputStream = null;
		PrintWriter outputStream2 = null;
		this.createSoldierListCM();
		//this.createSoldierListC(); //Full file comparetion
		//this.createSoldierListC_noMatch(); //compare only with noMatch
		//this.createSoldierListC_noMatch2();
		//this.createSoldierListC_noMatch3();
		this.createSoldierListK();
		System.out.println(this.listSoldierC.size());
		System.out.println(this.listSoldierS.size());
		int i=0;
		try {
			outputStream= new PrintWriter(new FileOutputStream("match_linksSecV2.csv"));
			outputStream2= new PrintWriter(new FileOutputStream("NotMatch_linksSecV2.csv"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outputStream.println(FILE_HEADER);
		outputStream2.println(FILE_HEADER);
		while(i<this.listSoldierS.size()){
			findmatch(listSoldierS.get(i), this.getListSoldierC(),outputStream,outputStream2,5); //first name compare
			//System.out.println(i);
			//System.out.println(listSoldierC.get(i).getLname()+"="+listSoldierC.get(i).getFname()+"="+listSoldierC.get(i).getRegimental());
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
			if(!(s.getRegimental().equals(""))){ //to noMiss !(s.getRegimental().equals(""))
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
					outputStream.append(listSoldier.get(i).getRank());
					outputStream.append(COMMA_DELIMITER);
					outputStream.append("0");
					outputStream.append(NEW_LINE_SEPARATOR);
				}
			}
			else {
				found=0;
				System.out.println("oi=================");
			}
			i++;
		}
		if(found==-1||found==0) { //to special case found==2 to noMiss found==-1||found==0
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
		String soldier1_LN="";
		String soldier2_LN="";
		/*	
		while(!(String.valueOf(listSoldier.get(i).getLname().charAt(0)).equals(firstletter))){
			i++;
		}*/
		switch (type){
			case 1:
				while((String.valueOf(listSoldier.get(i).getLname().charAt(0)).equals(firstletter))&&found==-1&&i<listSoldier.size()-1){
					soldier1=listSoldier.get(i).getFname();
					String temp[]=soldier1.split(" ");
					soldier2=s.getFname();
					String temp2[]=soldier2.split(" ");
					
					if(listSoldier.get(i).getLname().equals(s.getLname())&&listSoldier.get(i).getRegimental().equals(s.getRegimental())){
						System.out.println("zz");
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
				if(found==-1||found==0) {
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
							if(i<10){
								System.out.println(s.getFname()+","+listSoldier.get(i).getFname());
								
							}
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
				if(found==-1||found==0) {
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
			
			case 3:
				while((String.valueOf(listSoldier.get(i).getLname().charAt(0)).equals(firstletter))&&found==-1&&i<listSoldier.size()-1){
					soldier1=listSoldier.get(i).getFname();
					String temp[]=soldier1.split(" ");
					soldier2=s.getFname();
					String temp2[]=soldier2.split(" ");
					soldier1_LN=listSoldier.get(i).getLname();
					String temp3[]=soldier1_LN.split(" ");
					soldier2_LN=s.getLname();
					String temp4[]=soldier2_LN.split(" ");
					
					if(listSoldier.get(i).getRegimental().equals(s.getRegimental())){
						if(!(temp3[0].equals("")||temp4[0].equals(""))){
							String FL_3=String.valueOf(temp3[0].charAt(0));
							String FL_4=String.valueOf(temp4[0].charAt(0));
							if(FL_3.equals(FL_4)){
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
										outputStream.append(listSoldier.get(i).getLname());
										outputStream.append(COMMA_DELIMITER);
										outputStream.append(listSoldier.get(i).getFname());
										outputStream.append(COMMA_DELIMITER);
										outputStream.append(s.getRegimental());
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
						}
					}
					i++;
				}
				if(found==-1||found==0) {
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
			case 4:
				while((String.valueOf(listSoldier.get(i).getLname().charAt(0)).equals(firstletter))&&found==-1&&i<listSoldier.size()-1){
					soldier1_LN=listSoldier.get(i).getLname();
					String temp3[]=soldier1_LN.split(" ");
					soldier2_LN=s.getLname();
					String temp4[]=soldier2_LN.split(" ");
					
					if(listSoldier.get(i).getRegimental().equals(s.getRegimental())){
						if(!(temp3[0].equals("")||temp4[0].equals(""))){
							String FL_3=String.valueOf(temp3[0].charAt(0));
							String FL_4=String.valueOf(temp4[0].charAt(0));
							if(FL_3.equals(FL_4)){
								found=1;
								count++;
								this.setHints(count);
								//outputStream.println(s.getLname()+","+s.getFname()+","+String.valueOf(s.getRegimental()));
								outputStream.append(s.getLname());
								outputStream.append(COMMA_DELIMITER);
								outputStream.append(s.getFname());
								outputStream.append(COMMA_DELIMITER);
								outputStream.append(listSoldier.get(i).getLname());
								outputStream.append(COMMA_DELIMITER);
								outputStream.append(listSoldier.get(i).getFname());
								outputStream.append(COMMA_DELIMITER);
								outputStream.append(s.getRegimental());
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
				if(found==-1||found==0) {
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
			
			case 5:
				while(i<listSoldier.size()-1){
					
					if(listSoldier.get(i).getLname().equals(s.getLname())&&listSoldier.get(i).getRegimental().equals(s.getRegimental())&&listSoldier.get(i).getFname().equals(s.getFname())){
						System.out.println("zz");
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
				if(found==-1||found==0) {
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
	
	public void findmatch3(Soldier s, ArrayList<Soldier> listSoldier, PrintWriter outputStream, PrintWriter outputStream2) throws IOException {
		int i=0,found=-1;
		String COMMA_DELIMITER = ",";
		String NEW_LINE_SEPARATOR = "\n";
		
		int count=this.getHints();
		
			
		while(found==-1&&i<listSoldier.size()-1){
			if(!(s.getRegimental().equals(""))){
				if(listSoldier.get(i).getRegimental().equals(s.getRegimental())){
					
					found=1;
					count++;
					this.setHints(count);
					//outputStream.println(s.getLname()+","+s.getFname()+","+String.valueOf(s.getRegimental()));
					outputStream.append(s.getLname());
					outputStream.append(COMMA_DELIMITER);
					outputStream.append(s.getFname());
					outputStream.append(COMMA_DELIMITER);
					outputStream.append(listSoldier.get(i).getLname());
					outputStream.append(COMMA_DELIMITER);
					outputStream.append(listSoldier.get(i).getFname());
					outputStream.append(COMMA_DELIMITER);
					outputStream.append(s.getRegimental());
					outputStream.append(COMMA_DELIMITER);
					outputStream.append(s.getRank());
					outputStream.append(COMMA_DELIMITER);
					outputStream.append("0");
					outputStream.append(NEW_LINE_SEPARATOR);
				}
			}
			else {
					found=0;
					System.out.println("oi=================");
			}
			i++;
					
		}
		if(found==-1||found==0) {
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
	
	public void CompareServiceNumber() throws IOException{
		String FILE_HEADER = "LnameC,FnameC,LnameS,FnameS,Regiment,RankCasualtie,RankSoldier,Junk";
		PrintWriter outputStream = null;
		PrintWriter outputStream2 = null;
		this.createSoldierListS();
		this.createSoldierListC(); //Full file comparetion
		//this.createSoldierListC_noMatch(); //compare only with noMatch
		//this.createSoldierListC_noMatch3();
		int i=0;
		try {
			outputStream= new PrintWriter(new FileOutputStream("match_MService#_1sLvl.csv"));
			outputStream2= new PrintWriter(new FileOutputStream("NotMatch_MServie#_1sLvl.csv"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outputStream.println(FILE_HEADER);
		outputStream2.println(FILE_HEADER);
		while(i<this.listSoldierC.size()){
			findmatch(listSoldierC.get(i), this.getListSoldierS(),outputStream,outputStream2,1); //first name compare
			System.out.println(i);
			i++;
		
		}
		outputStream.close();
		outputStream2.close();
		
	}


}
