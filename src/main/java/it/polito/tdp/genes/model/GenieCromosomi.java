package it.polito.tdp.genes.model;

public class GenieCromosomi {
	private int cromosoma1;
	private int cromosoma2;
	private String geneID1;
	private String geneID2;
	private double correlazione;
	public GenieCromosomi(int cromosoma1, int cromosoma2, String geneID1, String geneID2, double correlazione) {
		super();
		this.cromosoma1 = cromosoma1;
		this.cromosoma2 = cromosoma2;
		this.geneID1 = geneID1;
		this.geneID2 = geneID2;
		this.correlazione = correlazione;
	}
	public int getCromosoma1() {
		return cromosoma1;
	}
	public void setCromosoma1(int cromosoma1) {
		this.cromosoma1 = cromosoma1;
	}
	public int getCromosoma2() {
		return cromosoma2;
	}
	public void setCromosoma2(int cromosoma2) {
		this.cromosoma2 = cromosoma2;
	}
	public String getGeneID1() {
		return geneID1;
	}
	public void setGeneID1(String geneID1) {
		this.geneID1 = geneID1;
	}
	public String getGeneID2() {
		return geneID2;
	}
	public void setGeneID2(String geneID2) {
		this.geneID2 = geneID2;
	}
	public double getCorrelazione() {
		return correlazione;
	}
	public void setCorrelazione(double correlazione) {
		this.correlazione = correlazione;
	}
	@Override
	public String toString() {
		return "GenieCromosomi [cromosoma1=" + cromosoma1 + ", cromosoma2=" + cromosoma2 + ", geneID1=" + geneID1
				+ ", geneID2=" + geneID2 + ", correlazione=" + correlazione + "]";
	}
	
	

}
