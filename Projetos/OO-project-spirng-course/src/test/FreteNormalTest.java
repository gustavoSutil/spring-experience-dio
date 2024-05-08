package test;

import java.math.BigInteger;

import entities.FreteNormal;
import view.Tests.TestsPrint;

public class FreteNormalTest {

    private FreteNormal frete;

    public FreteNormalTest() {
        TestsPrint.newTest("FRETE NORMAL");

        createNormalWithoutVolumErrorTest();
        createNormal();
        verifyCalcFrete();
    }

    protected void createNormalWithoutVolumErrorTest() {

        try {
            float[] volum = new float[0];

            BigInteger nf = BigInteger.valueOf(10);

            TestsPrint.init("createNormalWithoutVolumErrorTest");

            this.frete = new FreteNormal(
                    100f,
                    nf,
                    "endereço inicial",
                    "endereço final",
                    volum);
            TestsPrint.finish(false);

        } catch (Exception e) {
            if (e.getMessage() == "Erro nenhum volume encontrado")
                TestsPrint.finish(true);
            else {
                System.out.println(e);
                TestsPrint.finish(false);
            }
        }
    }

    protected void createNormal() {

        try {
            TestsPrint.init("CreateFreteNormal");

            float[] volum = new float[2];
            BigInteger nf = BigInteger.valueOf(10);
            volum[0] = 0.10f;
            volum[1] = 0.15f;

            this.frete = new FreteNormal(
                    100f,
                    nf,
                    "endereço inicial",
                    "endereço final",
                    volum);

            TestsPrint.finish(
                    this.frete.getVolums().get(0).getM3() == 0.10f &&
                            this.frete.getVolums().get(1).getM3() == 0.15f &&
                            this.frete.getDistanceKm() == 100f &&
                            this.frete.getNF() == nf &&
                            this.frete.getInitial() == "endereço inicial" &&
                            this.frete.getEnd() == "endereço final");

        } catch (Exception e) {
            System.out.println(e);
            TestsPrint.finish(false);
        }
    }

    protected void verifyCalcFrete() {
        TestsPrint.init("verifyCalcFrete");
        TestsPrint.finish(this.frete.getFreteValue() == 575.0f);
    }

}
