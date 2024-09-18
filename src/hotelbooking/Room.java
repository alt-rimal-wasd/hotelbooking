/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

/**
 *
 * @author emort
 */
public abstract class Room {

    private String roomNumber;
    private double price;
    private boolean available;

    public Room(String roomNumber, double price) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.available = true;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String bookingConfirmation(int nights) {

        return null;

    }
}
