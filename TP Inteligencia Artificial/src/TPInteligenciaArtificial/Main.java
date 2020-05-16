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
				try {
					String string= metodosBusqueda.getValue();
					agentState= AgenteCustodioMain.main(metodosBusqueda.getValue());
					
				} catch (PrologConnectorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lbDistanciaRecorrida.setText("Distancia Recorrida: "+ agentState.getDistanciaReocorrida());
				lbDistanciaRecorrida.setVisible(true);
				lbCostoRecorrido.setText("Costo del Recorrido: "+ agentState.getCostoCamino());
				lbCostoRecorrido.setVisible(true);
				
				VBox vb2= new VBox();
		
				WebView webView= new WebView();
				final WebEngine webEngine= webView.getEngine();
				webEngine.load(getClass().getResource("map.html").toExternalForm());
				
				Double[][] nodoCoordenadas= InicializarNodoCoordenada();
				
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
		launch(args);
	}
	
	
	private Double[][] InicializarNodoCoordenada() {
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
				{-31.612477, -60.679926},
				{-31.611657, -60.679264},
				{-31.611963, -60.677767},
				{-31.612207, -60.676726},
				{-31.612438, -60.675648},
				{-31.612653, -60.674597},
				{-31.612895, -60.673527},
				{-31.613123, -60.672451},
				{-31.613347, -60.671397},
				{-31.613525, -60.670343},
				{-31.613621, -60.670086},
				{-31.612630, -60.672318},
				{-31.612404, -60.673407},
				{-31.612189, -60.674458},
				{-31.611947, -60.675515},
				{-31.611716, -60.676596},
				{-31.610846, -60.678613},
				{-31.611058, -60.677532},
				{-31.611300, -60.676475},
				{-31.611519, -60.675407},
				{-31.611755, -60.674350},
				{-31.611977, -60.673269},
				{-31.612210, -60.672207},
				{-31.612418, -60.671134},
				{-31.612624, -60.670085},
				{-31.612827, -60.669147}, //Hernandarias-Brown
				{-31.612615, -60.668895},
				{-31.612055, -60.668321},
				{-31.611941, -60.668772},
				{-31.611733, -60.669829},
				{-31.611516, -60.670886},
				{-31.611290, -60.671967},
				{-31.611080, -60.673010},
				{-31.610838, -60.674094},
				{-31.610616, -60.675156},
				{-31.610406, -60.676215},
				{-31.610168, -60.677277},
				{-31.609974, -60.678082},
				{-31.609108, -60.677634}, //Zeballos-Paz
				{-31.609250, -60.677007},
				{-31.609469, -60.675961},
				{-31.609695, -60.674913},
				{-31.609930, -60.673843},
				{-31.610149, -60.672765},
				{-31.610380, -60.671708},
				{-31.610602, -60.670640},
				{-31.610824, -60.669591},
				{-31.611036, -60.668533},
				{-31.611207, -60.667677},
				{-31.610326, -60.667276},
				{-31.610102, -60.668285},
				{-31.609912, -60.669342},
				{-31.609697, -60.670391},
				{-31.609466, -60.671459},
				{-31.609238, -60.672529},
				{-31.609007, -60.673588},
				{-31.608760, -60.674653},
				{-31.608543, -60.675715},
				{-31.608230, -60.677148}, //Boneo-Paz
				{-31.607346, -60.676681},
				{-31.607586, -60.675452},
				{-31.607794, -60.674379},
				{-31.607997, -60.673322},
				{-31.608134, -60.672260},
				{-31.608335, -60.671227},
				{-31.608563, -60.670098},
				{-31.608797, -60.669026},
				{-31.609012, -60.667993},
				{-31.609224, -60.666942}, //Espora-Brown
				{-31.608361, -60.666714},
				{-31.608208, -60.667773},
				{-31.608009, -60.668827},
				{-31.607785, -60.669895},
				{-31.607504, -60.670997},
				{-31.607303, -60.672019},
				{-31.607230, -60.672542},
				{-31.607148, -60.673105},
				{-31.606938, -60.674151},
				{-31.606737, -60.675219},
				{-31.606522, -60.676217},
				{-31.606019, -60.675935},
				{-31.605775, -60.675828}, //Alberti-Paz
				{-31.605898, -60.674983},
				{-31.606108, -60.673948},
				{-31.606405, -60.672331},
				{-31.606236, -60.671733},
				{-31.606448, -60.670727},
				{-31.606976, -60.669673},
				{-31.607177, -60.668592},
				{-31.607405, -60.667538},
				{-31.607567, -60.666495},
				{-31.606726, -60.666307}, //Fasolino-Brown
				{-31.606575, -60.667316},
				{-31.606369, -60.668386},
				{-31.606129, -60.669451},
				{-31.605933, -60.670620},
				{-31.605699, -60.671573},
				{-31.605490, -60.672637},
				{-31.605280, -60.673726},
				{-31.605081, -60.674795},
				{-31.604940, -60.675468},
				{-31.605009, -60.672518},
				{-31.605219, -60.671440},
				{-31.605791, -60.666103}, //Ganesio-Brown
				{-31.605659, -60.667070},
				{-31.605431, -60.668143},
				{-31.605216, -60.669194},
				{-31.604988, -60.670363},
				{-31.604787, -60.671323},
				{-31.604586, -60.672417},
				{-31.604376, -60.673474},
				{-31.604161, -60.674536},
				{-31.604033, -60.675169},
				{-31.603101, -60.674874}, //Rosa-Paz
				{-31.603252, -60.674257},
				{-31.603435, -60.673243},
				{-31.603645, -60.672197},
				{-31.603860, -60.671129},
				{-31.604070, -60.670056},
				{-31.604276, -60.669010},
				{-31.604514, -60.667894},
				{-31.604715, -60.666810},
				{-31.604925, -60.665822},
				{-31.604008, -60.665571}, //Regimiento12 - Italia
				{-31.603807, -60.666553},
				{-31.603569, -60.667659},
				{-31.603365, -60.668752},
				{-31.603160, -60.669801},
				{-31.602950, -60.670869},
				{-31.602738, -60.671945},
				{-31.602519, -60.673010},
				{-31.602327, -60.674024},
				{-31.602204, -60.674630}
		};
		return nodoCoordenada;
	}

}
