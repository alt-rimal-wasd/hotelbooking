/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

/**
 *
 * @author emort
 */
public class DoubleRoom extends Room {

    public DoubleRoom(String roomNumber, double price) {
        super(roomNumber, price);
    }

    @Override
    public String bookingConfirmation(int nights) {
        return "Double Room " + getRoomNumber() + " booked for " + nights + " nights. Total Price: $" + (getPrice() * nights);
    }
}
