package org.sda.przypomnienie;

public class Test {

    private static class Dog {
        public String voice;
        public String getVoice() {
            return voice;
        }
        public void setVoice(String voice) {
            this.voice = voice;
        }
    }

    public static void main(String[] args) {
        Dog pimpus = new Dog();
        pimpus.setVoice("Hau Hau!");
        doSasiada(pimpus);
        System.out.println(pimpus.getVoice());
    }

    public static void doSasiada(Dog dog) {
        dog = new Dog();
        dog.setVoice("Miau!");
    }
}
