using WinFormsContadorMvp.Models;
using WinFormsContadorMvp.Views;

namespace WinFormsContadorMvp.Presenters;

internal class MainPresenter
{
    private MainView mainView;
    private CounterModel counterModel;

    public MainPresenter(MainView mainView, CounterModel counterModel)
    {
        this.mainView = mainView;
        this.counterModel = counterModel;
        this.mainView.Display = counterModel.Get().ToString();

        this.mainView.PlusButton_Click += Increment;
        this.mainView.MinusButton_Click += Decrement;
    }

    private void Increment(object? sender, EventArgs e) =>
        mainView.Display = counterModel.Increment().ToString();

    private void Decrement(object? sender, EventArgs e) => 
        mainView.Display = counterModel.Decrement().ToString();
}
