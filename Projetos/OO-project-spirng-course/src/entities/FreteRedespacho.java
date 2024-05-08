package entities;

import java.math.BigInteger;
import java.util.LinkedList;

import buiness_rules.CalculoFreteNormal;
import converters.Volum.Array2LinkedListConverter;
import exceptions.NoVolumError;

public class FreteRedespacho extends Frete {

    private int lastCte;

    @Override
    public void calculateFrete() throws Exception {
        float value = new CalculoFreteNormal().calculate(this);
        setFreteValue(value);
    }

    public FreteRedespacho(
          int lastCte,
          float distanceKm,
          BigInteger NF,
          String initial,
          String end,
          float[] volumsArray
        ) throws Exception {
            
        LinkedList<Volum> volums = new Array2LinkedListConverter().Array2LinkedList(volumsArray);

        if (volums.size() == 0)
            new NoVolumError();

        setVolums(volums);
        setLastCte(lastCte);
        setDistanceKm(distanceKm);
        setNF(NF);
        setInitial(initial);
        setEnd(end);

        calculateFrete();
    }

    public int getLastCte() {
        return lastCte;
    }

    public void setLastCte(int lastCte) {
        this.lastCte = lastCte;
    }
}
