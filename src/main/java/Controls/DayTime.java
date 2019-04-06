/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

/**
 *
 * @author Lister
 */
public class DayTime implements Comparable{
    
    private final int hours;
    private final int minutes;

    public DayTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String toString() {
        String stringo = String.format("%02d:%02d", this.hours , this.minutes);
        return stringo;
    }
    
    public static DayTime toDayTime(int time){
        return new DayTime((time%1440)/60,time%60);
    }
    
    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        
        DayTime t = (DayTime) o;
        
        if(this.hours == t.hours){
            if(this.minutes == t.minutes){
                return 0;
            } else{
                return this.minutes > t.minutes ? 1 : -1;
            }
        } else{
            return this.hours > t.hours ? 1 : -1;
        }
    }
    
}
