package com.Epov.Igor.models;

import com.Epov.Igor.constants.Const;
import com.Epov.Igor.logic.HandicapCalculator;
import com.Epov.Igor.logic.ScoresScanner;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@Component
public class Player implements ScoresScanner {
    private static final Logger log = LogManager.getLogger(Player.class);
    private String name;
    private String track;
    private String sex;
    private int OUT;
    private int TOT;
    private int HCP;
    private int NET;
    private final List<Integer> currentPars;
    HandicapCalculator calculator;

    @Override
    public void importParsFromFile(String fileName){
        try(Scanner scanner = new Scanner(new File(fileName))){
            String[] s = new String[Const.HOLE_NUMBER];

            while(scanner.hasNext()){
                s = scanner.nextLine().split(" ");
            }
            s = deleteEmptyStrings(s);
            for (String l: s){
                currentPars.add(Integer.parseInt(l));
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found.");
            log.info("File was not found.", e);
        }
        catch (NumberFormatException e){
            System.out.println("Неправильный формат данных.");
            log.info("Неправильный формат данных.");
        }
        computeOUT();
        computeTOT();
    }

    public Player() {
        this.currentPars = new ArrayList<>();
    }

    public void addPar(int i){
        currentPars.add(i);
    }

    public void addPar(int[] pars){
        for (int p: pars){
            currentPars.add(p);
        }
        computeOUT();
        computeTOT();
    }

    public void calculateNET(){
        if (this.HCP == 0){
            System.out.println(this.name +  "'s HCP is not calculated yet.");
            return;
        }
        this.NET = this.TOT - this.HCP;
    }

    public List<Integer> getPars(){
        return currentPars;
    }

    private String[] deleteEmptyStrings(String[] s) {
        return Arrays.stream(s).filter(str -> !str.isEmpty()).toArray(String[]::new);
    }

    private void computeOUT() {
        OUT = currentPars.stream().limit(Const.HOLE_NUMBER / 2).mapToInt(Integer::intValue).sum();
    }

    private void computeTOT(){
        TOT = currentPars.stream().mapToInt(Integer::intValue).sum();
    }
}
