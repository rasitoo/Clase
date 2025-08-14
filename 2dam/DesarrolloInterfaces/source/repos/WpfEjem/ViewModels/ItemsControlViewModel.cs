namespace WpfEjem.ViewModels;

using CommunityToolkit.Mvvm.ComponentModel;
using System.Collections.ObjectModel;


public class ItemsControlViewModel : ObservableObject
{
    private ObservableCollection<Language> _languages;

    public ObservableCollection<Language> Languages
    {
        get { return _languages; }
        set { SetProperty(ref _languages, value); }
    }

    public ItemsControlViewModel()
    {
        Languages = new ObservableCollection<Language>
        {
            new Language { Name = "Python", Type = "Interpretado", CreationYear = 1991, ImageUri = "path/to/python.png" },
            new Language { Name = "C", Type = "Compilado", CreationYear = 1972, ImageUri = "path/to/c.png" },
            new Language { Name = "C++", Type = "Compilado", CreationYear = 1983, ImageUri = "path/to/cpp.png" },
            new Language { Name = "Java", Type = "Interpretado", CreationYear = 1995, ImageUri = "path/to/java.png" },
            new Language { Name = "C#", Type = "Compilado", CreationYear = 2000, ImageUri = "path/to/csharp.png" }
        };
    }
}

