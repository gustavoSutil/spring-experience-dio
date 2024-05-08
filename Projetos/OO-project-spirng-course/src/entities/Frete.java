package entities;

import java.math.BigInteger;
import java.util.LinkedList;

public abstract class Frete {

    private Float distanceKm;
    private String initial;
    private String end;
    private BigInteger NF;
    private Float freteValue;
    private LinkedList<Volum> volums;
    
    public abstract void calculateFrete() throws Exception;

    public Float getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(Float distanceKm) {
        this.distanceKm = distanceKm;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public BigInteger getNF() {
        return NF;
    }

    public void setNF(BigInteger NF) {
        this.NF = NF;
    }

    public Float getFreteValue() {
        return freteValue;
    }

    public void setFreteValue(Float freteValue) {
        this.freteValue = freteValue;
    }

    public LinkedList<Volum> getVolums() {
        return volums;
    }

    public void setVolums(LinkedList<Volum> volum) {
        this.volums = volum;
    }
}
