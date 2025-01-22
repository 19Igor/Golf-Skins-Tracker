package com.Epov.Igor;

import com.Epov.Igor.constants.Const;
import com.Epov.Igor.models.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    void testFileImport(){
        Player player = new Player();
        player.setName("Bill");
        player.setTrack("Green");
        player.importParsFromFile(Const.BILL_SCORES);
        Assertions.assertEquals(18, player.getPars().size());
    }
}
