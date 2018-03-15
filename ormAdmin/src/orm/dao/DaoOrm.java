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

    public static void ajouterPlanete(Planete planete)
    {
        Configuration configuration = new Configuration();
        configuration.addClass(Planete.class);

        SessionFactory sessionControleur = configuration.buildSessionFactory();
        Session session = sessionControleur.openSession();
        planete = new Planete();

        session.beginTransaction();

        SQLQuery query = session.createSQLQuery("" + "INSERT INTO exoplanetes (planete,etoile,typeEtoile,masse,rayon,flux,temperature,periode,distance,zone,ist,sph,hzd,hzc,hza,pClasse,hClasse,phi,distance2,status,decouverte) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        query.setParameter(0, planete.getNom());
        query.setParameter(1, planete.getEtoile());
        query.setParameter(2, planete.getTypeEtoile());
        query.setParameter(3, planete.getMasse());
        query.setParameter(4, planete.getRayon());
        query.setParameter(5, planete.getFlux());
        query.setParameter(6, planete.getTemperature());
        query.setParameter(7, planete.getPeriode());
        query.setParameter(8, planete.getDistance());
        query.setParameter(9, planete.getZone());
        query.setParameter(10, planete.getIst());
        query.setParameter(11, planete.getSph());
        query.setParameter(12, planete.getHzd());
        query.setParameter(13, planete.getHzc());
        query.setParameter(14, planete.getHza());
        query.setParameter(15, planete.getpClasse());
        query.setParameter(16, planete.gethClasse());
        query.setParameter(17, planete.getPhi());
        query.setParameter(18, planete.getDistance2());
        query.setParameter(19, planete.getStatus());
        query.setParameter(20, planete.getDecouverte());


        query.executeUpdate();
        session.getTransaction();


    }










}
