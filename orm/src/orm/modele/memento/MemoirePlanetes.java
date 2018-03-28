package orm.modele.memento;
import java.util.ArrayList;
import java.util.List;

public class MemoirePlanetes {
    protected List<MementoPlanete> listePlanete;

    public MemoirePlanetes()
    {
        this.listePlanete = new ArrayList<MementoPlanete>();
    }

    public List<MementoPlanete> getListePlanete()
    {
        return listePlanete;
    }

    public void ajouterMemento(MementoPlanete memento)
    {
        this.listePlanete.add(memento);
    }

    public void setListePlanete(List<MementoPlanete> listePlanete)
    {
        this.listePlanete = listePlanete;
    }


}
