package by.koldunova.entity;

public class Room {

    private int numRoom;
    private String name;
    private String country;
    private boolean lampOn;
    
    public Room(int numRoom, String name, String country, boolean lampOn) {
        super();
        this.numRoom = numRoom;
        this.name = name;
        this.country = country;
        this.lampOn = lampOn;
    }

    public int getNumRoom() {
        return numRoom;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public boolean isLampOn() {
        return lampOn;
    }

    @Override
    public String toString() {
        return "Room [numRoom=" + numRoom + ", name=" + name + ", country=" + country + ", lampOn=" + lampOn + "]";
    }


}
