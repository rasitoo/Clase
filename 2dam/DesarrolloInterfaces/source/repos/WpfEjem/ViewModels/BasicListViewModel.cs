using CommunityToolkit.Mvvm.ComponentModel;
using System.Collections.ObjectModel;

namespace WpfEjem.ViewModels;

partial class BasicListViewModel : ObservableObject
{
    //colección observable de lenguajes de programación
    [ObservableProperty]
    private ObservableCollection<String> _languages = new ObservableCollection<String>
{
    "Python", "C", "C++", "Java", "C#", "JavaScript", "PHP", "Visual Basic", "SQL", "Assembly language"
};
}
