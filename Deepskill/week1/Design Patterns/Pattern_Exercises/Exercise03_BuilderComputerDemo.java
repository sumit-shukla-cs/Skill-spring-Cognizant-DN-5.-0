public class Exercise03_BuilderComputerDemo {
    public static void main(String[] args) {
        ComputerProduct officeComputer = new ComputerProduct.Builder()
                .processor("Intel Core i5")
                .ram("16 GB")
                .storage("512 GB SSD")
                .graphicsCard("Integrated Graphics")
                .operatingSystem("Windows 11")
                .build();

        ComputerProduct gamingComputer = new ComputerProduct.Builder()
                .processor("AMD Ryzen 9")
                .ram("32 GB")
                .storage("1 TB NVMe SSD")
                .graphicsCard("NVIDIA RTX 4070")
                .hasWifi(true)
                .operatingSystem("Windows 11 Pro")
                .build();

        System.out.println(officeComputer);
        System.out.println(gamingComputer);
    }
}

final class ComputerProduct {
    private final String processor;
    private final String ram;
    private final String storage;
    private final String graphicsCard;
    private final boolean hasWifi;
    private final String operatingSystem;

    private ComputerProduct(Builder builder) {
        this.processor = builder.processor;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.hasWifi = builder.hasWifi;
        this.operatingSystem = builder.operatingSystem;
    }

    @Override
    public String toString() {
        return "ComputerProduct{" +
                "processor='" + processor + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", hasWifi=" + hasWifi +
                ", operatingSystem='" + operatingSystem + '\'' +
                '}';
    }

    static final class Builder {
        private String processor;
        private String ram;
        private String storage;
        private String graphicsCard;
        private boolean hasWifi;
        private String operatingSystem;

        public Builder processor(String processor) {
            this.processor = processor;
            return this;
        }

        public Builder ram(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder hasWifi(boolean hasWifi) {
            this.hasWifi = hasWifi;
            return this;
        }

        public Builder operatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        public ComputerProduct build() {
            return new ComputerProduct(this);
        }
    }
}