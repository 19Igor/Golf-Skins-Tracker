package com.Epov.Igor.logic;

import com.Epov.Igor.constants.Const;
import com.Epov.Igor.models.Player;
import com.Epov.Igor.constants.SlopeAndRating;
import com.Epov.Igor.constants.SlopeRating;
import org.springframework.stereotype.Service;

import java.util.Locale;


@Service
public class HandicapHandler implements HandicapCalculator{
    SlopeAndRating slopeAndRating = new SlopeAndRating();

    @Override
    public int computeHandicap(Player p) {
        if (p.getSex().toLowerCase(Locale.ROOT).equals(Const.MAN)){
            return applyFormula(p.getTOT(), slopeAndRating.getMens().get(p.getTrack().toLowerCase()));
        }
        else{
            return applyFormula(p.getTOT(), slopeAndRating.getWomen().get(p.getTrack()));
        }
    }

    private int applyFormula(int grossScore, SlopeRating slopeAndRating){
        float res = (((grossScore - slopeAndRating.rating()) * Const.COEFFICIENT1) / slopeAndRating.slope()) * Const.COEFFICIENT2;
        return Math.round(res);
    }
}
