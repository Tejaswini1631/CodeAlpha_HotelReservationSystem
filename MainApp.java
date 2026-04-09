package com.app;

import java.util.ArrayList;
import java.util.Scanner;

class Room{
    int roomno;
    String roomtype;
    double roomprice;
    boolean isavailability;
    
    public Room(int room_no, String room_type, double room_price, boolean isavailability) {
        roomno = room_no;
        roomtype = room_type;
        roomprice = room_price;
        this.isavailability = isavailability;
    }
}

public class MainApp {

    public static void main(String[] args) {
        
        ArrayList<Room> al = new ArrayList<>();
        al.add(new Room(101,"Standard",1500,true));
        al.add(new Room(102,"Deluxe",2500,true));
        al.add(new Room(103,"Suite",3500,true));
        
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("------Menu------");
            System.out.println("1.View Rooms");
            System.out.println("2.Book Room");
            System.out.println("3.Cancel Booking");
            System.out.println("4.Exit");
            System.out.println("Choose options: ");
            
            int option = sc.nextInt();

            switch(option) {

                case 1:
                    System.out.println("View All the Rooms Available in Our Hotel:");
                    for(Room r:al) {
                        String status;
                        if(r.isavailability) {
                            status="Available";
                        }
                        else {
                            status="Booked";
                        }

                        System.out.println("Room_No: "+r.roomno+ 
                                " || Room_Type: "+r.roomtype +
                                " || Room_Price: "+r.roomprice+
                                " || Available: "+status);
                    }
                    break;

                case 2:
                    System.out.println("Book Rooms");
                    System.out.println("Enter the Room_No you want to Book");
                    int roomno = sc.nextInt();
                    boolean found = false;

                    for(Room r:al) {
                        if(r.roomno == roomno) {
                            found = true;

                            if(r.isavailability) {
                                r.isavailability = false;   
                                System.out.println("Room Booked Successfully!..");
                            }
                            else {
                                System.out.println("Room Already Booked!...");
                            }
                            break;
                        }
                    }

                    if(!found) {
                        System.out.println("Room not Found!");
                    }
                    break;

                case 3:
                    System.out.println("❌ Cancel Booking ❌");
                    System.out.println("Enter the Room_No you want to Cancel");
                    int roomno1 = sc.nextInt();
                    boolean foundCancel = false;

                    for(Room r:al) {
                        if(r.roomno == roomno1) {
                            foundCancel = true;

                            if(!r.isavailability) {  
                                r.isavailability = true;  
                                System.out.println("Booking Cancelled Successfully!..");
                            }
                            else {
                                System.out.println("Room is Already Available!...");
                            }
                            break;
                        }
                    }

                    if(!foundCancel) {
                        System.out.println("Room not Found!");
                    }
                    break;

                case 4:
                    System.out.println("Thank You 😊 Visit Again !.....");
                    return;  

                default:
                    System.out.println("Invalid choose correct one!");
            }
        }
    }
}
				

	


