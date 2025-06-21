public class ComputerTest {
    public static void main(String[] args) {
        // Basic Computer
        Computer basicComputer = new Computer.Builder()
                .setCPU("Intel i3")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .build();
        System.out.println("Basic Computer: " + basicComputer);

        // Gaming Computer
        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .setBluetooth(true)
                .setWifi(true)
                .build();
        System.out.println("Gaming Computer: " + gamingComputer);

        // Office Computer
        Computer officeComputer = new Computer.Builder()
                .setCPU("AMD Ryzen 5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setWifi(true)
                .build();
        System.out.println("Office Computer: " + officeComputer);
    }
}
