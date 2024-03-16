package kz.bitlab.techordaC3.springproject.controllers;

import kz.bitlab.techordaC3.springproject.models.DBManager;
import kz.bitlab.techordaC3.springproject.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
public class HomeController {
    @GetMapping(value = "/") // protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    public String index(Model model){
        ArrayList<Item> items = DBManager.getItems();
        model.addAttribute("items", items); //req.setAttribute("tovary", items)
        return "index";// req.getRequestDispatcher("index.html").forward(req, resp);
    }

    @GetMapping(value = "/addItem")
    public String addItem(){
        return "addItem";
    }

    @PostMapping(value = "/addItem")
    public String addItem(@RequestParam(name = "item_name") String name,
                          @RequestParam(name = "description") String description,
                          @RequestParam(name = "price") double price,
                          Model model){
        System.out.println(name+ " " + description);
        Item item = new Item();
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        DBManager.addItem(item);
        return "redirect:/";
    }
    @GetMapping(value = "/details/{id}")
    public String detailsItem(@PathVariable(name = "id") Long id,
                              Model model) {
        Item item = DBManager.getItem(id);
        model.addAttribute("tovar", item);
        return "details";
    }
    //result: http://localhost:8010/details/1

    @GetMapping(value = "/details")
    public String details(@RequestParam(name = "id") Long id,
                              Model model){
        Item item = DBManager.getItem(id);
        model.addAttribute("tovar", item);
        return "details";
    }
    //result: http://localhost:8010/details?id=1
}
