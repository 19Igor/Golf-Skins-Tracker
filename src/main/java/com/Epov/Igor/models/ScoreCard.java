package com.Epov.Igor.models;

import com.Epov.Igor.constants.Const;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScoreCard {
    private final List<Player> players;

    public ScoreCard() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player p){
        if (p.getPars().size() == Const.HOLE_NUMBER){
            p.calculateNET();
        }
        players.add(p);
    }

    public Player getPlayerByName(String name){
        return players.stream().filter(player -> player.getName().equals(name)).findFirst().orElse(null);
    }
}
