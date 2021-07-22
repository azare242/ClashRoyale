package sample.model.mechanismes;

/**
 * The enum Speed.
 */
public enum Speed {
    /**
     * Slow speed.
     */
    SLOW(1),
    /**
     * Medium speed.
     */
    MEDIUM(2),
    /**
     * Fast speed.
     */
    FAST(3),
    /**
     * Raged slow speed.
     */
    RAGED_SLOW(1.4),
    /**
     * Raged medium speed.
     */
    RAGED_MEDIUM(2.8),
    /**
     * Raged fast speed.
     */
    RAGED_FAST(4.2);

    private double tilesPerSecond;
    Speed(double i) {
        tilesPerSecond = i;
    }

    /**
     * Get tiles per second double.
     *
     * @return the double
     */
    public synchronized double getTilesPerSecond(){
        return tilesPerSecond;
    }
}
