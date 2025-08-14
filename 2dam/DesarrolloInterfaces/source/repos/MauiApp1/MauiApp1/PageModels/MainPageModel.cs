using CommunityToolkit.Mvvm.ComponentModel;

namespace MauiApp1.PageModels;

public partial class MainPageModel : ObservableObject
{
    [ObservableProperty]
    private string _title = "Ejemplo";
}
