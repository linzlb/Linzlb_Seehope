public class TestCPU {
    public static void main(String[] args) {
        new Thread(() -> {
            while (true){}
        }).start();
        new Thread(() -> {
            while (true){}
        }).start();
        new Thread(() -> {
            while (true){}
        }).start();
        new Thread(() -> {
            while (true){}
        }).start();
    }
}
