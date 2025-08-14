using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;

namespace Ejer2WpfExamenRodrigoTapiador;

/// <summary>
/// Interaction logic for MainWindow.xaml
/// </summary>
public partial class MainWindow : Window
{
    private string stringInicial;

    public MainWindow()
    {
        LoadSettings();
        InitializeComponent();
        stringInicial = StringFromRichTextBox(textBox);

    }
    private void LoadSettings()
    {
        Thread.CurrentThread.CurrentUICulture = new System.Globalization.CultureInfo("es");


    }

    private async void Execute_Click(object sender, RoutedEventArgs e)
    {
        string texto = StringFromRichTextBox(textBox);
        string[] lineas = texto.Split("\r\n");
        foreach (var item in lineas)
        {
            if (item.Equals("ESCALAR_X"))
                await EscalarXAsync();
        }
    }

    private void SaveCommand_Executed(object sender, ExecutedRoutedEventArgs e)
    {
        Microsoft.Win32.SaveFileDialog dlg = new Microsoft.Win32.SaveFileDialog();
        dlg.FileName = "Documento";
        dlg.DefaultExt = ".txt";

        bool? result = dlg.ShowDialog();

        if (result == true)
        {
            string filename = dlg.FileName;

            string content = StringFromRichTextBox(textBox);

            System.IO.File.WriteAllText(filename, content);
        }
    }
    string StringFromRichTextBox(RichTextBox rtb)
    {
        TextRange textRange = new TextRange(
          rtb.Document.ContentStart,
          rtb.Document.ContentEnd
        );

        return textRange.Text;
    }
    private void SaveCommand_CanExecute(object sender, CanExecuteRoutedEventArgs e)
    {
        String s = StringFromRichTextBox(textBox);
        if (!s.Equals(stringInicial))
            e.CanExecute = true;
    }
    private void OpenCommand_Executed(object sender, ExecutedRoutedEventArgs e)
    {
        Microsoft.Win32.OpenFileDialog dlg = new Microsoft.Win32.OpenFileDialog();

        bool? result = dlg.ShowDialog();

        if (result == true)
        {
            string filename = dlg.FileName;
            string content = System.IO.File.ReadAllText(filename);
            StringToRichTextBox(textBox, content);
        }
    }
    void StringToRichTextBox(RichTextBox rtb, string contenido)
    {
        TextRange textRange = new TextRange(
          rtb.Document.ContentStart,
          rtb.Document.ContentEnd
        );

        textRange.Text = contenido;
    }
    private async Task EscalarXAsync()
    {
        ScaleTransform scaleTransform = new();
        cuadrado.RenderTransform = scaleTransform;
        cuadrado.RenderTransformOrigin = new Point(0.5, 0.5);

        DoubleAnimation animacion = new();
        animacion.From = 1;
        animacion.To = 2;
        animacion.Duration = TimeSpan.FromSeconds(1);
        animacion.AutoReverse = true;

        TaskCompletionSource<bool> tcs = new();
        animacion.Completed += (s, e) => tcs.SetResult(true);

        scaleTransform.BeginAnimation(ScaleTransform.ScaleXProperty, animacion);

        await tcs.Task;
    }
}