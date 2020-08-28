package br.com.sistema.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema.model.Notas;
import br.com.sistema.util.ConnectionFactory;

public class NotasDAO {
		private Notas notas;
		private Connection conn;
		private java.sql.PreparedStatement ps;
		private ResultSet rs2;
		
		public NotasDAO() throws Exception{
			try {
				conn = ConnectionFactory.getConnection();
			} catch (Exception e) {
				throw new Exception("Erro" + e.getMessage());
			}
		}
		//**************************SAVE*************************************
		public void salvar(Notas notas) throws Exception {
			try {
				String sql= "INSERT INTO notas(RGM_ALUNO, DISC_NF, SEMESTRE_NF, NOTA_NF, FALTAS_NF) VALUES (?, ?, ?, ?, ?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, notas.getRGM_ALUNO());
				ps.setString(2, notas.getDISC_NF());
				ps.setString(3, notas.getSEMESTRE_NF());
				ps.setString(4, notas.getNOTA_NF());
				ps.setString(5, notas.getFALTAS_NF());
				ps.executeUpdate();
			} catch (Exception e) {
				throw new Exception("Erro ao Salvar" + e.getMessage());
			}
		}
		//**************************UPDATE*************************************
				public void alterar(Notas notas) throws Exception {
					try {
						String sql= "UPDATE notas SET DISC_NF=?, SEMESTRE_NF=?, NOTA_NF=?, FALTAS_NF=? WHERE RGM_ALUNO=?";
						ps = conn.prepareStatement(sql);
						ps.setString(1, notas.getDISC_NF());
						ps.setString(2, notas.getSEMESTRE_NF());
						ps.setString(3, notas.getNOTA_NF());
						ps.setString(4, notas.getFALTAS_NF());
						ps.setInt(5, notas.getRGM_ALUNO());
						ps.executeUpdate();
					} catch (Exception e) {
						throw new Exception("Erro ao Alterar" + e.getMessage());
					}
				}
				//**************************DELETE*************************************
				public void excluir(int RGM_ALUNO) throws Exception {
					try {
						String sql= "DELETE FROM notas WHERE RGM_ALUNO=?";
						ps = conn.prepareStatement(sql);
						ps.setInt(1, RGM_ALUNO);
						ps.executeUpdate();
					} catch (Exception e) {
						throw new Exception("Erro ao Excluir" + e.getMessage());
					}
				}
		//************************LIST*****************************************
			
				public List listarTodos() throws Exception {
					List<Notas> lista = new ArrayList<Notas>(); 
					try {
					ps = conn.prepareStatement("SELECT * FROM notas");
					rs2 = ps.executeQuery();
					while(rs2.next()) {
						int RGM_ALUNO = rs2.getInt("RGM_ALUNO");
						String DISC_NF = rs2.getString("DISC_NF");
						String SEMESTRE_NF = rs2.getString("SEMESTRE_NF");
						String NOTA_NF = rs2.getString("NOTA_NF");			
						String FALTAS_NF = rs2.getString("FALTAS_NF");
						notas = new Notas(RGM_ALUNO, DISC_NF, SEMESTRE_NF, NOTA_NF, FALTAS_NF);
						lista.add(notas);
					}
					return lista;
						
					}catch(Exception e) {
						throw new Exception("Erro ao Listar" + e.getMessage());
					}
				}

		//************************SELECT*****************************************
				public Notas consultar(int RGM_ALUNO) throws Exception {
					try {
					ps = conn.prepareStatement("SELECT * FROM notas WHERE RGM_ALUNO=?");
					ps.setInt(1, RGM_ALUNO);
					rs2 = ps.executeQuery();
					if (rs2.next()) {
						String DISC_NF = rs2.getString("DISC_NF");
						String SEMESTRE_NF = rs2.getString("SEMESTRE_NF");
						String NOTA_NF = rs2.getString("NOTA_NF");
						String FALTAS_NF = rs2.getString("FALTAS_NF");
						notas = new Notas(RGM_ALUNO, DISC_NF, SEMESTRE_NF, NOTA_NF, FALTAS_NF);	
					}
						return notas;
						
					} catch (Exception e) {
					throw new Exception("Erro ao Listar" + e.getMessage());
					}
				}
								
}
