using WinFormsExamenRodrigoTapiador.Models.dataclases;

namespace WinFormsExamenRodrigoTapiador.Models;

internal class Model
{
    public List<Persona> Personas { get; set; }
    public List<Premio> Premios { get; set; }
    public Model()
    {
        Personas = new();
        Premios = new();
    }
    internal void AnadirPersona(Persona per)
    {

        if (Personas.Count != 0)
            per.Id = Personas.Last().Id + 1;
        else
            per.Id = 0;
        Personas.Add(per);

    }
    public Persona ConsultarNombrePersona(string nombre)
    {
        foreach (var persona in Personas)
        {
            if (persona.Nombre.Equals(nombre))
            {
                return persona;
            }
        }

        return null;
    }

    internal void AnadirPremio(Premio pr)
    {
        if (Premios.Count != 0)
            pr.Id = Premios.Last().Id + 1;
        else
            pr.Id = 0;
        Premios.Add(pr);
    }
    internal Premio ConsultarNombrePremio(string nombre)
    {
        foreach (var premio in Premios)
        {
            if (premio.Nombre.Equals(nombre))
            {
                return premio;
            }
        }

        return null;
    }

    internal List<string> ListarNombres()
    {
        List<String> lista = new();
        foreach (var persona in Personas)
        {
            lista.Add(persona.Nombre);
        }
        return lista;
    }

    internal List<string> ListarPremios()
    {
        List<String> lista = new();
        foreach (var premio in Premios)
        {
            lista.Add(premio.Nombre);
        }
        return lista;
    }

    internal List<string> Sortear()
    {
        if (Premios.Count > 0 && Personas.Count > 0 && Personas.Count >= Premios.Count)
        {
            List<string> resultados = new();
            List<Persona> personasSorteo = Personas.ToList();
            List<Premio> premiosSorteo = Premios.ToList();
            Random r = new();
            int numPer;
            int numSort;
            for (global::System.Int32 i = 0; i < Premios.Count; i++)
            {
                numPer = r.Next(personasSorteo.Count);
                numSort = r.Next(premiosSorteo.Count);

                resultados.Add(personasSorteo.ElementAt(numPer).Nombre + " - " + premiosSorteo.ElementAt(numSort).Nombre);
                personasSorteo.RemoveAt(numPer);
                premiosSorteo.RemoveAt(numSort);
            }
            return resultados;
        }
        return null;
    }

    internal void BorrarListas()
    {
        Personas = new();
        Premios = new();
    }
}
