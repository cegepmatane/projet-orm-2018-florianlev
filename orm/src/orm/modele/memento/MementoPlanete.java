package orm.modele.memento;
import orm.modele.Planete;

import java.util.Date;

public class MementoPlanete {

    protected Planete planete;
    protected int version;
    static protected int versionCourante;

    public MementoPlanete(){
        this.planete = new Planete();
        this.version = versionCourante++;
    }

    public Planete getPlanete()
    {
        return planete;
    }

    public void setPlanete(Planete planete)
    {
        this.planete = planete;
    }
}
