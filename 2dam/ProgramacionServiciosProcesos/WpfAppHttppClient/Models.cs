namespace WpfAppHttppClient;


public class Product
{
    public int id { get; set; }
    public string Title { get; set; }
    public float Price { get; set; }
    public string Description { get; set; }
    public string Category { get; set; }
    public string Image { get; set; }
    public Rating Rating { get; set; }
}
public class Producto
{
    
    public string Nombre { get; set; }
    public double Precio { get; set; }
    public string Descripcion { get; set; }
    public string Categoria { get; set; }
    public string Image { get; set; }

}

public class Rating
{
    public float Rate { get; set; }
    public int Count { get; set; }
}

