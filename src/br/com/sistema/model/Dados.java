package br.com.sistema.model;

public class Dados {
		private int RGM_ALUNO;
		private String NOME_ALUNO;
		private String NASC_ALUNO;
		private String CPF_ALUNO;
		private String EMAIL_ALUNO;
		private String END_ALUNO;
		private String MUN_RESIDE;
		private String UF_ALUNO; 
		private String CEL_ALUNO;
		private String CURSO_ALUNO;
		private String CAMPUS_CURSO;
		private String PERIODO_CURSO;
		
		public Dados() { 
		}

		public Dados(int RGM_ALUNO, String NOME_ALUNO, String NASC_ALUNO, String CPF_ALUNO, String EMAIL_ALUNO,String END_ALUNO,String MUN_RESIDE,String UF_ALUNO,String CEL_ALUNO,String CURSO_ALUNO,String CAMPUS_CURSO,String PERIODO_CURSO) {
			this.RGM_ALUNO = RGM_ALUNO;
			this.NOME_ALUNO = NOME_ALUNO;
			this.NASC_ALUNO = NASC_ALUNO;
			this.CPF_ALUNO = CPF_ALUNO;
			this.EMAIL_ALUNO = EMAIL_ALUNO;
			this.END_ALUNO = END_ALUNO;
			this.MUN_RESIDE = MUN_RESIDE;
			this.UF_ALUNO = UF_ALUNO; 
			this.CEL_ALUNO = CEL_ALUNO;
			this.CURSO_ALUNO = CURSO_ALUNO;
			this.CAMPUS_CURSO = CAMPUS_CURSO;
			this.PERIODO_CURSO = PERIODO_CURSO;
		}
		//***************************************

		public int getRGM_ALUNO() {
			return RGM_ALUNO;
		}

		public void setRGM_ALUNO(int RGM_ALUNO) {
			this.RGM_ALUNO = RGM_ALUNO;
		}
		
		//***************************************
		
		public String getNOME_ALUNO() {
			return NOME_ALUNO;
		}

		public void setNOME_ALUNO(String NOME_ALUNO) {
			this.NOME_ALUNO = NOME_ALUNO;
		}
		//***************************************

		public String getNASC_ALUNO() {
			return NASC_ALUNO;
		}

		public void setNASC_ALUNO(String NASC_ALUNO) {
			this.NASC_ALUNO = NASC_ALUNO;
		}
		//***************************************

		public String getCPF_ALUNO() {
			return CPF_ALUNO;
		}

		public void setCPF_ALUNO(String CPF_ALUNO) {
			this.CPF_ALUNO = CPF_ALUNO;
		}
		//***************************************

		public String getEMAIL_ALUNO() {
			return EMAIL_ALUNO;
		}

		public void setEMAIL_ALUNO(String EMAIL_ALUNO) {
			this.EMAIL_ALUNO = EMAIL_ALUNO;
		}
		//***************************************
		public String getEND_ALUNO() {
			return END_ALUNO;
		}

		public void setEND_ALUNO(String END_ALUNO) {
			this.END_ALUNO = END_ALUNO;
		}
		//****************************************
		public String getMUN_RESIDE() {
			return MUN_RESIDE;
		}

		public void setMUN_RESIDE(String MUN_RESIDE) {
			this.MUN_RESIDE = MUN_RESIDE;
		}
		//****************************************
		public String getUF_ALUNO() {
			return UF_ALUNO;
		}

		public void setUF_ALUNO(String UF_ALUNO) {
			this.UF_ALUNO = UF_ALUNO;
		}
		//***************************************

		public String getCEL_ALUNO() {
			return CEL_ALUNO;
		}

		public void setCEL_ALUNO(String CEL_ALUNO) {
			this.CEL_ALUNO = CEL_ALUNO;
		}
		//***************************************
		
		public String getCURSO_ALUNO() {
			return CURSO_ALUNO;
		}

		public void setCURSO_ALUNO(String CURSO_ALUNO) {
			this.CURSO_ALUNO = CURSO_ALUNO;
		}
		//***************************************
		
		public String getCAMPUS_CURSO() {
			return CAMPUS_CURSO;
		}

		public void setCAMPUS_CURSO(String CAMPUS_CURSO) {
			this.CAMPUS_CURSO = CAMPUS_CURSO;
		}
		//***************************************
		
		public String getPERIODO_CURSO() {
			return PERIODO_CURSO;
		}

		public void setPERIODO_CURSO(String PERIODO_CURSO) {
			this.PERIODO_CURSO = PERIODO_CURSO;
		}
		
		
}
