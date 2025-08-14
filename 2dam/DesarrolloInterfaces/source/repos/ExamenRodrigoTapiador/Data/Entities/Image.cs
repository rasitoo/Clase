namespace ExamenRodrigoTapiador.Data.Entities;

public class Image
{
    public int Id { get; set; }
    public string? Title { get; set; }
    public int? Year { get; set; }
    public string? File { get; set; }
    public int? ArtistId { get; set; }
    public Artist? Artist { get; set; }
    public int? GenreId { get; set; }
    public Genre? Genre { get; set; }
}
