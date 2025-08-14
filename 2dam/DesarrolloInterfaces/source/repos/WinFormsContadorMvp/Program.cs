using WinFormsContadorMvp.Models;
using WinFormsContadorMvp.Presenters;
using WinFormsContadorMvp.Views;

namespace WinFormsContadorMvp;

internal static class Program
{
    [STAThread]
    static void Main()
    {
        ApplicationConfiguration.Initialize();

        MainView mainView = new ();
        CounterModel counterModel = new ();
        MainPresenter mainPresenter = new (mainView, counterModel);

        Application.Run(mainView);
    }
}