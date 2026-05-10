package components;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;
import javax.swing.*;
import java.awt.*;
import dao.AlunoDAO;
import models.Aluno;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.text.MaskFormatter;

public class Janela1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private JTextField txtRGM;
    private JTextField txtNome;
    private JFormattedTextField txtDataNascimento;
    private JFormattedTextField txtCPF;
    private JTextField txtEmail;
    private JTextField txtEndereco;
    private JTextField txtMunicipio;
    private JComboBox<String> cbUF;
    private JFormattedTextField txtCelular;
    private JComboBox<String> cbGenero;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Janela1 frame = new Janela1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Janela1() throws Exception {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 826, 477);

        // ── Variáveis de layout (declaradas UMA vez) ──
        int labelH  = 22;
        int fieldH  = 28;
        int marginX = 20;

        // ── Menu Bar ──
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnAluno = new JMenu("Aluno");
        menuBar.add(mnAluno);
        

        
        mnAluno.add(new JMenuItem("Alterar"));
        mnAluno.add(new JMenuItem("Consultar"));
        mnAluno.add(new JMenuItem("Excluir"));
        mnAluno.add(new JSeparator());
        mnAluno.add(new JMenuItem("Sair"));

        JMenu mnNotasFaltas = new JMenu("Notas e Faltas");
        menuBar.add(mnNotasFaltas);
        mnNotasFaltas.add(new JMenuItem("Salvar"));
        mnNotasFaltas.add(new JMenuItem("Alterar"));
        mnNotasFaltas.add(new JMenuItem("Excluir"));
        mnNotasFaltas.add(new JMenuItem("Consultar"));

        menuBar.add(new JMenu("Ajuda"));

        // ── Content Pane ──
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 10, 790, 410);
        contentPane.add(tabbedPane);


        // ── Aba Dados Pessoais ──

        JPanel panelDadosPessoais = new JPanel();
        panelDadosPessoais.setLayout(null);
        tabbedPane.addTab("Dados Pessoais", null, panelDadosPessoais, null);

        int[] rowY = {20, 75, 130, 185, 240, 295};

        JLabel lblRGM = new JLabel("RGM");
        lblRGM.setBounds(marginX, rowY[0] + 3, 40, labelH);
        panelDadosPessoais.add(lblRGM);

        txtRGM = new JTextField();
        txtRGM.setDocument(new ApenasNumeros(8));
        txtRGM.setBounds(65, rowY[0], 120, fieldH);
        panelDadosPessoais.add(txtRGM);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(210, rowY[0] + 3, 45, labelH);
        panelDadosPessoais.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(260, rowY[0], 505, fieldH);
        panelDadosPessoais.add(txtNome);

        JLabel lblDataNasc = new JLabel("Data de Nascimento");
        lblDataNasc.setBounds(marginX, rowY[1] + 3, 135, labelH);
        panelDadosPessoais.add(lblDataNasc);

        txtDataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
        txtDataNascimento.setBounds(160, rowY[1], 130, fieldH);
        panelDadosPessoais.add(txtDataNascimento);

        JLabel lblCPF = new JLabel("CPF");
        lblCPF.setBounds(310, rowY[1] + 3, 35, labelH);
        panelDadosPessoais.add(lblCPF);
       
        txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        txtCPF.setBounds(348, rowY[1], 180, fieldH);
        panelDadosPessoais.add(txtCPF);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(marginX, rowY[2] + 3, 40, labelH);
        panelDadosPessoais.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(65, rowY[2], 700, fieldH);
        panelDadosPessoais.add(txtEmail);

        JLabel lblEnd = new JLabel("Endereço");
        lblEnd.setBounds(marginX, rowY[3] + 3, 65, labelH);
        panelDadosPessoais.add(lblEnd);

        txtEndereco = new JTextField();
        txtEndereco.setBounds(90, rowY[3], 675, fieldH);
        panelDadosPessoais.add(txtEndereco);

        JLabel lblMunicipio = new JLabel("Município");
        lblMunicipio.setBounds(marginX, rowY[4] + 3, 65, labelH);
        panelDadosPessoais.add(lblMunicipio);

        txtMunicipio = new JTextField();
        txtMunicipio.setBounds(90, rowY[4], 200, fieldH);
        panelDadosPessoais.add(txtMunicipio);

        JLabel lblUF = new JLabel("UF");
        lblUF.setBounds(305, rowY[4] + 3, 25, labelH);
        panelDadosPessoais.add(lblUF);

        String[] estados = {
            "AC","AL","AP","AM","BA","CE","DF","ES","GO","MA",
            "MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN",
            "RS","RO","RR","SC","SP","SE","TO"
        };
        cbUF = new JComboBox<>(estados);
        cbUF.setSelectedItem("SP");
        cbUF.setBounds(333, rowY[4], 70, fieldH);
        panelDadosPessoais.add(cbUF);

        JLabel lblCelular = new JLabel("Celular");
        lblCelular.setBounds(420, rowY[4] + 3, 50, labelH);
        panelDadosPessoais.add(lblCelular);

        txtCelular = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
        txtCelular.setBounds(475, rowY[4], 290, fieldH);
        panelDadosPessoais.add(txtCelular);

        JLabel lblGenero = new JLabel("Gênero");
        lblGenero.setBounds(marginX, rowY[5] + 3, 55, labelH);
        panelDadosPessoais.add(lblGenero);

        cbGenero = new JComboBox<>(new String[]{
            "Selecione", "Masculino", "Feminino", "Não Binário", "Prefiro Não Informar"
        });
        cbGenero.setBounds(80, rowY[5], 180, fieldH);
        panelDadosPessoais.add(cbGenero);
        
        JButton btnNewButton = new JButton("Salvar");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 29));
        btnNewButton.addActionListener(new ActionListener() {
        	
        	
        	public void actionPerformed(ActionEvent e) {
        		try {
                    Aluno aluno = new Aluno();
                    aluno.setRgm(txtRGM.getText());
                    aluno.setNome(txtNome.getText());
                    aluno.setCpf(txtCPF.getText());
                    aluno.setEmail(txtEmail.getText());
                    aluno.setEndereco(txtEndereco.getText());
                    aluno.setMunicipio(txtMunicipio.getText());
                    aluno.setUf(cbUF.getSelectedItem().toString());
                    aluno.setNumeroCelular(txtCelular.getText());
                    aluno.setGenero(cbGenero.getSelectedItem().toString());

                    // curso exemplo
                    aluno.setCurso(1);

                    // convertendo data
                    SimpleDateFormat sdf =
                            new SimpleDateFormat("dd/MM/yyyy");

                    java.util.Date data =
                            sdf.parse(txtDataNascimento.getText());

                    aluno.setDataNascimento(data);

                    // DAO
                    AlunoDAO dao = new AlunoDAO();

                    // salva no banco
                    dao.salvar(aluno);

                    JOptionPane.showMessageDialog(
                            null,
                            "Aluno salvo com sucesso!"
                    );

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Erro: " + ex.getMessage()
                    );

                    ex.printStackTrace();
                }
        	}
        });
        btnNewButton.setBounds(523, 302, 262, 69);
        panelDadosPessoais.add(btnNewButton);

        // ── Aba Curso ──
        JPanel panelCurso = new JPanel();
        panelCurso.setLayout(null);
        tabbedPane.addTab("Curso", null, panelCurso, null);

        JLabel lblCurso = new JLabel("Curso");
        lblCurso.setBounds(marginX, 30, 55, labelH);
        panelCurso.add(lblCurso);

        JComboBox<String> cbCurso = new JComboBox<>(new String[]{
            "Analise e Desenvolvimento de Sistemas",
            "Ciência da Computação",
            "Engenharia de Software",
            "Sistemas de Informação",
            "Redes de Computadores"
        });
        cbCurso.setSelectedIndex(0);
        cbCurso.setBounds(90, 27, 450, fieldH);
        panelCurso.add(cbCurso);

        JLabel lblCampus = new JLabel("Campus");
        lblCampus.setBounds(marginX, 80, 55, labelH);
        panelCurso.add(lblCampus);

        JComboBox<String> cbCampus = new JComboBox<>(new String[]{
            "Tatuapé", "Centro", "Santo André", "Campinas", "Sorocaba"
        });
        cbCampus.setSelectedItem("Tatuapé");
        cbCampus.setBounds(90, 77, 450, fieldH);
        panelCurso.add(cbCampus);

        JLabel lblPeriodo = new JLabel("Período");
        lblPeriodo.setBounds(marginX, 130, 55, labelH);
        panelCurso.add(lblPeriodo);

        ButtonGroup grupoPeriodo = new ButtonGroup();

        JRadioButton rbMatutino = new JRadioButton("Matutino");
        rbMatutino.setBounds(90, 127, 100, fieldH);
        grupoPeriodo.add(rbMatutino);
        panelCurso.add(rbMatutino);

        JRadioButton rbVespertino = new JRadioButton("Vespertino");
        rbVespertino.setBounds(200, 127, 110, fieldH);
        grupoPeriodo.add(rbVespertino);
        panelCurso.add(rbVespertino);

        JRadioButton rbNoturno = new JRadioButton("Noturno");
        rbNoturno.setBounds(320, 127, 90, fieldH);
        rbNoturno.setSelected(true);
        grupoPeriodo.add(rbNoturno);
        panelCurso.add(rbNoturno);


     // ── Aba Notas e Faltas ──
     JPanel panelNotas = new JPanel();
     panelNotas.setLayout(null);
     tabbedPane.addTab("Notas e Faltas", null, panelNotas, null);

     // Linha 1: RGM e Nome do Aluno
     JLabel lblRGMNotas = new JLabel("RGM");
     lblRGMNotas.setBounds(marginX, 20, 35, labelH);
     panelNotas.add(lblRGMNotas);

     JTextField txtRGMNotas = new JTextField();
     txtRGMNotas.setDocument(new ApenasNumeros(8));
     txtRGMNotas.setBounds(60, 17, 120, fieldH);
     panelNotas.add(txtRGMNotas);

     JTextField txtNomeAluno = new JTextField("deverá mostrar o nome do aluno");
     txtNomeAluno.setForeground(new Color(0, 0, 0));
     txtNomeAluno.setEditable(false);
     txtNomeAluno.setBounds(195, 17, 570, fieldH);
     panelNotas.add(txtNomeAluno);

     // Linha 2: Curso do Aluno
     JTextField txtCursoAluno = new JTextField("deverá mostrar o curso do aluno");
     txtCursoAluno.setForeground(new Color(0, 0, 0));
     txtCursoAluno.setEditable(false);
     txtCursoAluno.setBounds(marginX, 60, 745, fieldH);
     panelNotas.add(txtCursoAluno);

     // Linha 3: Disciplina
     JLabel lblDisciplina = new JLabel("Disciplina");
     lblDisciplina.setBounds(marginX, 105, 65, labelH);
     panelNotas.add(lblDisciplina);

     JComboBox<String> cbDisciplina = new JComboBox<>(new String[]{
         "Programação Orientada a Objetos",
         "Estrutura de Dados",
         "Banco de Dados",
         "Engenharia de Software",
         "Redes de Computadores",
         "Sistemas Operacionais"
     });
     cbDisciplina.setSelectedIndex(0);
     cbDisciplina.setBounds(90, 102, 450, fieldH);
     panelNotas.add(cbDisciplina);

     // Linha 4: Semestre, Nota, Faltas
     JLabel lblSemestre = new JLabel("Semestre");
     lblSemestre.setBounds(marginX, 150, 60, labelH);
     panelNotas.add(lblSemestre);

     JComboBox<String> cbSemestre = new JComboBox<>(new String[]{
         "2020-1","2020-2","2021-1","2021-2",
         "2022-1","2022-2","2023-1","2023-2",
         "2024-1","2024-2","2025-1","2025-2"
     });
     cbSemestre.setSelectedItem("2020-1");
     cbSemestre.setBounds(85, 147, 90, fieldH);
     panelNotas.add(cbSemestre);

     JLabel lblNota = new JLabel("Nota");
     lblNota.setBounds(190, 150, 35, labelH);
     panelNotas.add(lblNota);

     JComboBox<String> cbNota = new JComboBox<>(new String[]{
         "0,0","0,5","1,0","1,5","2,0","2,5","3,0","3,5",
         "4,0","4,5","5,0","5,5","6,0","6,5","7,0","7,5",
         "8,0","8,5","9,0","9,5","10,0"
     });
     cbNota.setSelectedItem("0,5");
     cbNota.setBounds(228, 147, 70, fieldH);
     panelNotas.add(cbNota);

     JLabel lblFaltas = new JLabel("Faltas");
     lblFaltas.setBounds(315, 150, 40, labelH);
     panelNotas.add(lblFaltas);

     JTextField txtFaltas = new JTextField();
     txtFaltas.setDocument(new ApenasNumeros(3));
     txtFaltas.setBounds(358, 147, 80, fieldH);
     panelNotas.add(txtFaltas);
        tabbedPane.addTab("Boletim", null, new JPanel(), null);
    }

    class ApenasNumeros extends javax.swing.text.PlainDocument {
        private int limite;
        public ApenasNumeros(int limite) { this.limite = limite; }

        @Override
        public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
                throws javax.swing.text.BadLocationException {
            if (str == null) return;
            str = str.replaceAll("[^0-9]", "");
            if ((getLength() + str.length()) <= limite)
                super.insertString(offs, str, a);
        }
    }
}