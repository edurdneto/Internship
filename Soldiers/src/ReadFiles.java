import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;




public class ReadFiles {

	public static void main(String[] args) {
		
		String csvFile = "/Users/eduardo/Downloads/soldiers-2files-2/Soldiers.csv";
		String csvFile2= "/Users/eduardo/Downloads/soldiers-2files-2/casualties.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		
		try{
			br = new BufferedReader(new FileReader(csvFile));
			line = br.readLine();
			
			//1.Get Connection to database
			Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/soldiers","root","");
			//2.Create a statement
			Statement myStmt=myConn.createStatement();
			//3.Execute SQL QUery
			
			//reading first file && inserting
			Integer i=0;
			/*
			while ((line = br.readLine()) != null) {
				String[] temp= line.split(cvsSplitBy);
				i++;
				String sql = "INSERT INTO soldiersww1Mod " +
		                   "VALUES (" + i +", '"+ temp[0] +"', '"+ temp[1] +"','"+ temp[2] +"','"+ temp[3] +"','"+ temp[4] +"','"+ temp[5] +"')";
				System.out.println(sql);
				myStmt.executeUpdate(sql);
				
			}
			*/
			
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
			
			while((line=br.readLine())!=null){
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
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
	}

}
