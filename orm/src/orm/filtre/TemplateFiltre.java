package orm.filtre;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import orm.modele.Planete;

public abstract class TemplateFiltre {
	TreeMap<String, Planete> arbrePlanete;
	List<Planete> listeHabitable;
	List<Planete> listeAtteignable;
	List<Planete> listeAnalysable;
	public TemplateFiltre(TreeMap<String, Planete> arbrePlanete)
	{
		this.arbrePlanete = arbrePlanete;
		listeHabitable = new ArrayList<Planete>();
		listeAtteignable = new ArrayList<Planete>();
		listeAnalysable = new ArrayList<Planete>();
	}
	public void executer()
	{
		trierHabitable();
		trierAtteignable();
		trierAnalysable();
	}
	
	protected abstract void trierHabitable();
	protected abstract void trierAtteignable();
	protected abstract void trierAnalysable();
	
	public List<Planete> getListeHabitable() {
		return listeHabitable;
	}
	public List<Planete> getListeAtteignable() {
		return listeAtteignable;
	}
	public List<Planete> getListeAnalysable() {
		return listeAnalysable;
	}
}
