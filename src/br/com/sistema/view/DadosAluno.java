package br.com.sistema.view;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.TextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.sistema.dao.DadosDAO;
import br.com.sistema.dao.NotasDAO;
import br.com.sistema.model.Dados;
import br.com.sistema.model.Notas;



public class DadosAluno extends JFrame {
	
	private JPanel contentPane;
	private JLabel lblMessage;

	
	private JFormattedTextField ftfRGM;
	private JTextField txtNome;
	private JFormattedTextField ftfNascimento;
	private JFormattedTextField ftfCpf;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JComboBox cmbMunicipio;
	private JComboBox cmbUf;
	private JFormattedTextField ftfCelular;
	private JComboBox cmbCurso;
	private JComboBox cmbCampus;
	private final ButtonGroup btgPeriodo = new ButtonGroup();
	private JButton btnSave;
	private JButton btnOff;
	private JButton btnbtnUpload;
	private JButton btnBusca;
	private JButton btnTrash;
	private JButton btnClean;
	

	private JFormattedTextField ftfRgm2;
	private JButton btnSave2;
	private JButton btnOff2;
	private JButton btnbtnUpload2;
	private JButton btnBusca2;
	private JButton btnTrash2;
	
	private JComboBox cmbDisciplina;
	private JComboBox cmbSemestre;
	private JComboBox cmbNotas;
	private JTextField txtFaltas;

	
	private JFormattedTextField ftfRgm3;
	private JLabel lblNomeAluno;
	private JLabel lblCurso;
	private JButton btnBusca3;
	private JButton btnTrash3;
	
	private TextComponent ftfRgm;
	private AbstractButton rdbtnMatutino;
	private AbstractButton rdbtnVespetino;
	private AbstractButton rdbtnNoturno;
	
	private JTextArea txtDisciplina;


