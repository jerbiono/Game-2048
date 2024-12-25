package Controller;

import ViewJavaFx.Observer;

/**
 * An interface which Represents the object to be observed.
 *
 * @author nader - 54685
 */
public interface Observable {

    /**
     * Adds an observer to the list of observers for this object, provided that
     * it is not the same as some observer already in the list.
     *
     * @param observer the given observer.
     */
    public void registerObserver(Observer observer);

//    /**
//     * Allows to delette an observer from the list of observers.
//     *
//     * @param observer the given observer
//     */
//    public void removeObserver(Observer observer);
    /**
     * ALlows to notify all the observers.
     */
    public void notifyObservers();

}
