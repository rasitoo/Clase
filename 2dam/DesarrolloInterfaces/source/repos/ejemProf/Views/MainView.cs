namespace ejemProf.Views;

public class MainView : Form
{
    public EventHandler ButtonAdd_Click;
    public EventHandler ButtonSubstract_Click;

    private TableLayoutPanel tableLayoutPanel1;
    private Label Display;
    private Button buttonAdd;
    private Button buttonSubstract;

    public MainView()
    {
        InitializeComponent();
    }
    private void buttonAdd_Click(object sender, EventArgs e)
    {
        ButtonAdd_Click?.Invoke(sender, e);
    }
    private void buttonSubstract_Click(object sender, EventArgs e)
    {
        ButtonSubstract_Click?.Invoke(sender, e);
    }
    /// <summary>
    ///  Required designer variable.
    /// </summary>
    private System.ComponentModel.IContainer components = null;

    public Label Display1 { get => Display; set => Display = value; }


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
        tableLayoutPanel1 = new TableLayoutPanel();
        Display1 = new Label();
        buttonAdd = new Button();
        buttonSubstract = new Button();
        tableLayoutPanel1.SuspendLayout();
        SuspendLayout();
        // 
        // tableLayoutPanel1
        // 
        tableLayoutPanel1.ColumnCount = 2;
        tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));
        tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));
        tableLayoutPanel1.Controls.Add(Display1, 0, 0);
        tableLayoutPanel1.Controls.Add(buttonAdd, 0, 1);
        tableLayoutPanel1.Controls.Add(buttonSubstract, 1, 1);
        tableLayoutPanel1.Dock = DockStyle.Fill;
        tableLayoutPanel1.Location = new Point(0, 0);
        tableLayoutPanel1.Name = "tableLayoutPanel1";
        tableLayoutPanel1.RowCount = 2;
        tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 50F));
        tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 50F));
        tableLayoutPanel1.Size = new Size(800, 450);
        tableLayoutPanel1.TabIndex = 0;
        // 
        // Display
        // 
        Display1.AutoSize = true;
        tableLayoutPanel1.SetColumnSpan(Display1, 2);
        Display1.Dock = DockStyle.Fill;
        Display1.Location = new Point(3, 0);
        Display1.Name = "Display";
        Display1.Size = new Size(794, 225);
        Display1.TabIndex = 0;
        Display1.Text = "0";
        Display1.TextAlign = ContentAlignment.MiddleCenter;
        // 
        // buttonAdd
        // 
        buttonAdd.Dock = DockStyle.Fill;
        buttonAdd.Location = new Point(3, 228);
        buttonAdd.Name = "buttonAdd";
        buttonAdd.Size = new Size(394, 219);
        buttonAdd.TabIndex = 1;
        buttonAdd.Text = "+";
        buttonAdd.UseVisualStyleBackColor = true;
        // 
        // buttonSubstract
        // 
        buttonSubstract.AutoSize = true;
        buttonSubstract.Dock = DockStyle.Fill;
        buttonSubstract.Location = new Point(403, 228);
        buttonSubstract.Name = "buttonSubstract";
        buttonSubstract.Size = new Size(394, 219);
        buttonSubstract.TabIndex = 2;
        buttonSubstract.Text = "-";
        buttonSubstract.UseVisualStyleBackColor = true;
        // 
        // MainView
        // 
        AutoScaleDimensions = new SizeF(8F, 20F);
        AutoScaleMode = AutoScaleMode.Font;
        ClientSize = new Size(800, 450);
        Controls.Add(tableLayoutPanel1);
        Name = "MainView";
        Text = "MainView";
        tableLayoutPanel1.ResumeLayout(false);
        tableLayoutPanel1.PerformLayout();
        ResumeLayout(false);
    }

    #endregion
}
