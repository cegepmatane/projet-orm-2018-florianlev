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


	public VueOrm(int dummy)
	{
		listePlanete = null;
		controleur = null;
	}

	public VueOrm()
	{
		listePlanete = null;
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
	protected void afficherSceneSuprimer(int id)
	{
		StackPane racine = new StackPane();
		Label label = new Label("Voulez-vous vraiment suprimer la planete " + id + "?");
		racine.setAlignment(label, Pos.CENTER);
		
		Button oui = new Button("oui");
		this.ajouterEvenementSuprimer(oui, id);
		racine.setAlignment(oui, Pos.BOTTOM_LEFT);
		
		Button non = new Button("non");
		this.ajouterEvenementRetour(non);
		racine.setAlignment(non, Pos.BOTTOM_RIGHT);
		
		racine.getChildren().addAll(label, oui, non);
		Scene scene = new Scene(racine, 300, 100);
		changerScene(scene);
	}
	protected void afficherSceneAjouter()
	{
		StackPane racine = new StackPane();
		racine.setAlignment(Pos.TOP_LEFT);
		
		Label nomPage = new Label("Ajouter une planete");
		racine.setAlignment(nomPage, Pos.TOP_CENTER);
		
		ajouterChamps(racine, false, "none");
		
		Button valider = new Button("valider");
		this.ajouterEvenementAjouter(valider, racine);
		racine.setAlignment(valider, Pos.BOTTOM_CENTER);
		
		Button retour = new Button("retour");
		this.ajouterEvenementRetour(retour);
		racine.setAlignment(retour, Pos.BOTTOM_LEFT);
		
		racine.getChildren().addAll(nomPage, valider, retour);
		
		Scene scene = new Scene(racine, 500, 600);
		changerScene(scene);
	}
	/*protected void afficherSceneModifier(String planete)
	{
		StackPane racine = new StackPane();
		racine.setAlignment(Pos.TOP_LEFT);
		
		Label nomPage = new Label("Modifer la planete " + planete);
		racine.setAlignment(nomPage, Pos.TOP_CENTER);
		
		ajouterChamps(racine, true, planete);
		
		Button valider = new Button("valider");
		this.ajouterEvenementModifier(valider, racine);
		racine.setAlignment(valider, Pos.BOTTOM_CENTER);
		
		Button retour = new Button("retour");
		this.ajouterEvenementRetour(retour);
		racine.setAlignment(retour, Pos.BOTTOM_LEFT);
		
		racine.getChildren().addAll(nomPage, valider, retour);
		
		Scene scene = new Scene(racine, 500, 705);
		changerScene(scene);
	}*/
	protected void ajouterChamps(StackPane racine, boolean pourModifier, String planete)
	{
		int decalageYChamp = 20, decalageYLabel = 25, decalageY = 30, decalageXChamp = 100, decalageXLabel = 0; 
		
		
		Label labelNom = createurLabel("(S)nom", decalageXLabel, decalageYLabel);
		TextField champNom = createurTextField(decalageXChamp, decalageYChamp);
		/*if(pourModifier){
			champNom.setText(planete);
			labelNom.setVisible(false);
			champNom.setVisible(false);
		}*/
		racine.getChildren().addAll(labelNom, champNom);
		
		decalageYChamp += decalageY;
		decalageYLabel += decalageY;
		
		List<String> listeNom = new ArrayList<String>();
		listeNom.add("(S)Etoile");
		listeNom.add("(S)TypeEtoile");
		listeNom.add("(S)Masse");
		listeNom.add("(S)Rayon");
		listeNom.add("(F)Flux");
		listeNom.add("(S)Temperature");
		listeNom.add("(F)Periode");
		listeNom.add("(F)Distance");
		listeNom.add("(S)Zone");
		listeNom.add("(F)Hzd");
		listeNom.add("(F)Hzc");
		listeNom.add("(F)Hza");
		listeNom.add("(S)HClasse");
		listeNom.add("(S)Distance2");
		listeNom.add("(S)Status");
		listeNom.add("(S)Decouverte");
		listeNom.add("(S)PClasse");
		
		for(int parametre = 0; parametre < listeNom.size(); parametre ++)
		{
			Label label = createurLabel(listeNom.get(parametre), decalageXLabel, decalageYLabel);
			TextField champ = createurTextField(decalageXChamp, decalageYChamp);
			
			racine.getChildren().addAll(label, champ);
			
			decalageYChamp += decalageY;
			decalageYLabel += decalageY;
		}
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

	protected void changerScene(Scene scene)
	{
		scenePrincipale.setScene(scene);
		scenePrincipale.setTitle("Planet");
		scenePrincipale.show();
	}
	/*protected void ajouterEvenementModifier(Button boutton,StackPane racine)
	{
		boutton.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		    	controleur.modifier(racine);
		    	afficherScenePrincipale();
		    }});
	}*/
	protected void ajouterEvenementSuprimer(Button boutton, int planete)
	{
		boutton.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		    	controleur.suprimer(planete);
		    	afficherScenePrincipale();
		    }});
	}
	protected void ajouterEvenementAjouter(Button boutton, StackPane racine)
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
		    	 afficherSceneSuprimer( Integer.parseInt(boutton.getId()));
		    }});
	}
	protected void ajouterEvenementAjouter(Button boutton)
	{
		boutton.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		    	afficherSceneAjouter();
		    }});
	}
	/*protected void ajouterEvenementModifier(Button boutton)
	{

		boutton.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		    	Button boutton = (Button)e.getSource();
		    	 afficherSceneModifier((boutton.getId()));
		    }});
	}*/
	protected void afficherPanetes(VBox racine)
	{
		int decalage = 80;
		
		for(int position = listePlanete.size()-1;position >= 0; position--)
		{
			Label labelPlanet =  new Label(listePlanete.get(position).getNom());
			Button bouttonSuprimer = new Button("Supprimer");
			//Button bouttonModifier = new Button("Modifier");
			
			labelPlanet.setTranslateX(0);
			labelPlanet.setTranslateY(decalage);
			
			bouttonSuprimer.setId(String.valueOf(listePlanete.get(position).getId()));
			bouttonSuprimer.setTranslateX(100);
			bouttonSuprimer.setTranslateY(decalage-25);
			this.ajouterEvenementSuprimmer(bouttonSuprimer);
			
			//bouttonModifier.setId(listePlanete.get(position).getNom());
			//bouttonModifier.setTranslateX(200);
			//bouttonModifier.setTranslateY(decalage-50);
			//this.ajouterEvenementModifier(bouttonModifier);

			racine.getChildren().addAll(labelPlanet, bouttonSuprimer/*, bouttonModifier*/);
		}
	}

	public List<Planete> getListePlanete() {
		return listePlanete;
	}

	public void setListePlanete(List<Planete> listePlanete) {
		this.listePlanete = listePlanete;
	}
}
