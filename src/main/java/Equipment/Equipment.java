/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Equipment;

/**
 *
 * @author fuji
 */
public class Equipment {
    EquipmentType type;
    int busyTime;

    public Equipment(EquipmentType type, int busyTime) {
        this.type = type;
        this.busyTime = busyTime;
    }

    public int getBusyTime() {
        return busyTime;
    }

    public void setType(EquipmentType type) {
        this.type = type;
    }

    public void setBusyTime(int busyTime) {
        this.busyTime = busyTime;
    }

    public EquipmentType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Equipment"  +type + " ";
    }
    
    
    
}
