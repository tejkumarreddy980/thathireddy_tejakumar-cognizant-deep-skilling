public class BuilderPatternExample {

    static class Computer {
        private String cpu;
        private String ram;
        private String storage;
        private String graphicsCard;

        private Computer(Builder builder) {
            this.cpu = builder.cpu;
            this.ram = builder.ram;
            this.storage = builder.storage;
            this.graphicsCard = builder.graphicsCard;
        }

        public void displayConfig() {
            System.out.println("CPU: " + cpu);
            System.out.println("RAM: " + ram);
            System.out.println("Storage: " + storage);
            System.out.println("Graphics Card: " + (graphicsCard != null ? graphicsCard : "Not included"));
            System.out.println("-------------------------");
        }

        static class Builder {
            private String cpu;
            private String ram;
            private String storage;
            private String graphicsCard;

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

            public Builder setGraphicsCard(String graphicsCard) {
                this.graphicsCard = graphicsCard;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
            .setCPU("Intel Core i9")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .setGraphicsCard("NVIDIA RTX 4080")
            .build();

        Computer officePC = new Computer.Builder()
            .setCPU("Intel Core i5")
            .setRAM("16GB")
            .setStorage("512GB SSD")
            .build();

        System.out.println("Gaming PC Configuration:");
        gamingPC.displayConfig();

        System.out.println("Office PC Configuration:");
        officePC.displayConfig();
    }
}
