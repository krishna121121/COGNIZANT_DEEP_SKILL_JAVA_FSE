package DesignPatternsandPrinciples;

class Computer {
    private String cpu;
    private String ram;
    private String storage;

    private Computer(Builder builder) {
        cpu = builder.cpu;
        ram = builder.ram;
        storage = builder.storage;
    }

    public void display() {
        System.out.println(cpu + " " + ram + " " + storage);
    }

    static class Builder {
        private String cpu;
        private String ram;
        private String storage;

        public Builder setCPU(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRAM(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class Exercise3 {
    public static void main(String[] args) {
        Computer c = new Computer.Builder()
                .setCPU("i7")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .build();

        c.display();
    }
}