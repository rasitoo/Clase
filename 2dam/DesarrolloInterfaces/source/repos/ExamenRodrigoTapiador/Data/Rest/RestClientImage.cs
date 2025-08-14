using ExamenRodrigoTapiador.Data.Entities;
using System.Diagnostics;
using System.Text.Json;

namespace ExamenRodrigoTapiador.Data.Rest;

public class RestClientImage(ApiClientService apiClientService) : IRestClient<Image>
{
    private string _url = apiClientService.Url + "/images";
    public async Task<Image?> Get(int id)
    {
        Image? image = null;

        try
        {
            JsonDocument doc = await apiClientService.GetJsonAsync($"{_url}/{id}");
            JsonElement imageJson = doc.RootElement;

            if (doc != null)
            {
                image = new Image
                {
                    Id = imageJson.GetProperty("id").GetInt32(),
                    Title = imageJson.GetProperty("title").GetString(),
                    Year = imageJson.GetProperty("year").GetInt32(),
                    File = imageJson.GetProperty("file").GetString(),
                    ArtistId = imageJson.GetProperty("artist_id").GetInt32(),
                    GenreId = imageJson.GetProperty("genre_id").GetInt32(),
                    Artist = new Artist { Name = imageJson.GetProperty("artist").GetProperty("name").GetString()},
                    Genre = new Genre { Name = imageJson.GetProperty("genre").GetProperty("name").GetString()}


                };
            }
        }
        catch (Exception ex)
        {
            Debug.WriteLine(@"\tERROR {0}", ex.Message);
        }
        return image;
    }

    public async Task<List<Image>> GetAll(int offset = 0, int limit = 100)
    {
        var images = new List<Image>();

        try
        {
            JsonDocument doc = await apiClientService.GetJsonAsync($"{_url}/?offset={offset}&limit={limit}");
            JsonElement root = doc.RootElement;

            if (doc != null)
            {
                foreach (JsonElement imageJson in root.EnumerateArray())
                {
                    Image image = new Image
                    {
                        Id = imageJson.GetProperty("id").GetInt32(),
                        Title = imageJson.GetProperty("title").GetString(),
                        Year = imageJson.GetProperty("year").GetInt32(),
                        File = imageJson.GetProperty("file").GetString(),
                        ArtistId = imageJson.GetProperty("artist_id").GetInt32(),
                        GenreId = imageJson.GetProperty("genre_id").GetInt32(),
                        Artist = new Artist { Name = imageJson.GetProperty("artist").GetProperty("name").GetString() },
                        Genre = new Genre { Name = imageJson.GetProperty("genre").GetProperty("name").GetString() }


                    };
                    images.Add(image);
                }

            }
        }
        catch (Exception ex)
        {
            Debug.WriteLine(@"\tERROR {0}", ex.Message);
        }
        return images;
    }
}
