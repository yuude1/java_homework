package org.example;

import lombok.Getter;

@Getter
public class Superheros {
    protected String nameHero;
    private final String name;
    protected int age;

    public Superheros(String nameHero, String name, int age) {
        this.nameHero = nameHero;
        this.name = name;
        this.age = age;
    }

    public void introduceHero() {
        System.out.println("I am " + nameHero + ", also known as " + name);
    }

    @RunTimes(times = 2)
    public void savePeople(int peopleSaved) {
        System.out.println(nameHero + " saved " + peopleSaved + " people today!");
    }

    protected void trainHero(String skill) {
        System.out.println(nameHero + " is training in " + skill);
    }

    @RunTimes(times = 3)
    protected void phrasePrivate() {
        System.out.println("How did I end up here??");
    }

    private void revealSecret(String secret) {
        System.out.println("Secret of " + nameHero + ": " + secret);
    }

    @RunTimes(times = 5)
    private void restAfterBattle(int hours) {
        System.out.println(nameHero + " is resting for " + hours + " hours after battle.");
    }
}
