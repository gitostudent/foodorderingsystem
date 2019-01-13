package models.products.Food.Pizza;

import models.products.Food.Category;
import models.products.Food.Component;
import models.products.IStoreHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class NormalPizzaBuilder implements IPizzaBuilder{
    private IStoreHandler store;
    private Pizza product;
    private List<Component> usedcomponent;
    public NormalPizzaBuilder(IStoreHandler store, int id) {
        this.store=store;
        product= new Pizza(id,0);
        this.usedcomponent=new ArrayList<>();
    }

    public void buildDough() throws Exception {
        System.out.println("Chose your Pizza dought:");
        List<Component> comp=store.getDoughts();
        if(comp.isEmpty())
        {
            returnUsedComponents();
            throw new Exception("Brak  Ciasta do Pizzy");
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
            if(e.getName().equals(s) && e.getCategory()== Category.DOUGHT){
                usedcomponent.add(e);
                product.dought=s;
                break;
            }
        }
    }

    public void buildChesee() throws Exception {
        System.out.println("Chose your Pizza chesee:");
        List<Component> comp=store.getChesee();
        if(comp.isEmpty())
        {
            returnUsedComponents();
            throw new Exception("Brak  Sera do Pizzy");
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
            if(e.getName().equals(s) && e.getCategory()== Category.CHESEE){
                usedcomponent.add(e);
                product.chesee=s;
                break;
            }
        }
    }


    public void buildToppings() {
        List<Component> comp=store.getToppings();
        List<String> compname=comp.stream().map(p->p.getName()).collect(Collectors.toList());
        if(comp.isEmpty())
        {
            System.out.println("Brak  Dodatkow do Pizzy");
            return;
        }
        System.out.println("Chose your Pizza toppings:");
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
                break;
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
                System.out.println("Chose your Pizza toppings:");
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
