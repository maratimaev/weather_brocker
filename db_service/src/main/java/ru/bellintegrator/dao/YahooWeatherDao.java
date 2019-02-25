package ru.bellintegrator.dao;

import ru.bellintegrator.model.YahooWeather;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class YahooWeatherDao {
    @PersistenceContext(unitName = "postgre")
    private EntityManager em;

    public List<YahooWeather> findAll(){
//        List<YahooWeather> list = em.createQuery("select y from " + YahooWeather.class.getSimpleName() + " y")
//                .getResultList();

        return null;
    }
}
