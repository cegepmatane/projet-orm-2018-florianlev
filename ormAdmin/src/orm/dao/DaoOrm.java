package orm.dao;
import java.sql.SQLException;
import java.util.Iterator;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import orm.modele.Planete;
import java.util.ArrayList;
import java.util.List;
import orm.modele.Planete;



//package orm.dao;

public class DaoOrm {

	protected List<Planete> listePlanete;


    public DaoOrm() {

        listePlanete = new ArrayList<>();
    }

    public List<Planete> getRecherchePlanete ()
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
            listePlanete.add((Planete)iterateurPlanete.next());
        }
        
        session.close();
        sessionControleur.close();

        return listePlanete;
    }

    public static void ajouterPlanete()
    {
        Configuration configuration = new Configuration();
        configuration.addClass(Planete.class);

        SessionFactory sessionControleur = configuration.buildSessionFactory();
        Session session = sessionControleur.openSession();

        session.beginTransaction();
        
        SQLQuery query = session.createSQLQuery("" + "INSERT INTO exoplanetes (planete) VALUES (?)");
        query.setParameter(0, "test");
        query.executeUpdate();
        session.getTransaction();


    }










}
