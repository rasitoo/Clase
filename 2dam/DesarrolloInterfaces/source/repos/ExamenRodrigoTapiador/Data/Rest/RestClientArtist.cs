using ExamenRodrigoTapiador.Data.Entities;
using System.Diagnostics;
using System.Security.Policy;
using System.Text.Json;

namespace ExamenRodrigoTapiador.Data.Rest;

public class RestClientArtist(ApiClientService apiClientService) : IRestClient<Artist>
{
    private string _url = apiClientService.Url + "/artists";
    public async Task<Artist?> Get(int id)
    {
        var images = new List<Image>();
        Artist? artist = null;

        try
        {
            JsonDocument doc = await apiClientService.GetJsonAsync($"{_url}/{id}");
            JsonElement root = doc.RootElement;

            if (doc != null)
            {
                artist = new Artist
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

    public async Task<List<Artist>> GetAll(int offset = 0, int limit = 100)
    {
        var artists = new List<Artist>();

        try
        {
            JsonDocument doc = await apiClientService.GetJsonAsync($"{_url}/?offset={offset}&limit={limit}");
            JsonElement root = doc.RootElement;

            if (doc != null)
            {
                foreach(JsonElement jsonArtist in root.EnumerateArray())
                {
                    Artist artist = new Artist()
                    {
                        Id = jsonArtist.GetProperty("id").GetInt32(),
                        Name = jsonArtist.GetProperty("name").GetString()
                    };
                    artists.Add(artist);
                }
                
            }
        }
        catch (Exception ex)
        {
            Debug.WriteLine(@"\tERROR {0}", ex.Message);
        }
        return artists;
    }
}
