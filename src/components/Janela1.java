package components;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import dao.AlunoDAO;
import dao.NotaDAO;
import models.Aluno;
import models.Nota;

import java.awt.TextArea;
import javax.swing.JTable;

public class Janela1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    private Aluno aluno;
    private AlunoDAO dao;
    private JTextField txtRGM;
    private JTextField txtNome;
    private JFormattedTextField txtDataNascimento;
    private JFormattedTextField txtCPF;
    private JTextField txtEmail;
    private JTextField txtEndereco;
    private JTextField txtMunicipio;
    private JComboBox<String> cmbUF;
    private JFormattedTextField txtCelular;
    private JComboBox<String> cmbGenero;
    private JTextField txtNota;
    private JTextField txtMostraraFaltasDo;
    private JTextField txtSobrenome;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField txtRGMBoletim;
    private JTextField txtRGMNotas;
    private JTextField txtRGMLista;

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
        setBounds(100, 100, 826, 529);

        //
        int labelH  = 22;
        int fieldH  = 28;
        int marginX = 20;

      
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnAluno = new JMenu("Aluno");
        menuBar.add(mnAluno);
        
        JMenuItem mntmNewMenuItem_3 = new JMenuItem("Salvar");
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			Aluno aluno = new Aluno();

                    // Dados pessoais
                    aluno.setRgm(txtRGM.getText());
                    aluno.setNome(txtNome.getText());
                    aluno.setSobrenome(txtSobrenome.getText());
                    aluno.setCpf(txtCPF.getText());
                    aluno.setEmail(txtEmail.getText());
                    aluno.setEndereco(txtEndereco.getText());
                    aluno.setMunicipio(txtMunicipio.getText());
                    aluno.setUf(cmbUF.getSelectedItem().toString());
                    aluno.setNumeroCelular(txtCelular.getText());
                    aluno.setGenero(cmbGenero.getSelectedItem().toString());

                    // Data de nascimento
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    aluno.setDataNascimento(sdf.parse(txtDataNascimento.getText()));

                    // Salva no banco
                    AlunoDAO dao = new AlunoDAO();
                    dao.salvar(aluno);

                    JOptionPane.showMessageDialog(null, "Aluno salvo com sucesso!");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
                    ex.printStackTrace();
              }
        		
        	}
        });
        mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        mnAluno.add(mntmNewMenuItem_3);
        mnAluno.add(new JSeparator());
        JMenuItem menuItem = new JMenuItem("Sair");
        menuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
        mnAluno.add(menuItem);
        
        JMenu mnNewMenu = new JMenu("Curso");
        menuBar.add(mnNewMenu);
                
        JMenu mnAjuda = new JMenu("Ajuda");
        menuBar.add(mnAjuda);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Sobre");
        mntmNewMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(null, "Sistema feito para uso de gerenciamento escolar");
        		
        	}
        });
        mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
        mnAjuda.add(mntmNewMenuItem);


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 10, 790, 447);
        contentPane.add(tabbedPane);


        // Dados Pessoais

        JPanel panelDadosPessoais = new JPanel();
        panelDadosPessoais.setLayout(null);
        tabbedPane.addTab("Dados Pessoais", null, panelDadosPessoais, null);

        int[] rowY = {20, 75, 130, 185, 240, 295};

        JLabel lblRGM = new JLabel("RGM");
        lblRGM.setBounds(marginX, rowY[0] + 3, 40, labelH);
        panelDadosPessoais.add(lblRGM);

        txtRGM = new JTextField();
        txtRGM = new JFormattedTextField(new MaskFormatter("#####"));
        txtRGM.setBounds(65, rowY[0], 120, fieldH);
        panelDadosPessoais.add(txtRGM);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(210, rowY[0] + 3, 45, labelH);
        panelDadosPessoais.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(260, 20, 145, 28);
        panelDadosPessoais.add(txtNome);
        
        JLabel lblSobrenome = new JLabel("Sobrenome");
        lblSobrenome.setBounds(424, 27, 71, 14);
        panelDadosPessoais.add(lblSobrenome);
        
        txtSobrenome = new JTextField();
        txtSobrenome.setBounds(498, 20, 267, 28);
        panelDadosPessoais.add(txtSobrenome);
        txtSobrenome.setColumns(10);

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
        cmbUF = new JComboBox<>(estados);
        cmbUF.setSelectedItem("SP");
        cmbUF.setBounds(333, rowY[4], 70, fieldH);
        panelDadosPessoais.add(cmbUF);

        JLabel lblCelular = new JLabel("Celular");
        lblCelular.setBounds(420, rowY[4] + 3, 50, labelH);
        panelDadosPessoais.add(lblCelular);

        txtCelular = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
        txtCelular.setBounds(475, rowY[4], 290, fieldH);
        panelDadosPessoais.add(txtCelular);

        JLabel lblGenero = new JLabel("Gênero");
        lblGenero.setBounds(marginX, rowY[5] + 3, 55, labelH);
        panelDadosPessoais.add(lblGenero);

        cmbGenero = new JComboBox<>(new String[]{
            "Selecione", "Masculino", "Feminino", "Não Binário", "Prefiro Não Informar"
        });
        cmbGenero.setBounds(80, rowY[5], 180, fieldH);
        panelDadosPessoais.add(cmbGenero);
        
        
        // Botão NOVO (só apaga tudo)
        JButton btnNovo = new JButton("Novo");
        btnNovo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		txtRGM.setText(null);
        		txtNome.setText(null);
        		txtSobrenome.setText(null);
        		txtDataNascimento.setText(null);
        		txtCPF.setText(null);
        		txtEmail.setText(null);
        		txtEndereco.setText(null);
        		txtMunicipio.setText(null);
        		cmbUF.setSelectedIndex(0);
        		txtCelular.setText(null);
        		cmbGenero.setSelectedIndex(0);
        	}
        });
        btnNovo.setBounds(408, 378, 105, 39);
        panelDadosPessoais.add(btnNovo);
       

        // ── Aba Curso ──
        JPanel panelCurso = new JPanel();
        panelCurso.setLayout(null);
        tabbedPane.addTab("Curso", null, panelCurso, null);

        JLabel lblCurso = new JLabel("Curso");
        lblCurso.setBounds(marginX, 30, 55, labelH);
        panelCurso.add(lblCurso);
        
        JComboBox cmbCurso = new JComboBox();
        cmbCurso.setModel(new DefaultComboBoxModel(new String[] {"Analise e Desenvolvimento de Sistema", "Engenharia", "Direito", "Medicina", "Arquitetura"}));
        cmbCurso.setBounds(90, 30, 455, 22);
        panelCurso.add(cmbCurso);
        
        JLabel lblCampus = new JLabel("Campus");
        lblCampus.setBounds(marginX, 80, 55, labelH);
        panelCurso.add(lblCampus);
        
        JComboBox cmbCampus = new JComboBox();
        cmbCampus.setModel(new DefaultComboBoxModel(new String[] {"Tatuapé", "Mooca", "Lapa", "Santana", "Centro"}));
        cmbCampus.setBounds(90, 80, 455, 22);
        panelCurso.add(cmbCampus);


        JLabel lblPeriodo = new JLabel("Período");
        lblPeriodo.setBounds(marginX, 130, 55, labelH);
        panelCurso.add(lblPeriodo);
        
        
        JButton btnAlterarPessoais = new JButton("Alterar");
        btnAlterarPessoais.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			Aluno aluno = new Aluno();

                    // Dados pessoais
                    aluno.setRgm(txtRGM.getText());
                    aluno.setNome(txtNome.getText());
                    aluno.setSobrenome(txtSobrenome.getText());
                    aluno.setCpf(txtCPF.getText());
                    aluno.setEmail(txtEmail.getText());
                    aluno.setEndereco(txtEndereco.getText());
                    aluno.setMunicipio(txtMunicipio.getText());
                    aluno.setUf(cmbUF.getSelectedItem().toString());
                    aluno.setNumeroCelular(txtCelular.getText());
                    aluno.setGenero(cmbGenero.getSelectedItem().toString());

                    // Data de nascimento
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    aluno.setDataNascimento(sdf.parse(txtDataNascimento.getText()));

                    // Salva no banco
                    AlunoDAO dao = new AlunoDAO();
                    dao.atualizar(aluno);

                    JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso!");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar: " + ex.getMessage());
                    ex.printStackTrace();
                }
               }
            });
        
        btnAlterarPessoais.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnAlterarPessoais.setBounds(523, 378, 262, 41);
        panelDadosPessoais.add(btnAlterarPessoais);
        
        
        // SALVAR DADOS DO ALUNO
        JButton btnSalvarDadosPessoais = new JButton("Salvar");
        btnSalvarDadosPessoais.setFont(new Font("Tahoma", Font.PLAIN, 29));
        btnSalvarDadosPessoais.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		try {
                			Aluno aluno = new Aluno();

                            // Dados pessoais
                            aluno.setRgm(txtRGM.getText());
                            aluno.setNome(txtNome.getText());
                            aluno.setSobrenome(txtSobrenome.getText());
                            aluno.setCpf(txtCPF.getText());
                            aluno.setEmail(txtEmail.getText());
                            aluno.setEndereco(txtEndereco.getText());
                            aluno.setMunicipio(txtMunicipio.getText());
                            aluno.setUf(cmbUF.getSelectedItem().toString());
                            aluno.setNumeroCelular(txtCelular.getText());
                            aluno.setGenero(cmbGenero.getSelectedItem().toString());

                            // Data de nascimento
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            aluno.setDataNascimento(sdf.parse(txtDataNascimento.getText()));

                            // Salva no banco
                            AlunoDAO dao = new AlunoDAO();
                            dao.salvar(aluno);

                            JOptionPane.showMessageDialog(null, "Aluno salvo com sucesso!");

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
                            ex.printStackTrace();
                      }
        	       
        	}
        });
        btnSalvarDadosPessoais.setBounds(523, 298, 262, 69);
        panelDadosPessoais.add(btnSalvarDadosPessoais);
                
        
        // SALVAR CURSO DO ALUNO
        JButton btnSalvarDadosCurso = new JButton("Salvar");
        btnSalvarDadosCurso.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
                    Aluno aluno = new Aluno();
                    
                    // RGM do aluno
                    aluno.setRgm(txtRGM.getText());
                    
                    // Dados do curso
                    aluno.setCurso_id(cmbCurso.getSelectedIndex() + 1);
                    aluno.setPeriodo(buttonGroup.getSelection().getActionCommand());

                    // Salva no banco
                    AlunoDAO dao = new AlunoDAO();
                    dao.salvarCurso(aluno);

                    JOptionPane.showMessageDialog(null, "Curso do aluno salvo com sucesso!");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
                    ex.printStackTrace();
                }
        	}
        });
        btnSalvarDadosCurso.setFont(new Font("Tahoma", Font.PLAIN, 29));
        btnSalvarDadosCurso.setBounds(523, 298, 262, 69);       

        panelCurso.add(btnSalvarDadosCurso);
        
        JRadioButton rdbtnVespertino = new JRadioButton("Vespertino");
        buttonGroup.add(rdbtnVespertino);
        rdbtnVespertino.setActionCommand("Vespertino");
        rdbtnVespertino.setBounds(90, 130, 109, 23);
        rdbtnVespertino.setSelected(true);
        panelCurso.add(rdbtnVespertino);
        
        
        JRadioButton rdbtnMatutino = new JRadioButton("Matutino");
        buttonGroup.add(rdbtnMatutino);
        rdbtnMatutino.setBounds(201, 130, 109, 23);
        rdbtnMatutino.setActionCommand("Matutino");
        panelCurso.add(rdbtnMatutino);
        
        
        JRadioButton rdbtnNoturno = new JRadioButton("Noturno");
        buttonGroup.add(rdbtnNoturno);
        rdbtnNoturno.setBounds(312, 130, 109, 23);
        rdbtnNoturno.setActionCommand("Noturno");
        panelCurso.add(rdbtnNoturno);
        
        JButton btnAlterarCurso = new JButton("Alterar");
        btnAlterarCurso.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
                    Aluno aluno = new Aluno();

                    // Dados pessoais
                    aluno.setRgm(txtRGM.getText());
                    
                    // Dados do curso
                    aluno.setCurso_id(cmbCurso.getSelectedIndex() + 1);
                    aluno.setPeriodo(buttonGroup.getSelection().getActionCommand());

                    // Altera no banco
                    AlunoDAO dao = new AlunoDAO();
                    dao.atualizarCurso(aluno);

                    JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso!");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar: " + ex.getMessage());
                    ex.printStackTrace();
                }
        	}
        });
        
       // Botão MENU de SALVAR curso
        btnAlterarCurso.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnAlterarCurso.setBounds(523, 378, 262, 41);
        panelCurso.add(btnAlterarCurso);
        
        JMenuItem mntmSalvarCurso = new JMenuItem("Salvar Curso");
        mntmSalvarCurso.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
                    Aluno aluno = new Aluno();
                    
                    // RGM do aluno
                    aluno.setRgm(txtRGM.getText());
                    
                    // Dados do curso
                    aluno.setCurso_id(cmbCurso.getSelectedIndex() + 1);
                    aluno.setPeriodo(buttonGroup.getSelection().getActionCommand());

                    // Salva no banco
                    AlunoDAO dao = new AlunoDAO();
                    dao.salvarCurso(aluno);

                    JOptionPane.showMessageDialog(null, "Curso do aluno salvo com sucesso!");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
                    ex.printStackTrace();
                }
        	}
        });
        mntmSalvarCurso.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
        mnNewMenu.add(mntmSalvarCurso);


     // ── Aba Notas e Faltas ──
     JPanel panelNotas = new JPanel();
     panelNotas.setLayout(null);
     tabbedPane.addTab("Notas e Faltas", null, panelNotas, null);

     // Linha 1: RGM e Nome do Aluno
     JLabel lblRGMNotas = new JLabel("RGM");
     lblRGMNotas.setBounds(marginX, 20, 35, labelH);
     panelNotas.add(lblRGMNotas);

     txtRGMNotas = new JFormattedTextField(new MaskFormatter("#####"));
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

     JComboBox<String> Disciplina = new JComboBox<>(new String[]{
         "Programação Orientada a Objetos",
         "Estrutura de Dados",
         "Banco de Dados",
         "Engenharia de Software",
         "Redes de Computadores",
         "Sistemas Operacionais"
     });
     Disciplina.setModel(new DefaultComboBoxModel(new String[] {"Programação Orientada a Objetos", "Banco de Dados", "Engenharia de Software", "Calculo 1", "Direito Penal"}));
     Disciplina.setSelectedIndex(0);
     Disciplina.setBounds(90, 102, 450, fieldH);
     panelNotas.add(Disciplina);

     // Linha 4: Semestre, Nota, Faltas
     JLabel lblSemestre = new JLabel("Semestre");
     lblSemestre.setBounds(marginX, 150, 60, labelH);
     panelNotas.add(lblSemestre);

     
     JComboBox Semestre = new JComboBox();
     Semestre.setModel(new DefaultComboBoxModel(new String[] {"2025-1", "2025-2", "2026-1", "2026-2"}));
     Semestre.setBounds(75, 150, 94, 22);
     panelNotas.add(Semestre);
        JPanel panelBoletim = new JPanel();
        tabbedPane.addTab("Boletim", null, panelBoletim, null);
        panelBoletim.setLayout(null);
        
        

        
        JLabel lblRGM_1 = new JLabel("RGM");
        lblRGM_1.setBounds(10, 0, 40, 22);
        panelBoletim.add(lblRGM_1);
        

        
        txtRGMBoletim = new JTextField();
        txtRGMBoletim = new JFormattedTextField(new MaskFormatter("#####"));
        txtRGMBoletim.setBounds(10, 18, 120, 24);
        panelBoletim.add(txtRGMBoletim);
        txtRGMBoletim.setColumns(10);
        
        TextArea textBoletim = new TextArea();
        textBoletim.setBounds(10, 49, 765, 360);
        panelBoletim.add(textBoletim);
        
        JButton btnPesquisarBoletim = new JButton("Pesquisar");
        btnPesquisarBoletim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int RGM = Integer.parseInt(txtRGMBoletim.getText().trim());

                    NotaDAO notaDAO = new NotaDAO();
                    List<Nota> boletim = notaDAO.listarBoletim(RGM);

                    textBoletim.setText("");
                    for (Nota n : boletim) {
                        textBoletim.append("Disciplina: " + n.getDisciplina() + "\n");
                        textBoletim.append("Semestre: " + n.getSemestre() + "\n");
                        textBoletim.append("Nota: " + n.getNota() + "\n");
                        textBoletim.append("Faltas: " + n.getFalta() + "\n");
                        textBoletim.append("Situação: " + (n.getNota() >= 5 ? "Aprovado" : "") + "\n");
                        textBoletim.append("\n" + "------------------------------------" + "\n");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao pesquisar: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
        btnPesquisarBoletim.setBounds(140, 16, 120, 28);
        panelBoletim.add(btnPesquisarBoletim);
        
        
     JLabel lblNota = new JLabel("Nota");
     lblNota.setBounds(190, 150, 35, labelH);
     panelNotas.add(lblNota);

     JLabel lblFaltas = new JLabel("Faltas");
     lblFaltas.setBounds(370, 150, 40, labelH);
     panelNotas.add(lblFaltas);
     
     txtNota = new JTextField("Mostrara a nota do aluno");
     txtNota.setForeground(Color.BLACK);
     txtNota.setBounds(229, 147, 128, 28);
     panelNotas.add(txtNota);
     
     txtMostraraFaltasDo = new JTextField("Mostrara Faltas do aluno");
     txtMostraraFaltasDo.setForeground(Color.BLACK);
     txtMostraraFaltasDo.setBounds(412, 147, 128, 28);
     panelNotas.add(txtMostraraFaltasDo);
     
     JButton btnConsultar = new JButton("Consultar Aluno");
     btnConsultar.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e) {
     		try {
     			
     			// Atualiza as disciplinas para serem do curso
     			AlunoDAO dao = new AlunoDAO();
     			int RGM = Integer.parseInt(txtRGMNotas.getText());
     			aluno = dao.consultarAluno(RGM);
     			txtNomeAluno.setText(aluno.getNome() + " " + aluno.getSobrenome()+ "\n");
     			txtCursoAluno.setText(aluno.getNomeCurso());
     			
     			
     			
     			// Atualiza as notas e faltas
     			NotaDAO notaDAO = new NotaDAO();
     		    List<String> disciplinas = notaDAO.listarDisciplinas(aluno.getCurso_id());
     		    Disciplina.removeAllItems();
     		    for (String d : disciplinas) {
     		        Disciplina.addItem(d);
     		    }
     			
                txtNota.setText("");
                txtMostraraFaltasDo.setText("");
    	 
    			} catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex.getMessage());
                ex.printStackTrace();
            }
     	}
     });
     btnConsultar.setBounds(10, 182, 202, 38);
     panelNotas.add(btnConsultar);
     
     // Botão que altera a a nota
     JButton btnSalvarNota = new JButton("Salvar Nota");
     btnSalvarNota.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e) {
     		 try {
                 int RGM = Integer.parseInt(txtRGMNotas.getText().trim());
                 String disciplinaSelecionada = Disciplina.getSelectedItem().toString();
                 String semestreSelecionado = Semestre.getSelectedItem().toString();
                 double novaNota = Double.parseDouble(txtNota.getText().trim());
                 
                 if (novaNota > 10 || novaNota < 0) {
                	    JOptionPane.showMessageDialog(null, "Nota inválida! A nota deve ser entre 0 e 10.");
                	    return;
                	}

                 NotaDAO notaDAO = new NotaDAO();
                 notaDAO.atualizarNota(RGM, disciplinaSelecionada, semestreSelecionado, novaNota);
                 

                 JOptionPane.showMessageDialog(null, "Nota atualizada com sucesso!");
             } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null, "Erro ao atualizar nota: " + ex.getMessage());
                 ex.printStackTrace();
             }
     	}
     });
     
     
     btnSalvarNota.setBounds(229, 182, 128, 39);
     panelNotas.add(btnSalvarNota);
     
     // Botão que salva a falta
     JButton btnSalvarFalta = new JButton("Salvar Falta");
     btnSalvarFalta.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e) {
     		 try {
                 int RGM = Integer.parseInt(txtRGMNotas.getText().trim());
                 String disciplinaSelecionada = Disciplina.getSelectedItem().toString();
                 String semestreSelecionado = Semestre.getSelectedItem().toString();
                 int novaFalta = Integer.parseInt(txtMostraraFaltasDo.getText().trim());
                 if (novaFalta < 0) {
                	    JOptionPane.showMessageDialog(null, "Falta inválida! Faltas devem se pelo menos 0.");
                	    return;
                	}

                 NotaDAO notaDAO = new NotaDAO();
                 notaDAO.atualizarFalta(RGM, disciplinaSelecionada, semestreSelecionado, novaFalta);

                 JOptionPane.showMessageDialog(null, "Falta atualizada com sucesso!");
             } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null, "Erro ao atualizar falta: " + ex.getMessage());
                 ex.printStackTrace();
             }
     	}
     });
     btnSalvarFalta.setBounds(412, 183, 128, 39);
     panelNotas.add(btnSalvarFalta);
     
     JButton btnNewButton_1 = new JButton("Consultar Nota");
     btnNewButton_1.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e) {
     		 try {
                 int RGM = Integer.parseInt(txtRGMNotas.getText().trim());
                 String disciplinaSelecionada = Disciplina.getSelectedItem().toString();
                 String semestreSelecionado = Semestre.getSelectedItem().toString();

                 NotaDAO notaDAO = new NotaDAO();
                 Nota nota = notaDAO.consultarNota(RGM, disciplinaSelecionada, semestreSelecionado);

                 if (nota != null) {
                     txtNota.setText(String.valueOf(nota.getNota()));
                     txtMostraraFaltasDo.setText(String.valueOf(nota.getFalta()));
                 } else {
                     txtNota.setText("Sem registro");
                     txtMostraraFaltasDo.setText("Sem registro");
                 }

             } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null, "Erro ao buscar nota: " + ex.getMessage());
                 ex.printStackTrace();
             }
     	}
     });
     btnNewButton_1.setBounds(567, 142, 120, 39);
     panelNotas.add(btnNewButton_1);
     
     JPanel panelLista = new JPanel();
     panelLista.setLayout(null);
     tabbedPane.addTab("Lista", null, panelLista, null);
     
     JLabel lblAlunos_1 = new JLabel("Alunos:");
     lblAlunos_1.setBounds(10, 11, 46, 14);
     panelLista.add(lblAlunos_1);
     
     TextArea txtLista = new TextArea();
     txtLista.setBounds(10, 33, 439, 375);
     panelLista.add(txtLista);
     
     
     JButton btnAtualizar = new JButton("Atualizar");
     btnAtualizar.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e) {
     		try {
     			txtLista.setText(null);
	     		AlunoDAO dao = new AlunoDAO();
	     		
	     		List<Aluno> lista = new ArrayList<Aluno>();
	     		lista = dao.listar();
	     		
				for(Aluno listar : lista) { 
					txtLista.append("RGM do Aluno: " +listar.getRgm()+"\n");
					txtLista.append("Nome do Aluno: " +listar.getNome() + " " + listar.getSobrenome()+ "\n");
					txtLista.append("Curso do Aluno: " +listar.getNomeCurso()+"\n");
					txtLista.append("Periodo do Aluno: " +listar.getPeriodo()+"\n");
					txtLista.append("\n");
			}
     					
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex.getMessage());
                ex.printStackTrace();
            }
     	}
     });
     btnAtualizar.setBounds(455, 355, 98, 53);
     panelLista.add(btnAtualizar);
     
     JButton btnExcluir_1 = new JButton("Excluir");
     btnExcluir_1.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e) {
        		try {
                    Aluno aluno = new Aluno();

                    // Dados pessoais
                    aluno.setRgm(txtRGMLista.getText());
                    
                    // Altera no banco
                    AlunoDAO dao = new AlunoDAO();
                    dao.deletarAluno(aluno);

                    JOptionPane.showMessageDialog(null, "Aluno excluido com sucesso!");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
                    ex.printStackTrace();
                }
     	}
     });
     btnExcluir_1.setBounds(670, 355, 105, 53);
     panelLista.add(btnExcluir_1);

     
     JLabel lblRGM_2 = new JLabel("RGM");
     lblRGM_2.setBounds(670, 268, 40, 22);
     
     panelLista.add(lblRGM_2);
     
     txtRGMLista = new JFormattedTextField(new MaskFormatter("#####"));
     txtRGMLista.setBounds(670, 286, 109, 22);
     panelLista.add(txtRGMLista);
     txtRGMLista.setColumns(10);
     


    }
    }