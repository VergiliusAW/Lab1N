package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Perceptron {
    private double a = 0.01;
    private double w0 = -0.5;
    private int[] v;
    private int[] r;
    private double[] w;

    public Perceptron init(int w_length) {
        v = new int[w_length];
        Random r = new Random();
        w = new double[w_length];
        for (int i = 0; i < w.length; i++) {
            w[i] = r.nextDouble() % 1;
        }
        return this;
    }

    public Perceptron learn(int[] data_set) {
        v = data_set;
//        r = data_res;
//        learn();
        return this;
    }

    public Perceptron correct(double lrate,int error) {
        for(int k = 0;k<v.length;k++)
        {
            double delta = lrate * v[k] * error;
            w[k] += delta;
        }
        return this;
    }

//    public void learn(int epoch) {
//        for (int i = 0; i < epoch; i++) {
//            int totalError = 0;
//            for(int j =0;j<p;j++)
//            {
//                int output = binaryStepActivation();
//                int error = outputs[j] - output;
//
//                totalError +=error;
//
//                for(int k = 0;k<n;k++)
//                {
//                    double delta = lrate * inputs[j][k] * error;
//                    weights[k] += delta;
//                }
//
//
//            }
//            if(totalError == 0)
//                break;
//        }
//    }

    public double sigmoidActivation() {
        return 1 / (1 + Math.exp(-sum()));
    }

    public int binaryStepActivation() {
        if (sum() < 0) return 0;
        else return 1;
    }

    public double sum() {
        double sum = 0.0;
        for (int i = 0; i < v.length; i++) {
            sum += v[i] * w[i];
        }
        sum += w0;
        return sum;
    }

    public String getMetaData() {
        return String.format("w[%s] = [ %s] | sum(w) = %s \nbinaryStepActivation() = %s\nsigmoidActivation() = %s", w.length, getWTable(), sum(), binaryStepActivation(), sigmoidActivation());
    }

    private String getWTable() {
        StringBuilder builder = new StringBuilder();
        for (double i : w) {
            builder.append(String.format("%s ", i));
        }
        return builder.toString();
    }
}
