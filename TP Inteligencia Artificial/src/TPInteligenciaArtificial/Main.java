package TPInteligenciaArtificial;

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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
	ComboBox<String> metodosBusqueda;
	
	@Override
	public void start(Stage stage) throws Exception {
		VBox vb= new VBox(20);
		vb.setAlignment(Pos.TOP_CENTER);
		
		Label lbTitulo= new Label("Agente Custodio");
		lbTitulo.setFont(Font.font("Time New Romans", 21));
		//lbTitulo.setAlignment(Pos.TOP_CENTER);
		
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
		btn.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				try {
					String string= metodosBusqueda.getValue();
					AgenteCustodioState agentState= AgenteCustodioMain.main(metodosBusqueda.getValue());
					System.out.println("llega");
				} catch (PrologConnectorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 
		});
		
		hb2.getChildren().add(btn);
		
		vb.getChildren().add(lbTitulo);
		vb.getChildren().add(hb1);
		vb.getChildren().add(hb2);
		Scene scene= new Scene(vb, 350,200);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
