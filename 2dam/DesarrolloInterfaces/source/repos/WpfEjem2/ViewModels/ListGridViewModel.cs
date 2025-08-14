using CommunityToolkit.Mvvm.ComponentModel;
using System.Collections.ObjectModel;

namespace WpfEjem2.ViewModels;

public class Language
{
    public string Name { get; set; }
    public string Type { get; set; }
    public int CreationYear { get; set; }
}

public partial class ListGridViewModel : ObservableObject
{
    private ObservableCollection<Language> _languages;

    public ObservableCollection<Language> Languages
    {
        get { return _languages; }
        set { SetProperty(ref _languages, value); }
    }

    public ListGridViewModel()
    {
        // Inicializar la colección de lenguajes
        Languages = new ObservableCollection<Language>
        {
            new Language { Name = "Python", Type = "Interpretado", CreationYear = 1991 },
            new Language { Name = "C", Type = "Compilado", CreationYear = 1972 },
            new Language { Name = "C++", Type = "Compilado", CreationYear = 1983 },
            new Language { Name = "Java", Type = "Interpretado", CreationYear = 1995 },
            new Language { Name = "C#", Type = "Compilado", CreationYear = 2000 }
        };
    }
}
