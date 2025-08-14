using MauiApp1.PageModels;

namespace MauiApp1.Pages;

public partial class MainPage : ContentPage
{
    public MainPage(MainPageModel pageModel)
    {
        BindingContext = pageModel;
        InitializeComponent();
    }
}
