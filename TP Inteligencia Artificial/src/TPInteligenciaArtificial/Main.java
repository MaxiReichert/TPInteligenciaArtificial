package TPInteligenciaArtificial;

import java.io.IOException;
import java.util.ArrayList;

import AgenteCustodioIA.AgenteCustodio;
import AgenteCustodioIA.AgenteCustodioMain;
import AgenteCustodioIA.AgenteCustodioState;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
	ComboBox<String> metodosBusqueda;
	Label lbDistanciaRecorrida;
	Label lbCostoRecorrido;
	AgenteCustodioState agentState;
	WebEngine webEngine;
	
	@Override
	public void start(Stage stage) throws Exception {	
		VBox vb= new VBox(20);
		vb.setAlignment(Pos.TOP_CENTER);
		
		Label lbTitulo= new Label("Agente Custodio");
		lbTitulo.setFont(Font.font("Time New Romans", 21));
		
		HBox hb1= new HBox(10);
		hb1.setAlignment(Pos.CENTER);
		
		Label lbMetodoBusqueda= new Label("Método de búsqueda");
		lbMetodoBusqueda.setFont(Font.font("Arial", 12));
		
		metodosBusqueda = new ComboBox();
		metodosBusqueda.getItems().add("Costo Uniforme");
		metodosBusqueda.getItems().add("Profundidad");
		metodosBusqueda.getItems().add("Amplitud");
		metodosBusqueda.getItems().add("B�squeda informada");
		metodosBusqueda.setValue("Costo Uniforme");
		
		hb1.getChildren().add(lbMetodoBusqueda);
		hb1.getChildren().add(metodosBusqueda);
		Button btn= new Button("Avanzar");
		hb1.getChildren().add(btn);
		
		// Mapa
		HBox hb2= new HBox();
		hb2.setAlignment(Pos.CENTER);
		WebView webView= new WebView();
		webEngine = webView.getEngine();
		webEngine.load(getClass().getResource("map.html").toExternalForm());
		hb2.getChildren().add(webView);
		
		// Labels de distancia recorrida y costo
		HBox hb3= new HBox(10);
		hb3.setAlignment(Pos.CENTER);
		lbDistanciaRecorrida= new Label();
		lbDistanciaRecorrida.setVisible(false);
		lbCostoRecorrido= new Label();
		lbCostoRecorrido.setVisible(false);
		hb3.getChildren().add(lbDistanciaRecorrida);
		hb3.getChildren().add(lbCostoRecorrido);
		
		// Agrego todo a la ventana principal
		vb.getChildren().add(lbTitulo);
		vb.getChildren().add(hb1);
		vb.getChildren().add(hb2);
		vb.getChildren().add(hb3);
		Scene scene= new Scene(vb, 800, 600);
		stage.setScene(scene);
		stage.show();
		
		btn.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				execStrategy();
			}	 
		});
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	private void execStrategy() {
		try {
	    	  agentState = AgenteCustodioMain.main(metodosBusqueda.getValue());
	    	  // Dibujo el recorrido
	    	  webEngine.executeScript("setTravelPolyline(" + agentState.getRecorrido() + ")");
			  lbDistanciaRecorrida.setText("Distancia Recorrida: "+ agentState.getDistanciaRecorrida());
			  lbDistanciaRecorrida.setVisible(true);
			  lbCostoRecorrido.setText("Costo del Recorrido: "+ agentState.getCostoCamino());
			  lbCostoRecorrido.setVisible(true);
			  System.out.println("El agente alcanzó el objetivo!");
	      } catch (PrologConnectorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	      }
	}

}
