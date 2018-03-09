package orm.vue;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import orm.controleur.ControleurOrm;
import orm.modele.Planete;

public class VueOrm extends Application{
	protected List<Planete> listePlanete;
	protected ControleurOrm controleur;
	protected StackPane racine;
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
		StackPane racine = new StackPane();
		afficherPanetes(racine);		
		Scene scene = new Scene(racine, 500, 500);
		
		scenePrincipale.setScene(scene);
		scenePrincipale.setTitle("Planet");
		scenePrincipale.show();
	}
	public void afficherPanetes(StackPane racine)
	{
		Text texte = new Text();
		String chaine = "";
		
		for(int position = listePlanete.size()-1;position >= 0; position--){
			chaine+=listePlanete.get(position).getNom();
			chaine+="	";
		}
		
		texte.setText(chaine);
		texte.setWrappingWidth(500);
		racine.getChildren().add(texte);
	}
}
