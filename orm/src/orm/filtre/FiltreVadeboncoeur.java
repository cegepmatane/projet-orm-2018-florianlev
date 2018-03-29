package orm.filtre;

import java.util.TreeMap;
import java.util.Map.Entry;

import orm.modele.Planete;

public class FiltreVadeboncoeur extends TemplateFiltre{

	public FiltreVadeboncoeur(TreeMap<String, Planete> arbrePlanete) {
		super(arbrePlanete);
	}

	@Override
	protected void trierHabitable() {
		for(Entry<String, Planete> entree: arbrePlanete.entrySet()){
			
			Planete planete = entree.getValue();
			int temperature = Integer.valueOf(planete.getTemperature().substring(0, 3));
			//System.out.println(temperature);
			if(temperature < 240)
				this.listeHabitable.add(planete);
		}
		//System.out.println(this.listeHabitable.size());
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
			if(distance < 20)
				this.listeAtteignable.add(planete);
		}
		//System.out.println(this.listeAtteignable.size());
	}

	@Override
	protected void trierAnalysable() {
		// aucun critere
		
	}

}
