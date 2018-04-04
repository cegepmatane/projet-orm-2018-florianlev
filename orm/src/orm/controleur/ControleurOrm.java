package orm.controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import orm.dao.DaoOrm;
import orm.modele.Planete;
import orm.modele.memento.*;
import orm.vue.VueOrm;

public class ControleurOrm {
	protected VueOrm vue;
	protected DaoOrm daoPlanete;
	protected TreeMap<String, Planete> arbrePlanete;
	protected MementoPlanete memento;
	protected MemoirePlanetes memoire;



	public ControleurOrm(VueOrm vue)
	{
		memoire = new MemoirePlanetes();
		memento = new MementoPlanete();

		this.vue = vue;
		DaoOrm daoPlanete = new DaoOrm();
		arbrePlanete = daoPlanete.getRecherchePlanete();
		//memento.setPlanete(arbrePlanete.get("Earth"));
		//memoire.ajouterMemento(memento);
		vue.setArbrePlanete(arbrePlanete);
	}

	public void sauvegarder(Planete planete)
	{
		memento.setPlanete(planete);
	}
}