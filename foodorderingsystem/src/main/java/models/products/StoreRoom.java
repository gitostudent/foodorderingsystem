package models.products;

import models.products.Food.Category;
import models.products.Food.Component;

import java.util.*;
import java.util.stream.Collectors;

public class StoreRoom implements IStoreHandler{
    public StoreRoom(PriceComponent price){
        this.items=new HashMap<Component, Integer>();
        this.price=price;

    }
    private Map<Component,Integer> items;
    private PriceComponent price;


    @Override
    public List<Component> getDoughts() {
        return items.keySet().stream().filter(p->items.get(p).compareTo(0)!=0 && p.getCategory()== Category.DOUGHT).collect(Collectors.toList());
    }

    @Override
    public List<Component> getChesee() {
        return items.keySet().stream().filter(p->items.get(p).compareTo(0)!=0 && p.getCategory()== Category.CHESEE).collect(Collectors.toList());

    }

    @Override
    public List<Component> getToppings() {
        return items.keySet().stream().filter(p->items.get(p).compareTo(0)!=0 && p.getCategory()== Category.TOPLING).collect(Collectors.toList());

    }

    @Override
    public List<Component> getVegeDoughts() {
        return items.keySet().stream().filter(p->items.get(p).compareTo(0)!=0 && p.getCategory()== Category.DOUGHT && p.isFor_vege()).collect(Collectors.toList());

    }

    @Override
    public List<Component> getVegeChesee() {
        return items.keySet().stream().filter(p->items.get(p).compareTo(0)!=0 && p.getCategory()== Category.CHESEE && p.isFor_vege()).collect(Collectors.toList());

    }

    @Override
    public List<Component> getVegeToppings() {
        return items.keySet().stream().filter(p->items.get(p).compareTo(0)!=0 && p.getCategory()== Category.TOPLING && p.isFor_vege()).collect(Collectors.toList());

    }

    @Override
    public void addComponent(Component e) {
        try {
            price.getPrice(e);
            items.putIfAbsent(e,0);
            items.replace(e,items.get(e)+1);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void removeComponent(Component e) {
        if(items.containsKey(e)){
            items.replace(e,items.get(e)-1);
            if(items.get(e).compareTo(0)==0){
                items.remove(e);
            }
        }
        else
        {
            System.out.println("Nie ma takiego towaru");
        }
    }

    @Override
    public double getComponentPrice(Component e) {
        try {
            return price.getPrice(e);
        } catch (Exception e1) {
            System.out.println("Brak Ustanowionej Ceny Dodatek Darmowy");
            return 0;
        }
    }

}
