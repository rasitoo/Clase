using ExamenRodrigoTapiador.Data.Rest;
using ExamenRodrigoTapiador.Data;
using System;
using System.Configuration;
using System.Data;
using System.Windows;
using Microsoft.Extensions.DependencyInjection;
using ExamenRodrigoTapiador.UI.ViewModels;
using ExamenRodrigoTapiador.Data.Entities;

namespace ExamenRodrigoTapiador;

/// <summary>
/// Interaction logic for App.xaml
/// </summary>
public partial class App : Application
{
    protected override void OnStartup(StartupEventArgs e)
    {
        try
        {
            var serviceCollection = new ServiceCollection();
            ConfigureServices(serviceCollection);
            ServiceProvider serviceProvider = serviceCollection.BuildServiceProvider() ?? throw new InvalidOperationException("ServiceProvider no se pudo inicializar.");

            var mainWindow = serviceProvider.GetService<MainWindow>() ?? throw new InvalidOperationException("MainWindow no se pudo inicializar.");
            mainWindow.DataContext = serviceProvider.GetRequiredService<MainViewModel>();
            mainWindow.Show();
        }
        catch (Exception ex)
        {
            MessageBox.Show($"Ocurrió un error: {ex.Message}", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
            Current.Shutdown();
        }
    }
    private static void ConfigureServices(IServiceCollection services)
    {
        services.AddTransient<MainViewModel>();
        services.AddTransient<MainWindow>();
        services.AddScoped<ApiClientService>();
        services.AddScoped<IRestClient<Artist>, RestClientArtist>();
        services.AddScoped<IRestClient<Genre>, RestClientGenre>();
        services.AddScoped<IRestClient<Image>, RestClientImage>();
    }
}

