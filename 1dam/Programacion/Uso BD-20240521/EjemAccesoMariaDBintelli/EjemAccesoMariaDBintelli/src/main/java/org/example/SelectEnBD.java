package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectEnBD {
    Connection conexion() {
    	Connection con=null;
    	String surl="jdbc:mariadb://localhost:3306/bdprueba";    	
    	try {
    		con=DriverManager.getConnection(surl,"jmpl", "clave");
    	}catch (Exception e) {
    		System.out.println("Error conexi�n");
    	}
    	return con;
    }
    void cerrarConexion (Connection con)   {
    	try {
    	con.close();
    	}catch (SQLException e) {
    		System.out.println("Error cierre conexi�n");
    	}
    }
    void ejecutarSelect(Connection con) {
    	try( PreparedStatement st= con.prepareStatement ("SELECT idEditorial, nombre FROM editorial ")){
    		ResultSet rs=st.executeQuery();
    		while (rs.next()) {
    			System.out.println(rs.getString("idEditorial")+"  "+rs.getString("nombre"));
    		}
    		rs.close();
    	}catch (SQLException e) {
    		System.out.println("Error consulta"+ e.getErrorCode());
    	}
    }
    void insercion(Connection con) {
    	try {
    		 String cadena="INSERT INTO editorial (idEditorial, nombre, tlf) "+
    	     " VALUE (?, \"Paraninfo\", \"913333333\" )";
    		 PreparedStatement st= con.prepareStatement (cadena);
    		 st.setInt(1, 6673);
    		 int numReg=st.executeUpdate();
    		 System.out.println("Registros insertados:"+numReg);
    	}catch (SQLException e) {
    		System.out.println("Error cierre conexi�n");
    		e.printStackTrace();
    	}
    }

     
	public static void main(String[] args) throws SQLException {
		SelectEnBD objBd= new SelectEnBD();
		Connection con=objBd.conexion();
		con.setAutoCommit(true); 

		objBd.ejecutarSelect(con);
		objBd.insercion(con);
		
		objBd.ejecutarSelect(con);
		con.rollback();
		objBd.cerrarConexion(con);
		
	}
}
