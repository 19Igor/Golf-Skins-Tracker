package com.Epov.Igor.logic;

import com.Epov.Igor.models.Player;
import com.Epov.Igor.dto.PlayerDTO;
import com.Epov.Igor.models.ScoreCard;
import org.springframework.stereotype.Component;

@Component
public class ScoreCardHandler {
    ScoreCard scoreCard;
    HandicapCalculator handicapHandler;

    public ScoreCardHandler(ScoreCard scoreCard, HandicapCalculator handicapCalculator){
        this.scoreCard = scoreCard;
        this.handicapHandler = handicapCalculator;
    }

    public void addScoreToPlayer(String playerName, int score){
        Player p = scoreCard.getPlayerByName(playerName);
        p.addPar(score);
    }

    public void addPlayer(PlayerDTO playerDTO){
        Player p = new Player();
        p.setName(playerDTO.getName());
        p.setTrack(playerDTO.getTrack().toLowerCase());
        p.setSex(playerDTO.getSex().toLowerCase());
        p.addPar(playerDTO.getScores());
        p.setHCP(handicapHandler.computeHandicap(p));
        scoreCard.addPlayer(p);
    }

    public Player getPlayer(String name){
        return scoreCard.getPlayerByName(name);
    }
}
