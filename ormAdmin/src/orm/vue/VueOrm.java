package orm.vue;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
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
	protected VBox racine;
	protected Alert alerte;
	protected Alert alerteContinent;
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
		racine = new VBox();
		racine.setAlignment(Pos.TOP_LEFT);
		this.afficherScenePrincipale();
		
	}
	public void afficherScenePrincipale()
	{
		Button bouttonAjouter = new Button();
		bouttonAjouter.setText("Ajouter");
		bouttonAjouter.setTranslateX(105);
		bouttonAjouter.setTranslateY(20);
		

		racine.getChildren().add(bouttonAjouter);
		
		afficherPanetes();	
		
		
		ScrollPane scroll = new ScrollPane();
		scroll.setContent(racine);
		Scene scene = new Scene(scroll, 500, 500);
		
		scenePrincipale.setScene(scene);
		scenePrincipale.setTitle("Planet");
		scenePrincipale.show();
	}
	public void afficherPanetes()
	{
		int translateY = 80;
		
		
		for(int position = listePlanete.size()-1;position >= 0; position--)
		{
			Label labelPlanet =  new Label(listePlanete.get(position).getNom());
			Button bouttonSuprimer = new Button();
			Button bouttonModifier = new Button();
			
			labelPlanet.setTranslateX(0);
			labelPlanet.setTranslateY(translateY);
			
			bouttonSuprimer.setId(listePlanete.get(position).getNom());
			bouttonSuprimer.setText("Suprimer");
			bouttonSuprimer.setTranslateX(100);
			bouttonSuprimer.setTranslateY(translateY-25);
			
			bouttonModifier.setId(listePlanete.get(position).getNom());
			bouttonModifier.setText("Modifier");
			bouttonModifier.setTranslateX(200);
			bouttonModifier.setTranslateY(translateY-50);
			

			racine.getChildren().addAll(labelPlanet, bouttonSuprimer, bouttonModifier);
			
		}
	}
}
