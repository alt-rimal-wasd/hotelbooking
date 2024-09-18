/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;

/**
 *
 * @author emort
 */
public class fileManager {

    public static HashMap<String, Customer> readCustomerInfo() {
        HashMap<String, Customer> customerMap = new HashMap();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./resources/customer_info.txt"));
            String line = null;
            while ((line = br.readLine()) != null) {
                //got help from chat gpt to handle in case the file to read from is empty.
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] str = line.split(",");
                String name = str[0];
                String phoneNumber = str[1];
                String email = str[2];
                customerMap.put(phoneNumber, new Customer(name, phoneNumber, email));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(fileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(fileManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(fileManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return customerMap;
    }

    public static void writeCustomerInfo(HashMap<String, Customer> customerMap) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("customer_info.txt");
            for (Customer customer : customerMap.values()) {
                pw.println(customer.getName() + "," + customer.getPhoneNumber() + "," + customer.getEmail());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(fileManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    public static HashMap<String, Room> readRoomsFromFile() {
        HashMap<String, Room> roomsMap = new HashMap();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./resources/room_info.txt"));
            String line = null;
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                String roomNumber = data[0];
                double price = Double.parseDouble(data[1]);
                boolean available = Boolean.parseBoolean(data[2]);
                String type = data[3];

                Room room = null;
                switch (type) {
                    case "Single":
                        room = new SingleRoom(roomNumber, price);
                        break;
                    case "Double":
                        room = new DoubleRoom(roomNumber, price);
                        break;
                    case "Suite":
                        room = new Suite(roomNumber, price);
                        break;
                    default:
                        Logger.getLogger(fileManager.class.getName()).log(Level.SEVERE, "Unknown room type: " + type);
                        continue;
                }

                if (room != null) {
                    room.setAvailable(available);
                    roomsMap.put(roomNumber, room);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(fileManager.class.getName()).log(Level.SEVERE, "Room info file not found", ex);
        } catch (IOException ex) {
            Logger.getLogger(fileManager.class.getName()).log(Level.SEVERE, "Error reading room info file", ex);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(fileManager.class.getName()).log(Level.SEVERE, "Error closing BufferedReader", ex);
                }
            }
        }
        return roomsMap;
    }
}
