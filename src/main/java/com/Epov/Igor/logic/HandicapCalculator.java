package com.Epov.Igor.logic;

import com.Epov.Igor.models.Player;
import org.springframework.stereotype.Service;

@Service
public interface HandicapCalculator {
    int computeHandicap(Player player);
}
