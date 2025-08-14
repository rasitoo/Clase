using CommunityToolkit.Mvvm.ComponentModel;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WpfEjem.ViewModels;
partial class CustomListViewModel : ObservableObject
{
    //colección observable de lenguajes de programación
    [ObservableProperty]
    private ObservableCollection<Language> _languages = new ObservableCollection<Language>
    {
        new Language { Name = "Python", Type = "Interpretado", CreationYear = 1991, ImageUri = "path/to/python.png" },
        new Language { Name = "C", Type = "Compilado", CreationYear = 1972, ImageUri = "path/to/c.png" },
        new Language { Name = "C++", Type = "Compilado", CreationYear = 1983, ImageUri = "path/to/cpp.png" },
        new Language { Name = "Dart", Type = "Compilado e Interpretado", CreationYear = 2011, ImageUri = "path/to/dart.png" }
    };
}

