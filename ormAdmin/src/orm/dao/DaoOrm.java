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
    private Session session;
    private SessionFactory sessionControleur;


    public DaoOrm() {

        listePlanete = new ArrayList<>();
        Configuration configuration = new Configuration();
        configuration.addClass(Planete.class);
        sessionControleur = configuration.buildSessionFactory();
        session = sessionControleur.openSession();
    }

    public List<Planete> getRecherchePlanete ()
    {
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



        return listePlanete;
    }
   
    public void ajouterPlanete(Planete planete)
    {
        session.save(planete);
    }

    public void modifierPlanete(Planete planete) {


        Configuration configuration = new Configuration();
        configuration.addClass(Planete.class);

        SessionFactory sessionControleur = configuration.buildSessionFactory();
        Session session = sessionControleur.openSession();

        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("" + "UPDATE exoplanetes SET etoile ='" + planete.getEtoile() + "', typeEtoile ='" + planete.getTypeEtoile() +"', masse ='" + planete.getMasse() + "', rayon ='" + planete.getMasse() + "', flux='" + planete.getFlux() + "', temperature ='" + planete.getTemperature() + "', periode ='" + planete.getPeriode() + "', distance ='" + planete.getDistance() + "', zone ='" + planete.getZone() + "', ist ='" + planete.getIst() + "', sph ='" + planete.getSph() + "', hzd ='" + planete.getHzd() + "', hzc='" + planete.getHzc() + "', hza='" + planete.getHza() + "', pClasse='" + planete.getpClasse() + "', hClasse='" + planete.gethClasse() + "', phi='" + planete.getPhi() + "', distance2='" + "', status='" + planete.getStatus() + "', decouverte='" + planete.getDecouverte() + "' WHERE planete ='" + planete.getNom()+"'");

        //SQLQuery query = session.createSQLQuery("" + "UPDATE exoplanetes SET planete = 'ploute' WHERE planete = 'caca'");

        query.executeUpdate();
        session.getTransaction();
    }


    public void supprimerPlanete(String planete) {


        Transaction transaction = session.beginTransaction();
        Planete planeteTermine = new Planete();
        planeteTermine.setNom(planete);
        session.delete(planeteTermine);
        transaction.commit();
    }










}
