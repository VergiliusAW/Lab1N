package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerceptronNetwork extends Perceptron{

    private List<Perceptron> perceptrons;
    private int[][] data;
    private int[] res;
    private double lrate = 0.1;

    public PerceptronNetwork init(int[][] data_sets, int[] data_res) {
        perceptrons = new ArrayList<>(Arrays.asList(init(data_res.length)));
        data = data_sets;
        res = data_res;
        learn(200);
//        System.out.print(perceptrons.get(0).getMetaData());
        return this;
    }

    public void learn(int epoch) {
        for(int i=0;i<epoch;i++)
        {
            boolean totalError = false;
            for(int j =0;j<res.length;j++)
            {
                int output = perceptrons.get(0).learn(data[j]).binaryStepActivation();
                int error = res[j] - output;
                if (error!=0) totalError = true;
                System.out.println(String.format("res[%s] = %s\noutput = %s\nstep = %s\nisError() = %s\n%s",j,res[j],output,i,totalError,perceptrons.get(0).getMetaData()));
                perceptrons.get(0).correct(lrate,error);
            }
            if(!totalError) {
                System.out.println(String.format("Количество эпох = %s",i));
                break;
            }
        }
    }

    public int is(int[] data_set) {
        return perceptrons.get(0).learn(data_set).binaryStepActivation();
    }
}
