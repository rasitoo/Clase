namespace WinFormsExamenRodrigoTapiador.Views;

public partial class MainView : Form
{
    public string DisplayNombre { get => textBoxNombre.Text; set => textBoxNombre.Text = value; }
    public string DisplayPremio { get => textBoxPremio.Text; set => textBoxPremio.Text = value; }
    public List<String> DisplayNombres { set => listBoxNombres.DataSource = value; }
    public List<String> DisplayPremios { set => listBoxPremios.DataSource = value; }
    public List<String> DisplayResultado { set => listBoxResultado.DataSource = value; }



    public event EventHandler buttonAnadirNombre_Click;
    public event EventHandler buttonAnadirPremio_Click;
    public event EventHandler buttonNuevoSorteo_Click;
    public event EventHandler buttonSortear_Click;

    public MainView()
    {
        InitializeComponent();
        AttachEventHandlers();
    }

    private void AttachEventHandlers()
    {
        buttonAnadirNombre.Click += (sender, e) => buttonAnadirNombre_Click?.Invoke(sender, e);
        buttonAnadirPremio.Click += (sender, e) => buttonAnadirPremio_Click?.Invoke(sender, e);
        buttonNuevoSorteo.Click += (sender, e) => buttonNuevoSorteo_Click?.Invoke(sender, e);
        buttonSortear.Click += (sender, e) => buttonSortear_Click?.Invoke(sender, e);

    }

    internal void MostrarError(string v)
    {
        MessageBox.Show(v, "Error", MessageBoxButtons.RetryCancel, MessageBoxIcon.Error);
    }
}
