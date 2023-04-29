package groomingSalon_07;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    //Add
    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }

    //Remove
    public boolean remove(String name) {
        //true -> ако има такова животно с даденото име
        //false-> ако няма такова животвно с даденото име
        for (Pet pet : this.data) {
            if (pet.getName().equals(name)) {
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }

    //getPet
    public Pet getPet(String name, String owner) {
        //ако има животно с дадените параметри -> връшаме го
        //няма животно  с дадените параметри -> връшаме null
        for (Pet pet : this.data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    //getCount
    public int getCount() {
        return this.data.size();
    }

    //getStatistics
    public String getStatistics() {
        String output = "";
        output += "The grooming salon has the following clients:\n";
        for (Pet pet : this.data) {
            output += pet.getName() + " " + pet.getOwner() + "\n";
        }
        return output;
    }


}
