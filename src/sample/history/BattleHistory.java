package sample.history;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BattleHistory implements Serializable {

    private List<Battle> battleList;

    public BattleHistory(){
        battleList = new ArrayList<>();
    }

    public void addBattle(Battle battle){
        battleList.add(battle);
    }

    public String get(){
        String res = "";
        for (Battle battle : battleList){
            res += battle.getDetails();
        }
        return res;
    }
}
