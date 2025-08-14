namespace WinFormsApp1
{
    partial class Form1
    {
        private System.ComponentModel.IContainer components = null;

        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        private void InitializeComponent()
        {
            label1 = new Label();
            backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            tableLayoutPanel1 = new TableLayoutPanel();
            Numero7 = new Button();
            Numero8 = new Button();
            Numero9 = new Button();
            SimboloMas = new Button();
            SimboloMenos = new Button();
            Numero4 = new Button();
            Numero5 = new Button();
            Numero6 = new Button();
            SimboloPor = new Button();
            SimboloDividir = new Button();
            Numero1 = new Button();
            Numero2 = new Button();
            Numero3 = new Button();
            SimboloIgual = new Button();
            SimbolPunto = new Button();
            Numero0 = new Button();
            tableLayoutPanel1.SuspendLayout();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            tableLayoutPanel1.SetColumnSpan(label1, 5);
            label1.Dock = DockStyle.Fill;
            label1.Location = new Point(3, 0);
            label1.Name = "label1";
            label1.Size = new Size(789, 96);
            label1.TabIndex = 1;
            label1.Text = "0";
            label1.TextAlign = ContentAlignment.MiddleRight;
            // 
            // tableLayoutPanel1
            // 
            tableLayoutPanel1.ColumnCount = 5;
            tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 20F));
            tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 20F));
            tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 20F));
            tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 20F));
            tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 20F));
            tableLayoutPanel1.Controls.Add(SimbolPunto, 4, 3);
            tableLayoutPanel1.Controls.Add(Numero0, 0, 4);
            tableLayoutPanel1.Controls.Add(SimboloDividir, 4, 2);
            tableLayoutPanel1.Controls.Add(Numero1, 0, 3);
            tableLayoutPanel1.Controls.Add(Numero2, 1, 3);
            tableLayoutPanel1.Controls.Add(Numero3, 2, 3);
            tableLayoutPanel1.Controls.Add(SimboloIgual, 3, 3);
            tableLayoutPanel1.Controls.Add(label1, 0, 0);
            tableLayoutPanel1.Controls.Add(Numero7, 0, 1);
            tableLayoutPanel1.Controls.Add(Numero8, 1, 1);
            tableLayoutPanel1.Controls.Add(Numero9, 2, 1);
            tableLayoutPanel1.Controls.Add(SimboloMas, 3, 1);
            tableLayoutPanel1.Controls.Add(SimboloMenos, 4, 1);
            tableLayoutPanel1.Controls.Add(Numero4, 0, 2);
            tableLayoutPanel1.Controls.Add(Numero5, 1, 2);
            tableLayoutPanel1.Controls.Add(Numero6, 2, 2);
            tableLayoutPanel1.Controls.Add(SimboloPor, 3, 2);
            tableLayoutPanel1.Dock = DockStyle.Fill;
            tableLayoutPanel1.Location = new Point(0, 0);
            tableLayoutPanel1.Name = "tableLayoutPanel1";
            tableLayoutPanel1.RowCount = 5;
            tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 22.02729F));
            tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 19.4931774F));
            tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 19.4931774F));
            tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 19.4931774F));
            tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Percent, 19.4931774F));
            tableLayoutPanel1.Size = new Size(795, 440);
            tableLayoutPanel1.TabIndex = 2;
            // 
            // Numero7
            // 
            Numero7.Dock = DockStyle.Fill;
            Numero7.Location = new Point(3, 99);
            Numero7.Name = "Numero7";
            Numero7.Size = new Size(153, 79);
            Numero7.TabIndex = 2;
            Numero7.Text = "7";
            Numero7.UseVisualStyleBackColor = true;
            // 
            // Numero8
            // 
            Numero8.Dock = DockStyle.Fill;
            Numero8.Location = new Point(162, 99);
            Numero8.Name = "Numero8";
            Numero8.Size = new Size(153, 79);
            Numero8.TabIndex = 3;
            Numero8.Text = "8";
            Numero8.UseVisualStyleBackColor = true;
            // 
            // Numero9
            // 
            Numero9.Dock = DockStyle.Fill;
            Numero9.Location = new Point(321, 99);
            Numero9.Name = "Numero9";
            Numero9.Size = new Size(153, 79);
            Numero9.TabIndex = 4;
            Numero9.Text = "9";
            Numero9.UseVisualStyleBackColor = true;
            // 
            // SimboloMas
            // 
            SimboloMas.Dock = DockStyle.Fill;
            SimboloMas.Location = new Point(480, 99);
            SimboloMas.Name = "SimboloMas";
            SimboloMas.Size = new Size(153, 79);
            SimboloMas.TabIndex = 5;
            SimboloMas.Text = "+";
            SimboloMas.UseVisualStyleBackColor = true;
            // 
            // SimboloMenos
            // 
            SimboloMenos.Dock = DockStyle.Fill;
            SimboloMenos.Location = new Point(639, 99);
            SimboloMenos.Name = "SimboloMenos";
            SimboloMenos.Size = new Size(153, 79);
            SimboloMenos.TabIndex = 6;
            SimboloMenos.Text = "-";
            SimboloMenos.UseVisualStyleBackColor = true;
            // 
            // Numero4
            // 
            Numero4.Dock = DockStyle.Fill;
            Numero4.Location = new Point(3, 184);
            Numero4.Name = "Numero4";
            Numero4.Size = new Size(153, 79);
            Numero4.TabIndex = 7;
            Numero4.Text = "4";
            Numero4.UseVisualStyleBackColor = true;
            // 
            // Numero5
            // 
            Numero5.Dock = DockStyle.Fill;
            Numero5.Location = new Point(162, 184);
            Numero5.Name = "Numero5";
            Numero5.Size = new Size(153, 79);
            Numero5.TabIndex = 8;
            Numero5.Text = "5";
            Numero5.UseVisualStyleBackColor = true;
            // 
            // Numero6
            // 
            Numero6.Dock = DockStyle.Fill;
            Numero6.Location = new Point(321, 184);
            Numero6.Name = "Numero6";
            Numero6.Size = new Size(153, 79);
            Numero6.TabIndex = 9;
            Numero6.Text = "6";
            Numero6.UseVisualStyleBackColor = true;
            // 
            // SimboloPor
            // 
            SimboloPor.Dock = DockStyle.Fill;
            SimboloPor.Location = new Point(480, 184);
            SimboloPor.Name = "SimboloPor";
            SimboloPor.Size = new Size(153, 79);
            SimboloPor.TabIndex = 10;
            SimboloPor.Text = "X";
            SimboloPor.UseVisualStyleBackColor = true;
            // 
            // SimboloDividir
            // 
            SimboloDividir.Dock = DockStyle.Fill;
            SimboloDividir.Location = new Point(639, 184);
            SimboloDividir.Name = "SimboloDividir";
            SimboloDividir.Size = new Size(153, 79);
            SimboloDividir.TabIndex = 11;
            SimboloDividir.Text = "%";
            SimboloDividir.UseVisualStyleBackColor = true;
            // 
            // Numero1
            // 
            Numero1.Dock = DockStyle.Fill;
            Numero1.Location = new Point(3, 269);
            Numero1.Name = "Numero1";
            Numero1.Size = new Size(153, 79);
            Numero1.TabIndex = 12;
            Numero1.Text = "1";
            Numero1.UseVisualStyleBackColor = true;
            // 
            // Numero2
            // 
            Numero2.Dock = DockStyle.Fill;
            Numero2.Location = new Point(162, 269);
            Numero2.Name = "Numero2";
            Numero2.Size = new Size(153, 79);
            Numero2.TabIndex = 13;
            Numero2.Text = "2";
            Numero2.UseVisualStyleBackColor = true;
            // 
            // Numero3
            // 
            Numero3.Dock = DockStyle.Fill;
            Numero3.Location = new Point(321, 269);
            Numero3.Name = "Numero3";
            Numero3.Size = new Size(153, 79);
            Numero3.TabIndex = 14;
            Numero3.Text = "3";
            Numero3.UseVisualStyleBackColor = true;
            // 
            // SimboloIgual
            // 
            tableLayoutPanel1.SetColumnSpan(SimboloIgual, 2);
            SimboloIgual.Dock = DockStyle.Fill;
            SimboloIgual.Location = new Point(480, 269);
            SimboloIgual.Name = "SimboloIgual";
            tableLayoutPanel1.SetRowSpan(SimboloIgual, 2);
            SimboloIgual.Size = new Size(312, 168);
            SimboloIgual.TabIndex = 15;
            SimboloIgual.Text = "=";
            SimboloIgual.UseVisualStyleBackColor = true;
            // 
            // SimbolPunto
            // 
            SimbolPunto.Dock = DockStyle.Fill;
            SimbolPunto.Location = new Point(3, 354);
            SimbolPunto.Name = "SimbolPunto";
            SimbolPunto.Size = new Size(153, 83);
            SimbolPunto.TabIndex = 16;
            SimbolPunto.Text = ".";
            SimbolPunto.UseVisualStyleBackColor = true;
            // 
            // Numero0
            // 
            tableLayoutPanel1.SetColumnSpan(Numero0, 2);
            Numero0.Dock = DockStyle.Fill;
            Numero0.Location = new Point(162, 354);
            Numero0.Name = "Numero0";
            Numero0.Size = new Size(312, 83);
            Numero0.TabIndex = 17;
            Numero0.Text = "0";
            Numero0.UseVisualStyleBackColor = true;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = SystemColors.ActiveBorder;
            ClientSize = new Size(795, 440);
            Controls.Add(tableLayoutPanel1);
            Name = "Form1";
            Text = "Form1";
            tableLayoutPanel1.ResumeLayout(false);
            tableLayoutPanel1.PerformLayout();
            ResumeLayout(false);
        }

        private Label label1;
        private TableLayoutPanel tableLayoutPanel1;
        private System.ComponentModel.BackgroundWorker backgroundWorker1;
        private Button SimboloDividir;
        private Button Numero1;
        private Button Numero2;
        private Button Numero3;
        private Button Numero7;
        private Button Numero8;
        private Button Numero9;
        private Button SimboloMas;
        private Button SimboloMenos;
        private Button Numero4;
        private Button Numero5;
        private Button Numero6;
        private Button SimboloPor;
        private Button SimbolPunto;
        private Button Numero0;
        private Button SimboloIgual;
    }
}
