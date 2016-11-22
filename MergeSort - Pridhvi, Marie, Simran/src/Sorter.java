import java.util.LinkedList;

/**
 * Interface to be implemented by each of the Sorters
 */
public interface Sorter
{
  
    /**
     * method that returns an array of integers with two elements in the format {x, y}
     * this method will be called periodically by the Driver class to get the exact location of the Sorter for the first part of the game
     * Location should change each time its called
     */
    public int[] location();
    
    /**
     * will be called by the Driver when the Sorter "hits" the head in the first part of the game
     * provides the sorter with the head of the linked list that they are to sort
     * the method should then sort the LinkedList in ascending order and return the sorted Integers as a LinkedList upon completion
     */
    public LinkedList sort(LinkedList aList);
    
    /**
     * method that provides the Sorter with the length and width of the coordinate plot through the variable side as it is a square
     * all of the values returned by the location() method will be within the coordinates of side by side
     * 0 <= x < side
     * 0 <= y < side
     * this method will be called prior to any location call
     */
    public void setBoundaries(int side);
}
