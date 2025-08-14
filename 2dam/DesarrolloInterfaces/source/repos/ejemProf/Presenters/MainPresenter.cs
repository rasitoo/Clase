using ejemProf.Views;

namespace ejemProf.Presenters;

internal class MainPresenter
{
    private MainView mainView;

    public MainPresenter(MainView mainView)
    {
        this.mainView = mainView;

        this.mainView.ButtonAdd_Click += Increment;
        this.mainView.ButtonSubstract_Click += Decrement;

    }

    private void Decrement(object? sender, EventArgs e)
    {
        MessageBox.Show("Adios");

    }

    private void Increment(object? sender, EventArgs e)
    {
        MessageBox.Show("Hola");
    }

}