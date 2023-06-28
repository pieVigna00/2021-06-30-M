package it.polito.tdp.genes.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.polito.tdp.genes.model.Cromosoma;
import it.polito.tdp.genes.model.Genes;
import it.polito.tdp.genes.model.GenieCromosomi;
import it.polito.tdp.genes.model.Interactions;


public class GenesDao {
	public void getMappaGenes(Map<Genes, Set<Integer>> mappaGeni){
		String sql= "SELECT DISTINCT geneID, Chromosome, Essential "
				+ "FROM genes "
				+ "WHERE Chromosome>0 "
				+ "GROUP BY geneID";
				Connection conn = DBConnect.getConnection();
		        try {
					PreparedStatement st = conn.prepareStatement(sql);
					ResultSet res = st.executeQuery();
					while (res.next()) {
						Genes genes = new Genes(res.getString("GeneID"), 
								res.getString("Essential"), 
								res.getInt("Chromosome"));
						if(!mappaGeni.containsKey(genes) || mappaGeni.isEmpty()) {
							mappaGeni.put(genes, new HashSet<Integer>());
						}
						mappaGeni.get(genes).add(res.getInt("Chromosome"));
						
					}
					res.close();
					st.close();
					conn.close();
					
				} catch (SQLException e) {
					throw new RuntimeException("Database error", e) ;
				}
		        
	}
	
	public List<GenieCromosomi> getGenieCromosomi() {
		String sql="SELECT DISTINCTROW g1.Chromosome AS c1, g2.Chromosome AS c2, i.GeneID1, i.GeneID2, Expression_corr "
				+ "FROM interactions i, genes g1, genes g2 "
				+ "WHERE i.GeneID1=g1.GeneID AND i.GeneID2=g2.GeneID AND g1.Chromosome!=g2.Chromosome AND g1.Chromosome!=0 AND g2.Chromosome!=0 "
				+"ORDER BY c1, c2";
		List<GenieCromosomi> result= new ArrayList<>();
		Connection conn = DBConnect.getConnection();
        try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {
				GenieCromosomi genieCromo= new GenieCromosomi(res.getInt("c1"), res.getInt("c1"),
						res.getString("GeneID1"),res.getString("GeneID2"), res.getDouble("Expression_corr"));
				result.add(genieCromo);
				
				}
			res.close();
			st.close();
			conn.close();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException("Database error", e) ;
		}
	}
	public List<Genes> getAllGenes(){
		String sql = "SELECT DISTINCT GeneID, Essential, Chromosome FROM Genes";
		List<Genes> result = new ArrayList<Genes>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Genes genes = new Genes(res.getString("GeneID"), 
						res.getString("Essential"), 
						res.getInt("Chromosome"));
				result.add(genes);
			}
			res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error", e) ;
		}
	}
	public List<Cromosoma> getAllCromosoma(){
		String sql="SELECT DISTINCT Chromosome "
				+ "FROM genes "
				+ "WHERE chromosome>0"; 
		List<Cromosoma> result = new ArrayList<>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Cromosoma cromosoma= new Cromosoma(res.getInt("Chromosome"));
				result.add(cromosoma);
			}
			res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error", e) ;
		}
	}
	


	
}
