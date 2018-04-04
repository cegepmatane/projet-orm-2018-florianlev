package orm.vue;

import java.util.Map.Entry;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import orm.controleur.ControleurOrm;
import orm.modele.Planete;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

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
		TabPane racine = new TabPane();
		afficherPanetes(racine);
		Scene scene = new Scene(racine, 500, 500);


		ongletlistePlanete = new Tab("");
		tabPane.getTabs().add(ongletlistePlanete);

		marquePage = new Tab("");
		tabPane.getTabs().add(marquePage);

		recherche = new Tab("");
		tabPane.getTabs().add(recherche);


		//btnSauvegarder = new Button();
		//btnSauvegarder.setText("Say 'Hello World'");

		scenePrincipale.setScene(scene);
		scenePrincipale.setTitle("Planet");
		scenePrincipale.show();

		//controleur.afficherOnglets();
	}
	public void afficherPanetes(TabPane racine)
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
		this.ongletlistePlanete.setText(texte);
	}
	public void setArbrePlanete(TreeMap<String, Planete> arbrePlanete) {
		this.arbrePlanete = arbrePlanete;
	}
}
