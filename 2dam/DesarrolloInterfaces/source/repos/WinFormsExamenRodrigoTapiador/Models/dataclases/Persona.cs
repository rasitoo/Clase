namespace WinFormsExamenRodrigoTapiador.Models.dataclases;

public class Persona
{
    public string Nombre { get; set; }
    public int Id { get; set; }


    public Persona() { }
    public Persona(string nombre)
    {
        Nombre = nombre;
    }
}
