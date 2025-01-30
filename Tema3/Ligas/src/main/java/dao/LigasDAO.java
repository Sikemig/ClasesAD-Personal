package dao;

import database.HibernateUtil;
import model.Liga;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LigasDAO {

    Session session;

    // persist --> guarda
    // merge --> actualiza - inserta(id)
    // list --> select(id)
    // remove --> borrar(id)

    // namedQuery / Query --> HQL
    // nativeQuery / Query --> SQL

    public void crearLiga(Liga liga){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.persist(liga);

        session.getTransaction().commit();
        session.close();
    }

    public Liga getLiga(int id){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Liga liga = session.get(Liga.class, id);

        session.getTransaction().commit();
        session.close();

        return liga;
    }

    public List<Liga> getAllLigas(){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        //List<Liga> ligas = session.
        // HQL -> Query -> NativeQuery(sentencias SQL) -> Query(HQL) -> namedQuery(HQL)
        Query<Liga> query = session.createQuery("FROM Liga", Liga.class);
        List<Liga> listaLigas = query.list();

        session.getTransaction().commit();
        session.close();
        return listaLigas;
    }
}
