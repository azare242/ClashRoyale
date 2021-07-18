package sample.Controllers.view;

import javafx.scene.image.Image;
import sample.model.cards.Card;

public class ImagesByCard {

    private final Image archer;
    private final Image barbarians;
    private final Image arrows;
    private final Image babyDragon;
    private final Image cannon;
    private final Image fireBall;
    private final Image giant;
    private final Image infernoTower;
    private final Image miniPEKKA;
    private final Image rage;
    private final Image valkyrie;
    private final Image wizard;

    private static ImagesByCard instance = null;

    private ImagesByCard() {
        archer = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/ArchersCard.png"));
        barbarians = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/BarbariansCard.png"));
        arrows = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/ArrowsCard.png"));
        babyDragon = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/BabyDragonCard.png"));
        cannon = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/CannonCard.png"));
        fireBall = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/FireballCard.png"));
        giant = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/GiantCard.png"));
        infernoTower = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/InfernoTowerCard.png"));
        miniPEKKA = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/MiniPEKKACard.png"));
        rage = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/RageCard.png"));
        valkyrie = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/ValkyrieCard.png"));
        wizard = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/WizardCard.png"));
    }

    public static ImagesByCard getInstance() {
        if (instance == null) instance = new ImagesByCard();

        return instance;
    }

    public Image getImage(Card card) {
        String className = card.getClass().getSimpleName();
        Image image = null;
        switch (className) {
            case "Archers":
                image = archer;
                break;
            case "Arrows":
                image = arrows;
                break;
            case "BabyDragon":
                image = babyDragon;
                break;
            case "Barbarians":
                image = barbarians;
                break;
            case "Cannon":
                image = cannon;
                break;
            case "FireBall":
                image = fireBall;
                break;
            case "Giant":
                image = giant;
                break;
            case "InfernoTower":
                image = infernoTower;
                break;
            case "MiniPEKKA":
                image = miniPEKKA;
                break;
            case "Rage":
                image = rage;
                break;
            case "Valkyrie":
                image = valkyrie;
                break;
            case "Wizard":
                image = wizard;
                break;
        }
        return image;
    }
}
