package Day7;

import java.util.HashMap;
import java.util.Map;

public class Theatre {

    // map containing the seat number as its key and status(booked/not) as its value
    private Map<Integer, Boolean> seats;

    //when instructor gets called, creates specified number of seats with all of them being "empty"(true)
    public Theatre(int numOfSeats){
        seats = new HashMap<>();
        int i;
        for (i = 1; i <= numOfSeats; i++){
            seats.put(i , true);
        }
    }

    //checks if the seat is empty or not and then takes an action based on its status
    public synchronized void bookSeat(int num){
        if(seats.get(num)){
            seats.replace(num, false);
            System.out.println("Seat booked with number: " + num + " " + Thread.currentThread().getName());
        }else {
            System.out.println("Seat is already occupied!");
        }
    }

    //prints every seat along with its status
    public void printSeats(){
        int i;
        for(i = 1; i <= seats.size(); i++){
            if(seats.get(i)){
                System.out.println("Seat number: " + i + " Status: Not Booked");
            }else {
                System.out.println("Seat number: " + i + " Status: Booked");
            }
        }
    }
}
