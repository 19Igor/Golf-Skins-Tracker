package com.Epov.Igor.controller;

import com.Epov.Igor.logic.ScoreCardHandler;
import com.Epov.Igor.models.Player;
import com.Epov.Igor.dto.PlayerDTO;
import com.Epov.Igor.dto.RequestMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("controller")
public class HttpController {
    private final ScoreCardHandler scoreHandler;

    public HttpController(ScoreCardHandler scoreHandler) {
        this.scoreHandler = scoreHandler;
    }

    @PostMapping("/addPlayer")
    public RequestMessage addPlayer(@RequestBody PlayerDTO playerDTO){
        scoreHandler.addPlayer(playerDTO);
        return new RequestMessage(200, "Игрок сохранён.");
    }

    @GetMapping("/getPlayerByName")
    public Player getPlayerByName(@RequestParam String playerName){
        return scoreHandler.getPlayer(playerName);
    }
}
