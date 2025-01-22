package com.Epov.Igor;

import com.Epov.Igor.models.Player;
import com.Epov.Igor.models.ScoreCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ScoreCardTest {
    @Test
    void testScoreCardTestAddAndGetMethod(){
        ScoreCard card = new ScoreCard();
        Player p = new Player();
        p.setName("Bill");
        p.setTrack("Green");
        p.setSex("Man");
        int[] a = {5, 2, 4, 4, 5, 5, 4, 6, 5, 4, 3, 5, 4, 5, 4, 3, 4, 5};
        p.addPar(a);
        card.addPlayer(p);
        Assertions.assertNotEquals(null, card.getPlayerByName("Bill"));
    }

}
