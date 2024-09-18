/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

/**
 *
 * @author emort
 */
public class SingleRoom extends Room {

    public SingleRoom(String roomNumber, double price) {
        super(roomNumber, price);
    }

    @Override
    public String bookingConfirmation(int nights) {
        return "Single Room " + getRoomNumber() + " booked for " + nights + " nights. Total Price: $" + (getPrice() * nights);
    }
}
