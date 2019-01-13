package models.products.Food.Pizza;

import models.products.Food.Category;
import models.products.Food.Component;
import models.products.Food.Food;
import models.products.IStoreHandler;
import models.products.ProductFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class VegePizzaBuilder implements IPizzaBuilder{
    private IStoreHandler store;
    private Pizza product;
    private List<Component> usedcomponent;
    public VegePizzaBuilder(IStoreHandler store, int id) {
        product= new Pizza(id,0);
        this.store=store;
        this.usedcomponent=new ArrayList<>();
    }

    public void buildDough() throws Exception {
        System.out.println("Chose your Vegetarian Pizza dought:");
        List<Component> comp=store.getVegeDoughts();
        if(comp.isEmpty())
        {
            returnUsedComponents();
            throw new Exception("Brak  Ciasta do Vege Pizzy");
        }
        List<String> compname=comp.stream().map(p->p.getName()).collect(Collectors.toList());
        System.out.println(compname.stream().collect(joining(", ", "[", "]")));
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        while(!compname.contains(s)){
            System.out.println("Try Again");
            s=scanner.nextLine();
        }
        try {
            for (Component e : comp) {
                if (e.getName().equals(s)) {
                    usedcomponent.add(e);
                    product.dought= s;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void buildChesee() throws Exception {
        System.out.println("Chose your Vegetarian Pizza chesee:");
        List<Component> comp=store.getVegeChesee();
        if(comp.isEmpty())
        {
            returnUsedComponents();
            throw new Exception("Brak  Sera do Vege Pizzy");
        }
        List<String> compname=comp.stream().map(p->p.getName()).collect(Collectors.toList());
        System.out.println(compname.stream().collect(joining(", ", "[", "]")));
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        while(!compname.contains(s)){
            System.out.println("Try Again");
            s=scanner.nextLine();

        }
        for(Component e : comp){
            if(e.getName().equals(s)){
                usedcomponent.add(e);
                product.chesee=s;
            }
        }
    }


    public void buildToppings() {//Posible only Vege Toppings
        List<Component> comp=store.getVegeToppings();
        List<String> compname=comp.stream().map(p->p.getName()).collect(Collectors.toList());
        if(comp.isEmpty())
        {
            System.out.println("Brak  Dodatkow do Vege Pizzy");
            return;
        }
        System.out.println("Chose your Vegetarian Pizza toppings:");
        System.out.println(compname.stream().collect(joining(", ", "[", "]")));
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        while(!compname.contains(s)){
            System.out.println("Try Again");
            s=scanner.nextLine();

        }
        for(Component e : comp){
            if(e.getName().equals(s) && e.getCategory()== Category.TOPLING){
                usedcomponent.add(e);
                product.toppings.add(s);
            }
        }
        do{
            comp=comp.stream().filter(p->!usedcomponent.contains(p)).collect(Collectors.toList());
            compname=comp.stream().map(p->p.getName()).collect(Collectors.toList());
            if(comp.isEmpty()){
                System.out.println("Brak dodatkowych dodatkow");
                break;
            }
            System.out.println("Whant another toplings? [Y/N]");
            s=scanner.nextLine();
            while(!s.equals("Y") && !s.equals("N")) {
                System.out.println("Try Again");
                s=scanner.nextLine();
            }
            if(s.equals("Y")) {
                System.out.println("Chose your Vegetarian Pizza toppings:");
                System.out.println(compname.stream().collect(joining(", ", "[", "]")));
                String g=scanner.nextLine();
                while(!compname.contains(g)){
                    System.out.println("Try Again");
                    g=scanner.nextLine();

                }
                for(Component e : comp) {
                    if (e.getName().equals(g) && e.getCategory()== Category.TOPLING) {
                        usedcomponent.add(e);
                        product.toppings.add(g);
                    }
                }

            }
        }while(!s.equals("N"));
    }

    @Override
    public void buildPrice() {
        double total=0;
        for(Component e : usedcomponent){
            total+=store.getComponentPrice(e);
        }
        product.setPrice(total);
    }

    public void returnUsedComponents(){
        for(Component e : usedcomponent){
            store.addComponent(e);
        }
    }

    public Pizza getPizza() {
        for (Component e : usedcomponent){
            store.removeComponent(e);
        }
        return product;
    }
}
