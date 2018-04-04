package orm.vue;

import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import orm.controleur.ControleurOrm;
import orm.modele.Planete;

public class VueOrm extends Application{


	protected TreeMap<String, Planete> arbrePlanete;
	protected ControleurOrm controleur;
	protected StackPane racine;
	protected Alert alerte;
	protected Alert alerteContinent;
	protected Stage scenePrincipale;
	protected TabPane tabPane;
	protected Tab ongletlistePlanete;
	protected Tab marquePage;
	protected Tab recherche;
	protected Button btnSauvegarder;
	
	public VueOrm()
	{
		arbrePlanete = new TreeMap<String, Planete>();
		controleur = new ControleurOrm(this);
	}
	
	@Override
	public void start(Stage scenePrincipale) throws Exception 
	{
		this.scenePrincipale = scenePrincipale;
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.TOP_LEFT);


		ScrollPane scroll = new ScrollPane();
		scroll.setContent(vbox);

		TabPane racine = new TabPane();
		afficherPanetes(vbox);
		Scene scene = new Scene(racine, 500, 500);

		//StackPane tabListePlanete = new StackPane();
		//afficherPanetes(scroll);
		ongletlistePlanete = new Tab("");

		ongletlistePlanete.setText("Liste des planetes");
		ongletlistePlanete.setContent(scroll);
		racine.getTabs().add(ongletlistePlanete);

		marquePage = new Tab("");
		racine.getTabs().add(marquePage);
		ongletlistePlanete.setText("Marque page");


		recherche = new Tab("");
		racine.getTabs().add(recherche);

		scenePrincipale.setScene(scene);
		scenePrincipale.setTitle("Planet");
		scenePrincipale.show();

	}

	protected void afficherPanetes(VBox racine)
	{
		int decalage = 80;

		for(Entry<String, Planete> entree : arbrePlanete.entrySet())
		{

			Planete planete = entree.getValue();
			Label labelPlanet =  new Label(planete.getNom());
			//Button bouttonModifier = new Button("Modifier");

			labelPlanet.setTranslateX(0);
			labelPlanet.setTranslateY(decalage);

			//bouttonModifier.setId(listePlanete.get(position).getNom());
			//bouttonModifier.setTranslateX(200);
			//bouttonModifier.setTranslateY(decalage-50);
			//this.ajouterEvenementModifier(bouttonModifier);

			racine.getChildren().addAll(labelPlanet);
		}
	}

	/*public void afficherPanetes(StackPane racine)
	{
		Text texte = new Text();
		String chaine = "";
		for(Entry<String, Planete> entree : arbrePlanete.entrySet()){
			Planete planete = entree.getValue();
			chaine+=planete.getNom();
			chaine+="	";
		}
		
		texte.setText(chaine);
		texte.setWrappingWidth(500);
		racine.getChildren().add(texte);

	}*/



	public void setArbrePlanete(TreeMap<String, Planete> arbrePlanete) {
		this.arbrePlanete = arbrePlanete;
	}
}
