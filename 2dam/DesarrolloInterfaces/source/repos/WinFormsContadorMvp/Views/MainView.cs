namespace WinFormsContadorMvp.Views;

public class MainView : Form
{
    public EventHandler PlusButton_Click;
    public EventHandler MinusButton_Click;

    public MainView()
    {
        InitializeComponent();
        AttachEventHandlers();
    }

    public string Display { get => display.Text; set => display.Text = value; }
    
    private TableLayoutPanel tableLayoutPanel;
    private Label display;
    private Button plusButton;
    private Button minusButton;
    private System.ComponentModel.IContainer components = null;

    
    private void AttachEventHandlers()
    {
        plusButton.Click += (sender, e) => PlusButton_Click?.Invoke(sender, e);
        minusButton.Click += (sender, e) => MinusButton_Click?.Invoke(sender, e);
    }

    private void InitializeComponent()
    {
        tableLayoutPanel = new TableLayoutPanel();
        display = new Label();
        plusButton = new Button();
        minusButton = new Button();

        tableLayoutPanel.ColumnCount = 2;
        tableLayoutPanel.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));
        tableLayoutPanel.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));
        tableLayoutPanel.Controls.Add(display, 0, 0);
        tableLayoutPanel.Controls.Add(plusButton, 0, 1);
        tableLayoutPanel.Controls.Add(minusButton, 1, 1);
        tableLayoutPanel.Dock = DockStyle.Fill;
        tableLayoutPanel.Location = new Point(0, 0);
        tableLayoutPanel.RowCount = 2;
        tableLayoutPanel.RowStyles.Add(new RowStyle(SizeType.Percent, 50F));
        tableLayoutPanel.RowStyles.Add(new RowStyle(SizeType.Percent, 50F));
        tableLayoutPanel.Size = new Size(250, 250);
        tableLayoutPanel.TabIndex = 0;

        tableLayoutPanel.SetColumnSpan(display, 2);
        display.Dock = DockStyle.Fill;
        display.Font = new Font("Segoe UI", 72F, FontStyle.Regular, GraphicsUnit.Point, 0);
        display.TextAlign = ContentAlignment.MiddleCenter;

        plusButton.Dock = DockStyle.Fill;
        plusButton.Font = new Font("Segoe UI", 36F);
        plusButton.Text = "+";
        plusButton.UseVisualStyleBackColor = true;

        minusButton.Dock = DockStyle.Fill;
        minusButton.Font = new Font("Segoe UI", 36F);
        minusButton.Text = "-";
        minusButton.UseVisualStyleBackColor = true;

        AutoScaleDimensions = new SizeF(7F, 15F);
        AutoScaleMode = AutoScaleMode.Font;
        ClientSize = new Size(250, 250);
        Controls.Add(tableLayoutPanel);
        Text = "Contador";
        tableLayoutPanel.PerformLayout();
        ResumeLayout(false);
    }

    protected override void Dispose(bool disposing)
    {
        if (disposing && (components != null)) components.Dispose();
        base.Dispose(disposing);
    }
}
