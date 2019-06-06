package com.taidinh95.particleswarm;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Swarm {
    private List<Particle> particles;
    private Function.FunctionType functionType;
    private double inertia = 0.729844;
    private double cognitiveComponent = 1.49618;
    private double socialComponent = 1.49618;
    private Vector bestSwarmPosition;

    public Swarm(int noOfParticles, Function.FunctionType functionType) {
        particles = new ArrayList<>();
        for (int i = 0; i < noOfParticles; i++) {
            Particle particle = new Particle();
            particles.add(particle);
            if (bestSwarmPosition == null || Function.eval(bestSwarmPosition, functionType) < Function.eval(particle.getPosition(), functionType)) {
                this.bestSwarmPosition = particle.getPosition();
            }
        }
        this.functionType = functionType;
    }

    public static void main(String[] args) {
        Swarm swarm = new Swarm(50, Function.FunctionType.ThreeHump);
        swarm.run();
    }

    private void run() {
        for (int i = 0; i < 50; i++) {
            Function.FunctionType simpleFunction = functionType;
            double currentValue = Function.eval(bestSwarmPosition, simpleFunction);
            System.out.println(currentValue);
            for (Particle particle : particles) {
                particle.updateNewPosition(this);
                double eval = Function.eval(particle.getPosition(), simpleFunction);
                double eval1 = Function.eval(particle.getBestKnownPosition(), simpleFunction);
                if (eval < eval1) {
                    particle.updateBestKnownPosition();
                }
                double eval2 = Function.eval(bestSwarmPosition, simpleFunction);
                if (eval < eval2) {
                    bestSwarmPosition = particle.getPosition().clone();
                    System.out.println("Update swarm best position");
                }
            }
            System.out.println("Current best position: " + bestSwarmPosition);
        }

    }

    private Vector getBestSwarmPosition() {
        if (bestSwarmPosition != null) {
            return bestSwarmPosition;
        }
        return null;
    }
}
