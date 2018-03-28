package orm.controleur;

import java.util.TreeMap;

import orm.dao.DaoOrm;
import orm.filtre.FiltreVadeboncoeur;
import orm.modele.Planete;
import orm.vue.VueOrm;

public class ControleurOrm {
	protected VueOrm vue;
	protected DaoOrm daoPlanete;
	protected TreeMap<String, Planete> arbrePlanete;

	public ControleurOrm(VueOrm vue)
	{
		this.vue = vue;
		DaoOrm daoPlanete = new DaoOrm();
		arbrePlanete = daoPlanete.getRecherchePlanete();
		vue.setArbrePlanete(arbrePlanete);
	}
}