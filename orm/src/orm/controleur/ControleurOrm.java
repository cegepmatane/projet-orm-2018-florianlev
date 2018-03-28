package orm.controleur;

import java.util.ArrayList;
import java.util.List;

import orm.dao.DaoOrm;
import orm.modele.ArbrePlanete;
import orm.modele.Planete;
import orm.vue.VueOrm;

public class ControleurOrm {
	protected VueOrm vue;
	protected DaoOrm daoPlanete;
	protected ArbrePlanete arbrePlanete;

	public ControleurOrm(VueOrm vue)
	{
		this.vue = vue;
		DaoOrm daoPlanete = new DaoOrm();
		daoPlanete.getRecherchePlanete();
		
		arbrePlanete = daoPlanete.getRecherchePlanete();
	}
	public List<Planete> getListePlanete() {
		return arbrePlanete.retournerListe();
	}
}
