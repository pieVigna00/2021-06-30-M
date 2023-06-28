package it.polito.tdp.genes.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import it.polito.tdp.genes.db.GenesDao;

public class Model {
	GenesDao dao;
	Graph<Cromosoma, DefaultWeightedEdge> grafo;
	Map<Integer, Cromosoma> mappaCromosomi;
	Map<Genes, Set<Integer>> mappaGeni; 
	List<Arco> archi;
	public Model() {
		this.dao=new GenesDao();
		this.mappaGeni= new HashMap<>();
		this.mappaCromosomi= new HashMap<>();
		this.dao.getMappaGenes(mappaGeni);
		
	}
	public void buildGraph() {
		this.grafo= new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		this.archi=new ArrayList<>();
		List<Cromosoma> vertici= this.dao.getAllCromosoma();
		for(Cromosoma c: vertici) {
			mappaCromosomi.put(c.getCromosoma(), c);
		}
		Graphs.addAllVertices(this.grafo, vertici);
		List<GenieCromosomi> result= this.dao.getGenieCromosomi();
		for(int i=0; i<result.size(); i++) {
			int c1=result.get(i).getCromosoma1();
			int c2=result.get(i).getCromosoma2();
			Cromosoma cro1=mappaCromosomi.get(c1);
			Cromosoma cro2= mappaCromosomi.get(c2);
			double peso=result.get(i).getCorrelazione();
			for(int j=1; j<result.size();j++) {
				if(c1==result.get(j).getCromosoma1() && c2==result.get(j).getCromosoma2()) 
					peso+=result.get(j).getCorrelazione();
			}
			Arco arco= new Arco(cro1, cro2, peso);
			archi.add(arco);
			Graphs.addEdge(this.grafo, cro1, cro2, peso);
		}
		
	}
	public int getNumeroVertici() {
		return this.grafo.vertexSet().size();
	}
	public int getNumeroArchi() {
		return this.grafo.edgeSet().size();
	}
	public double getMinimoPeso() {
		double min=1000;
		for(Arco a: archi) {
			if(a.getPeso()<min) {
				min=a.getPeso();
			}
		}
		return min;
	}
	public double getMassimoPeso() {
		double max=0;
		for(Arco a: archi) {
			if(a.getPeso()>max) {
				max=a.getPeso();
			}
		}
		return max;
	}
	public int getNumeroArchiMaggiori(int soglia) {
		int numero=0;
		for(Arco a: archi) {
			if(a.getPeso()>soglia)
			numero++;
		}
		return numero;
	}
	public int getNumeroArchiMinori(int soglia) {
		int numero=0;
		for(Arco a: archi) {
			if(a.getPeso()<soglia)
			numero++;
		}
		return numero;
	}
	
	
}