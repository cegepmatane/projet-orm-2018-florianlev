package orm.vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import orm.controleur.ControleurOrm;
import orm.modele.Planete;

public class VueOrm extends Application{
	
	protected ControleurOrm controleur;
	protected StackPane racine;
	protected Alert alerte;
	protected Alert alerteContinent;
	protected Stage scenePrincipale; 
	protected Planete planete;
	public VueOrm()
	{
		controleur = new ControleurOrm(this);
		planete = new Planete();
		planete.setNom("terre");
	}
	
	@Override
	public void start(Stage scenePrincipale) throws Exception 
	{
		this.scenePrincipale = scenePrincipale;
		Label label = new Label(planete.getNom());
		StackPane racine = new StackPane();
		
		racine.getChildren().add(label);
		Scene scene = new Scene(racine, 500, 500);
		
		scenePrincipale.setScene(scene);
		scenePrincipale.setTitle("Planet");
		scenePrincipale.show();
	}

}
