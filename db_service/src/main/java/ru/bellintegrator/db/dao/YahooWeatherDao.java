package ru.bellintegrator.db.dao;

import org.springframework.stereotype.Component;
import ru.bellintegrator.db.model.YahooWeather;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class YahooWeatherDao {
    @PersistenceContext(unitName = "postgre")
    private EntityManager em;

    public void save(YahooWeather yahooWeather) {
        try {
            em.persist(yahooWeather);
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
