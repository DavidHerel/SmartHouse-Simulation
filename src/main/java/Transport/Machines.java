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
public abstract class Machines {
    private int speed;
    private int busyTime;

    public Machines(int speed, int busyTime) {
        this.speed = speed;
        this.busyTime = busyTime;
    }
    

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getBusyTime() {
        return busyTime;
    }

    public void setBusyTime(int busyTime) {
        this.busyTime = busyTime;
    }
}
