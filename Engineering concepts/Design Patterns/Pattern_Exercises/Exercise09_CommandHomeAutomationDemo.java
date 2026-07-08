public class Exercise09_CommandHomeAutomationDemo {
    public static void main(String[] args) {
        LightDevice livingRoomLight = new LightDevice("Living Room Light");
        FanDevice ceilingFan = new FanDevice("Bedroom Fan");

        HomeAutomationCommand lightOn = new LightOnCommand(livingRoomLight);
        HomeAutomationCommand fanOn = new FanOnCommand(ceilingFan);
        HomeAutomationCommand fanOff = new FanOffCommand(ceilingFan);
        HomeAutomationCommand lightOff = new LightOffCommand(livingRoomLight);

        HomeRemoteController remote = new HomeRemoteController();

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(fanOn);
        remote.pressButton();

        remote.setCommand(fanOff);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();
    }
}

interface HomeAutomationCommand {
    void execute();
}

final class LightDevice {
    private final String name;

    LightDevice(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name + " turned ON");
    }

    public void off() {
        System.out.println(name + " turned OFF");
    }
}

final class FanDevice {
    private final String name;

    FanDevice(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name + " turned ON");
    }

    public void off() {
        System.out.println(name + " turned OFF");
    }
}

final class LightOnCommand implements HomeAutomationCommand {
    private final LightDevice lightDevice;

    LightOnCommand(LightDevice lightDevice) {
        this.lightDevice = lightDevice;
    }

    @Override
    public void execute() {
        lightDevice.on();
    }
}

final class LightOffCommand implements HomeAutomationCommand {
    private final LightDevice lightDevice;

    LightOffCommand(LightDevice lightDevice) {
        this.lightDevice = lightDevice;
    }

    @Override
    public void execute() {
        lightDevice.off();
    }
}

final class FanOnCommand implements HomeAutomationCommand {
    private final FanDevice fanDevice;

    FanOnCommand(FanDevice fanDevice) {
        this.fanDevice = fanDevice;
    }

    @Override
    public void execute() {
        fanDevice.on();
    }
}

final class FanOffCommand implements HomeAutomationCommand {
    private final FanDevice fanDevice;

    FanOffCommand(FanDevice fanDevice) {
        this.fanDevice = fanDevice;
    }

    @Override
    public void execute() {
        fanDevice.off();
    }
}

final class HomeRemoteController {
    private HomeAutomationCommand command;

    public void setCommand(HomeAutomationCommand command) {
        this.command = command;
    }

    public void pressButton() {
        if (command == null) {
            throw new IllegalStateException("No command assigned");
        }
        command.execute();
    }
}