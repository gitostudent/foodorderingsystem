package models.products.Food.Pizza;

import static java.util.stream.Collectors.joining;

public class SasuedPizza extends Pizza {

    private Pizza decorPizza;
    public SasuedPizza(int id, double price) {
        super(id, price);
    }
    public SasuedPizza(Pizza pizza) {
        super(pizza);
        this.decorPizza=pizza;
    }
    @Override
    public String toString() {
        String toplingslist=toppings.stream().collect(joining(", ", "with ", ""));
        if(toplingslist.equals("with")){
            toplingslist="without";
        }
        return (new StringBuilder())
                .append("Sasued Pizza with ")
                .append(dought)
                .append(" dought, ")
                .append(chesee)
                .append(" chesee and ").append(toplingslist).append(" toplings").toString();
    }

}
