package sample.model.animations;

import javafx.scene.image.Image;

public class Animations {

    public final Image WizardPlayerSideMove1= new Image(getClass().getResourceAsStream("/sample/model/animations/wizardMoves/wizardPlayerSideMove1.png"));
    public final Image WizardPlayerSideMove2= new Image(getClass().getResourceAsStream("/sample/model/animations/wizardMoves/wizardPlayerSideMove2.png"));
    public final Image WizardBotSideMove1= new Image(getClass().getResourceAsStream("/sample/model/animations/wizardMoves/wizardBotSideMove1.png"));
    public final Image WizardBotSideMove2= new Image(getClass().getResourceAsStream("/sample/model/animations/wizardMoves/wizardBotSideMove2.png"));

    public final Image ArcherPlayerSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/animations/archerMoves/archerMovePlayerSide1.png"));
    public final Image ArcherPlayerSideMove2 = new Image(getClass().getResourceAsStream("/sample/model/animations/archerMoves/archerMovePlayerSide2.png"));
    public final Image ArcherBotSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/animations/archerMoves/archerMoveBotSide1.png"));
    public final Image ArcherBotSideMove2 = new Image(getClass().getResourceAsStream("/sample/model/animations/archerMoves/archerMoveBotSide2.png"));

    public final Image BarbarianPlayerSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/animations/barbarianMoves/barbarianMovePlayerSide1.png"));
    public final Image BarbarianPlayerSideMove2 = new Image(getClass().getResourceAsStream("/sample/model/animations/barbarianMoves/barbarianMovePlayerSide2.png"));
    public final Image BarbarianBotSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/animations/barbarianMoves/barbarianMoveBotSide1.png"));
    public final Image BarbarianBotSideMove2 = new Image(getClass().getResourceAsStream("/sample/model/animations/barbarianMoves/barbarianMoveBotSide2.png"));

    public final Image BabyDragonPlayerSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/animations/babyDragonMoves/babyDragonPlayerSideMove1.png"));
    public final Image BabyDragonPlayerSideMove2 = new Image(getClass().getResourceAsStream("/sample/model/animations/babyDragonMoves/babyDragonPlayerSideMove2.png"));
    public final Image BabyDragonBotSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/animations/babyDragonMoves/babyDragonBotSideMove1.png"));
    public final Image BabyDragonBotSideMove2 = new Image(getClass().getResourceAsStream("/sample/model/animations/babyDragonMoves/babyDragonBotSideMove2.png"));

    public final Image GiantPlayerSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/animations/giantMoves/giantMovePlayerSide1.png"));
    public final Image GiantPlayerSideMove2 = new Image(getClass().getResourceAsStream("/sample/model/animations/giantMoves/giantMovePlayerSide2.png"));
    public final Image GiantBotSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/animations/giantMoves/giantMoveBotSide1.png"));
    public final Image GiantBotSideMove2 = new Image(getClass().getResourceAsStream("/sample/model/animations/giantMoves/giantMoveBotSide2.png"));

    public final Image MiniPEKKAPlayerSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/animations/pekkaMoves/pekkaPlayerSideMove1.png"));
    public final Image MiniPEKKAPlayerSideMove2= new Image(getClass().getResourceAsStream("/sample/model/animations/pekkaMoves/pekkaPlayerSideMove2.png"));
    public final Image MiniPEKKABotSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/animations/pekkaMoves/pekkaBotSideMove1.png"));
    public final Image MiniPEKKABotSideMove2 = new Image(getClass().getResourceAsStream("/sample/model/animations/pekkaMoves/pekkaBotSideMove2.png"));

    public final Image ValkyriePlayerSideMove1= new Image(getClass().getResourceAsStream("/sample/model/animations/valkyrieMoves/valkyriePlayerSideMove1.png"));
    public final Image ValkyriePlayerSideMove2= new Image(getClass().getResourceAsStream("/sample/model/animations/valkyrieMoves/valkyriePlayerSideMove2.png"));
    public final Image ValkyrieBotSideMove1= new Image(getClass().getResourceAsStream("/sample/model/animations/valkyrieMoves/valkyrieBotSideMove1.png"));
    public final Image ValkyrieBotSideMove2= new Image(getClass().getResourceAsStream("/sample/model/animations/valkyrieMoves/valkyrieBotSideMove2.png"));



    private Animations(){

    }
    private static Animations instance = null;
    public static Animations getInstance(){
        if (instance == null) instance = new Animations();

        return instance;
    }

}
