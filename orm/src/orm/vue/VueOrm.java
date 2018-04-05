package orm.vue;

import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import orm.controleur.ControleurOrm;
import orm.modele.Planete;
import orm.modele.memento.MementoPlanete;

public class VueOrm extends Application{


	protected TreeMap<String, Planete> arbrePlanete;



	protected List<Planete> listeHabitable;
	protected List<Planete> listeAtteignable;
	protected List<Planete> listeAnalysable;
	protected ControleurOrm controleur;
	protected StackPane racine;
	protected Alert alerte;
	protected Alert alerteContinent;
	protected Stage scenePrincipale;
	protected TabPane tabPane;
	protected Tab ongletlistePlanete;
	protected Tab marquePage;
	protected Tab rechercheTournesol;
	protected Tab rechercheVadeboncoeur;

	public VueOrm()
	{
		arbrePlanete = new TreeMap<String, Planete>();
		controleur = new ControleurOrm(this);
	}
	
	@Override
	public void start(Stage scenePrincipale) throws Exception 
	{
		this.scenePrincipale = scenePrincipale;
		VBox vboxListe = new VBox();
		VBox vboxSauvegarder = new VBox();
		VBox vboxRechercheTournesol = new VBox();
		VBox vboxRechercheVadeboncoeur = new VBox();

		vboxListe.setAlignment(Pos.TOP_LEFT);
		vboxSauvegarder.setAlignment(Pos.TOP_LEFT);
		vboxRechercheTournesol.setAlignment(Pos.TOP_LEFT);
		vboxRechercheVadeboncoeur.setAlignment(Pos.TOP_LEFT);

		ScrollPane scrollListeSauvegarde = new ScrollPane();
		ScrollPane scrollListe = new ScrollPane();
		ScrollPane scrollRechercheTournesol = new ScrollPane();
		ScrollPane scrollRechercheVadeboncoeur = new ScrollPane();

		scrollListeSauvegarde.setContent(vboxSauvegarder);
		scrollListe.setContent(vboxListe);
		scrollRechercheTournesol.setContent(vboxRechercheTournesol);
		scrollRechercheVadeboncoeur.setContent(vboxRechercheVadeboncoeur);

		TabPane racine = new TabPane();
		afficherPanetes(vboxListe);
		afficherPanetesSauvegarder(vboxSauvegarder);
		Scene scene = new Scene(racine, 500, 500);

		//StackPane tabListePlanete = new StackPane();
		//afficherPanetes(scroll);
		ongletlistePlanete = new Tab("");

		ongletlistePlanete.setText("Liste des planetes");
		ongletlistePlanete.setContent(scrollListe);
		racine.getTabs().add(ongletlistePlanete);

		marquePage = new Tab("");
		marquePage.setText("Marque page");
		marquePage.setContent(scrollListeSauvegarde);
		racine.getTabs().add(marquePage);


		rechercheTournesol = new Tab("");
		rechercheTournesol.setText("Recherche tournesol");
		racine.getTabs().add(rechercheTournesol);

		rechercheVadeboncoeur = new Tab("");
		rechercheVadeboncoeur.setText("Recherche vadeboncoeur");
		racine.getTabs().add(rechercheVadeboncoeur);

		scenePrincipale.setScene(scene);
		scenePrincipale.setTitle("Planet");
		scenePrincipale.show();

	}

	protected void ajouterEvenementSauvegarder(Button boutton, Planete planete)
	{
		boutton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controleur.sauvegarder(planete);
			}
		});
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

	protected void afficherPanetesSauvegarder(VBox racine)
	{
		int decalage = 80;

		for(Entry<String, Planete> entree : arbrePlanete.entrySet())
		{

			Planete planete = entree.getValue();
			Label labelPlanet =  new Label(planete.getNom());
			//Button  = new Button("Modifier");
			Button btnSauvegarder = new Button("Sauvegarder");

			labelPlanet.setTranslateX(0);
			labelPlanet.setTranslateY(decalage);

			btnSauvegarder.setId(planete.getNom());
			btnSauvegarder.setTranslateX(200);
			btnSauvegarder.setTranslateY(decalage-50);
			this.ajouterEvenementSauvegarder(btnSauvegarder, planete);

			racine.getChildren().addAll(labelPlanet, btnSauvegarder);
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
	public void setListeHabitable(List<Planete> listeHabitable) {
		this.listeHabitable = listeHabitable;
	}
	public void setListeAnalysable(List<Planete> listeAnalysable) {
		this.listeAnalysable = listeAnalysable;
	}
	public void setListeAtteignable(List<Planete> listeAtteignable) {
		this.listeAtteignable = listeAtteignable;
	}



	public void setArbrePlanete(TreeMap<String, Planete> arbrePlanete) {
		this.arbrePlanete = arbrePlanete;
	}
}
