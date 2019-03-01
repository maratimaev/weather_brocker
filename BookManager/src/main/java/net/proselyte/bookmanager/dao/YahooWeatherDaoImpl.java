package net.proselyte.bookmanager.dao;

import net.proselyte.bookmanager.model.YahooWeather;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class YahooWeatherDaoImpl implements YahooWeatherDao {
//    @PersistenceContext(unitName = "postgre")
//    private EntityManager em;

//    @Autowired
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
