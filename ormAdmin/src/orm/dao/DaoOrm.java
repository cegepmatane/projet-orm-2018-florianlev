package orm.dao;
import java.util.Iterator;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import orm.modele.Planete;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.List;


//package orm.dao;

public class DaoOrm {

    protected Hashtable<Integer, Planete> indexPlanete;
    protected List<Planete> listePlanete;
    private Session session;
    private SessionFactory sessionControleur;

    public DaoOrm() {

        indexPlanete = null;
        ouvrirSession();
    }

    public void ouvrirSession()
    {
        Configuration configuration = new Configuration();
        configuration.addClass(Planete.class);
        sessionControleur = configuration.buildSessionFactory();
        session = sessionControleur.openSession();
    }

    public void fermer()
    {
        // Nettoyage final (une seule fois)
        session.close();
        sessionControleur.close();

    }


    public List<Planete> getRecherchePlanete ()
    {

        if(this.listePlanete == null)
        {
            this.indexPlanete = new Hashtable<Integer, Planete>();
            this.listePlanete = new ArrayList<Planete>();
            Transaction operation = null;

            Iterator iterateurPlanete = session.createQuery("from Planete").iterate();

            while (iterateurPlanete.hasNext())
            {
                Planete planete = (Planete)iterateurPlanete.next();
                this.indexPlanete.put(planete.getId(), planete);
                this.listePlanete.add(planete);
            }
        }

        return this.listePlanete;
    }
   
    public void ajouterPlanete(Planete planete)
    {
        session.save(planete);

    }



    public void supprimerPlanete(int id) {
        Transaction transaction = session.beginTransaction();
        //Planete planeteTermine = new Planete();
        //planeteTermine.setId(id);
        Planete planete = this.indexPlanete.get(id);
        session.delete(planete);
        transaction.commit();
        this.listePlanete.remove(planete);
        this.indexPlanete.remove(planete.getId());
    }

}
