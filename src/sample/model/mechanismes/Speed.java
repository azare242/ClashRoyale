package sample.model.mechanismes;

public enum Speed {
    SLOW(1),MEDIUM(2),FAST(3);

    private int tilesPerSecond;
    Speed(int i) {
        tilesPerSecond = i;
    }
    public int getTilesPerSecond(){
        return tilesPerSecond;
    }
}
