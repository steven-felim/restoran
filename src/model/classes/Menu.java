package model.classes;

abstract class Menu {
    private String menuID;
    private String menuName;
    private int menuPrice;

    public Menu(String menuID, String menuName, int menuPrice) {
        this.menuID = menuID;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }

    public String getMenuID() {
        return menuID;
    }

    public void setMenuID(String menuID) {
        this.menuID = menuID;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }
}
