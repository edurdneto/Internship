/**
 * 
 */
package entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import java.lang.*;

/**
 * @author eduardo
 *
 */
public class Statistic {

	ArrayList<Name>names;
	private int Total;
	private int cMissingRank;
	private int cMissingFname;
	private int cMissingRegiment;
	
	
	public int getcMissingRegiment() {
		return cMissingRegiment;
	}

	public void setcMissingRegiment(int cMissingRegiment) {
		this.cMissingRegiment = cMissingRegiment;
	}

	/**
	 * 
	 */
	public Statistic() {
		names=new ArrayList<Name>();
		this.setTotal(0);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Name> getNames() {
		return names;
	}

	public void setNames(ArrayList<Name> names) {
		this.names = names;
	}
	
	public int getTotal() {
		return Total;
	}

	public void setTotal(int total) {
		Total = total;
	}
	

	
	public int getcMissingRank() {
		return cMissingRank;
	}

	public void setcMissingRank(int cMissingRank) {
		this.cMissingRank = cMissingRank;
	}
	
	public int getcMissingFname() {
		return cMissingFname;
	}

	public void setcMissingFname(int cMissingFname) {
		this.cMissingFname = cMissingFname;
	}
	
	public void createListNameTriplas(){
		String csvFile = "/Users/eduardo/Desktop/Internship/Soldiers/bin/res/match.csv";
		BufferedReader br = null;
		
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<Name>myArray=new ArrayList<Name>();
		
		try{
			br = new BufferedReader(new FileReader(csvFile));
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] temp= line.split(cvsSplitBy);
				Name n=new Name();
				n.setLname(temp[0]);
				n.setFname(temp[1]);
				//System.out.println(temp[2]);
				n.setRegiment(temp[2]);
				myArray.add(n);
				
			}
			this.setNames(myArray);
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
	}
		

