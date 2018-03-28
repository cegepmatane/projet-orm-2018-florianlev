package orm.filtre;

import java.util.List;

import orm.modele.Planete;

public abstract class TemplateFiltre {
	List<Planete> listeATrier;
	List<Planete> listeHabitable;
	List<Planete> listeAtteignable;
	List<Planete> listeAnalysable;
	public TemplateFiltre(List<Planete> listePlanete)
	{
		this.listeATrier = listePlanete;
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
