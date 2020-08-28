package br.com.sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema.model.Dados;
import br.com.sistema.util.ConnectionFactory;

public class DadosDAO { //CRUD
	
		private Dados dados;
		private Connection conn; //conexao com o banco de dados
		private PreparedStatement ps; //permite executar a query
		private ResultSet rs; // tabela
		
		public DadosDAO() throws Exception{
			try {
				conn = ConnectionFactory.getConnection();
			} catch (Exception e) {
				throw new Exception("Erro" + e.getMessage()); //remover depois 
			}
		}
		//**************************** SAVE ********************************************** 
		public void salvar(Dados dados) throws Exception {
			try {
				String sql="INSERT INTO dadospessoais(RGM_ALUNO,NOME_ALUNO,NASC_ALUNO,CPF_ALUNO,EMAIL_ALUNO,END_ALUNO,MUN_RESIDE,UF_ALUNO,CEL_ALUNO,CURSO_ALUNO,CAMPUS_CURSO,PERIODO_CURSO)" 
				+ "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				ps = conn.prepareStatement(sql);
				ps.setInt(1,dados.getRGM_ALUNO());
				ps.setString(2, dados.getNOME_ALUNO());
				ps.setString(3, dados.getNASC_ALUNO());
				ps.setString(4, dados.getCPF_ALUNO());
				ps.setString(5, dados.getEMAIL_ALUNO());
				ps.setString(6, dados.getEND_ALUNO());
				ps.setString(7, dados.getMUN_RESIDE());
				ps.setString(8, dados.getUF_ALUNO());
				ps.setString(9, dados.getCEL_ALUNO());
				ps.setString(10, dados.getCURSO_ALUNO());
				ps.setString(11, dados.getCAMPUS_CURSO());
				ps.setString(12, dados.getPERIODO_CURSO());
				ps.executeUpdate();
			} catch (Exception e) { 
			//	throw new Exception("Erro ao salvar" + e.getMessage());
			}
		}
		//**************************** UPDADE **********************************************
		public void alterar(Dados dados) throws Exception {
			try {
				String sql="UPDATE dadospessoais SET NOME_ALUNO=?,NASC_ALUNO=?,CPF_ALUNO=?,EMAIL_ALUNO=?,END_ALUNO=?,MUN_RESIDE=?,UF_ALUNO=?,CEL_ALUNO=?,CURSO_ALUNO=?,CAMPUS_CURSO=?,PERIODO_CURSO=? WHERE RGM_ALUNO=?";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, dados.getNOME_ALUNO());
				ps.setString(2, dados.getNASC_ALUNO());
				ps.setString(3, dados.getCPF_ALUNO());
				ps.setString(4, dados.getEMAIL_ALUNO());
				ps.setString(5, dados.getEND_ALUNO());
				ps.setString(6, dados.getMUN_RESIDE());
				ps.setString(7, dados.getUF_ALUNO());
				ps.setString(8, dados.getCEL_ALUNO());
				ps.setString(9, dados.getCURSO_ALUNO());
				ps.setString(10, dados.getCAMPUS_CURSO());
				ps.setString(11, dados.getPERIODO_CURSO()); 
				ps.setInt(12, dados.getRGM_ALUNO());
				ps.executeUpdate();
			} catch (Exception e) {
				throw new Exception("Erro ao alterar" + e.getMessage());
			}
		}
		//**************************** DELETE **********************************************
		public void excluir(int RGM_ALUNO) throws Exception {
			try {
				String sql = "DELETE FROM dadospessoais WHERE RGM_ALUNO=?";
				ps = conn.prepareStatement(sql);			
				ps.setInt(1, RGM_ALUNO);
				ps.executeUpdate();
			} catch (Exception e) {
				throw new Exception("Erro ao excluir" + e.getMessage());
			}
		}
		
		
				public Dados consultar(int RGM_ALUNO) throws Exception {
			String sql = "SELECT * FROM dadospessoais WHERE RGM_ALUNO=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1,RGM_ALUNO);
				rs = ps.executeQuery();
				if (rs.next()) {
				String NOME_ALUNO = rs.getString("NOME_ALUNO");
				String NASC_ALUNO = rs.getString("NASC_ALUNO");
				String CPF_ALUNO = rs.getString("CPF_ALUNO");
				String EMAIL_ALUNO = rs.getString("EMAIL_ALUNO");
				String END_ALUNO = rs.getString("END_ALUNO");
				String MUN_RESIDE = rs.getString("MUN_RESIDE");
				String UF_ALUNO = rs.getString("UF_ALUNO");
				String CEL_ALUNO = rs.getString("CEL_ALUNO");
				String CURSO_ALUNO = rs.getString("CURSO_ALUNO");
				String CAMPUS_CURSO = rs.getString("CAMPUS_CURSO");
				String PERIODO_CURSO = rs.getString("PERIODO_CURSO");
				dados = new Dados(RGM_ALUNO,NOME_ALUNO,NASC_ALUNO,CPF_ALUNO,EMAIL_ALUNO,END_ALUNO,MUN_RESIDE,UF_ALUNO,CEL_ALUNO,CURSO_ALUNO,CAMPUS_CURSO,PERIODO_CURSO);
				//lista.add(dados);
				}
				return dados;
				
			} catch (Exception e) {
				throw new Exception("Erro ao listar!" + e.getMessage()); //Remover depois
			}
		}
}
