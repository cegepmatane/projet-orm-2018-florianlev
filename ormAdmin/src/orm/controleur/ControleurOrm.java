package orm.controleur;

import java.util.ArrayList;
import java.util.List;

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
		DaoOrm daoPlanete = new DaoOrm();
		daoPlanete.getRecherchePlanete();
		daoPlanete.ajouterPlanete();

		listePlanete = daoPlanete.getRecherchePlanete();
	}
	public List<Planete> getListePlanete() {
		return listePlanete;
	}
}
