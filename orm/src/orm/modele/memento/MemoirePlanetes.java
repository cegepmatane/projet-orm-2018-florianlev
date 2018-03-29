package orm.modele.memento;
import java.util.HashMap;

public class MemoirePlanetes {
    protected HashMap<String, MementoPlanete> hashPlanete;

    public MemoirePlanetes()
    {
        this.hashPlanete = new HashMap<String, MementoPlanete>();
    }

    public HashMap<String, MementoPlanete> getListePlanete()
    {
        return hashPlanete;
    }

    public void ajouterMemento(MementoPlanete memento)
    {
        this.hashPlanete.put(memento.planete.getNom(), memento);
    }

    public void setListePlanete(HashMap<String, MementoPlanete> hashPlanete)
    {
        this.hashPlanete = hashPlanete;
    }
}
