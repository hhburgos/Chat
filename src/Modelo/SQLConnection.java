package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {
    
	private static Connection cn;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn=DriverManager.getConnection("jdbc:sqlserver://192.168.43.108:1433;databaseName=HolaMundo","PEPE","1234");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cn;
	}
	
	public static boolean compruebaLogin (String mail, String pass) {
		Connection pruebaCn = SQLConnection.getConnection();
		if (pruebaCn!=null) {
			//System.out.println("Conectado\n" + pruebaCn.toString());
			try {
				Statement stm = pruebaCn.createStatement();
				ResultSet rst = stm.executeQuery("select * from Empleados where Correo = '" + mail + "' and Pass = '" + pass + "'");
				while(rst.next()) {
					//System.out.println("bien");
					return(true);
				}
				//System.out.println("mal");
				return (false);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Fallo en la consulta");
				return (false);
			}
			
		} else {
			System.out.println("No conectado");
			return (false);
		}
	}
	
	public static void main (String [] args) {
		compruebaLogin("jon@g.com","admind");
//		Connection pruebaCn = SQLConection.getConnection();
//		if (pruebaCn!=null) {
//			System.out.println("Conectado\n" + pruebaCn.toString());
//			try {
//				Statement stm = pruebaCn.createStatement();
//				ResultSet rst = stm.executeQuery("select * from Empleados");
//				while(rst.next()) {
//					System.out.println("id: " + rst.getInt(1));
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println("Fallo en la consulta");
//			}
//			
//		} else {
//			System.out.println("No conectado");
//		}
	}
    
}
