package converters.Volum;

import java.util.LinkedList;

import entities.Volum;

public class Array2LinkedListConverter {

    public LinkedList<Volum> Array2LinkedList(float[] array){
        int len = array.length;
        LinkedList<Volum> volums = new LinkedList<>();
        
        for(int i = 0; i < len ; i++)
            volums.add(new Volum(array[i]));

        return volums;
    }
}