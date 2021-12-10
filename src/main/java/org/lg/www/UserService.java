package org.lg.www;

public class UserService {
    private Frulit fruit;

    public void setFruit(Frulit fruit) {
        this.fruit = fruit;
    }
    public void getFruit() {
        this.fruit.get();
    }
}
