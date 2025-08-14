package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejemplo3 {
	Connection conexion() {
		Connection con = null;      
	    String sURL = "jdbc:mariadb://localhost:3306/bdprueba";

	    try {
	       // con = DriverManager.getConnection(sURL,"root","asdf1234");
	        con = DriverManager.getConnection(sURL,"jmpl","pruebaJMPL");
	    } catch (Exception e) {
	       System.out.println("Error cerrando conexiones: "
	          + e.toString());
	    } 
	    return con;
	}
	void cerrarConexion(Connection con ) throws SQLException {
		con.close(); 
	}
	void pruebaSelect(Connection con ){
		System.out.println("Conexi�n BD");
	           
	      try {
	         // con = DriverManager.getConnection(sURL,"root","asdf1234");
	      //    try (PreparedStatement stmt = con.prepareStatement("SELECT titulo FROM libro")) {
	          try (PreparedStatement stmt = con.prepareStatement("SELECT titulo FROM libro where codigo<3")) {
	    	    // Ejecutamos Query
	    	    ResultSet rs = stmt.executeQuery();
	    	     
	    	    // Recorremos el resultado
	    	    while (rs.next()) 
	    	      System.out.println (rs.getString("titulo"));
	    	    } catch (SQLException sqle) { 
	    	      System.out.println("Error en la ejecuci�n:" 
	    	    + sqle.getErrorCode() + " " + sqle.getMessage());    
	    	    }
	    	} catch (Exception e) { 
	    	  System.out.println("Error en la conexi�n:" + e.toString() );
	    	} finally {
	    	  try {
	    	    // Cerramos posibles conexiones abiertas
	    	    if (con!=null) con.close();    
	    	  } catch (Exception e) {
	    	    System.out.println("Error cerrando conexiones: "
	    	      + e.toString());
	    	  } 
	    	} 
	}
	void insercion(Connection con) throws SQLException {
		try{  
		String cadenaInsercion = "INSERT INTO editorial ("
		+ " idEditorial,"+ " nombre,"+ " tlf ) VALUES (12343, \"editorial3\", 911111111)";
		PreparedStatement insercion=con.prepareStatement(cadenaInsercion);  
		
//		PreparedStatement insercion=con.prepareStatement("insert into editorial values(?,?,?)");  
//		insercion.setInt(1,12345);//1 es para el primer par�metro, 12345 es el valor (idEditorial)
//		insercion.setString(2,"Editorial2");  
//		insercion.setString(3,"911234567");  
		int numReg=insercion.executeUpdate();   
		System.out.println(numReg+ " registros insertados");
		}catch(Exception e){ 
			System.out.println(e);
			e.printStackTrace();
		}  
	}
	public static void main(String[] args) throws SQLException {
		Ejemplo3 obj=new Ejemplo3();
		Connection con = obj.conexion();
		obj.pruebaSelect(con);
		//obj.insercion(con);
		obj.cerrarConexion(con);
		System.out.println("FIN");
    }
}
