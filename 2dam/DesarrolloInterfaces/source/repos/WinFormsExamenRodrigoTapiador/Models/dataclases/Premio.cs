namespace WinFormsExamenRodrigoTapiador.Models.dataclases;

public class Premio
{
    public string Nombre { get; set; }
    public int Id { get; set; }


    public Premio() { }
    public Premio(string nombre)
    {
        Nombre = nombre;
    }
}
