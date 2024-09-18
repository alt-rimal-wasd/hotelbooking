/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

import java.util.List;
import java.util.Random;

/**
 *
 * @author emort
 */
public class Booking {

    private Room room;
    private Customer customer;
    private int nights;

    public Booking(Room room, Customer customer, int nights) {
        this.room = room;
        this.customer = customer;
        this.nights = nights;
    }

    public String confirmBooking() {
        room.setAvailable(false);
        return room.bookingConfirmation(nights);
    }
// got help from chat gpt to assign ramdom room numbers from available rooms

    public static Room assignRoom(List<Room> rooms) {
        Random rand = new Random();
        Room selectedRoom;
        do {
            selectedRoom = rooms.get(rand.nextInt(rooms.size()));
        } while (!selectedRoom.isAvailable());
        return selectedRoom;
    }
}
