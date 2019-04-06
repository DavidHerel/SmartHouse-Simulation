/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transport;

/**
 *
 * @author fuji
 */
public class Car extends Machines{
    
    public Car(int speed, int busyTime) {
        super(speed, busyTime);
    }

    @Override
    public String toString() {
        return "Car";
    }
    
}
