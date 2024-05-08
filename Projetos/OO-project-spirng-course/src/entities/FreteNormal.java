package entities;

import java.math.BigInteger;
import java.util.LinkedList;

import buiness_rules.CalculoFreteNormal;
import converters.Volum.Array2LinkedListConverter;
import exceptions.NoVolumError;

public class FreteNormal extends Frete{
    
    @Override
    public void calculateFrete() throws Exception {
        float value = new CalculoFreteNormal().calculate(this);
        setFreteValue(value);
    }

    public FreteNormal(
        float distanceKm,
        BigInteger NF,
        String initial,
        String end,
        float[] volumsArray) throws Exception {
          
        LinkedList<Volum> volums = new Array2LinkedListConverter().Array2LinkedList(volumsArray);

        if (volums.size() == 0)
            new NoVolumError();

        setVolums(volums);
        setDistanceKm(distanceKm);
        setNF(NF);
        setInitial(initial);
        setEnd(end);

        calculateFrete();
  }
}
