package ro.emanuel.turcu.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Studenti {
	static int id;

	public static void main(String[] args) throws SQLException {

		Properties connectionProps = new Properties();
		connectionProps.put("user", "root");
		connectionProps.put("password", "");
		Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_db",
				connectionProps);

		selectAll(conn);
//		delete(8, conn);
		System.out.println("-------------------------------");
//		insert(8,"Dorel", 108, "mecanica", 6, conn);
//		updateNume(6, "Nelu", conn);
		updateNrMatricol(6, 106, conn);
		
		selectAll(conn);
		

		conn.close();

	}

	public static void selectAll(Connection conn) throws SQLException {
		Statement stmt = (Statement) conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENTI");

		while (rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			int nrMatricol = rs.getInt("nr_matricol");
			String sectia = rs.getString("sectia");
			float media = rs.getFloat("medie");
			System.out.println(id + " " + nume + " " + nrMatricol + " " + sectia + " -> " + media);
		}
	}

	public static void delete(int id, Connection conn) throws SQLException {
		Statement stmt = (Statement) conn.createStatement();
		stmt.executeUpdate("DELETE FROM STUDENTI WHERE id="+id);
	}

	public static void insert(int id, String nume, int nrMatricol, String sectie, float medie, Connection conn) throws SQLException {
		Statement stmt = (Statement) conn.createStatement();
		stmt.executeUpdate("INSERT INTO STUDENTI \r\n" + "VALUES ("+id+", \""+nume+"\", "+nrMatricol+", \""+sectie+"\", "+medie+")");
	}
	
	public static void updateNume(int id, String nume, Connection conn)throws SQLException {
		Statement stmt = (Statement) conn.createStatement();
		stmt.executeUpdate("UPDATE STUDENTI\r\n SET nume = \""+nume+"\" WHERE id = "+id);
	}
	
	public static void updateNrMatricol(int id, int nrMatricol, Connection conn)throws SQLException {
		Statement stmt = (Statement) conn.createStatement();
		stmt.executeUpdate("UPDATE STUDENTI\r\n SET nr_matricol = "+nrMatricol+" WHERE id = "+id);
	}
	
}
