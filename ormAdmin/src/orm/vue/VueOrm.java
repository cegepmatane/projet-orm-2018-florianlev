package orm.vue;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import orm.controleur.ControleurOrm;
import orm.modele.Planete;

public class VueOrm extends Application{
	protected List<Planete> listePlanete;
	protected ControleurOrm controleur;
	protected Alert suprimer;
	protected Stage scenePrincipale; 
	
	public VueOrm()
	{
		listePlanete = new ArrayList<>();
		controleur = new ControleurOrm(this);
		listePlanete = controleur.getListePlanete();
	}
	
	@Override
	public void start(Stage scenePrincipale) throws Exception 
	{
		this.scenePrincipale = scenePrincipale;
		
		this.afficherScenePrincipale();
		
	}
	protected void afficherScenePrincipale()
	{
		VBox racine = new VBox();
		racine.setAlignment(Pos.TOP_LEFT);
		Button bouttonAjouter = new Button();
		bouttonAjouter.setText("Ajouter");
		bouttonAjouter.setTranslateX(105);
		bouttonAjouter.setTranslateY(20);
		this.ajouterEvenementAjouter(bouttonAjouter);

		racine.getChildren().add(bouttonAjouter);
		
		afficherPanetes(racine);	
		
		
		ScrollPane scroll = new ScrollPane();
		scroll.setContent(racine);
		Scene scene = new Scene(scroll, 500, 500);
		changerScene(scene);
	}
	protected void afficherAlerteSuprimer(String Planete)
	{
	}
	protected void afficherSceneAjouter()
	{
		StackPane racine = new StackPane();
		Scene scene = new Scene(racine, 500, 500);
		changerScene(scene);
	}
	protected void afficherSceneModifier(String Planete)
	{
		StackPane racine = new StackPane();
		Scene scene = new Scene(racine, 500, 500);
		changerScene(scene);
	}
	protected void changerScene(Scene scene)
	{
		scenePrincipale.setScene(scene);
		scenePrincipale.setTitle("Planet");
		scenePrincipale.show();
	}
	protected void ajouterEvenementSuprimmer(Button boutton)
	{
	}
	protected void ajouterEvenementAjouter(Button boutton)
	{
		boutton.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		    	afficherSceneAjouter();
		    }});
	}
	protected void ajouterEvenementModifier(Button boutton)
	{
		
	}
	protected void afficherPanetes(VBox racine)
	{
		int decalage = 80;
		
		for(int position = listePlanete.size()-1;position >= 0; position--)
		{
			Label labelPlanet =  new Label(listePlanete.get(position).getNom());
			Button bouttonSuprimer = new Button("Suprimer");
			Button bouttonModifier = new Button("Modifier");
			
			labelPlanet.setTranslateX(0);
			labelPlanet.setTranslateY(decalage);
			
			bouttonSuprimer.setId(listePlanete.get(position).getNom());
			bouttonSuprimer.setTranslateX(100);
			bouttonSuprimer.setTranslateY(decalage-25);
			this.ajouterEvenementSuprimmer(bouttonSuprimer);
			
			bouttonModifier.setId(listePlanete.get(position).getNom());
			bouttonModifier.setTranslateX(200);
			bouttonModifier.setTranslateY(decalage-50);

			racine.getChildren().addAll(labelPlanet, bouttonSuprimer, bouttonModifier);
		}
	}
}
