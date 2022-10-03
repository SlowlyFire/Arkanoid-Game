package arkanoid.hit_listener;
/**
 * @author Gal Giladi
 */
public interface HitNotifier {

    /**
     * addHitListener function: the function adds as a listener to hit events.
     * @param hl  : a HitListener-type variable that represents the listener we notify about the hit.
     */
    void addHitListener(HitListener hl);

    /**
     * removeHitListener function: the function removes hl from the list of listeners to hit events.
     * @param hl  : a HitListener-type variable that represents the listener we notify about the hit.
     */
    void removeHitListener(HitListener hl);
}
