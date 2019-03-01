//package net.proselyte.bookmanager.controller;
//
//import net.proselyte.bookmanager.model.YahooWeather;
//import net.proselyte.bookmanager.service.YahooWeatherService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//public class BookController {
//    private YahooWeatherService yahooWeatherService;
//
//    @Autowired(required = true)
//    @Qualifier(value = "yahooWeatherService")
//    public void setYahooWeatherService(YahooWeatherService yahooWeatherService) {
//        this.yahooWeatherService = yahooWeatherService;
//    }
//
//    @RequestMapping(value = "books", method = RequestMethod.GET)
//    public String listBooks(Model model){
//        model.addAttribute("book", new YahooWeather());
//        model.addAttribute("listBooks", this.yahooWeatherService.listBooks());
//
//        return "books";
//    }
//
//    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
//    public String addBook(@ModelAttribute("book") YahooWeather yahooWeather){
//        if(yahooWeather.getId() == 0){
//            this.yahooWeatherService.addBook(yahooWeather);
//        }else {
//            this.yahooWeatherService.updateBook(yahooWeather);
//        }
//
//        return "redirect:/books";
//    }
//
//    @RequestMapping("/remove/{id}")
//    public String removeBook(@PathVariable("id") int id){
//        this.yahooWeatherService.removeBook(id);
//
//        return "redirect:/books";
//    }
//
//    @RequestMapping("edit/{id}")
//    public String editBook(@PathVariable("id") int id, Model model){
//        model.addAttribute("book", this.yahooWeatherService.getBookById(id));
//        model.addAttribute("listBooks", this.yahooWeatherService.listBooks());
//
//        return "books";
//    }
//
//    @RequestMapping("bookdata/{id}")
//    public String bookData(@PathVariable("id") int id, Model model){
//        model.addAttribute("book", this.yahooWeatherService.getBookById(id));
//
//        return "bookdata";
//    }
//}
