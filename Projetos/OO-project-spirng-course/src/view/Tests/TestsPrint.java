package view.Tests;

//Simgleton
public class TestsPrint {
    public static void newTest(String name){
        System.out.println("\n-------------- TEST "+ name + " --------------\n");
    }

    public static void init (String name) {
        System.out.println("👀 ------------ TEST "+ name + " --------------");
    }
    
    public static void finish (Boolean ok) {
        if(ok) System.out.println("✅ O teste passou"); 
        else   System.out.println("❌ O teste falhou");
    }
    

}