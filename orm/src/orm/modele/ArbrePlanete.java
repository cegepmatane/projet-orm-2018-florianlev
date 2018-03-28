package orm.modele;

import java.util.ArrayList;
import java.util.List;

public class ArbrePlanete {
	
	protected Noeud noeud;
	class Noeud
	{
		protected Planete planete;
		protected Noeud gauche;
		protected Noeud droite;
		protected int valeur;
		public Noeud(Planete planete, int valeur)
		{
			this.planete = planete;
			this.valeur = valeur;
		}
	}
	public ArbrePlanete()
	{
		noeud = null;
	}
	public void ajouter(Planete planete)
	{
		Noeud nouveau = new Noeud(planete, recupererValeur(planete));
		if(null == noeud)
		{
			noeud = new Noeud(planete, recupererValeur(planete));
		}
		else
		{
			ajouter(noeud, nouveau);
		}
	}
	private void ajouter(Noeud courrant, Noeud nouveau)
	{
		if(nouveau.valeur > courrant.valeur)
		{
			if(null == courrant.droite)
			{
				courrant.droite = nouveau;
			}else
			{
				ajouter(courrant.droite, nouveau);
			}
		}else
		{
			if(null == courrant.gauche)
			{
				courrant.gauche = nouveau;
			}else
			{
				ajouter(courrant.gauche, nouveau);
			}
		}
	}
	List<Planete> liste = new ArrayList<Planete>();
	public List<Planete> retournerListe()
	{
		this.chercherPlanete(this.noeud);
		return liste;
	}
	protected void chercherPlanete(Noeud noeud)
	{
		if (null == noeud) 
			return;
        if (null != noeud.gauche)
        	chercherPlanete(noeud.gauche);
        liste.add(noeud.planete);
        if (null != noeud.droite) 
        	chercherPlanete(noeud.droite);
	}
	private int recupererValeur(Planete planete)
	{
		int valeur = 0;
		valeur += Integer.valueOf(planete.getNom().charAt(0));
		valeur += Integer.valueOf(planete.getNom().charAt(1));
		valeur += Integer.valueOf(planete.getNom().charAt(2));
		valeur += Integer.valueOf(planete.getNom().charAt(3));
		valeur += Integer.valueOf(planete.getNom().charAt(4));
		valeur += planete.getNom().length();
		
		System.out.println(valeur);
		
		return valeur;
	}
}