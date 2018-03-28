package orm.dao;
import java.util.Iterator;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import orm.modele.Planete;
import java.util.TreeMap;

public class DaoOrm {

	TreeMap<String, Planete> arbrePlanete;
    public DaoOrm() {
    	arbrePlanete = new TreeMap<String, Planete>();
    }

    public TreeMap<String, Planete> getRecherchePlanete ()
    {
        Configuration configuration = new Configuration();
        configuration.addClass(Planete.class);

        SessionFactory sessionControleur = configuration.buildSessionFactory();
        Session session = sessionControleur.openSession();

        Transaction operation = null;
        try
        {
            operation = session.beginTransaction();
            Planete planeteTest = new Planete();
            session.save(planeteTest);
        }
        catch (Exception e)
        {
            if (operation != null) operation.rollback();
        }

        Iterator iterateurPlanete = session.createQuery("from Planete").iterate();

        while (iterateurPlanete.hasNext())
        {
        	Planete planete = (Planete)iterateurPlanete.next();
        	if(null!=planete)arbrePlanete.put(planete.getNom(), planete);
        }
        
        session.close();
        sessionControleur.close();

        return arbrePlanete;
    }









}
