package com.taidinh95.particleswarm;

public class Function {

    public static double eval(Vector vector, FunctionType functionType) {
        double x = vector.getX();
        double y = vector.getY();
        if (functionType == FunctionType.SimpleFunction) {
            return x * x - 3 * x - 2;
        } else if (functionType == FunctionType.Auckley) {
            double p1 = -20 * Math.exp(-0.2 * Math.sqrt(0.5 * ((x * x) + (y * y))));
            double p2 = Math.exp(0.5 * (Math.cos(2 * Math.PI * x) + Math.cos(2 * Math.PI * y)));
            return p1 - p2 + Math.E + 20;
        } else if (functionType == FunctionType.ThreeHump) {
            return threeHumpCamelFunction(x, y);
        }
        return 0;
    }

    /**
     * Perform the Three-Hump Camel function.
     *
     * @param x the x component
     * @param y the y component
     * @return the z component
     */
    static double threeHumpCamelFunction(double x, double y) {
        double p1 = 2 * x * x;
        double p2 = 1.05 * Math.pow(x, 4);
        double p3 = Math.pow(x, 6) / 6;
        return p1 - p2 + p3 + x * y + y * y - 1;
    }

    public enum FunctionType {
        SimpleFunction, Auckley, ThreeHump
    }
}
