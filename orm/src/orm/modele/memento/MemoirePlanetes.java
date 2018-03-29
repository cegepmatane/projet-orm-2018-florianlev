package orm.modele.memento;
import java.util.HashMap;
import java.util.Map.Entry;

public class MemoirePlanetes {
    protected HashMap<String, MementoPlanete> hashPlanete;
    protected DaoMemento daoMemento;
    public MemoirePlanetes()
    {
        this.hashPlanete = new HashMap<String, MementoPlanete>();
        this.daoMemento = new DaoMemento();
    }

    public HashMap<String, MementoPlanete> getListePlanete()
    {
        return hashPlanete;
    }

    public void ajouterMemento(MementoPlanete memento)
    {
        this.hashPlanete.put(memento.planete.getNom(), memento);
        daoMemento.sauvegarder(memento);
    }

    public void setListePlanete(HashMap<String, MementoPlanete> hashPlanete)
    {
        this.hashPlanete = hashPlanete;
        for(Entry<String, MementoPlanete> entree : hashPlanete.entrySet())
        {
        	daoMemento.sauvegarder(entree.getValue());
        }
    }
}
