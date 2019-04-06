/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RandomEvents;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author fuji
 */
public enum RandomEventType {
    WIND, //close blinds and windows
    SNOW, //will encrease the temperature
    STORM, //close windows
    SUN; //open windows and blinds
    
private static final List<RandomEventType> VALUES =
    Collections.unmodifiableList(Arrays.asList(values()));
  private static final int SIZE = VALUES.size();
  private static final Random RANDOM = new Random();

  public static RandomEventType randomEvent()  {
    return VALUES.get(RANDOM.nextInt(SIZE));
  }
    
}
