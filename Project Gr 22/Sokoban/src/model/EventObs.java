package model;


/**
 * Observer interface for know  events.
  */

public interface EventObs {

	  /**
     * Called when the event changes.
       */
	
    void UpdateEvent(Model.Events event);
	
}