	public void createListName(int type){
		//String csvFile = "/Users/eduardo/Downloads/soldiers-2files/Soldiers.csv";
		String csvFile = "/Users/eduardo/Downloads/soldiers-2files/casualties.csv";
		BufferedReader br = null;
		
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<Name>myArray=new ArrayList<Name>();
		
		try{
			br = new BufferedReader(new FileReader(csvFile));
			line = br.readLine();
			String PrevName[]=line.split(cvsSplitBy);
			int count=1,cMissingRank=0,cMissingFname=0, cMissingRegiment=0;
			while ((line = br.readLine()) != null) {
				String[] temp= line.split(cvsSplitBy);
				this.setTotal(this.getTotal()+1);
				switch(type){
				
				case 1:
					if(PrevName[0].equals(temp[0])){
					count++;
					myArray.get(myArray.size()-1).setTimes(count);
					//System.out.println("oi");
					}
					else {
						count=1;
						Name n=new Name();
						n.setLname(temp[0]);
						n.setTimes(count);
						myArray.add(n);
					}
					PrevName[0]=temp[0];
					break;
				case 2:
					if(PrevName[1].equals(""))cMissingFname++;
					
					if(PrevName[0].equals(temp[0])&&PrevName[1].equals(temp[1])){
						count++;
						myArray.get(myArray.size()-1).setTimes(count);
						//System.out.println("oi");
					}
					else {
						count=1;
						Name n=new Name();
						n.setLname(temp[0]);
						n.setFname(temp[1]);
						n.setTimes(count);
						myArray.add(n);
					}
					PrevName[0]=temp[0];
					PrevName[1]=temp[1];
					this.setcMissingFname(cMissingFname);
					break;
					
					
				case 3:
					
					if(PrevName[3].equals(""))cMissingRank++;
					else System.out.println(PrevName[3]);
					if(PrevName[0].equals(temp[0])&&PrevName[1].equals(temp[1])&&PrevName[3].equals(temp[3])){
						count++;
						myArray.get(myArray.size()-1).setTimes(count);
						//System.out.println("oi");
					}
					else {
						count=1;
						Name n=new Name();
						n.setLname(temp[0]);
						n.setFname(temp[1]);
						n.setRank(temp[3]);
						n.setTimes(count);
						myArray.add(n);
					}
					PrevName[0]=temp[0];
					PrevName[1]=temp[1];
					PrevName[3]=temp[3];
					this.setcMissingRank(cMissingRank);
					break;
					
				//Create a list with all names	
				case 4:
					count=0;
					//System.out.println("oi");
					Name n=new Name();
					n.setLname(temp[0]);
					n.setFname(temp[1]);
					n.setRank(temp[4]);
					n.setRegiment(temp[3]);
					n.setTimes(count);
					myArray.add(n);
					
					break;
				
				case 5:
					//regiment on file soldiers will be temp 4
					if(PrevName[4].equals(""))cMissingRegiment++;
					else System.out.println(PrevName[4]);
					if(PrevName[0].equals(temp[0])&&PrevName[1].equals(temp[1])&&PrevName[4].equals(temp[4])){
						count++;
						myArray.get(myArray.size()-1).setTimes(count);
						//System.out.println("oi");
					}
					else {
						count=1;
						Name name=new Name();
						name.setLname(temp[0]);
						name.setFname(temp[1]);
						name.setRank(temp[3]);
						name.setRegiment(temp[4]);
						name.setTimes(count);
						myArray.add(name);
					}
					PrevName[0]=temp[0];
					PrevName[1]=temp[1];
					PrevName[3]=temp[3];
					PrevName[4]=temp[4];
					this.setcMissingRegiment(cMissingRegiment);
					
					break;
					
				}
			}
			this.setNames(myArray);
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
	}
	
	
	
	public void setNameFreq(Name n){
		float f=(float)n.getTimes()/(float)this.getTotal();
		n.setFreq(f);
	}
			
	public void calcNamesFreq(){
		int i=0;
		ArrayList<Name>myArrayName=this.getNames();
		while(i!=myArrayName.size()){
			this.setNameFreq(myArrayName.get(i));
			i++;
		}
	}
	
	public void checkRankMatch() throws FileNotFoundException{
		String csvFile = "/Users/eduardo/Desktop/Internship/Soldiers/match_noMISS.csv";
		BufferedReader br = null;
		String FILE_HEADER = "Lname,Fname,Regiment,RankCasualtie,RankSoldier";
		PrintWriter outputStream = null;
		outputStream= new PrintWriter(new FileOutputStream("rank_match.csv"));
		String COMMA_DELIMITER = ",";
		String NEW_LINE_SEPARATOR = "\n";
		Integer i=0;
		
		
		
		String line = "";
		String cvsSplitBy = ",";
		
		try{
			br = new BufferedReader(new FileReader(csvFile));
			outputStream.println(FILE_HEADER);
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				System.out.println(i);
				String[] temp= line.split(cvsSplitBy);
				if(temp[3].equals(temp[4])){
					outputStream.append(temp[0]);
					outputStream.append(COMMA_DELIMITER);
					outputStream.append(temp[1]);
					outputStream.append(COMMA_DELIMITER);
					outputStream.append(temp[3]);
					outputStream.append(COMMA_DELIMITER);
					outputStream.append(temp[4]);
					outputStream.append(COMMA_DELIMITER);
					outputStream.append(temp[5]);
					outputStream.append(COMMA_DELIMITER);
					outputStream.append("0");
					outputStream.append(NEW_LINE_SEPARATOR);
					
				}
				i++;
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		outputStream.close();
		
	}
	
	public int highestFrequency(ArrayList<Name> names){
		int i=0,index=0;
		float f;
		float g;
		g=names.get(0).getFreq();
		while(i<names.size()){
			f=names.get(i).getFreq();
			int result=Float.compare(f, g);
			if(result>0){
				g=f;
				index=i;
			}
			i++;
		}
		return index;
	}
	
	public ArrayList<Name> sort(ArrayList<Name> n){
		Collections.sort(n, new Comparator<Name>() {
	        @Override
	        public int compare(Name  n1, Name  n2)
	        {

	            return  Float.compare(n1.freq,n2.freq);
	        }
	    });
		return n;
	}
	
	public void findDuplicates(String FileName) throws IOException{
		BufferedReader br = null;
		int count=0;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<Soldier>myArray=new ArrayList<Soldier>();
		
		try{
			br = new BufferedReader(new FileReader(FileName));
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] temp= line.split(cvsSplitBy);
				Soldier s=new Soldier();	
				s.setLname(temp[0]);
				s.setFname(temp[1]);
				s.setRank(temp[6]);
				s.setRegimental(temp[4]);
				myArray.add(s);
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
		String FILE_HEADER = "Lname,Fname,Regiment,RankCasualtie,RankSoldier,Junk";
		PrintWriter outputStream = null;
		
		int i=0;
		try {
			outputStream= new PrintWriter(new FileOutputStream("match_match_NoMiss_B_4sLvl_DUPLICATE.csv"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outputStream.println(FILE_HEADER);
		String COMMA_DELIMITER = ",";
		String NEW_LINE_SEPARATOR = "\n";
		System.out.println("passei");
		while(i<myArray.size()){
			Soldier s1=myArray.get(i);
			int j=i+1;
			while(j<myArray.size()){
				Soldier s2=myArray.get(j);
				if(s1.getLname().equals(s2.getLname())&&s1.getRegimental().equals(s2.getRegimental())){
					if(s1.getFname().equals(s2.getFname())){
						count++;
						outputStream.append(s1.getLname());
						outputStream.append(COMMA_DELIMITER);
						outputStream.append(s1.getFname());
						outputStream.append(COMMA_DELIMITER);
						outputStream.append(s1.getRegimental());
						outputStream.append(COMMA_DELIMITER);
						outputStream.append(s1.getRank());
						outputStream.append(COMMA_DELIMITER);
						outputStream.append("0");
						outputStream.append(NEW_LINE_SEPARATOR);
					}
				}
				j++;
			}
			System.out.println(i);
			i++;
		
		}
		outputStream.close();
		System.out.println(count);
	}
	
	public ArrayList<Name> sortLNames(ArrayList<Name> n){
		Collections.sort(n, new Comparator<Name>() {
	        @Override
	        public int compare(Name  n1, Name  n2)
	        {

	        	return  n1.Lname.compareTo(n2.Lname);
	        }
	    });
		return n;
	}
	
	public ArrayList<Name> sortFname(ArrayList<Name> n){
			Collections.sort(n, new Comparator<Name>() {
	        @Override
	        public int compare(Name  n1, Name  n2)
	        {

	            return  n1.Fname.compareTo(n2.Fname);
	        }
	    });
		return n;
	}
	
	public ArrayList<Name> sortRank(ArrayList<Name> n){
		Collections.sort(n, new Comparator<Name>() {
			@Override
			public int compare(Name  n1, Name  n2)
			{

				return  n1.Rank.compareTo(n2.Rank);
			}
		});
		return n;
	}
	
	public ArrayList<Name> sortRegiment(ArrayList<Name> n){
		Collections.sort(n, new Comparator<Name>() {
			@Override
			public int compare(Name  n1, Name  n2)
			{

				return  n1.Regiment.compareTo(n2.Regiment);
			}
		});
		return n;
	}
	
	public ArrayList<Name> RankList(ArrayList<Name> n){
		int i=0,count=0;
		ArrayList<Name> myArray=new ArrayList<Name>();
		myArray.add(n.get(0));
		myArray.get(0).setTimes(1);
		while(i<n.size()-1){
			//System.out.println("oi");
			if(myArray.get(myArray.size()-1).getRank().equals(n.get(i+1).getRank())){
				count++;
				myArray.get(myArray.size()-1).setTimes(count);
			} else {
				count=1;
				myArray.add(n.get(i+1));
				myArray.get(myArray.size()-1).setTimes(count);
			}
			i++;
		}
		return myArray;
	}
	
	public ArrayList<Name> RegimentList(ArrayList<Name> n){
		int i=0,count=0;
		ArrayList<Name> myArray=new ArrayList<Name>();
		myArray.add(n.get(0));
		myArray.get(0).setTimes(1);
		while(i<n.size()-1){
			//System.out.println("oi");
			if(myArray.get(myArray.size()-1).getRegiment().equals(n.get(i+1).getRegiment())){
				count++;
				myArray.get(myArray.size()-1).setTimes(count);
			} else {
				count=1;
				myArray.add(n.get(i+1));
				myArray.get(myArray.size()-1).setTimes(count);
			}
			i++;
		}
		return myArray;
	}
	
	public void write(ArrayList<Name> n){
		String COMMA_DELIMITER = ",";
		String NEW_LINE_SEPARATOR = "\n";
		String FILE_HEADER = "Lname,Fname,Freq,Times,Rank,Regiment";
		FileWriter fileWriter = null;
		
		try{
			fileWriter = new FileWriter("ListLNFNRegiment(soldiers).csv");
			 
			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			for(Name ns : n){
				fileWriter.append(ns.getLname());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(ns.getFname());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(ns.getFreq()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(ns.getTimes()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(ns.getRank()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(ns.getRegiment()));
				fileWriter.append(NEW_LINE_SEPARATOR);

			}
			System.out.println("CSV file was created successfully !!!");
			
		} catch(Exception e){
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();

			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

		}
		
	}
	
	public void writeRank(ArrayList<Name> n){
		String COMMA_DELIMITER = ",";
		String NEW_LINE_SEPARATOR = "\n";
		String FILE_HEADER = "Rank,Times, freq";
		FileWriter fileWriter = null;
		
		try{
			fileWriter = new FileWriter("RankList(casualties).csv");
			 
			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			for(Name ns : n){
				fileWriter.append(ns.getRank());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(ns.getTimes()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(ns.getFreq()));
				fileWriter.append(NEW_LINE_SEPARATOR);

			}
			System.out.println("CSV file was created successfully !!!");
			
		} catch(Exception e){
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();

			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

		}
		
	}
	
	public void writeRegiment(ArrayList<Name> n){
		String COMMA_DELIMITER = ",";
		String NEW_LINE_SEPARATOR = "\n";
		String FILE_HEADER = "Regiment,Times,freq";
		FileWriter fileWriter = null;
		
		try{
			fileWriter = new FileWriter("RegimentList(casualties).csv");
			 
			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			for(Name ns : n){
				fileWriter.append(ns.getRegiment());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(ns.getTimes()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(ns.getFreq()));
				fileWriter.append(NEW_LINE_SEPARATOR);

			}
			System.out.println("CSV file was created successfully !!!");
			
		} catch(Exception e){
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();

			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

		}
		
	}
	
}
