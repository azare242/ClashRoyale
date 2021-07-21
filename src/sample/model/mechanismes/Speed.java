package sample.model.mechanismes;

public enum Speed {
    SLOW(1),MEDIUM(2),FAST(3),RAGED_SLOW(1.4),RAGED_MEDIUM(2.8),RAGED_FAST(4.2);

    private double tilesPerSecond;
    Speed(double i) {
        tilesPerSecond = i;
    }
    public synchronized double getTilesPerSecond(){
        return tilesPerSecond;
    }
}
