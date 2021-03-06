import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import entities.Compare;
import entities.Name;
import entities.Soldier;
import entities.Statistic;




public class ReadFiles {
	
	public static void getLastNameStatistic(){
		Statistic s=new Statistic();
		s.createListName(1);
		ArrayList<Name>n=new ArrayList<Name>();
		ArrayList<Name>ranklis=new ArrayList<Name>();
		n=s.getNames();
		s.calcNamesFreq();
		int index=s.highestFrequency(n);
		System.out.println(n.get(index).getLname()+":"+n.get(index).getTimes()+"index:"+index);
		System.out.println(s.getTotal());
		System.out.println(n.get(index).getFreq());
		System.out.println("Distinct names:"+n.size());	
		s.sort(n);
		s.write(n);
		/* 
		n=s.sortRank(n);
		System.out.println(n.get(n.size()-1).getLname()+":"+n.get(n.size()-1).getTimes()+"-freq-"+n.get(n.size()-1).getFreq());
		s.write(n);
		ranklis=s.RankList(n);
		s.writeRank(ranklis);
		*/			
	
	}
	
	public static void getLNFNStatistic(){
		Statistic s=new Statistic();
		s.createListName(2);
		ArrayList<Name>n=new ArrayList<Name>();
		ArrayList<Name>ranklis=new ArrayList<Name>();
		n=s.getNames();
		s.calcNamesFreq();
		int index=s.highestFrequency(n);
		System.out.println(n.get(index).getLname()+"-"+n.get(index).getFname()+":"+n.get(index).getTimes()+"index:"+index);
		System.out.println(s.getTotal());
		System.out.println(n.get(index).getFreq());
		System.out.println("Distinct names:"+n.size());	
		System.out.println("Total Missing Fname:"+s.getcMissingFname());
		
		n=s.sort(n);
		System.out.println(n.get(n.size()-1).getLname()+":"+n.get(n.size()-1).getTimes()+"-freq-"+n.get(n.size()-1).getFreq());
		s.write(n);
					
	}
	
	public static void getLNFNRStatistic(){
		Statistic s=new Statistic();
		s.createListName(3);
		ArrayList<Name>n=new ArrayList<Name>();
		ArrayList<Name>ranklis=new ArrayList<Name>();
		n=s.getNames();
		n=s.getNames();
		System.out.println(n.get(5).getLname()+"-"+n.get(5).getFname()+":"+n.get(5).getTimes()+"-"+n.get(5).getRank());
		System.out.println(s.getTotal());
		//Calculating the frequency with Fname and Lname matching in both files
		s.calcNamesFreq();
		System.out.println(n.get(5).getFreq());
		System.out.println("Distinct names:"+n.size());	
		System.out.println("Total Missing Rank:"+s.getcMissingRank());
		n=s.sort(n);
		System.out.println(n.get(n.size()-1).getLname()+":"+n.get(n.size()-1).getTimes()+"-freq-"+n.get(n.size()-1).getFreq());
		s.write(n);
					
	}
	
	public static void getLNFNRRegStatistic(){
		Statistic s=new Statistic();
		s.createListName(5);
		ArrayList<Name>n=new ArrayList<Name>();
		ArrayList<Name>ranklis=new ArrayList<Name>();
		n=s.getNames();
		System.out.println(n.get(5).getLname()+"-"+n.get(5).getFname()+":"+n.get(5).getTimes()+"-"+n.get(5).getRank());
		System.out.println(s.getTotal());
		//Calculating the frequency with Fname and Lname matching in both files
		s.calcNamesFreq();
		System.out.println(n.get(5).getFreq());
		System.out.println("Distinct names:"+n.size());	
		System.out.println("Total Missing Regiments:"+s.getcMissingRegiment());
		n=s.sort(n);
		System.out.println(n.get(n.size()-1).getLname()+":"+n.get(n.size()-1).getTimes()+"-freq-"+n.get(n.size()-1).getFreq());
		s.write(n);
					
	}
	
	public static void getRankList(){
		Statistic s=new Statistic();
		s.createListName(4);
		//Getting this arraylist to test
		ArrayList<Name>n=new ArrayList<Name>();
		ArrayList<Name>ranklis=new ArrayList<Name>();
		n=s.getNames();
		
		n=s.sortRank(n);
		ranklis=s.RankList(n);
		s.calcNamesFreq();
		s.sort(ranklis);
		s.writeRank(ranklis);
		System.out.println(s.getTotal());
		System.out.println("Distinct names:"+ranklis.size());
	}
	
	public static void getRegimentList(){
		Statistic s=new Statistic();
		s.createListName(4);
		//Getting this arraylist to test
		ArrayList<Name>n=new ArrayList<Name>();
		ArrayList<Name>reglis=new ArrayList<Name>();
		n=s.getNames();
		
		int index;
		
		n=s.sortRegiment(n);
		System.out.println(n.get(n.size()-1).getLname()+":"+n.get(n.size()-1).getTimes()+"-freq-"+n.get(n.size()-1).getFreq());
		s.write(n);
		reglis=s.RegimentList(n);
		s.calcNamesFreq();
		s.sort(reglis);
		s.writeRegiment(reglis);
		System.out.println(s.getTotal());
		System.out.println("Distinct names:"+reglis.size());
	}
	
	static void findDuplicates(){
		Statistic s=new Statistic();
		s.createListNameTriplas();
		ArrayList<Name>n=new ArrayList<Name>();
		n=s.getNames();
		n=s.sortLNames(n);
		int i=1;
		while(i<n.size()){
			if(n.get(i).getLname().equals(n.get(i-1).getLname())&&n.get(i).getFname().equals(n.get(i-1).getFname())&&n.get(i).getRegiment().equals(n.get(i-1).getRegiment())){
				System.out.println(n.get(i-1).getLname()+","+n.get(i-1).getFname()+","+n.get(i-1).getRegiment());
			}
			i++;
		}
		
	}

