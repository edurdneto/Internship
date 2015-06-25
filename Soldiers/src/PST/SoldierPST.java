package PST;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Dao.SoldierDao;
import entities.Soldier;

public class SoldierPST implements SoldierDao {

	final String soldierTab = "soldiersssww1";

	@Override
	public Soldier getSoldier(int id) {
		Connection conn;
		ResultSet rs;
		Statement stmt;
		String query;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ISsoldiers", "root", "");
			stmt = conn.createStatement();
			query = "select Lname from where ID = 1";
			rs = stmt.executeQuery(query);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//conn.close();
			//stmt.close();
			//rs.close();
		}

		// // 1.Get Connection to database
		// Connection con;
		// Statement st;
		// try {
		// con = DriverManager.getConnection(
		// "jdbc:mysql://localhost:3306/soldiers", "root", "unifor");
		// st = con.createStatement();
		// // 3.Execute SQL QUery
		//
		// con.close();
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// // reading first file && inserting
		// Integer i = 0;
		// /*
		// * while ((line = br.readLine()) != null) { String[] temp=
		// * line.split(cvsSplitBy); i++; String sql =
		// * "INSERT INTO soldiersww1Mod " + "VALUES (" + i +", '"+ temp[0]
		// * +"', '"+ temp[1] +"','"+ temp[2] +"','"+ temp[3] +"','"+ temp[4]
		// * +"','"+ temp[5] +"')"; System.out.println(sql);
		// * myStmt.executeUpdate(sql);
		// *
		// * }
		// */

		return null;
	}
}
