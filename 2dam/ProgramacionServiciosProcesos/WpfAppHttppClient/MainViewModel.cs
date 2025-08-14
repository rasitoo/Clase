using CommunityToolkit.Mvvm.ComponentModel;
using System.Diagnostics;
using System.Net.Http;
using System.Text.Json;
using System.Windows;

namespace WpfAppHttppClient;

internal partial class MainViewModel : ObservableObject
{
    [ObservableProperty]
    private string _title = "Ejemplo Apis";
    [ObservableProperty]
    private List<Product> _products = [];
    [ObservableProperty]
    private List<Producto> _productos = [];

    HttpClient _client;
    JsonSerializerOptions _serializerOptions;

    public async void getItems()
    {
        await RefreshAndMapDataAsync();

        if (Productos.Count > 0)
        {
            MessageBox.Show(Productos[0].Nombre);
        }
        else
        {
            MessageBox.Show("No se encontraron productos.");
        }
    }
    public MainViewModel()
    {
        _client = new HttpClient();
        _serializerOptions = new JsonSerializerOptions
        {
            PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
            WriteIndented = true
        };
        Productos = new List<Producto>(); // Inicializar la lista
        getItems();
    }
    public async Task<List<Product>> RefreshDataAsync()
    {
        Uri uri = new Uri(string.Format("https://fakestoreapi.com/products", string.Empty));
        try
        {
            HttpResponseMessage response = await _client.GetAsync(uri);
            if (response.IsSuccessStatusCode)
            {
                string content = await response.Content.ReadAsStringAsync();
                Products = JsonSerializer.Deserialize<List<Product>>(content, _serializerOptions);
            }
        }
        catch (Exception ex)
        {
            Debug.WriteLine(@"\tERROR {0}", ex.Message);
        }

        return Products;
    }
    public async Task<List<Producto>> RefreshAndMapDataAsync()
    {

        int currentPage = 1;
        int totalPages = 1;
        Productos.Clear();

        while (currentPage <= totalPages)
        {
            Uri uri = new($"https://rickandmortyapi.com/api/character?page={currentPage}");
            try
            {
                HttpResponseMessage response = await _client.GetAsync(uri);
                if (response.IsSuccessStatusCode)
                {
                    string content = await response.Content.ReadAsStringAsync();

                    using (JsonDocument doc = JsonDocument.Parse(content))
                    {
                        JsonElement info = doc.RootElement.GetProperty("info");
                        totalPages = info.GetProperty("pages").GetInt32();

                        foreach (JsonElement jsonProduct in doc.RootElement.GetProperty("results").EnumerateArray())
                        {
                            Producto product = new()
                            {
                                Nombre = jsonProduct.GetProperty("name").GetString(),
                                //Precio = jsonProduct.GetProperty("status").GetDouble(),
                                Categoria = jsonProduct.GetProperty("species").GetString(),
                                Descripcion = jsonProduct.GetProperty("type").GetString(),
                                Image = jsonProduct.GetProperty("image").GetString()
                            };
                            Productos.Add(product);
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                Debug.WriteLine(@"\tERROR {0}", ex.Message);
            }

            currentPage++;
        }
        return Productos;
    }
}
