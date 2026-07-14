public class CommandTest {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        RemoteControl remote = new RemoteControl();
        
        remote.setCommand(new LightOnCommand(livingRoomLight));
        remote.pressButton();
    }
}