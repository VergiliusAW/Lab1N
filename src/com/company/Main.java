package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] data_set = {
                {0,0},
                {0,1},
                {1,0},
                {1,1},
        };
        int[] data_res = {
                0,
                0,
                0,
                1
        };
        PerceptronNetwork perceptronNetwork = new PerceptronNetwork();
        perceptronNetwork.init(data_set,data_res);
        for (int i=0; i< data_set.length; i++) {
            System.out.println(perceptronNetwork.is(data_set[i]));
        }
        //        Perceptron perceptron = new Perceptron();
//        for (int i = 0; i < data_set.length; i++) {
//            perceptron.init(data_set[i].length);
//            perceptron.learn(data_set[i],data_res);
//            System.out.println(perceptron.getMetaData());
//        }
        PerceptronGit p = new PerceptronGit();
        double inputs[][] = {
                {0,0},
                {0,1},
                {1,0},
                {1,1}
        };
        int outputs[] = {
                0,
                0,
                0,
                1
        };

        p.Train(inputs, outputs,0.2, 0.1, 200);
//        System.out.println(p.Output(new double[]{0,0}));
//        System.out.println(p.Output(new double[]{1,0}));
//        System.out.println(p.Output(new double[]{0,1}));
//        System.out.println(p.Output(new double[]{1,1}));
    }
}
