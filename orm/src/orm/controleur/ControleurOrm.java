package orm.controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import orm.dao.DaoOrm;
import orm.filtre.FiltreTournesol;
import orm.modele.Planete;
import orm.modele.memento.*;
import orm.vue.VueOrm;

public class ControleurOrm {
	protected VueOrm vue;
	protected DaoOrm daoPlanete;
	protected TreeMap<String, Planete> arbrePlanete;

	//protected MementoPlanete memento;
	protected MemoirePlanetes memoire;



	public ControleurOrm(VueOrm vue)
	{
		memoire = new MemoirePlanetes();
		//memento = new MementoPlanete();
		FiltreTournesol filtreTournesol = new FiltreTournesol(arbrePlanete);

		this.vue = vue;
		DaoOrm daoPlanete = new DaoOrm();
		arbrePlanete = daoPlanete.getRecherchePlanete();
		//memento.setPlanete(arbrePlanete.get("Earth"));
		//memoire.ajouterMemento(memento);
		vue.setArbrePlanete(arbrePlanete);
			if( null != filtreTournesol.getListeAtteignable())
			{

				filtreTournesol.executer();

				//vue.setListeAnalysable(filtreTournesol.getListeAnalysable());
				vue.setListeAtteignable(filtreTournesol.getListeAtteignable());
				//vue.setListeHabitable(filtreTournesol.getListeHabitable());
			}
		}

	public void sauvegarder(Planete planete)
	{
		MementoPlanete memento = new MementoPlanete();
		memento.setPlanete(planete);
		memoire.ajouterMemento(memento);
	}
}