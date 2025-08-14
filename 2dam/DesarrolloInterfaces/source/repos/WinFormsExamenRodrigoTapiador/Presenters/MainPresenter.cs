using WinFormsExamenRodrigoTapiador.Models;
using WinFormsExamenRodrigoTapiador.Models.dataclases;
using WinFormsExamenRodrigoTapiador.Views;

namespace WinFormsExamenRodrigoTapiador.Presenters;

internal class MainPresenter
{
    private MainView _mainView;
    private Model _model;

    public MainPresenter(MainView mainView, Model model)
    {
        this._mainView = mainView;
        this._model = model;
        _mainView.buttonAnadirPremio_Click += OnbuttonAnadirPremio_Click;
        _mainView.buttonAnadirNombre_Click += OnbuttonAnadirNombre_Click;
        _mainView.buttonSortear_Click += OnbuttonSortear_Click;
        _mainView.buttonNuevoSorteo_Click += OnbuttonNuevoSorteo_Click;
    }

    private void OnbuttonNuevoSorteo_Click(object? sender, EventArgs e)
    {
        _model.BorrarListas();
        _mainView.DisplayNombres = _model.ListarNombres();
        _mainView.DisplayPremios = _model.ListarPremios();


    }

    private void OnbuttonSortear_Click(object? sender, EventArgs e)
    {
        List<String> resultados = _model.Sortear();
        if (resultados is null)
            _mainView.MostrarError("No se puede hacer un sorteo si hay más premios que participantes o si una de las listas está vacía");
        else
            _mainView.DisplayResultado = _model.Sortear();
    }

    private void OnbuttonAnadirNombre_Click(object? sender, EventArgs e)
    {
        string nombre = _mainView.DisplayNombre;
        Persona per = _model.ConsultarNombrePersona(nombre);
        if (per is null)
        {
            per = new Persona(nombre);
            _model.AnadirPersona(per);
            _mainView.DisplayNombres = _model.ListarNombres();
        }
        else
        {
            _mainView.MostrarError("Ese nombre ya existe, pruebe otro");
        }
    }

    private void OnbuttonAnadirPremio_Click(object? sender, EventArgs e)
    {
        string nombre = _mainView.DisplayPremio;
        Premio pr = _model.ConsultarNombrePremio(nombre);
        if (pr is null)
        {
            pr = new Premio(_mainView.DisplayPremio);
            _model.AnadirPremio(pr);
            _mainView.DisplayPremios = _model.ListarPremios();
        }
        else
        {
            _mainView.MostrarError("Ese premio ya existe, pruebe otro");
        }
    }
}
