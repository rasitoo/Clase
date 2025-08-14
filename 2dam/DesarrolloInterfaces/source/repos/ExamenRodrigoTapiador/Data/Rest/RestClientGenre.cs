using ExamenRodrigoTapiador.Data.Entities;
using System.Diagnostics;
using System.Text.Json;

namespace ExamenRodrigoTapiador.Data.Rest;

public class RestClientGenre(ApiClientService apiClientService) : IRestClient<Genre>
{
    private string _url = apiClientService.Url + "/genres";
    public async Task<Genre?> Get(int id)
    {
        var images = new List<Image>();
        Genre? artist = null;

        try
        {
            JsonDocument doc = await apiClientService.GetJsonAsync($"{_url}/{id}");
            JsonElement root = doc.RootElement;

            if (doc != null)
            {
                artist = new Genre
                {
                    Id = root.GetProperty("id").GetInt32(),
                    Name = root.GetProperty("name").GetString(),
                    Images = images
                };
                foreach (JsonElement imageJson in root.GetProperty("images").EnumerateArray())
                {
                    try
                    {
                        Image image = new()
                        {
                            Id = imageJson.GetProperty("id").GetInt32(),
                            Title = imageJson.GetProperty("title").GetString(),
                            Year = imageJson.GetProperty("year").GetInt32(),
                            File = imageJson.GetProperty("file").GetString(),
                            ArtistId = imageJson.GetProperty("artist_id").GetInt32(),
                            GenreId = imageJson.GetProperty("genre_id").GetInt32(),
                        };

                        images.Add(image);
                    }
                    catch (Exception ex)
                    {
                        Debug.WriteLine(@"\tERROR {0}", ex.Message);
                    }
                }
            }
        }
        catch (Exception ex)
        {
            Debug.WriteLine(@"\tERROR {0}", ex.Message);
        }
        return artist;
    }

    public async Task<List<Genre>> GetAll(int offset = 0, int limit = 100)
    {
        var genres = new List<Genre>();

        try
        {
            JsonDocument doc = await apiClientService.GetJsonAsync($"{_url}/?offset={offset}&limit={limit}");
            JsonElement root = doc.RootElement;

            if (doc != null)
            {
                foreach (JsonElement jsonGenre in root.EnumerateArray())
                {
                    Genre artist = new Genre()
                    {
                        Id = jsonGenre.GetProperty("id").GetInt32(),
                        Name = jsonGenre.GetProperty("name").GetString()
                    };
                    genres.Add(artist);
                }

            }
        }
        catch (Exception ex)
        {
            Debug.WriteLine(@"\tERROR {0}", ex.Message);
        }
        return genres;
    }
}