	private Dados dados;
	private DadosDAO dao;
	private Notas notas;
	private NotasDAO notasdao;
	private JTextField txtRgmNotas;
	private JTextField txtRgmBoletim;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DadosAluno frame = new DadosAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public DadosAluno() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 453, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewAluno = new JMenu("Aluno");
		mnNewAluno.setBorder(null);
		mnNewAluno.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewAluno);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Salvar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//***********************************************************
				try {
					dados = new Dados();
					dados.setRGM_ALUNO(Integer.parseInt(ftfRgm.getText()));
					dados.setNOME_ALUNO(txtNome.getText());
					dados.setNASC_ALUNO(ftfNascimento.getText());
					dados.setCPF_ALUNO(ftfCpf.getText());
					dados.setEMAIL_ALUNO(txtEmail.getText());
					dados.setEND_ALUNO(txtEndereco.getText());
					dados.setMUN_RESIDE((String)cmbMunicipio.getSelectedItem());
					dados.setUF_ALUNO((String)cmbUf.getSelectedItem());
					dados.setCEL_ALUNO(ftfCelular.getText());
					dados.setCURSO_ALUNO((String)cmbCurso.getSelectedItem());
					dados.setCAMPUS_CURSO((String)cmbCampus.getSelectedItem());
				
				if(rdbtnMatutino.isSelected()) {
					dados.setPERIODO_CURSO("Matutino");
					dao = new DadosDAO();
					dao.salvar(dados);
				}else if(rdbtnVespetino.isSelected()) {
					dados.setPERIODO_CURSO("Vespertino");
					dao = new DadosDAO();
					dao.salvar(dados); 
				}else if(rdbtnNoturno.isSelected()){
					dados.setPERIODO_CURSO("Noturno");
					dao = new DadosDAO();
					dao.salvar(dados);
				}
				
					//Abrir a conexão
					dao = new DadosDAO();
					//Salvando
					dao.salvar(dados);
					JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
				} catch (Exception e) {
					//JOptionPane.showMessageDialog(null, "Erro ao salvar");
				}
					
				//***********************************************************
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewAluno.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Alterar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//*********************************************************** 
				try {
					dados = new Dados();
					dados.setRGM_ALUNO(Integer.parseInt(ftfRgm.getText()));
					dados.setNOME_ALUNO(txtNome.getText());
					dados.setNASC_ALUNO(ftfNascimento.getText());
					dados.setCPF_ALUNO(ftfCpf.getText());
					dados.setEMAIL_ALUNO(txtEmail.getText());
					dados.setEND_ALUNO(txtEndereco.getText());
					dados.setMUN_RESIDE((String)cmbMunicipio.getSelectedItem());
					dados.setUF_ALUNO((String)cmbUf.getSelectedItem());
					dados.setCEL_ALUNO(ftfCelular.getText());
					dados.setCURSO_ALUNO((String)cmbCurso.getSelectedItem());
					dados.setCAMPUS_CURSO((String)cmbCampus.getSelectedItem());
				
				if(rdbtnMatutino.isSelected()) {
					dados.setPERIODO_CURSO("Matutino");
					dao = new DadosDAO();
					dao.salvar(dados);
				}else if(rdbtnVespetino.isSelected()) {
					dados.setPERIODO_CURSO("Vespertino");
					dao = new DadosDAO();
					dao.salvar(dados);
				}else if(rdbtnNoturno.isSelected()){
					dados.setPERIODO_CURSO("Noturno");
					dao = new DadosDAO();
					dao.salvar(dados);
				}
				
					//Abrir a conexão
					dao = new DadosDAO();
					//Alterar
					dao.alterar(dados);
					JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
					//lblMessage.setText("Alterado com sucesso!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro ao Alterar");
					//lblMessage.setText("Erro ao ALterar!");
				}
					
				//***********************************************************
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewAluno.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Consultar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//*************************************************************
				try {
						dao = new DadosDAO();
						int codigo = Integer.parseInt(ftfRgm.getText());
						dados = dao.consultar(codigo);
						txtNome.setText(dados.getNOME_ALUNO());
						ftfNascimento.setText(dados.getNASC_ALUNO());
						ftfCpf.setText(dados.getCPF_ALUNO());
						txtEmail.setText(dados.getEMAIL_ALUNO());
						txtEndereco.setText(dados.getEND_ALUNO());
						ftfCelular.setText(dados.getCEL_ALUNO());
						
						String municipio = dados.getMUN_RESIDE();
						  if (municipio.equals("Bahia")) {
							cmbMunicipio.setSelectedIndex(1);
						} else if (municipio.equals("Minas Gerais")) {
								cmbMunicipio.setSelectedIndex(2);
						} else if (municipio.equals("Rio de Janeiro")) {
								cmbMunicipio.setSelectedIndex(3);
						} else if (municipio.equals("São Paulo")){
								cmbMunicipio.setSelectedIndex(4);
						}
							
					//*************************************************************	
						  	String Uf = dados.getUF_ALUNO();	
							if (Uf.equals("BA")) {
								cmbUf.setSelectedIndex(1);
							} else if (Uf.equals("MG")) {
								cmbUf.setSelectedIndex(2);
							} else if (Uf.equals("RJ")) {
			 					cmbUf.setSelectedIndex(3);
							} else {
								cmbUf.setSelectedIndex(4);
							}
							
							String Curso = dados.getCURSO_ALUNO();		
							if (Curso.equals("Análise e Desenvolvimento de Sistemas")) {
								cmbCurso.setSelectedIndex(2);
							} else if (Curso.equals("Gestão de Recursos Humanos")) {
								cmbCurso.setSelectedIndex(3);
							} else if (Curso.equals("Logística")) {
			 					cmbCurso.setSelectedIndex(4);
							} else if (Curso.equals("Marketing")) {
				 				cmbCurso.setSelectedIndex(5);
							} else {
				 				cmbCurso.setSelectedIndex(6);
							} 
						//*************************************************************	
							String Campus = dados.getCAMPUS_CURSO();		
							if (Campus.equals("Pinheiros")) {
								cmbCampus.setSelectedIndex(1);
							} else {
								cmbCampus.setSelectedIndex(2);
							}	
							
						//*************************************************************	
						String periodo = dados.getPERIODO_CURSO();	
							if (periodo.equals("Matutino")) {
								rdbtnMatutino.setSelected(true);
							} else if (periodo.equals("Vespertino")){ 
								rdbtnVespetino.setSelected(true);
							} else if (periodo.equals("Noturno")){ 
								rdbtnNoturno.setSelected(true);
							}	
					} catch (Exception e4) {
					//JOptionPane.showMessageDialog(null, "Aluno não encontrado");
					}
				//*************************************************************
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewAluno.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Excluir");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//***********************************************************
				try {
					//Abrir a conexão
					dao = new DadosDAO();
					//Alterar
					int codigo = Integer.parseInt(ftfRgm.getText());
					dao.excluir(codigo);
					//JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
					JOptionPane.showMessageDialog(null,"Excluido com sucesso!");
				
					ftfRgm.setText(null);
					txtNome.setText(null); 
					ftfNascimento.setText(null); 
					ftfNascimento.setText("");
					ftfCpf.setText(null);
					txtEmail.setText(null);
					txtEndereco.setText(null);
					cmbMunicipio.setSelectedItem("");
					cmbUf.setSelectedItem("");
					ftfCelular.setText(null);
					cmbCurso.setSelectedItem(null);
					cmbCampus.setSelectedItem(null);
					//rdbtnMatutino.setText(null);
					//rdbtnVespetino.setText(null);
					//rdbtnNoturno.setText(null);
				
				} catch (Exception e3) {
					//JOptionPane.showMessageDialog(null,"Falha ao Excluir!");
				}
				
				//***********************************************************
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewAluno.add(mntmNewMenuItem_3);
		
		JSeparator separator = new JSeparator();
		mnNewAluno.add(separator);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Sair");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//***********************************************************
			System.exit(0);
				//***********************************************************
			}
		});
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewAluno.add(mntmNewMenuItem_4);
		
		JMenu mnNewNotasFaltas = new JMenu("Notas e Faltas");
		mnNewNotasFaltas.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewNotasFaltas);
		
		JMenuItem menuItem = new JMenuItem("Salvar");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//*********************************************************************
				try {
					notas = new Notas ();
					notas.setRGM_ALUNO(Integer.parseInt(txtRgmNotas.getText()));
					notas.setDISC_NF((String)cmbDisciplina.getSelectedItem());
					notas.setSEMESTRE_NF((String)cmbSemestre.getSelectedItem());
					notas.setNOTA_NF((String)cmbNotas.getSelectedItem());
					notas.setFALTAS_NF(txtFaltas.getText());
					notasdao = new NotasDAO();
					notasdao.salvar(notas);
					JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, "Erro ao Salvar!");
					System.out.println(e3.getMessage());
				}
				
				
				//*****************************************************************
			}
		});
		menuItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewNotasFaltas.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Alterar");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//*********************************************************************
				try {
					notas = new Notas ();
					notas.setRGM_ALUNO(Integer.parseInt(txtRgmNotas.getText()));
					notas.setDISC_NF((String)cmbDisciplina.getSelectedItem());
					notas.setSEMESTRE_NF((String)cmbSemestre.getSelectedItem());
					notas.setNOTA_NF((String)cmbNotas.getSelectedItem());
					notas.setFALTAS_NF(txtFaltas.getText());
					notasdao = new NotasDAO();
					notasdao.alterar(notas);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Alterar!");
					System.out.println(e1.getMessage());
				}
				
				
				//*****************************************************************
			}
		});
		menuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		menuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewNotasFaltas.add(menuItem_1);
		
		JMenuItem menuItem_3 = new JMenuItem("Excluir");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//*********************************************************************
				try {
					
					notasdao = new NotasDAO();
					
					int codigo = Integer.parseInt(txtRgmNotas.getText());
					notasdao.excluir(codigo);
					JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Excluir!");
					System.out.println(e1.getMessage());
				}
				
				
				//*****************************************************************
			}
		});
		menuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuItem_3.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewNotasFaltas.add(menuItem_3);
		
		JMenuItem menuItem_2 = new JMenuItem("Consultar");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//*************************************************************
				try {
						dao = new DadosDAO();
						int codiDados = Integer.parseInt(txtRgmNotas.getText());
						dados = dao.consultar(codiDados);
						lblNomeAluno.setText(dados.getNOME_ALUNO());
						lblCurso.setText(dados.getCURSO_ALUNO());
						
						
						notasdao = new NotasDAO();
						
						int codiNotas = Integer.parseInt(txtRgmNotas.getText());
						notas = notasdao.consultar(codiNotas);
						txtFaltas.setText(notas.getFALTAS_NF());

						String disciplina = notas.getDISC_NF();
							   if (disciplina.equals("APLICAÇÕES PARA INTERNET")) {
							cmbDisciplina.setSelectedIndex(1);
						} else if (disciplina.equals("BANCO DE DADOS")) {
							cmbDisciplina.setSelectedIndex(2);
						} else if (disciplina.equals("PROGRAMAÇÃO DE COMPUTADORES")){
							cmbDisciplina.setSelectedIndex(3);
						} else if (disciplina.equals("PROGRAMAÇÃO ORIENTADA A OBJETOS")){
							cmbDisciplina.setSelectedIndex(4);
						} else if (disciplina.equals("PROGRAMAÇÃO PARA DISPOSITIVOS MÓVEIS")){
							cmbDisciplina.setSelectedIndex(5);
						} else if (disciplina.equals("PROGRAMAÇÃO WEB")){
							cmbDisciplina.setSelectedIndex(6);
						} else if (disciplina.equals("TÉCNICAS DE DESENVOLVIMENTO DE ALGORITMOS")){
							cmbDisciplina.setSelectedIndex(7);
						} else {
							cmbDisciplina.setSelectedIndex(8);
						} 
							
					
						  
						  	String semestre = notas.getSEMESTRE_NF();	
						  		   if (semestre.equals("2020-01")) {
								cmbSemestre.setSelectedIndex(1);
							} else {
								cmbSemestre.setSelectedIndex(2);
							}

							String NotaAluno = notas.getNOTA_NF();
								   if (NotaAluno.equals("0")) { 
							    cmbNotas.setSelectedIndex(1);
						    } else if (NotaAluno.equals("1")) {
								cmbNotas.setSelectedIndex(2);
							} else if (NotaAluno.equals("2")) {
								cmbNotas.setSelectedIndex(3);
							} else if (NotaAluno.equals("3")) {
								cmbNotas.setSelectedIndex(4);
							} else if (NotaAluno.equals("4")) {
								cmbNotas.setSelectedIndex(5);
							} else if (NotaAluno.equals("5")) {
								cmbNotas.setSelectedIndex(6);
							} else if (NotaAluno.equals("6")) {
								cmbNotas.setSelectedIndex(7);
							} else if (NotaAluno.equals("7")) {
								cmbNotas.setSelectedIndex(8);
							} else if (NotaAluno.equals("8")) {
								cmbNotas.setSelectedIndex(9);
							} else if (NotaAluno.equals("9")) {
								cmbNotas.setSelectedIndex(10);
							} else {
								cmbNotas.setSelectedIndex(11);
							}	
							
					} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, "Disciplinas não encontradas");
					//System.out.println(e3.getMessage());
					}
				//*************************************************************
			}
		});
		menuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuItem_2.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewNotasFaltas.add(menuItem_2);
		
		JMenu mnNewAjuda = new JMenu("Ajuda");
		mnNewAjuda.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewAjuda);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Sobre");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//********************************************************
				JOptionPane.showMessageDialog(null, "Informações do Menu");
				//********************************************************
			}
		});
		mnNewAjuda.add(mntmNewMenuItem_5);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 44, 433, 273);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RGM");
		lblNewLabel.setBounds(10, 27, 31, 20);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(159, 27, 46, 20);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtNome = new JTextField();
		txtNome.setBounds(206, 27, 212, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data de nascimento");
		lblNewLabel_2.setBounds(10, 65, 139, 20);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JFormattedTextField ftfNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		ftfNascimento.setBounds(145, 65, 77, 20);
		ftfNascimento.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		panel.add(ftfNascimento);
		
		
		JLabel lblNewLabel_3 = new JLabel("CPF");
		lblNewLabel_3.setBounds(232, 65, 46, 20);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JFormattedTextField ftfCpf = new JFormattedTextField(new MaskFormatter("###-###-###/##"));
		ftfCpf.setBounds(272, 65, 146, 20);
		panel.add(ftfCpf);
		
		JLabel lblNewLabel_4 = new JLabel("E-mail");
		lblNewLabel_4.setBounds(10, 98, 46, 20);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtEmail = new JTextField();
		txtEmail.setBounds(73, 98, 345, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Endere\u00E7o");
		lblNewLabel_5.setBounds(10, 134, 68, 20);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(73, 134, 345, 20);
		panel.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Municipio");
		lblNewLabel_6.setBounds(10, 175, 57, 20);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox cmbMunicipio = new JComboBox();
		cmbMunicipio.setBounds(77, 175, 86, 20);
		panel.add(cmbMunicipio);
		cmbMunicipio.setModel(new DefaultComboBoxModel(new String[] {"", "Bahia", "Minas Gerais", "Rio de Janeiro", "S\u00E3o Paulo"}));
		
		JLabel lblNewLabel_7 = new JLabel("UF");
		lblNewLabel_7.setBounds(173, 175, 31, 20);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox cmbUf = new JComboBox();
		cmbUf.setBounds(195, 175, 57, 20);
		panel.add(cmbUf);
		cmbUf.setModel(new DefaultComboBoxModel(new String[] {"", "BA", "MG", "RJ", "SP"}));
		
		JLabel lblNewLabel_8 = new JLabel("Celular");
		lblNewLabel_8.setBounds(262, 175, 46, 20);
		panel.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JFormattedTextField ftfCelular = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		ftfCelular.setBounds(318, 175, 100, 20);
		panel.add(ftfCelular);
		
		JFormattedTextField ftfRgm = new JFormattedTextField();
		ftfRgm.setBounds(51, 27, 98, 20);
		panel.add(ftfRgm);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Curso");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(24, 27, 79, 20);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCampus.setBounds(24, 77, 79, 20);
		panel_1.add(lblCampus);
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPeriodo.setBounds(24, 124, 79, 20);
		panel_1.add(lblPeriodo);
		
		JComboBox cmbCurso = new JComboBox();
		cmbCurso.setModel(new DefaultComboBoxModel(new String[] {"-- Selecione um Curso --", "An\u00E1lise e Desenvolvimento de Sistemas", "Gest\u00E3o de Recursos Humanos", "Gest\u00E3o da Tecnologia da Informa\u00E7\u00E3o", "Log\u00EDstica", "Marketing", "Secretariado"}));
		cmbCurso.setBounds(109, 27, 290, 20);
		panel_1.add(cmbCurso);
		
		JComboBox cmbCampus = new JComboBox();
		cmbCampus.setModel(new DefaultComboBoxModel(new String[] {"-- Selecione uma Unidade --", "Pinheiros", "Tat\u00FAape"}));
		cmbCampus.setBounds(109, 77, 290, 20);
		panel_1.add(cmbCampus);
		
		JRadioButton rdbtnMatutino = new JRadioButton("Matutino");
		btgPeriodo.add(rdbtnMatutino);
		rdbtnMatutino.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnMatutino.setBounds(109, 124, 92, 20);
		panel_1.add(rdbtnMatutino);
		
		JRadioButton rdbtnNoturno = new JRadioButton("Noturno");
		btgPeriodo.add(rdbtnNoturno);
		rdbtnNoturno.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnNoturno.setBounds(297, 124, 79, 20);
		panel_1.add(rdbtnNoturno);
		
		JRadioButton rdbtnVespetino = new JRadioButton("Vespetino");
		btgPeriodo.add(rdbtnVespetino);
		rdbtnVespetino.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnVespetino.setBounds(203, 124, 92, 20);
		panel_1.add(rdbtnVespetino);
		
		JButton btnOff = new JButton("");
		btnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//***********************************************************
				ftfRgm.setText(null);
				txtNome.setText(null); 
				ftfNascimento.setText(null); 
				ftfNascimento.setText("");
				ftfCpf.setText(null);
				txtEmail.setText(null);
				txtEndereco.setText(null);
				cmbMunicipio.setSelectedIndex(0);
				cmbUf.setSelectedItem("");
				ftfCelular.setText(null);
				cmbCurso.setSelectedIndex(0);
				cmbCampus.setSelectedIndex(0);
				
				//rdbtnMatutino.setText(null);
				//rdbtnVespetino.setText(null);
				//rdbtnNoturno.setText(null);
				//***********************************************************
			}
		});
		btnOff.setIcon(new ImageIcon("C:\\Users\\Vinicius Sararoli\\eclipse-workspace\\SistemaAluno\\imgs\\IconLimpar.png"));
		btnOff.setBounds(24, 171, 63, 63);
		panel_1.add(btnOff);
		
		JButton btnAlteracao = new JButton("");
		btnAlteracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//***********************************************************
				try {
					dados = new Dados();
					dados.setRGM_ALUNO(Integer.parseInt(ftfRgm.getText()));
					dados.setNOME_ALUNO(txtNome.getText());
					dados.setNASC_ALUNO(ftfNascimento.getText());
					dados.setCPF_ALUNO(ftfCpf.getText());
					dados.setEMAIL_ALUNO(txtEmail.getText());
					dados.setEND_ALUNO(txtEndereco.getText());
					dados.setMUN_RESIDE((String)cmbMunicipio.getSelectedItem());
					dados.setUF_ALUNO((String)cmbUf.getSelectedItem());
					dados.setCEL_ALUNO(ftfCelular.getText());
					dados.setCURSO_ALUNO((String)cmbCurso.getSelectedItem());
					dados.setCAMPUS_CURSO((String)cmbCampus.getSelectedItem());
				
				if(rdbtnMatutino.isSelected()) {
					dados.setPERIODO_CURSO("Matutino");
					dao = new DadosDAO();
					dao.salvar(dados);
				}else if(rdbtnVespetino.isSelected()) {
					dados.setPERIODO_CURSO("Vespertino");
					dao = new DadosDAO();
					dao.salvar(dados);
				}else if(rdbtnNoturno.isSelected()){
					dados.setPERIODO_CURSO("Noturno");
					dao = new DadosDAO();
					dao.salvar(dados);
				}
				
					//Abrir a conexão
					dao = new DadosDAO();
					//Alterar
					dao.alterar(dados);
					JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
					//lblMessage.setText("Alterado com sucesso!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro ao Alterar");
					//lblMessage.setText("Erro ao ALterar!");
				}
					
				//***********************************************************
			
			}
		});
		btnAlteracao.setIcon(new ImageIcon("C:\\Users\\Vinicius Sararoli\\eclipse-workspace\\SistemaAluno\\imgs\\IconUp.png"));
		btnAlteracao.setBounds(101, 171, 63, 63);
		panel_1.add(btnAlteracao);
		
		btnSave = new JButton("");
		btnSave.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
				//***********************************************************
				try {
					dados = new Dados();
					dados.setRGM_ALUNO(Integer.parseInt(ftfRgm.getText()));
					dados.setNOME_ALUNO(txtNome.getText());
					dados.setNASC_ALUNO(ftfNascimento.getText());
					dados.setCPF_ALUNO(ftfCpf.getText());
					dados.setEMAIL_ALUNO(txtEmail.getText());
					dados.setEND_ALUNO(txtEndereco.getText());
					dados.setMUN_RESIDE((String)cmbMunicipio.getSelectedItem());
					dados.setUF_ALUNO((String)cmbUf.getSelectedItem());
					dados.setCEL_ALUNO(ftfCelular.getText());
					dados.setCURSO_ALUNO((String)cmbCurso.getSelectedItem());
					dados.setCAMPUS_CURSO((String)cmbCampus.getSelectedItem());
				
				if(rdbtnMatutino.isSelected()) {
					dados.setPERIODO_CURSO("Matutino");
					dao = new DadosDAO();
					dao.salvar(dados);
				}else if(rdbtnVespetino.isSelected()) {
					dados.setPERIODO_CURSO("Vespertino");
					dao = new DadosDAO();
					dao.salvar(dados); 
				}else if(rdbtnNoturno.isSelected()){
					dados.setPERIODO_CURSO("Noturno");
					dao = new DadosDAO();
					dao.salvar(dados);
				}
				
					//Abrir a conexão
					dao = new DadosDAO();
					//Salvando
					dao.salvar(dados);
					JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar");
				}
					
				//***********************************************************
			}
		});
		btnSave.setIcon(new ImageIcon("C:\\Users\\Vinicius Sararoli\\eclipse-workspace\\SistemaAluno\\imgs\\IconSave.png"));
		btnSave.setBounds(178, 171, 63, 63);
		panel_1.add(btnSave);
		
		JButton btnBusca = new JButton("");
		btnBusca.setIcon(new ImageIcon("C:\\Users\\Vinicius Sararoli\\eclipse-workspace\\SistemaAluno\\imgs\\IconQuery.png"));
		btnBusca.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				//*************************************************************
				try {
						dao = new DadosDAO();
						int codigo = Integer.parseInt(ftfRgm.getText());
						dados = dao.consultar(codigo);
						txtNome.setText(dados.getNOME_ALUNO());
						ftfNascimento.setText(dados.getNASC_ALUNO());
						ftfCpf.setText(dados.getCPF_ALUNO());
						txtEmail.setText(dados.getEMAIL_ALUNO());
						txtEndereco.setText(dados.getEND_ALUNO());
						ftfCelular.setText(dados.getCEL_ALUNO());
						
						String municipio = dados.getMUN_RESIDE();
						  if (municipio.equals("Bahia")) {
							cmbMunicipio.setSelectedIndex(1);
						} else if (municipio.equals("Minas Gerais")) {
								cmbMunicipio.setSelectedIndex(2);
						} else if (municipio.equals("Rio de Janeiro")) {
								cmbMunicipio.setSelectedIndex(3);
						} else if (municipio.equals("São Paulo")){
								cmbMunicipio.setSelectedIndex(4);
						}
							
					//*************************************************************	
						  	String Uf = dados.getUF_ALUNO();	
							if (Uf.equals("BA")) {
								cmbUf.setSelectedIndex(1);
							} else if (Uf.equals("MG")) {
								cmbUf.setSelectedIndex(2);
							} else if (Uf.equals("RJ")) {
			 					cmbUf.setSelectedIndex(3);
							} else {
								cmbUf.setSelectedIndex(4);
							}
							
							String Curso = dados.getCURSO_ALUNO();		
							if (Curso.equals("Análise e Desenvolvimento de Sistemas")) {
								cmbCurso.setSelectedIndex(1);
							} else if (Curso.equals("Gestão de Recursos Humanos")) {
								cmbCurso.setSelectedIndex(2);
							} else if (Curso.equals("Gestão da Tecnologia da Informação")) {
								cmbCurso.setSelectedIndex(3);
							} else if (Curso.equals("Logística")) {
			 					cmbCurso.setSelectedIndex(4);
							} else if (Curso.equals("Marketing")) {
				 				cmbCurso.setSelectedIndex(5);
							} else {
				 				cmbCurso.setSelectedIndex(6);
							} 
						//*************************************************************	
							String Campus = dados.getCAMPUS_CURSO();		
							if (Campus.equals("Pinheiros")) {
								cmbCampus.setSelectedIndex(1);
							} else {
								cmbCampus.setSelectedIndex(2);
							}	
							
						//*************************************************************	
						String periodo = dados.getPERIODO_CURSO();	
							if (periodo.equals("Matutino")) {
								rdbtnMatutino.setSelected(true);
							} else if (periodo.equals("Vespertino")){ 
								rdbtnVespetino.setSelected(true);
							} else if (periodo.equals("Noturno")){ 
								rdbtnNoturno.setSelected(true);
							}	
					} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Aluno não encontrado");
					}
				//*************************************************************
				
				
			}
		});
		btnBusca.setBounds(255, 171, 63, 63);
		panel_1.add(btnBusca);
		
		JButton btnTrash = new JButton("");
		btnTrash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//***********************************************************
				try {
					//Abrir a conexão
					dao = new DadosDAO();
					//Alterar
					int codigo = Integer.parseInt(ftfRgm.getText());
					dao.excluir(codigo);
					//JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
					JOptionPane.showMessageDialog(null,"Excluido com sucesso!");
				
					ftfRgm.setText(null);
					txtNome.setText(null); 
					ftfNascimento.setText(null); 
					ftfNascimento.setText("");
					ftfCpf.setText(null);
					txtEmail.setText(null);
					txtEndereco.setText(null);
					cmbMunicipio.setSelectedItem("");
					cmbUf.setSelectedItem("");
					ftfCelular.setText(null);
					cmbCurso.setSelectedItem(null);
					cmbCampus.setSelectedItem(null);
					//rdbtnMatutino.setText(null);
					//rdbtnVespetino.setText(null);
					//rdbtnNoturno.setText(null);
				
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null,"Falha ao Excluir!");
				}
				
				//***********************************************************
			}
		});
		btnTrash.setIcon(new ImageIcon("C:\\Users\\Vinicius Sararoli\\eclipse-workspace\\SistemaAluno\\imgs\\IconTrash.png"));
		btnTrash.setBounds(332, 171, 63, 63);
		panel_1.add(btnTrash);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("RGM");
		label.setBounds(10, 16, 31, 20);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(label);
		
		JLabel lblNomeAluno = new JLabel("");
		lblNomeAluno.setBounds(172, 16, 229, 20);
		lblNomeAluno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeAluno.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(105, 105, 105), new Color(105, 105, 105)));
		panel_2.add(lblNomeAluno);
		
		JLabel lblCurso = new JLabel("");
		lblCurso.setBounds(10, 47, 391, 20);
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurso.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(105, 105, 105), new Color(105, 105, 105)));
		panel_2.add(lblCurso);
		
		JLabel lblNewLabel_10 = new JLabel("Disciplina");
		lblNewLabel_10.setBounds(10, 82, 65, 20);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_10);
		
		JComboBox cmbDisciplina = new JComboBox();
		cmbDisciplina.setBounds(72, 84, 329, 20);
		cmbDisciplina.setModel(new DefaultComboBoxModel(new String[] {"", "APLICA\u00C7\u00D5ES PARA INTERNET", "BANCO DE DADOS", "PROGRAMA\u00C7\u00C3O DE COMPUTADORES", "PROGRAMA\u00C7\u00C3O ORIENTADA A OBJETOS", "PROGRAMA\u00C7\u00C3O PARA DISPOSITIVOS M\u00D3VEIS", "PROGRAMA\u00C7\u00C3O WEB", "T\u00C9CNICAS DE DESENVOLVIMENTO DE ALGORITMOS", "T\u00C9CNICAS DE PROGRAMA\u00C7\u00C3O"}));
		panel_2.add(cmbDisciplina);
		
		JLabel lblNewLabel_11 = new JLabel("Semestre");
		lblNewLabel_11.setBounds(10, 116, 65, 20);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_11);
		
		JComboBox cmbSemestre = new JComboBox();
		cmbSemestre.setBounds(76, 115, 86, 20);
		cmbSemestre.setModel(new DefaultComboBoxModel(new String[] {"", "2020-01", "2020-02"}));
		panel_2.add(cmbSemestre);
		
		JComboBox cmbNotas = new JComboBox();
		cmbNotas.setBounds(216, 115, 56, 20);
		cmbNotas.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		panel_2.add(cmbNotas);
		
		JLabel lblNewLabel_12 = new JLabel("Faltas");
		lblNewLabel_12.setBounds(309, 116, 46, 20);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_12);
		
		JLabel lblNota = new JLabel("Nota");
		lblNota.setBounds(172, 115, 38, 20);
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNota);
		
		JButton BtnSave2 = new JButton("");
		BtnSave2.setBounds(25, 171, 63, 63);
		BtnSave2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//*********************************************************************
				try {
					notas = new Notas ();
					notas.setRGM_ALUNO(Integer.parseInt(txtRgmNotas.getText()));
					notas.setDISC_NF((String)cmbDisciplina.getSelectedItem());
					notas.setSEMESTRE_NF((String)cmbSemestre.getSelectedItem());
					notas.setNOTA_NF((String)cmbNotas.getSelectedItem());
					notas.setFALTAS_NF(txtFaltas.getText());
					notasdao = new NotasDAO();
					notasdao.salvar(notas);
					JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao Salvar!");
					System.out.println(e.getMessage());
				}
				
				
				//*****************************************************************
			}
		});
		BtnSave2.setIcon(new ImageIcon("C:\\Users\\Vinicius Sararoli\\eclipse-workspace\\SistemaAluno\\imgs\\IconSave.png"));
		panel_2.add(BtnSave2);
		
		JButton btnAlteracao2 = new JButton("");
		btnAlteracao2.setBounds(102, 171, 63, 63);
		btnAlteracao2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//*********************************************************************
				try {
					notas = new Notas ();
					notas.setRGM_ALUNO(Integer.parseInt(txtRgmNotas.getText()));
					notas.setDISC_NF((String)cmbDisciplina.getSelectedItem());
					notas.setSEMESTRE_NF((String)cmbSemestre.getSelectedItem());
					notas.setNOTA_NF((String)cmbNotas.getSelectedItem());
					notas.setFALTAS_NF(txtFaltas.getText());
					notasdao = new NotasDAO();
					notasdao.alterar(notas);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Alterar!");
					System.out.println(e1.getMessage());
				}
				
				
				//*****************************************************************
			}
		});
		btnAlteracao2.setIcon(new ImageIcon("C:\\Users\\Vinicius Sararoli\\eclipse-workspace\\SistemaAluno\\imgs\\IconUp.png"));
		panel_2.add(btnAlteracao2);
		
		JButton btnConsultarNotas = new JButton("");
		btnConsultarNotas.setBounds(179, 171, 63, 63);
		btnConsultarNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//*************************************************************
				try {
						dao = new DadosDAO();
						int codiDados = Integer.parseInt(txtRgmNotas.getText());
						dados = dao.consultar(codiDados);
						lblNomeAluno.setText(dados.getNOME_ALUNO());
						lblCurso.setText(dados.getCURSO_ALUNO());
						
						
						notasdao = new NotasDAO();
						
						int codiNotas = Integer.parseInt(txtRgmNotas.getText());
						notas = notasdao.consultar(codiNotas);
						txtFaltas.setText(notas.getFALTAS_NF());

						String disciplina = notas.getDISC_NF();
							   if (disciplina.equals("APLICAÇÕES PARA INTERNET")) {
							cmbDisciplina.setSelectedIndex(1);
						} else if (disciplina.equals("BANCO DE DADOS")) {
							cmbDisciplina.setSelectedIndex(2);
						} else if (disciplina.equals("PROGRAMAÇÃO DE COMPUTADORES")){
							cmbDisciplina.setSelectedIndex(3);
						} else if (disciplina.equals("PROGRAMAÇÃO ORIENTADA A OBJETOS")){
							cmbDisciplina.setSelectedIndex(4);
						} else if (disciplina.equals("PROGRAMAÇÃO PARA DISPOSITIVOS MÓVEIS")){
							cmbDisciplina.setSelectedIndex(5);
						} else if (disciplina.equals("PROGRAMAÇÃO WEB")){
							cmbDisciplina.setSelectedIndex(6);
						} else if (disciplina.equals("TÉCNICAS DE DESENVOLVIMENTO DE ALGORITMOS")){
							cmbDisciplina.setSelectedIndex(7);
						} else {
							cmbDisciplina.setSelectedIndex(8);
						} 
							
					
						  
						  	String semestre = notas.getSEMESTRE_NF();	
						  		   if (semestre.equals("2020-01")) {
								cmbSemestre.setSelectedIndex(1);
							} else {
								cmbSemestre.setSelectedIndex(2);
							}
					
					
							
							String NotaAluno = notas.getNOTA_NF();
								   if (NotaAluno.equals("0")) { 
							    cmbNotas.setSelectedIndex(1);
						    } else if (NotaAluno.equals("1")) {
								cmbNotas.setSelectedIndex(2);
							} else if (NotaAluno.equals("2")) {
								cmbNotas.setSelectedIndex(3);
							} else if (NotaAluno.equals("3")) {
								cmbNotas.setSelectedIndex(4);
							} else if (NotaAluno.equals("4")) {
								cmbNotas.setSelectedIndex(5);
							} else if (NotaAluno.equals("5")) {
								cmbNotas.setSelectedIndex(6);
							} else if (NotaAluno.equals("6")) {
								cmbNotas.setSelectedIndex(7);
							} else if (NotaAluno.equals("7")) {
								cmbNotas.setSelectedIndex(8);
							} else if (NotaAluno.equals("8")) {
								cmbNotas.setSelectedIndex(9);
							} else if (NotaAluno.equals("9")) {
								cmbNotas.setSelectedIndex(10);
							} else {
								cmbNotas.setSelectedIndex(11);
							}	
							
					} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, "Disciplinas não encontradas");
					//System.out.println(e3.getMessage());
					}
				//*************************************************************
			}
		});
		btnConsultarNotas.setIcon(new ImageIcon("C:\\Users\\Vinicius Sararoli\\eclipse-workspace\\SistemaAluno\\imgs\\IconQuery.png"));
		panel_2.add(btnConsultarNotas);
		
		JButton btnTrashNotas = new JButton("");
		btnTrashNotas.setBounds(256, 171, 63, 63);
		btnTrashNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//*********************************************************************
				try {
					
					notasdao = new NotasDAO();
					
					int codigo = Integer.parseInt(txtRgmNotas.getText());
					notasdao.excluir(codigo);
					JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Excluir!");
					System.out.println(e1.getMessage());
				}
				
				
				//*****************************************************************

			}
		});
		btnTrashNotas.setIcon(new ImageIcon("C:\\Users\\Vinicius Sararoli\\eclipse-workspace\\SistemaAluno\\imgs\\IconTrash.png"));
		panel_2.add(btnTrashNotas);
		
		JButton btnOff2 = new JButton("");
		btnOff2.setBounds(333, 171, 63, 63);
		btnOff2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//***********************************************************
				txtRgmNotas.setText(null);
				lblNomeAluno.setText(null);
				lblCurso.setText(null); 
				cmbDisciplina.setSelectedIndex(0);
				cmbSemestre.setSelectedIndex(0);
				cmbNotas.setSelectedIndex(0);
				txtFaltas.setText(null);
			
				//***********************************************************
			}
		});
		btnOff2.setIcon(new ImageIcon("C:\\Users\\Vinicius Sararoli\\eclipse-workspace\\SistemaAluno\\imgs\\IconLimpar.png"));
		panel_2.add(btnOff2);
		
		txtFaltas = new JTextField();
		txtFaltas.setBounds(353, 115, 46, 20);
		panel_2.add(txtFaltas);
		txtFaltas.setColumns(10);
		
		txtRgmNotas = new JTextField();
		txtRgmNotas.setBounds(51, 16, 98, 20);
		txtRgmNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtRgmNotas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(105, 105, 105), new Color(105, 105, 105)));
		txtRgmNotas.setActionCommand("txtRgmNota");
		panel_2.add(txtRgmNotas);
		txtRgmNotas.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Boletim", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel label_1 = new JLabel("RGM");
		label_1.setBounds(10, 11, 31, 20);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(label_1);
		
		JLabel lblNomeBoletim = new JLabel("");
		lblNomeBoletim.setBounds(118, 30, 300, 20);
		lblNomeBoletim.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, new Color(105, 105, 105)));
		panel_3.add(lblNomeBoletim);
		
		JLabel lblCursoBoletim = new JLabel("");
		lblCursoBoletim.setBounds(10, 73, 408, 20);
		lblCursoBoletim.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, new Color(105, 105, 105)));
		panel_3.add(lblCursoBoletim);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(118, 11, 98, 20);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(lblNome);
		
		JLabel lblCurso_1 = new JLabel("Curso");
		lblCurso_1.setBounds(10, 54, 98, 20);
		lblCurso_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(lblCurso_1);
		
		JLabel lblDisciplina = new JLabel("Disciplinas");
		lblDisciplina.setBounds(108, 100, 73, 20);
		lblDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(lblDisciplina);
		
		btnClean = new JButton("");
		btnClean.setBounds(10, 195, 40, 40);
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//***********************************************************
				txtRgmBoletim.setText("");
				lblNomeBoletim.setText(null); 
				lblCursoBoletim.setText(null); 
				txtDisciplina.setText(" "); 
				lblMessage.setText(null);
				//***********************************************************
			}
		});
		btnClean.setIcon(new ImageIcon("C:\\Users\\Vinicius Sararoli\\eclipse-workspace\\SistemaAluno\\imgs\\IconClean.png"));
		panel_3.add(btnClean);
		
		JButton btnListar = new JButton("");
		btnListar.setBounds(60, 195, 40, 40);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//***********************************************************
				try {
					dao = new DadosDAO();
					int codiDados = Integer.parseInt(txtRgmBoletim.getText());
					dados = dao.consultar(codiDados);
					lblNomeBoletim.setText(dados.getNOME_ALUNO());
					lblCursoBoletim.setText(dados.getCURSO_ALUNO());
					}
					catch(Exception e1) {
						System.out.println(e1.getMessage());
						//lblAluno.setText("Erro ao Consultar");
					}
	
				
				try {
					List<Notas> lista = new ArrayList<Notas>();
					notasdao = new NotasDAO();
					int rgm = Integer.parseInt(txtRgmBoletim.getText());
					lista = notasdao.listarTodos();
					for(Notas notas : lista) {
						txtDisciplina.append("Disciplina... "+notas.getDISC_NF()+"\n");
						txtDisciplina.append("Semestre... "+notas.getSEMESTRE_NF()+"\n");
						txtDisciplina.append("Nota... "+notas.getNOTA_NF()+"\n");
						txtDisciplina.append("Falta... "+notas.getFALTAS_NF()+"\n\n");
						
					}
					
					}catch(Exception e1) {
						//lblAviso1.setText("Erro ao Consultar" + e1.getMessage());
						System.out.println(e1.getMessage());
						
					}
				
				//=============================
				
				
				//***********************************************************
			}
		});
		btnListar.setIcon(new ImageIcon("C:\\Users\\Vinicius Sararoli\\eclipse-workspace\\SistemaAluno\\imgs\\IconList.png"));
		panel_3.add(btnListar);
		
		TextArea txtDisciplina = new TextArea();
		txtDisciplina.setBounds(106, 120, 312, 115);
		txtDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(txtDisciplina);
		
		txtRgmBoletim = new JTextField();
		txtRgmBoletim.setBounds(10, 30, 98, 20);
		txtRgmBoletim.setColumns(10);
		txtRgmBoletim.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(128, 128, 128), new Color(169, 169, 169)));
		panel_3.add(txtRgmBoletim);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setBounds(13, 318, 429, 14);
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMessage.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(128, 128, 128), null));
		contentPane.add(lblMessage);
	}
}
