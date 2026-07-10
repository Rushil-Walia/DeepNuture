// Test Class
public class BuilderTest {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB NVMe")
                .build();
        System.out.println(gamingPC);
    }
}