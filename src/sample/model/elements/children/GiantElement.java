package sample.model.elements.children;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.model.cards.Troop;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class GiantElement extends TroopElement {
    public GiantElement(Side side) {
        super(1.5,Speed.SLOW,Target.BUILDINGS,0,false,2000,126,side);
    }

    @Override
    public void levelUp() {

    }

}
