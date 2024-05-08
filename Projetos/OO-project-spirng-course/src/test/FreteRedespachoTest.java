package test;

import java.math.BigInteger;

import entities.FreteRedespacho;
import view.Tests.TestsPrint;

public class FreteRedespachoTest {

    private FreteRedespacho redespacho;

    public FreteRedespachoTest(){
        TestsPrint.newTest("REDESPACHO");
        
        createRedespachoWithoutVolumErrorTest();
        createRedespacho();
        verifyCalcFrete();
    }

    protected void createRedespachoWithoutVolumErrorTest(){

        try{
            float[] volum = new float[0];
            
            BigInteger nf = BigInteger.valueOf(10);

            TestsPrint.init("createRedespachoWithoutVolumErrorTest");

            this.redespacho = new FreteRedespacho(
                    1,
                    100f,
                    nf,
                    "endereço inicial",
                    "endereço final",
                    volum
            );
            TestsPrint.finish(false);
    
        }catch(Exception e){
            if (e.getMessage() == "Erro nenhum volume encontrado")
                TestsPrint.finish(true);
            else{
                System.out.println(e);
                TestsPrint.finish(false);
            }
        }
    }

    protected void createRedespacho(){

        try{
            TestsPrint.init("createRedespacho");

            float[] volum = new float[2];            
            BigInteger nf = BigInteger.valueOf(10);
            volum[0] = 0.10f;
            volum[1] = 0.15f;
        
            this.redespacho = new FreteRedespacho(
                    1,
                    100f,
                    nf,
                    "endereço inicial",
                    "endereço final",
                    volum
            );

            TestsPrint.finish(
                this.redespacho.getVolums().get(0).getM3() == 0.10f &&
                this.redespacho.getVolums().get(1).getM3() == 0.15f &&
                this.redespacho.getDistanceKm() == 100f &&
                this.redespacho.getLastCte() == 1 &&
                this.redespacho.getNF() == nf &&
                this.redespacho.getInitial() == "endereço inicial" &&
                this.redespacho.getEnd() == "endereço final"
            );

        }catch(Exception e){
            System.out.println(e);
            TestsPrint.finish(false);
        }
    }

    protected void verifyCalcFrete(){
        TestsPrint.init("verifyCalcFrete");
        TestsPrint.finish(this.redespacho.getFreteValue() == 575.0f);
    }

}
