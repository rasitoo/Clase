package HashTable;


public class Clave {
  int codigo;
  String xxx;
  
  public Clave(int codigo, String xxx) {
	super();
	this.codigo = codigo;
	this.xxx=xxx;
  }

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + codigo;
	result = prime * result + ((xxx == null) ? 0 : xxx.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Clave other = (Clave) obj;
	if (codigo != other.codigo)
		return false;
	if (xxx == null) {
		if (other.xxx != null)
			return false;
	} else if (!xxx.equals(other.xxx))
		return false;
	return true;
}

@Override
public String toString() {
	return "Clave [codigo=" + codigo + ", xxx=" + xxx + "]";
}




  
}
