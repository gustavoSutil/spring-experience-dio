package buiness_rules;

import java.util.LinkedList;

import entities.Frete;
import entities.Volum;
import exceptions.NoVolumError;

public class CalculoFreteNormal implements CalculoFreteInterface{

    private static float m3value = 2.3f;

    private static float pricePerDitance = 10;

    public float calculate(Frete frete) throws Exception{
        try{
            float total = 0f;
            LinkedList<Volum> list = frete.getVolums();
            int quantity = list.size();

            if (quantity == 0){
                new NoVolumError();
            }

            for (int i=0; i < quantity; i++){
                total += m3value * list.get(i).getM3();
            }

            return total * (pricePerDitance * frete.getDistanceKm());

        }catch(NoVolumError e){
            System.out.println(e.toString());
            return 0f;
        }
    }
}
