package solucionesfede.ej5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;


public class OperacionesCRUD {


    public static Connection getConnection() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/vendedores";
            String user = "root";
            String password = "";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al conectar con la base de datos");
        }
    }



    public static void insertarOficina(Oficina oficina) {
        String query = "INSERT INTO OFICINAS (NUM_OFI, CIUDAD, REGION, NUM_DIR, OBJETIVO, VENTAS) VALUES (?, ?, ?, ?, ?, ?)";
        try (	Connection conn = getConnection(); 
 		PreparedStatement ps = conn.prepareStatement(query)) {
            	ps.setInt(1, oficina.getNumOfi());
            	ps.setString(2, oficina.getCiudad());
            	ps.setString(3, oficina.getRegion());
            	ps.setInt(4, oficina.getNumDir());
            	ps.setDouble(5, oficina.getObjetivo());
            	ps.setDouble(6, oficina.getVentas());
            	ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Oficina> listarOficinas() {
        List<Oficina> oficinas = new ArrayList<>();
        String query = "SELECT * FROM OFICINAS";
        try (	Connection conn = getConnection(); 
		Statement stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery(query)) {
            	while (rs.next()) 
		{
                	Oficina oficina = new Oficina(rs.getInt("NUM_OFI"), rs.getString("CIUDAD"), rs.getString("REGION"),
                        		rs.getInt("NUM_DIR"), rs.getDouble("OBJETIVO"), rs.getDouble("VENTAS"));
                	oficinas.add(oficina);
            	}
        	} catch (SQLException e) {
            		e.printStackTrace();
        }
        return oficinas;
    }

    public static void borrarOficina(int numOfi) {
        String query = "DELETE FROM OFICINAS WHERE NUM_OFI = ?";
        try (	Connection conn = getConnection(); 
		PreparedStatement ps = conn.prepareStatement(query)) {
            	ps.setInt(1, numOfi);
            	ps.executeUpdate();
        	} catch (SQLException e) {
       		     e.printStackTrace();
        		}
    }

    public static void insertarVendedor(Vendedor vendedor) {
        String query = "INSERT INTO VENDEDORES (NUM_EMP, NOMBRE, EDAD, NUM_OFI, OFICIO, FECHA_CONT, NUM_DIR, CUOTA, VENTAS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (	Connection conn = getConnection(); 
		PreparedStatement ps = conn.prepareStatement(query)) {
            	ps.setInt(1, vendedor.getNumEmp());
            	ps.setString(2, vendedor.getNombre());
            	ps.setInt(3, vendedor.getEdad());
            	ps.setInt(4, vendedor.getNumOfi());
            	ps.setString(5, vendedor.getOficio());
            	java.sql.Date fechaCont = new java.sql.Date(vendedor.getFechaCont().getTime());
            	ps.setDate(6, fechaCont);
            	ps.setInt(7, vendedor.getNumDir());
            	ps.setDouble(8, vendedor.getCuota());
            	ps.setDouble(9, vendedor.getVentas());
            	ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Vendedor> listarVendedores() {
        List<Vendedor> vendedores = new ArrayList<>();
        String query = "SELECT * FROM VENDEDORES";
        try (	Connection conn = getConnection(); 
		Statement stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery(query)) {
            	while (rs.next()) {
                	String fechaContStr = rs.getString("FECHA_CONT");
                	java.sql.Date fechaCont = null;
                	if (fechaContStr != null) {
                    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
                    	try {
                        	Date utilDate = sdf.parse(fechaContStr);  
                        	fechaCont = new java.sql.Date(utilDate.getTime()); 
                    	} catch (java.text.ParseException e) {
                        		e.printStackTrace();
  
                        fechaCont = null;  
                    }
                }

                Vendedor vendedor = new Vendedor(
                        rs.getInt("NUM_EMP"),
                        rs.getString("NOMBRE"),
                        rs.getInt("EDAD"),
                        rs.getInt("NUM_OFI"),
                        rs.getString("OFICIO"),
                        fechaCont,  
                        rs.getInt("NUM_DIR"),
                        rs.getDouble("CUOTA"),
                        rs.getDouble("VENTAS")
                );
                vendedores.add(vendedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendedores;
    }

    public static void borrarVendedor(int numEmp) {
        String query = "DELETE FROM VENDEDORES WHERE NUM_EMP = ?";
        try (	Connection conn = getConnection(); 
		PreparedStatement ps = conn.prepareStatement(query)) {
            	ps.setInt(1, numEmp);
            	ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertarProducto(Producto producto) {
        String query = "INSERT INTO PRODUCTOS (ID_FAB, ID_PROD, DESCRIPCION, PRECIO, EXISTENCIAS) VALUES (?, ?, ?, ?, ?)";
        try (	Connection conn = getConnection(); 
		PreparedStatement ps = conn.prepareStatement(query)
	   ) {
           	ps.setString(1, producto.getIdFab());
            	ps.setString(2, producto.getIdProd());
            	ps.setString(3, producto.getDescripcion());
            	ps.setDouble(4, producto.getPrecio());
            	ps.setInt(5, producto.getExistencias());
            	ps.executeUpdate();
        	} catch (SQLException e) {
            		e.printStackTrace();
        }
    }

    public static List<Producto> listarProductos() {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM PRODUCTOS";
        try (	Connection conn = getConnection(); 
		Statement stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery(query)) {
            	while (rs.next()) {
                	Producto producto = new Producto(rs.getString("ID_FAB"), rs.getString("ID_PROD"), rs.getString("DESCRIPCION"),
                        	rs.getDouble("PRECIO"), rs.getInt("EXISTENCIAS"));
                	productos.add(producto);
        	    }
  	      } catch (SQLException e) {
            	e.printStackTrace();
        		}
        return productos;
    }

    public static void borrarProducto(String idProd) {
        String query = "DELETE FROM PRODUCTOS WHERE ID_PROD = ?";
        try (	Connection conn = getConnection(); 
		PreparedStatement ps = conn.prepareStatement(query)
	   ) {
            	ps.setString(1, idProd);
            	ps.executeUpdate();
             } catch (SQLException e) {
            		e.printStackTrace();
        }
    }

    public static void insertarCliente(Cliente cliente) {
        String query = "INSERT INTO CLIENTES (NUM_CLI, EMPRESA, NUM_EMP, LIMITE_CREDITO) VALUES (?, ?, ?, ?)";
        try (	Connection conn = getConnection(); 
		PreparedStatement ps = conn.prepareStatement(query)
	    ) {
            	ps.setInt(1, cliente.getNumCli());
            	ps.setString(2, cliente.getEmpresa());
            	ps.setInt(3, cliente.getNumEmp());
            	ps.setDouble(4, cliente.getLimiteCredito());
            	ps.executeUpdate();
        	} catch (SQLException e) {
            		e.printStackTrace();
        	}
    }

    public static List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM CLIENTES";
        try (	Connection conn = getConnection(); 
		Statement stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery(query)) {
            	while (rs.next()) {
                	Cliente cliente = new Cliente(rs.getInt("NUM_CLI"), rs.getString("EMPRESA"), rs.getInt("NUM_EMP"), rs.getDouble("LIMITE_CREDITO"));
                	clientes.add(cliente);
            	}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public static void borrarCliente(int numCli) {
        String query = "DELETE FROM CLIENTES WHERE NUM_CLI = ?";
        try (	Connection conn = getConnection(); 
		PreparedStatement ps = conn.prepareStatement(query)
	) {
            ps.setInt(1, numCli);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertarPedido(Pedido pedido) {
        String query = "INSERT INTO PEDIDOS (NUM_PED, FECHA_PED, NUM_CLI, NUM_EMP, ID_FAB, ID_PROD, CANTIDAD, IMPORTE) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (	Connection conn = getConnection(); 
		PreparedStatement ps = conn.prepareStatement(query)) 
		{
            		ps.setInt(1, pedido.getNumPed());
            		java.sql.Date fechaped = new java.sql.Date(pedido.getFechaPed().getTime());
            		ps.setDate(2, fechaped);
            		ps.setInt(3, pedido.getNumCli());
            		ps.setInt(4, pedido.getNumEmp());
            		ps.setString(5, pedido.getIdFab());
            		ps.setString(6, pedido.getIdProd());
            		ps.setInt(7, pedido.getCantidad());
            		ps.setDouble(8, pedido.getImporte());
            		ps.executeUpdate();
        	} catch (SQLException e) {
            		e.printStackTrace();
        }
    }

    public static List<Pedido> listarPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        String query = "SELECT * FROM PEDIDOS";
        try (	Connection conn = getConnection(); 
		Statement stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery(query)) {
            	while (rs.next()) {
                	Pedido pedido = new Pedido(rs.getInt("NUM_PED"), rs.getDate("FECHA_PED"), rs.getInt("NUM_CLI"),
                        	rs.getInt("NUM_EMP"), rs.getString("ID_FAB"), rs.getString("ID_PROD"),
                        	rs.getInt("CANTI"), rs.getDouble("IMPORTE"));
                	pedidos.add(pedido);
            	}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    public static void borrarPedido(int numPed) {
        String query = "DELETE FROM PEDIDOS WHERE NUM_PED = ?";
        try (	Connection conn = getConnection(); 
		PreparedStatement ps = conn.prepareStatement(query)
	) 	{
            		ps.setInt(1, numPed);
            		ps.executeUpdate();
        	} catch (SQLException e) {
            		e.printStackTrace();
        	}
    }
}
