package kz.bitlab.techordaC3.springproject.models;


import java.util.ArrayList;
public class DBManager {
    private static ArrayList<Item> items = new ArrayList<>();
    private static long id = 5L;

    static {
        items.add(new Item(1L, "iphone 15 pro", "iphone 15 pro", 420000));
        items.add(new Item(2L, "iphone 12 pro", "iphone 12 pro", 230000));
        items.add(new Item(3L, "iphone 13 pro", "iphone 13 pro", 310000));
        items.add(new Item(4L, "iphone 14 pro", "iphone 14 pro", 350000));
    }

    public static void addItem(Item item){
        items.add(item);
        item.setId(id);
        id++;
    }

    public static ArrayList<Item> getItems(){
        return items;
    }

    public static Item getItem(Long idshka){
       return items.stream().filter(it -> it.getId()==idshka).findFirst().orElseThrow();
    }
}
