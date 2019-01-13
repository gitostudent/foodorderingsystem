package models.products.Food.Pizza;

import models.products.Food.Food;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Pizza extends Food {


    String dought;
    String chesee;
    List<String> toppings;

    public Pizza(int id, double price) {
        super(id, "Pizza", price);
        toppings=new ArrayList<String>();
    }
    public Pizza(Pizza pizza){
        super(pizza.getId(), "Pizza", pizza.getPrice());
        this.dought=pizza.dought;
        this.chesee=pizza.chesee;
        this.toppings=pizza.toppings;
    }

    @Override
    public String toString() {
        String toplingslist=toppings.stream().collect(joining(", ", "with ", ""));
        if(toplingslist.equals("with")){
            toplingslist="without";
        }
        return (new StringBuilder())
                .append("Pizza with ")
                .append(dought)
                .append(" dought, ")
                .append(chesee)
                .append(" chesee and ").append(toplingslist).append(" toplings").toString();
    }
}
