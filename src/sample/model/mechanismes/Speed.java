package sample.model.mechanismes;

public enum Speed {
    SLOW(5),MEDIUM(10),FAST(15);

    private int tilesPerSecond;
    Speed(int i) {
        tilesPerSecond = i;
    }
    public int getTilesPerSecond(){
        return tilesPerSecond;
    }
}
