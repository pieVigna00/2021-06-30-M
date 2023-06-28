package it.polito.tdp.genes.model;

import java.util.List;

public class Cromosoma {
	public int cromosoma;
	public List<Genes> listaGene;
	public Cromosoma(int cromosoma) {
		super();
		this.cromosoma = cromosoma;
	}
	public int getCromosoma() {
		return cromosoma;
	}
	public void setCromosoma(int cromosoma) {
		this.cromosoma = cromosoma;
	}
	public List<Genes> getGeneId() {
		return listaGene;
	}
	public void addGene(Genes gene) {
		this.listaGene.add(gene);
	}
	

}