	public static void main(String[] args) throws IOException {
		//---COMPARING RANKS----
		//Statistic s=new Statistic();
		//s.checkRankMatch();
		
		
		
		//---------COMPARE----------
		
		Compare c=new Compare();
		c.startCompare();
		//c.CompareServiceNumber();
		//c.selectBsoldiers();
		System.out.println(c.getHints());
		
		
		//---------Find duplicates----
		//Statistic s=new Statistic();
		//s.findDuplicates("/Users/eduardo/Desktop/Internship/Soldiers/match_NoMiss_B_4sLvl.csv");
		
		//findDuplicates();
		
		
		//String csvFile = "/Users/eduardo/Downloads/soldiers-2files/Soldiers.csv";
		//String csvFile2= "/Users/eduardo/Downloads/soldiers-2files-2/casualties.csv";
		//BufferedReader br = null;
		//String line = "";
		//String cvsSplitBy = ",";
		//ArrayList<Soldier>myArray=new ArrayList<Soldier>();
		
		//------------GETING SOME STATISTICS-------------
		/*
		getLastNameStatistic();
		getLNFNStatistic();
		getLNFNStatistic();
		getLNFNRRegStatistic();
		*/
		
		//get full list of soldiers
		
		/*
		String csvFileSol = "/Users/eduardo/Downloads/soldiers-2files/Soldiers.csv";
		String csvFileCas = "/Users/eduardo/Downloads/soldiers-2files/casualties.csv";
		BufferedReader br = null;
			
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<Soldier>myArraySol=new ArrayList<Soldier>();
		ArrayList<Soldier>myArrayCas=new ArrayList<Soldier>();
			
		try{
			br = new BufferedReader(new FileReader(csvFileSol));
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] temp= line.split(cvsSplitBy);
				Soldier soldier=new Soldier();
				soldier.setFname(temp[1]);
				soldier.setLname(temp[0]);
				soldier.setRank(temp[4]);
				myArraySol.add(soldier);
			}
							
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
		try{
			br = new BufferedReader(new FileReader(csvFileCas));
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] temp= line.split(cvsSplitBy);
				Soldier soldier=new Soldier();
				soldier.setFname(temp[1]);
				soldier.setLname(temp[0]);
				soldier.setRank(temp[5]);
				myArrayCas.add(soldier);
			}
							
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
	*/
		//getRegimentList();	
		//getRankList(); //Using This function - You need change the function createlistname
		
		//TO READ FROM A FILE AND STORAGE IN A DATA BASE
		/* 
		/*
		try{
			br = new BufferedReader(new FileReader(csvFile));
			line = br.readLine();
			
			//1.Get Connection to database
			//Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ISsoldiers","root","");
			//2.Create a statement
			//Statement myStmt=myConn.createStatement();
			//3.Execute SQL QUery
			
			//reading first file && inserting
			Integer i=0;
			
			while ((line = br.readLine()) != null) {
				String[] temp= line.split(cvsSplitBy);
				Soldier s=new Soldier();
				s.setLname(temp[0]);
				s.setFname(temp[1]);
				s.setRegimental(temp[4]);
				s.setRank(temp[3]);
				myArray.add(s);
				System.out.println("Surname:"+temp[0]+","+"Gname:"+temp[1]+"Rank:"+","+temp[3]);
				
			}
		
			
			//reading second file (casulaties.csv) && WONT NEED DO THAT!!
			
			/*br=new BufferedReader(new FileReader(csvFile2));
			line = br.readLine();
			i=0;
			while ((line = br.readLine()) != null) {
				String[] temp= line.split(cvsSplitBy);
				i++;
				String sql = "INSERT INTO casualties " +
		                   "VALUES (" + i +", '"+ temp[0] +"', '"+ temp[1] +"','"+ temp[2] +"','"+ temp[3] +"','"+ temp[4] +"','"+ temp[5] +"','"+ temp[6] +"','"+ temp[7] +"','"+ temp[8] +"')";
				System.out.println(sql);
				myStmt.executeUpdate(sql);
				
			}*/
			// READING each element from the file and compare with each element in the table
			
			/*while((line=br.readLine())!=null){
				//can't handle with the whole table(need split it) 
				ResultSet myRs=myStmt.executeQuery("select * from soldiersww1Mod where id<400000");
				//First part
				//4.Process the result set (we will read the soldier table and compare with the file casualties)
				while (myRs.next()){
					//compare (id and rank are the only information that can match in both files)
					//System.out.println(myRs.getInt("id") + ","+myRs.getString("surname"));
				}
				
				ResultSet myRs2=myStmt.executeQuery("select * from soldiersww1Mod where id>=400000");
				//Second part
				//4.Process the result set (we will read the soldier table and compare with the file casualties)
				while (myRs2.next()){
					//compare (id and rank are the only information that can match in both files)
					//System.out.println(myRs2.getInt("id") + ","+myRs2.getString("surname"));
				}
			}*/
			//comparing from two tables
			/*ResultSet myRs=myStmt.executeQuery("select * from casualties where ID<5");
			while (myRs.next()){
				Statement myStmt2=myConn.createStatement();
				char firstL=myRs.getString("Lname").charAt(0);
				ResultSet myRs2=myStmt2.executeQuery("select * from soldiersww1 where ID<5");
				while(myRs2.next()){
					
				}
				myRs2.close();
				//System.out.println(myRs.getString("Lname").charAt(0));
			}*/
			/*System.out.println("fim");
			
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		*/
	}

}
