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
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import orm.controleur.ControleurOrm;
import orm.modele.Planete;

public class VueOrm extends Application{
	protected List<Planete> listePlanete;
	protected ControleurOrm controleur;
	protected Stage scenePrincipale; 
	
	public VueOrm()
	{
		listePlanete = new ArrayList<>();
		controleur = new ControleurOrm(this);
	}
	
	@Override
	public void start(Stage scenePrincipale) throws Exception 
	{
		this.scenePrincipale = scenePrincipale;
		
		this.afficherScenePrincipale();
		
	}
	protected void afficherScenePrincipale()
	{
		listePlanete = controleur.getListePlanete();
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
	protected void afficherSceneSuprimer(String planete)
	{
		StackPane racine = new StackPane();
		Label label = new Label(planete);
		racine.getChildren().add(label);
		Scene scene = new Scene(racine, 500, 500);
		changerScene(scene);
	}
	protected void afficherSceneAjouter()
	{
		StackPane racine = new StackPane();
		racine.setAlignment(Pos.TOP_LEFT);
		
		Label nomPage = new Label("Ajouter une planete");
		racine.setAlignment(nomPage, Pos.TOP_CENTER);
		
		ajouterChamps(racine);
		
		Button valider = new Button("valider");
		this.ajouterEvenementValider(valider, racine);
		racine.setAlignment(valider, Pos.BOTTOM_CENTER);
		
		Button retour = new Button("retour");
		this.ajouterEvenementRetour(retour);
		racine.setAlignment(retour, Pos.BOTTOM_LEFT);
		
		racine.getChildren().addAll(nomPage, valider, retour);
		
		Scene scene = new Scene(racine, 500, 705);
		changerScene(scene);
	}
	protected void ajouterChamps(StackPane racine)
	{
		int decalageYChamp = 20, decalageYLabel = 25, decalageY = 30, decalageXChamp = 100, decalageXLabel = 0; 
		
		Label labelNom = createurLabel("(S)nom", decalageXLabel, decalageYLabel);
		TextField champNom = createurTextField(decalageXChamp, decalageYChamp);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelEtoile = createurLabel("(S)Etoile", decalageXLabel, decalageYLabel);
		TextField champEtoile = createurTextField(decalageXChamp, decalageYChamp);

		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelTypeEtoile = createurLabel("(S)TypeEtoile", decalageXLabel, decalageYLabel);
		TextField champTypeEtoile = createurTextField(decalageXChamp, decalageYChamp);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelMasse = createurLabel("(S)Masse", decalageXLabel, decalageYLabel);
		TextField champMasse = createurTextField(decalageXChamp, decalageYChamp);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelRayon = createurLabel("(S)Rayon", decalageXLabel, decalageYLabel);
		TextField champRayon = createurTextField(decalageXChamp, decalageYChamp);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelFlux = createurLabel("(F)Flux", decalageXLabel, decalageYLabel);
		TextField champFlux = createurTextField(decalageXChamp, decalageYChamp);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelTemperature = createurLabel("(S)Temperature", decalageXLabel, decalageYLabel);
		TextField champTemperature = createurTextField(decalageXChamp, decalageYChamp);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelPeriode = createurLabel("(F)Periode", decalageXLabel, decalageYLabel);
		TextField champPeriode = createurTextField(decalageXChamp, decalageYChamp);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelDistance = createurLabel("(F)Distance", decalageXLabel, decalageYLabel);
		TextField champDistance = createurTextField(decalageXChamp, decalageYChamp);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelZone = createurLabel("(S)Zone", decalageXLabel, decalageYLabel);
		TextField champZone = createurTextField(decalageXChamp, decalageYChamp);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelIst = createurLabel("(F)Ist", decalageXLabel, decalageYLabel);
		TextField champIst = createurTextField(decalageXChamp, decalageYChamp);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelSph = createurLabel("(F)Sph", decalageXLabel, decalageYLabel);
		TextField champSph = createurTextField(decalageXChamp, decalageYChamp);

		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelHzd = createurLabel("(F)Hzd", decalageXLabel, decalageYLabel);
		TextField champHzd = createurTextField(decalageXChamp, decalageYChamp);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelHzc = createurLabel("(F)Hzc", decalageXLabel, decalageYLabel);
		TextField champHzc = createurTextField(decalageXChamp, decalageYChamp);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelHza = createurLabel("(F)Hza", decalageXLabel, decalageYLabel);
		TextField champHza = createurTextField(decalageXChamp, decalageYChamp);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelFClasse = createurLabel("(S)FClasse", decalageXLabel, decalageYLabel);
		TextField champFClasse = createurTextField(decalageXChamp, decalageYChamp);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelHClasse = createurLabel("(S)HClasse", decalageXLabel, decalageYLabel);
		TextField champHClasse = createurTextField(decalageXChamp, decalageYChamp);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelPhi = createurLabel("(S)Phi", decalageXLabel, decalageYLabel);
		TextField champPhi = createurTextField(decalageXChamp, decalageYChamp);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelDistance2 = createurLabel("(S)Distance2", decalageXLabel, decalageYLabel);
		TextField champDistance2 = createurTextField(decalageXChamp, decalageYChamp);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelStatus = createurLabel("(S)Status", decalageXLabel, decalageYLabel);
		TextField champStatus = createurTextField(decalageXChamp, decalageYChamp);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelDecouverte = createurLabel("(S)Decouverte", decalageXLabel, decalageYLabel);
		TextField champDecouverte = createurTextField(decalageXChamp, decalageYChamp);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		Label labelPClasse = createurLabel("(S)PClasse", decalageXLabel, decalageYLabel);
		TextField champPClasse = createurTextField(decalageXChamp, decalageYChamp);
		
		
		racine.getChildren().addAll(labelNom, champNom, labelEtoile, champEtoile, labelTypeEtoile, champTypeEtoile, labelMasse, champMasse, labelRayon, champRayon, labelFlux, champFlux, labelTemperature, champTemperature,
				labelPeriode, champPeriode, labelDistance, champDistance, labelZone, champZone, labelIst, champIst, labelSph, champSph, labelHzd ,champHzd, labelHzc ,champHzc, labelHza ,champHza, labelFClasse ,champFClasse, 
				labelHClasse ,champHClasse, labelPhi ,champPhi, labelDistance2, champDistance2, labelStatus, champStatus, labelDecouverte, champDecouverte, labelPClasse ,champPClasse);
	}
	protected TextField createurTextField( int x, int y)
	{
		TextField textField = new TextField();
		textField.setTranslateX(x);
		textField.setTranslateY(y);
		return textField;
	}
	protected Label createurLabel(String contenu, int x, int y)
	{
		Label label = new Label(contenu + " : ");
		label.setTranslateX(x);
		label.setTranslateY(y);
		return label;
	}
	protected void afficherSceneModifier(String planete)
	{
		StackPane racine = new StackPane();
		Label label = new Label(planete);
		racine.getChildren().add(label);
		Scene scene = new Scene(racine, 500, 500);
		changerScene(scene);
	}
	protected void changerScene(Scene scene)
	{
		scenePrincipale.setScene(scene);
		scenePrincipale.setTitle("Planet");
		scenePrincipale.show();
	}
	protected void ajouterEvenementValider(Button boutton, StackPane racine)
	{
		boutton.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		    	controleur.ajouter(racine);
		    	afficherScenePrincipale();
		    }});
	}
	protected void ajouterEvenementRetour(Button boutton)
	{
		boutton.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		    	afficherScenePrincipale();
		    }});
	}
	protected void ajouterEvenementSuprimmer(Button boutton)
	{
		boutton.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		    	Button boutton = (Button)e.getSource();
		    	 afficherSceneSuprimer(boutton.getId());
		    }});
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

		boutton.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		    	Button boutton = (Button)e.getSource();
		    	 afficherSceneModifier(boutton.getId());
		    }});
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
			this.ajouterEvenementModifier(bouttonModifier);

			racine.getChildren().addAll(labelPlanet, bouttonSuprimer, bouttonModifier);
		}
	}
}
