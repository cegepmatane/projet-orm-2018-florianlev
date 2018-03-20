package orm.controleur;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import orm.dao.DaoOrm;
import orm.modele.Planete;
import orm.vue.VueOrm;

public class ControleurOrm {
	protected VueOrm vue;
	protected DaoOrm daoPlanete;
	protected List<Planete> listePlanete;

	public ControleurOrm(VueOrm vue)
	{
		this.vue = vue;
		listePlanete = new ArrayList<>();
		daoPlanete = new DaoOrm();

		//FONCTION AJOUT PLANETE PREND EN PARAM UN OBJET PLANETE
		//daoPlanete.ajouterPlanete();

		//FONCTION SUPPRIMER PLANETE PREND EN PARAM UN STRING
		//daoPlanete.supprimerPlanete("test");

		//FONCTION MODIFIER PLANETE PREND EN PARAM UN OBJET PLANETE
		//daoPlanete.modifierPlanete();

		listePlanete = daoPlanete.getRecherchePlanete();
	}
	public List<Planete> getListePlanete() {
		return daoPlanete.getRecherchePlanete();
	}
	public void ajouter(StackPane racine)
	{
		Planete planete = new Planete();
		List<TextField> listeDonnee = new ArrayList<TextField>();
		for(int donne = 1; donne <= 35; donne+=2)
		{
			listeDonnee.add((TextField)racine.getChildren().get(donne));
			//System.out.println("ok");
		}

		daoPlanete.ajouterPlanete(creationPlanete(listeDonnee));
	}
	public void modifier(StackPane racine)
	{
		Planete planete = new Planete();
		List<TextField> listeDonnee = new ArrayList<TextField>();
		//System.out.println("ok");
		for(int donne = 1; donne <= 41; donne+=2)
		{
			listeDonnee.add((TextField)racine.getChildren().get(donne));
			//System.out.println("ok");
		}

		//daoPlanete.modifierPlanete(creationPlanete(listeDonnee));
	}
	public void suprimer(int id)
	{
		daoPlanete.supprimerPlanete(id);
	}
	protected Planete creationPlanete(List<TextField> listeDonnee)
	{
		Planete planete = new Planete();
		
		planete.setNom(listeDonnee.get(0).getText());
		planete.setEtoile(listeDonnee.get(1).getText());
		planete.setTypeEtoile(listeDonnee.get(2).getText());
		planete.setMasse(listeDonnee.get(3).getText());
		planete.setRayon(listeDonnee.get(4).getText());
		planete.setFlux(listeDonnee.get(5).getText());
		planete.setTemperature(listeDonnee.get(6).getText());
		planete.setPeriode(listeDonnee.get(7).getText());
		planete.setDistance(listeDonnee.get(8).getText());
		planete.setZone(listeDonnee.get(9).getText());
		planete.setHzd(listeDonnee.get(10).getText());
		planete.setHzc(listeDonnee.get(11).getText());
		planete.setHza(listeDonnee.get(12).getText());
		planete.sethClasse(listeDonnee.get(13).getText());
		planete.setDistance2(listeDonnee.get(14).getText());
		planete.setStatus(listeDonnee.get(15).getText());
		planete.setDecouverte(listeDonnee.get(16).getText());
		planete.setpClasse(listeDonnee.get(17).getText());
		
		return planete;
	}

}
