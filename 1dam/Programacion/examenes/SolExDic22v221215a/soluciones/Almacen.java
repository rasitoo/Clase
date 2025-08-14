import java.io.IOException;

public class Almacen {
    Producto prods[];
    int cont=0;
    Teclado t= new Teclado();
    Almacen(){
    	prods= new Producto[100];
    }
    boolean alta(int tipo, int cod, int cant, double precio) {
    	boolean ok=true;
    	
    	if (cont<prods.length && buscarPorCodigo(cod)==null)
    		prods[cont++]=new Producto(tipo, cod, cant, precio);
    	else 
    		ok=false;
    	return ok;
    }
    Producto buscarPorCodigo(int codigo) {
    	Producto p=null;
    	boolean encontrado=false;
    	for (int i=0;i<cont && !encontrado;i++)
    		if (prods[i].codigo==codigo) {
    			p=prods[i];
    			encontrado=true;
    		}
    	return p;
    }
    double vender(int codigo, int cant) {
    	Producto p=buscarPorCodigo(codigo);
    	int cantVendida=0;
    	if (p!=null) {
    		if (p.cantidad>= cant)
    			cantVendida= cant;
    		else
    			cantVendida= p.cantidad;
    		p.cantidad= p.cantidad-cantVendida;
    	}
    	return cantVendida*p.precio;
    }
   void venderPorTipo(int tipo, int cant){
    	int cantTotalVendida=0, cantVprod=0;
    	double precioTotal=0;
    	for (int i=0;i<cont && cantTotalVendida != cant;i++)
    		if (prods[i].tipo==tipo) {
    			if (prods[i].cantidad >= cant)
    				cantVprod= cant;
        		else
        			cantVprod+= prods[i].cantidad;
    			prods[i].cantidad= prods[i].cantidad-cantVprod;
    			System.out.println("Prod código:"+prods[i].codigo+" vendidas "+cantVprod+" precio:"+prods[i].precio);
    			precioTotal += prods[i].precio *cantVprod;
    			cantTotalVendida += cantVprod;
    		}
    	System.out.println("Vendidas "+ cantTotalVendida+ " unidades por un total de "+precioTotal+"€");
    }
   void eliminarProducto(int cod2){
	   for (int i=0; i<cont; i++ ) {
		   if (prods[i].codigo==cod2) {
			   for (int j=i; j<cont-1; j++)
				   prods[j]=prods[j+1];
		   }
		   prods[cont]=null;
		   cont--;
	   }
   }
   boolean fusionar(int cod1, int cod2) {
	   boolean ok=true;
	   Producto p1= buscarPorCodigo(cod1);
	   Producto p2=buscarPorCodigo(cod2);
	   if (p1!=null && p2!=null && p1.codigo==p2.codigo ) {
		   p1.cantidad +=p2.cantidad;
		   p1.precio = (p1.precio + p2.precio)/2;
		   eliminarProducto(cod2);
	   }
	   else
		   ok=false;
	   return ok;
   }
    int pedirTipoProducto() throws IOException{
    	int tipo=0;
    	do {
    		System.out.println("Tipo producto entre 1 y 10, 0 si no se quiere introducir ningún tipo");
    		tipo=t.leerInt();
    	}while (tipo>=0 && tipo<10);
    	return tipo;
    }
    void listarPorTipo (int tipo) {
    	int cant=0;
    	int media=0;
    	int num=0;
    	for (int i=0; i<cont; i++ ) {
    		if (prods[i].tipo== tipo) {
    			prods[i].mostrar();
    			cant+=prods[i].cantidad;
    			media+=prods[i].precio;
    			num++;
    		}
    	}
    	if( num!=0)
    		System.out.println("Cantidad total:"+ cant+" precio medio:"+media/num);
    }
    void menu() throws IOException {
    	int opc;
    	int tipo, codigo, codigo2, cantidad;
    	double precio, total;
    	do {
    		System.out.println("1-Alta");
    		System.out.println("2-Vender producto");
    		System.out.println("3-Vender por tipo de producto");
    		System.out.println("4-Fusionar 2 productos");
    		System.out.println("5-Listar por tipo producto");
    		System.out.println("0-Fin");
    		opc=t.leerInt();
    		switch (opc) {
    		case 1->  {
    				   tipo= pedirTipoProducto();
    				   if (tipo!=0) {
    					 System.out.println("código");
    					 codigo= t.leerInt();
    				     System.out.println("cantidad");
    				     cantidad= t.leerInt();
    				     System.out.println("precio");
    				     precio=t.leerDouble();
    				     if (alta(tipo, codigo, cantidad, precio) )
    				    	 System.out.println("Producto dado de alta correctamente");
    				     else 
    				    	 System.out.println("no hay sitio para más productos"); 
    				   }
    		   }
    		case 2->  { System.out.println("código");
    					codigo= t.leerInt();
    					System.out.println("cantidad");
   				        cantidad= t.leerInt();
   				        total=vender(codigo, cantidad);
   				        System.out.println("Precio total de la venta:"+total);
    		  }
    		case 3->  { tipo= pedirTipoProducto();
			   			if (tipo!=0) {
			   			  System.out.println("cantidad");
			   			  cantidad= t.leerInt();
			   			  venderPorTipo(tipo, cantidad);
			   			}
			   		}
    		case 4->  { System.out.println("código1");
						codigo= t.leerInt();
						System.out.println("código2");
						codigo2= t.leerInt();
						fusionar(codigo, codigo2);
    		  }
    		case 5->  { tipo= pedirTipoProducto();
   						if (tipo!=0) {
   							listarPorTipo(tipo);
   						}
   			  }
    		}
    		
    	}while (opc!=0);
    }
	
	public static void main (String arg[]) throws IOException {
		Almacen a= new Almacen();
		a.menu();
	}
}
