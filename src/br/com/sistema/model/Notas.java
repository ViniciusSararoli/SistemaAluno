package br.com.sistema.model;

public class Notas {
	
	private int RGM_ALUNO;
	private String DISC_NF;
	private String SEMESTRE_NF;
	private String NOTA_NF;
	private String FALTAS_NF;
	
	public Notas() {
		
	}

	public Notas(int RGM_ALUNO, String DISC_NF, String SEMESTRE_NF, String NOTA_NF, String FALTAS_NF) {
		super();
		this.RGM_ALUNO = RGM_ALUNO;
		this.DISC_NF = DISC_NF;
		this.SEMESTRE_NF = SEMESTRE_NF;
		this.NOTA_NF = NOTA_NF;
		this.FALTAS_NF = FALTAS_NF;
	}

	public int getRGM_ALUNO() {
		return RGM_ALUNO;
	}

	public void setRGM_ALUNO(int RGM_ALUNO) {
		this.RGM_ALUNO = RGM_ALUNO;
	}

	public String getDISC_NF() {
		return DISC_NF;
	}

	public void setDISC_NF(String DISC_NF) {
		this.DISC_NF = DISC_NF;
	}

	public String getSEMESTRE_NF() {
		return SEMESTRE_NF;
	}

	public void setSEMESTRE_NF(String SEMESTRE_NF) {
		this.SEMESTRE_NF = SEMESTRE_NF;
	}

	public String getNOTA_NF() {
		return NOTA_NF;
	}

	public void setNOTA_NF(String NOTA_NF) {
		this.NOTA_NF = NOTA_NF;
	}

	public String getFALTAS_NF() {
		return FALTAS_NF;
	}

	public void setFALTAS_NF(String FALTAS_NF) {
		this.FALTAS_NF = FALTAS_NF;
	}
	

}


