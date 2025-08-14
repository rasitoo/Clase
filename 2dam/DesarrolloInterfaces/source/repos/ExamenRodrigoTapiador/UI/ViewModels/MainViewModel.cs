using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using ExamenRodrigoTapiador.Data.Entities;
using ExamenRodrigoTapiador.Data.Rest;
using System.Collections.ObjectModel;
using System.Threading.Tasks;

namespace ExamenRodrigoTapiador.UI.ViewModels;

public partial class MainViewModel : ObservableObject
{
    private IRestClient<Artist> _clientArtist;
    private IRestClient<Genre> _clientGenre;
    private IRestClient<Image> _clientImage;

    [ObservableProperty]
    private ObservableCollection<Image> _images = [];
    [ObservableProperty]
    private Image? _selectedImage = new();
    [ObservableProperty]
    private ObservableCollection<Artist> _artists = [];
    [ObservableProperty]
    private Artist? _selectedArtist = new();

    public MainViewModel(IRestClient<Artist> clientArtist, IRestClient<Genre> clientGenre, IRestClient<Image> clientImage)
    {
        this._clientArtist = clientArtist;
        this._clientGenre = clientGenre;
        this._clientImage = clientImage;
        getArtists();
        getImages();

    }
    [RelayCommand]
    private void FilterButton()
    {
        getImages();
        List<Image> tempImages = new();
        foreach(Image image in Images)
        {
            if (image.Artist.Name.Equals(SelectedArtist.Name))
            {
                tempImages.Add(image);
            }
        }
        Images = new(tempImages);
    }

    private async Task getImages()
    {
        var images = await _clientImage.GetAll();
        Images = new ObservableCollection<Image>(images);
    }

    private async void getArtists()
    {

        var artists = await _clientArtist.GetAll();
        Artists = new ObservableCollection<Artist>(artists);
    }
}
