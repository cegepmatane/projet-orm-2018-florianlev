package orm.filtre;

import java.util.TreeMap;
import java.util.Map.Entry;

import orm.modele.Planete;

public class FiltreTournesol extends TemplateFiltre{

	public FiltreTournesol(TreeMap<String, Planete> arbrePlanete) {
		super(arbrePlanete);
	}

	@Override
	protected void trierHabitable() {
		// aucun critere
		
	}

	@Override
	protected void trierAtteignable() {
		for(Entry<String, Planete> entree : arbrePlanete.entrySet()){
			
			Planete planete = entree.getValue();
			float distance = 0;
			String stringDistance = planete.getDistance();
			stringDistance += "    ";

			try{
				distance = Float.valueOf(stringDistance.substring(0, 4));
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage() + " : " + planete.getNom());
			}
			//System.out.println(distance);
			if(distance < 100)
				this.listeAtteignable.add(planete);
		}
		//System.out.println(this.listeAtteignable.size());
	}

	@Override
	protected void trierAnalysable() {
		for(Entry<String, Planete> entree : arbrePlanete.entrySet()){
			
			Planete planete = entree.getValue();
			float periode = Float.valueOf(planete.getPeriode().substring(0, 3));
			//System.out.println(periode);
			if(periode < 40)
				this.listeAnalysable.add(planete);
		}
		//System.out.println(this.listeAnalysable.size());
		
	}

}
