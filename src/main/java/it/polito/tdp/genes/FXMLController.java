/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.genes;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.genes.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model ;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnContaArchi"
    private Button btnContaArchi; // Value injected by FXMLLoader

    @FXML // fx:id="btnRicerca"
    private Button btnRicerca; // Value injected by FXMLLoader

    @FXML // fx:id="txtSoglia"
    private TextField txtSoglia; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doContaArchi(ActionEvent event) {
    	String soglia=txtSoglia.getText();
    	int sogliaNum=0;
    	try {
    		sogliaNum= Integer.parseInt(soglia);
    	}
    	catch (NumberFormatException e) {
    		txtResult.appendText("Devi inserire un numero ");
    		return;
    	}
    	if(sogliaNum<this.model.getMinimoPeso() || sogliaNum>model.getMassimoPeso()) {
    		txtResult.appendText("Devi inserire una soglia compresa tra il valore minimo e il valore massimo");
    		return;
    	}
    	txtResult.appendText("Il numero di archi con peso maggiore è: " +model.getNumeroArchiMaggiori(sogliaNum)+"\n");
    	txtResult.appendText("Il numero di archi con peso minore è: " +model.getNumeroArchiMinori(sogliaNum)+"\n");
    	}

    @FXML
    void doRicerca(ActionEvent event) {

    }
    public void buildGraph() {
    	this.model.buildGraph();
		txtResult.setText("Grafo creato correttamente : "+this.model.getNumeroVertici()+" vertici e "
				+this.model.getNumeroArchi()+" archi");
    }
    public void setModel(Model model) {
		this.model = model ;
		this.buildGraph();
	}
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnContaArchi != null : "fx:id=\"btnContaArchi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnRicerca != null : "fx:id=\"btnRicerca\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtSoglia != null : "fx:id=\"txtSoglia\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	
}
