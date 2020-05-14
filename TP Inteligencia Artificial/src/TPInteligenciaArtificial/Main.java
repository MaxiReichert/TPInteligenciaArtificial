package TPInteligenciaArtificial;

import java.io.IOException;

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
	
	@Override
	public void start(Stage stage) throws Exception {	
		VBox vb= new VBox(20);
		vb.setAlignment(Pos.TOP_CENTER);
		
		Label lbTitulo= new Label("Agente Custodio");
		lbTitulo.setFont(Font.font("Time New Romans", 21));
		
		HBox hb1= new HBox(10);
		hb1.setAlignment(Pos.CENTER);
		
		Label lbMetodoBusqueda= new Label("Elija un metodo de busqueda");
		lbMetodoBusqueda.setFont(Font.font("Arial", 12));
		
		metodosBusqueda= new ComboBox();
		metodosBusqueda.getItems().add("Costo Uniforme");
		metodosBusqueda.getItems().add("Profundidad");
		metodosBusqueda.getItems().add("Amplitud");
		
		hb1.getChildren().add(lbMetodoBusqueda);
		hb1.getChildren().add(metodosBusqueda);
		
		HBox hb2= new HBox();
		hb2.setAlignment(Pos.BOTTOM_CENTER);
		
		Button btn= new Button("Avanzar");
		
		
		hb2.getChildren().add(btn);
		
		lbDistanciaRecorrida= new Label();
		lbDistanciaRecorrida.setVisible(false);
		
		lbCostoRecorrido= new Label();
		lbCostoRecorrido.setVisible(false);
		
		vb.getChildren().add(lbTitulo);
		vb.getChildren().add(hb1);
		vb.getChildren().add(hb2);
		vb.getChildren().add(lbDistanciaRecorrida);
		vb.getChildren().add(lbCostoRecorrido);
		Scene scene= new Scene(vb, 350,200);
		stage.setScene(scene);
		stage.show();
		
		btn.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				/*try {
					String string= metodosBusqueda.getValue();
					agentState= AgenteCustodioMain.main(metodosBusqueda.getValue());
					
				} catch (PrologConnectorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lbDistanciaRecorrida.setText("Distancia Recorrida: "+ agentState.getDistanciaReocorrida());
				lbDistanciaRecorrida.setVisible(true);
				lbCostoRecorrido.setText("Costo del Recorrido: "+ agentState.getCostoCamino());
				lbCostoRecorrido.setVisible(true);*/
				
				VBox vb2= new VBox();
		
				WebView webView= new WebView();
				final WebEngine webEngine= webView.getEngine();
				webEngine.load(getClass().getResource("maps.html").toExternalForm());
				
				vb2.getChildren().add(webView);
				Scene sceneMapa= new Scene(vb2, 800,600);
				Stage stageMapa= new Stage();
				stageMapa.setScene(sceneMapa);
				stageMapa.show();
				System.out.println("llega");
			}
			 
		});
		
	}
	
	public static void main(String[] args) {
		/*
		// Test calcular distancia
		DistanceTime distanceTime = new DistanceTime();
		try {
			Long[] calculate = distanceTime.calculate("-31.615911,-60.672965", "-31.615826,-60.673228");
			System.out.println(calculate[0] + " " + calculate[1]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		launch(args);

	}
	
	
	private void InicializarNodoCoordenada() {
		Double[][] nodoCoordenada= {
				{-31.615911, -60.672965},
				{-31.615826, -60.673228},
				{-31.615559, -60.674329},
				{-31.615344, -60.675402},
				{-31.615143, -60.676413},
				{-31.614932, -60.677495},
				{-31.614707, -60.678544},
				{-31.614463, -60.679721},
				{-31.614128, -60.681230},
				{-31.613323, -60.680600},
				{-31.613554, -60.679463},
				{-31.613771, -60.678317},
				{-31.614029, -60.677228},
				{-31.614239, -60.676150},
				{-31.614417, -60.675128},
				{-31.614650, -60.674080},
				{-31.614940, -60.672975},
				{-31.615162, -60.671988},
				{-31.614408, -60.671017},
				{-31.614264, -60.671650},
				{-31.614036, -60.672712},
				{-31.613803, -60.673785},
				{-31.613579, -60.674842},
				{-31.613339, -60.675904},
				{-31.613108, -60.676977},
				{-31.612866, -60.678045},
				{-31.612628, -60.679196},
				{-31.612477, -60.679926} //Casanello-Paz
				
		};
	}

}
