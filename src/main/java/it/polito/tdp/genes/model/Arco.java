package it.polito.tdp.genes.model;

public class Arco {
	private Cromosoma c1;
	private Cromosoma c2;
	private double peso;
	public Arco(Cromosoma c1, Cromosoma c2, double peso) {
		super();
		this.c1 = c1;
		this.c2 = c2;
		this.peso = peso;
	}
	public Cromosoma getC1() {
		return c1;
	}
	public void setC1(Cromosoma c1) {
		this.c1 = c1;
	}
	public Cromosoma getC2() {
		return c2;
	}
	public void setC2(Cromosoma c2) {
		this.c2 = c2;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Arco [c1=" + c1 + ", c2=" + c2 + ", peso=" + peso + "]";
	}
	

}
