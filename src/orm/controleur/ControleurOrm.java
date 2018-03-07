package orm.controleur;

import orm.dao.DaoOrm;
import orm.vue.VueOrm;

public class ControleurOrm {
	VueOrm vue;
	DaoOrm daoPlanete;



	public ControleurOrm(VueOrm vue)
	{
		this.vue = vue;

		DaoOrm daoPlanete = new DaoOrm();

		daoPlanete.getRecherchePlanete();
	}
}
