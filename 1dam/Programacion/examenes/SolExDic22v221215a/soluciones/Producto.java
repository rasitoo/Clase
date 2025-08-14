
public class Producto {
	 int tipo;
	 int codigo;
	 int cantidad;
	 double precio;
	public Producto(int tipo, int codigo, int cantidad, double precio) {
		this.tipo = tipo;
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	void mostrar() {
		System.out.println("Tipo:"+tipo+" código:"+codigo+" cantidad:"+cantidad+" precio:"+precio);
	}
}
