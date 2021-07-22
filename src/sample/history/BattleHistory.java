package sample.history;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Battle history.
 */
public class BattleHistory implements Serializable {

    private List<Battle> battleList;

    /**
     * Instantiates a new Battle history.
     */
    public BattleHistory(){
        battleList = new ArrayList<>();
    }

    /**
     * Add battle.
     *
     * @param battle the battle
     */
    public void addBattle(Battle battle){
        battleList.add(battle);
    }

    /**
     * Get string.
     *
     * @return the string
     */
    public String get(){
        String res = "";
        for (Battle battle : battleList){
            res += battle.getDetails();
        }
        return res;
    }
}
