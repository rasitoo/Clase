namespace WinFormsExamenRodrigoTapiador.Views;

partial class MainView
{
    /// <summary>
    ///  Required designer variable.
    /// </summary>
    private System.ComponentModel.IContainer components = null;

    /// <summary>
    ///  Clean up any resources being used.
    /// </summary>
    /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
    protected override void Dispose(bool disposing)
    {
        if (disposing && (components != null))
        {
            components.Dispose();
        }
        base.Dispose(disposing);
    }

    #region Windows Form Designer generated code

    /// <summary>
    ///  Required method for Designer support - do not modify
    ///  the contents of this method with the code editor.
    /// </summary>
    private void InitializeComponent()
    {
        textBoxNombre = new TextBox();
        textBoxPremio = new TextBox();
        buttonAnadirNombre = new Button();
        tableLayoutPanel1 = new TableLayoutPanel();
        buttonAnadirPremio = new Button();
        listBoxNombres = new ListBox();
        listBoxPremios = new ListBox();
        buttonSortear = new Button();
        buttonNuevoSorteo = new Button();
        listBoxResultado = new ListBox();
        tableLayoutPanel1.SuspendLayout();
        SuspendLayout();
        // 
        // textBoxNombre
        // 
        textBoxNombre.Anchor = AnchorStyles.Top | AnchorStyles.Bottom | AnchorStyles.Left | AnchorStyles.Right;
        textBoxNombre.Location = new Point(3, 3);
        textBoxNombre.Name = "textBoxNombre";
        textBoxNombre.Size = new Size(194, 27);
        textBoxNombre.TabIndex = 0;
        // 
        // textBoxPremio
        // 
        textBoxPremio.Dock = DockStyle.Fill;
        textBoxPremio.Location = new Point(603, 3);
        textBoxPremio.Name = "textBoxPremio";
        textBoxPremio.Size = new Size(194, 27);
        textBoxPremio.TabIndex = 1;
        // 
        // buttonAnadirNombre
        // 
        buttonAnadirNombre.Dock = DockStyle.Fill;
        buttonAnadirNombre.Location = new Point(3, 48);
        buttonAnadirNombre.Name = "buttonAnadirNombre";
        buttonAnadirNombre.Size = new Size(194, 39);
        buttonAnadirNombre.TabIndex = 2;
        buttonAnadirNombre.Text = "Añadir nombre";
        buttonAnadirNombre.UseVisualStyleBackColor = true;
        // 
        // tableLayoutPanel1
        // 
        tableLayoutPanel1.ColumnCount = 4;
        tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 25F));
        tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 25F));
        tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 25F));
        tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 25F));
        tableLayoutPanel1.Controls.Add(textBoxPremio, 3, 0);
        tableLayoutPanel1.Controls.Add(textBoxNombre, 0, 0);
        tableLayoutPanel1.Controls.Add(buttonAnadirNombre, 0, 1);
        tableLayoutPanel1.Controls.Add(buttonAnadirPremio, 3, 1);
        tableLayoutPanel1.Controls.Add(listBoxNombres, 0, 2);
        tableLayoutPanel1.Controls.Add(listBoxPremios, 3, 2);
        tableLayoutPanel1.Controls.Add(buttonSortear, 1, 2);
        tableLayoutPanel1.Controls.Add(buttonNuevoSorteo, 2, 2);
        tableLayoutPanel1.Controls.Add(listBoxResultado, 1, 3);
        tableLayoutPanel1.Dock = DockStyle.Fill;
        tableLayoutPanel1.Location = new Point(0, 0);
        tableLayoutPanel1.Name = "tableLayoutPanel1";
        tableLayoutPanel1.RowCount = 4;
        tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 10F));
        tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 10F));
        tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 40F));
        tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 40F));
        tableLayoutPanel1.Size = new Size(800, 450);
        tableLayoutPanel1.TabIndex = 3;
        // 
        // buttonAnadirPremio
        // 
        buttonAnadirPremio.Dock = DockStyle.Fill;
        buttonAnadirPremio.Location = new Point(603, 48);
        buttonAnadirPremio.Name = "buttonAnadirPremio";
        buttonAnadirPremio.Size = new Size(194, 39);
        buttonAnadirPremio.TabIndex = 3;
        buttonAnadirPremio.Text = "Añadir premio";
        buttonAnadirPremio.UseVisualStyleBackColor = true;
        // 
        // listBoxNombres
        // 
        listBoxNombres.Dock = DockStyle.Fill;
        listBoxNombres.FormattingEnabled = true;
        listBoxNombres.Location = new Point(3, 93);
        listBoxNombres.Name = "listBoxNombres";
        tableLayoutPanel1.SetRowSpan(listBoxNombres, 2);
        listBoxNombres.Size = new Size(194, 354);
        listBoxNombres.TabIndex = 4;
        // 
        // listBoxPremios
        // 
        listBoxPremios.Dock = DockStyle.Fill;
        listBoxPremios.FormattingEnabled = true;
        listBoxPremios.Location = new Point(603, 93);
        listBoxPremios.Name = "listBoxPremios";
        tableLayoutPanel1.SetRowSpan(listBoxPremios, 2);
        listBoxPremios.Size = new Size(194, 354);
        listBoxPremios.TabIndex = 5;
        // 
        // buttonSortear
        // 
        buttonSortear.Dock = DockStyle.Fill;
        buttonSortear.Location = new Point(203, 93);
        buttonSortear.Name = "buttonSortear";
        buttonSortear.Size = new Size(194, 174);
        buttonSortear.TabIndex = 6;
        buttonSortear.Text = "¡Sortear!";
        buttonSortear.UseVisualStyleBackColor = true;
        // 
        // buttonNuevoSorteo
        // 
        buttonNuevoSorteo.Dock = DockStyle.Fill;
        buttonNuevoSorteo.Location = new Point(403, 93);
        buttonNuevoSorteo.Name = "buttonNuevoSorteo";
        buttonNuevoSorteo.Size = new Size(194, 174);
        buttonNuevoSorteo.TabIndex = 7;
        buttonNuevoSorteo.Text = "Nuevo sorteo";
        buttonNuevoSorteo.UseVisualStyleBackColor = true;
        // 
        // listBoxResultado
        // 
        tableLayoutPanel1.SetColumnSpan(listBoxResultado, 2);
        listBoxResultado.Dock = DockStyle.Fill;
        listBoxResultado.FormattingEnabled = true;
        listBoxResultado.Location = new Point(203, 273);
        listBoxResultado.Name = "listBoxResultado";
        listBoxResultado.Size = new Size(394, 174);
        listBoxResultado.TabIndex = 8;
        // 
        // MainView
        // 
        AutoScaleDimensions = new SizeF(8F, 20F);
        AutoScaleMode = AutoScaleMode.Font;
        ClientSize = new Size(800, 450);
        Controls.Add(tableLayoutPanel1);
        Name = "MainView";
        Text = "Ejercicio 1: Premios";
        tableLayoutPanel1.ResumeLayout(false);
        tableLayoutPanel1.PerformLayout();
        ResumeLayout(false);
    }

    #endregion

    private TextBox textBoxNombre;
    private TextBox textBoxPremio;
    private Button buttonAnadirNombre;
    private TableLayoutPanel tableLayoutPanel1;
    private Button buttonAnadirPremio;
    private ListBox listBoxNombres;
    private ListBox listBoxPremios;
    private Button buttonSortear;
    private Button buttonNuevoSorteo;
    private ListBox listBoxResultado;
}
