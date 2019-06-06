package com.taidinh95.particleswarm;

import lombok.Data;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Function;

@Data
public class Particle {
    private static Random random = new Random();
    private Vector position;
    private Vector velocity;
    private Vector bestKnownPosition;

    public Particle() {
        position = new Vector(10, 0);
        velocity = new Vector();
        bestKnownPosition = position.clone();
    }

    public void updateNewPosition(Swarm swarm) {
        calculateNewVelocity(swarm, Vector::getX, Vector::setX);
        calculateNewVelocity(swarm, Vector::getY, Vector::setY);
        calculateNewVelocity(swarm, Vector::getZ, Vector::setZ);
        position.add(velocity);
    }

    public void updateBestKnownPosition() {
        bestKnownPosition = position.clone();
    }

    public void calculateNewVelocity(Swarm swarm, Function<Vector, Double> getter, BiConsumer<Vector, Double> setter) {
        double random1 = random.nextDouble();
        double random2 = random.nextDouble();
        double oldVelocity = getter.apply(velocity);
        double bestKnownPosition = getter.apply(this.bestKnownPosition);
        double position = getter.apply(this.position);
        double bestSwarmPosition = getter.apply(swarm.getBestSwarmPosition());
        double part1 = swarm.getInertia() * oldVelocity;
        double part2 = swarm.getSocialComponent() * random1 * (bestKnownPosition - position);
        double part3 = swarm.getCognitiveComponent() * random2 * (bestSwarmPosition - position);
        setter.accept(velocity, part1 + part2 + part3);
    }

}
