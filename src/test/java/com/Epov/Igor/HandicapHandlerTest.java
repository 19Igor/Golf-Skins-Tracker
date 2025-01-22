package com.Epov.Igor;

import com.Epov.Igor.logic.HandicapHandler;
import com.Epov.Igor.models.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HandicapHandlerTest {
    @Test
    void computeHandicapTest(){
        HandicapHandler handler = new HandicapHandler();

        Player p = new Player();
        p.setName("Bill");
        p.setTrack("Green");
        p.setSex("Man");
        int[] a = {5, 2, 4, 4, 5, 5, 4, 6, 5, 4, 3, 5, 4, 5, 4, 3, 4, 5};
        p.addPar(a);
        Assertions.assertEquals(3, handler.computeHandicap(p));
    }
}
