using System.Net.Http;
using System.Text.Json;
using System.Text;
using static System.Net.WebRequestMethods;

namespace ExamenRodrigoTapiador.Data;

public class ApiClientService
{
    private readonly HttpClient _client;
    private readonly JsonSerializerOptions _serializerOptions;
    public string Url { get; set; } = "http://192.168.16.10:7777";

    public ApiClientService()
    {
        _client = new HttpClient();
        _serializerOptions = new JsonSerializerOptions
        {
            PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
            WriteIndented = true
        };
    }

    public async Task<JsonDocument> GetJsonAsync(string url)
    {
        var response = await _client.GetAsync(url);
        response.EnsureSuccessStatusCode();
        var jsonString = await response.Content.ReadAsStringAsync();
        return JsonDocument.Parse(jsonString);
    }

}
