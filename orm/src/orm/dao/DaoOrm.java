package orm.dao;
import java.util.Iterator;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import orm.modele.ArbrePlanete;
import orm.modele.Planete;
import java.util.ArrayList;
import java.util.List;
import orm.modele.Planete;



//package orm.dao;

public class DaoOrm {

	ArbrePlanete arbrePlanete;
    public DaoOrm() {
    	arbrePlanete = new ArbrePlanete();;
    }

    public ArbrePlanete getRecherchePlanete ()
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
        	if(null!=planete)arbrePlanete.ajouter(planete);
        }
        
        session.close();
        sessionControleur.close();

        return arbrePlanete;
    }









}
