namespace WpfEjem.ViewModels;

using CommunityToolkit.Mvvm.ComponentModel;
using System.Collections.Generic;
using System.Collections.ObjectModel;
public class TreeDataViewModel : ObservableObject
{
    private ObservableCollection<LanguageType> _languageTypes;

    public ObservableCollection<LanguageType> LanguageTypes
    {
        get { return _languageTypes; }
        set { SetProperty(ref _languageTypes, value); }
    }

    public TreeDataViewModel()
    {
        // Inicializar la colección de tipos de lenguajes
        LanguageTypes = new ObservableCollection<LanguageType>
    {
        new LanguageType
        {
            Name = "Compilado",
            Languages = new List<Language>
            {
                new Language { Name = "C", CreationYear = 1972 },
                new Language { Name = "C++", CreationYear = 1983 },
                new Language { Name = "Go", CreationYear = 2009 },
                new Language { Name = "Swift", CreationYear = 2014 },
                new Language { Name = "Rust", CreationYear = 2010 }
            }
        },
        new LanguageType
        {
            Name = "Interpretado",
            Languages = new List<Language>
            {
                new Language { Name = "Python", CreationYear = 1991 },
                new Language { Name = "JavaScript", CreationYear = 1995 },
                new Language { Name = "Ruby", CreationYear = 1995 },
                new Language { Name = "PHP", CreationYear = 1995 }
            }
        }
    };
    }
}

public class Language2
{
    public string Name { get; set; }
    public int CreationYear { get; set; }
}

public class LanguageType
{
    public string Name { get; set; }
    public List<Language> Languages { get; set; }
}

