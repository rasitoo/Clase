using WinFormsExamenRodrigoTapiador.Presenters;
using WinFormsExamenRodrigoTapiador.Models;
using WinFormsExamenRodrigoTapiador.Views;


namespace WinFormsExamenRodrigoTapiador
{
    internal static class Program
    {
        /// <summary>
        ///  The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            MainView mainView = new();
            Model model = new();
            MainPresenter mainPresenter = new MainPresenter(mainView, model);

            Application.Run(mainView);
        }
    }
}