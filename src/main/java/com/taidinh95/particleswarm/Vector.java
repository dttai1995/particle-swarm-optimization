package com.taidinh95.particleswarm;

import lombok.Data;

import java.util.Random;

@Data
public class Vector {
    private static Random random = new Random();
    private double x;
    private double y;
    private double z;

    public Vector(double standardDeviation, double mean) {
        x = random.nextGaussian() * standardDeviation + mean;
        y = random.nextGaussian() * standardDeviation + mean;
        z = random.nextGaussian() * standardDeviation + mean;
    }

    public Vector() {
    }

    public void add(Vector anotherVector) {
        this.x = this.x + anotherVector.getX();
        this.y = this.y + anotherVector.getY();
        this.z = this.z + anotherVector.getZ();
    }

    public Vector clone() {
        Vector vector = new Vector();
        vector.setX(x);
        vector.setY(y);
        vector.setZ(z);
        return vector;
    }

    public void mul(double multipler) {
        this.x = this.x * multipler;
        this.y = this.y * multipler;
        this.z = this.z * multipler;
    }

}
