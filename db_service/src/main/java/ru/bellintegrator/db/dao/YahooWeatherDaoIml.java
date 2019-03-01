package ru.bellintegrator.db.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.db.model.YahooWeather;

import java.util.List;

@Repository
public class YahooWeatherDaoIml implements YahooWeatherDao{
//    @PersistenceContext(unitName = "postgre")
//    private EntityManager em;

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(YahooWeather yahooWeather) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
//            em.persist(yahooWeather);
            session.persist(yahooWeather);
            String str = "wefqwf";
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<YahooWeather> findAll(){
//        List<YahooWeatherView> list = em.createQuery("select y from " + YahooWeatherView.class.getSimpleName() + " y")
//                .getResultList();

        return null;
    }
}
