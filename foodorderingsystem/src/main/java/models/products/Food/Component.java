package models.products.Food;

import java.util.Objects;

public class Component {
    private String name;
    private boolean for_vege;
    private Category category;
    Component(){

    }
    public Component(String name, boolean for_vege, Category category){
        this.name=name;
        this.for_vege=for_vege;
        this.category=category;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Component)) {
            return false;
        }
        Component c = (Component) o;
        return name.equals(c.name) && for_vege==c.for_vege && category.equals(c.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, for_vege, category);
    }



    public boolean isFor_vege() {
        return for_vege;
    }

    public void setFor_vege(boolean for_vege) {
        this.for_vege = for_vege;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
