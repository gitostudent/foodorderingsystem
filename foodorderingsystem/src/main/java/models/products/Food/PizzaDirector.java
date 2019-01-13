package models.products.Food;

import models.products.Food.Pizza.*;
import models.products.IStoreHandler;

import java.util.Scanner;

public class PizzaDirector {
    private IPizzaBuilder builder;
    private IStoreHandler store;
    PizzaDirector() {
    }
    PizzaDirector(IStoreHandler store) {
        this.store=store;
    }
    void assignBuilder(IPizzaBuilder builder) {
        this.builder = builder;
    }
    public Pizza getPizza() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want Pizza sauce? It it is free!!! [Y/N]");
        String s=scanner.nextLine();
        while(!s.equals("Y") && !s.equals("N")){
            System.out.println("Try Again[Y/N]");
            s=scanner.nextLine();
        }
        Pizza p;
        if(s.equals("Y")){
            p=new SasuedPizza(builder.getPizza());
        }
        else {
            p = builder.getPizza();
        }
        System.out.println("Your Pizza:");
        System.out.println(p);
        System.out.println("and it cost:"+p.getPrice());
        return p;
    }
    void construct(int id) throws Exception {
        System.out.println("Do you want Vegetarian Pizza? [Y/N]");
        Scanner scanner = new Scanner(System.in);
        String s=scanner.nextLine();
        while(!s.equals("Y") && !s.equals("N")){
            System.out.println("Try Again[Y/N]"+s);
            s=scanner.nextLine();
        }
        if(s.equals("Y")){
            assignBuilder(new VegePizzaBuilder(store,id));
        }
        else{
            assignBuilder(new NormalPizzaBuilder(store,id));
        }
        try {
            builder.buildDough();
            builder.buildChesee();
            builder.buildToppings();
            builder.buildPrice();
        } catch (Exception e) {
            System.out.println("Brak skladnikow na Pizze. Przepraszamy");
            throw new Exception("Blad przy tworzeniu Pizzy");

        }

    }
};
