package sample.model.Animations;

import javafx.scene.image.Image;

public class Animations {

    public final Image WizardPlayerSideMove1= new Image(getClass().getResourceAsStream("/sample/model/Animations/wizardMoves/wizardPlayerSideMove1.png"));
    public final Image WizardPlayerSideMove2= new Image(getClass().getResourceAsStream("/sample/model/Animations/wizardMoves/wizardPlayerSideMove2.png"));
    public final Image WizardBotSideMove1= new Image(getClass().getResourceAsStream("/sample/model/Animations/wizardMoves/wizardBotSideMove1.png"));
    public final Image WizardBotSideMove2= new Image(getClass().getResourceAsStream("/sample/model/Animations/wizardMoves/wizardBotSideMove2.png"));

    public final Image ArcherPlayerSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/Animations/archerMoves/archerMovePlayerSide1.png"));
    public final Image ArcherPlayerSideMove2 = new Image(getClass().getResourceAsStream("/sample/model/Animations/archerMoves/archerMovePlayerSide2.png"));
    public final Image ArcherBotSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/Animations/archerMoves/archerMoveBotSide1.png"));
    public final Image ArcherBotSideMove2 = new Image(getClass().getResourceAsStream("/sample/model/Animations/archerMoves/archerMoveBotSide2.png"));

    public final Image BarbarianPlayerSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/Animations/barbarianMoves/barbarianMovePlayerSide1.png"));
    public final Image BarbarianPlayerSideMove2 = new Image(getClass().getResourceAsStream("/sample/model/Animations/barbarianMoves/barbarianMovePlayerSide2.png"));
    public final Image BarbarianBotSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/Animations/barbarianMoves/barbarianMoveBotSide1.png"));
    public final Image BarbarianBotSideMove2 = new Image(getClass().getResourceAsStream("/sample/model/Animations/barbarianMoves/barbarianMoveBotSide2.png"));

    public final Image BabyDragonPlayerSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/Animations/babyDragonMoves/babyDragonPlayerSideMove1.png"));
    public final Image BabyDragonPlayerSideMove2 = new Image(getClass().getResourceAsStream("/sample/model/Animations/babyDragonMoves/babyDragonPlayerSideMove2.png"));
    public final Image BabyDragonBotSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/Animations/babyDragonMoves/babyDragonBotSideMove1.png"));
    public final Image BabyDragonBotSideMove2 = new Image(getClass().getResourceAsStream("/sample/model/Animations/babyDragonMoves/babyDragonBotSideMove2.png"));

    public final Image GiantPlayerSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/Animations/giantMoves/giantMovePlayerSide1.png"));
    public final Image GiantPlayerSideMove2 = new Image(getClass().getResourceAsStream("/sample/model/Animations/giantMoves/giantMovePlayerSide2.png"));
    public final Image GiantBotSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/Animations/giantMoves/giantMoveBotSide1.png"));
    public final Image GiantBotSideMove2 = new Image(getClass().getResourceAsStream("/sample/model/Animations/giantMoves/giantMoveBotSide2.png"));

    public final Image MiniPEKKAPlayerSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/Animations/pekkaMoves/pekkaPlayerSideMove1.png"));
    public final Image MiniPEKKAPlayerSideMove2= new Image(getClass().getResourceAsStream("/sample/model/Animations/pekkaMoves/pekkaPlayerSideMove2.png"));
    public final Image MiniPEKKABotSideMove1 = new Image(getClass().getResourceAsStream("/sample/model/Animations/pekkaMoves/pekkaBotSideMove1.png"));
    public final Image MiniPEKKABotSideMove2 = new Image(getClass().getResourceAsStream("/sample/model/Animations/pekkaMoves/pekkaBotSideMove2.png"));

    public final Image ValkyriePlayerSideMove1= new Image(getClass().getResourceAsStream("/sample/model/Animations/valkyrieMoves/valkyriePlayerSideMove1.png"));
    public final Image ValkyriePlayerSideMove2= new Image(getClass().getResourceAsStream("/sample/model/Animations/valkyrieMoves/valkyriePlayerSideMove2.png"));
    public final Image ValkyrieBotSideMove1= new Image(getClass().getResourceAsStream("/sample/model/Animations/valkyrieMoves/valkyrieBotSideMove1.png"));
    public final Image ValkyrieBotSideMove2= new Image(getClass().getResourceAsStream("/sample/model/Animations/valkyrieMoves/valkyrieBotSideMove2.png"));



    private Animations(){

    }
    private static Animations instance = null;
    public static Animations getInstance(){
        if (instance == null) instance = new Animations();

        return instance;
    }

}
