using System.Windows;

namespace WpfAppHttppClient;

public partial class MainWindow : Window
{
    public MainWindow()
    {
        DataContext = new MainViewModel();
        InitializeComponent();
    }
}