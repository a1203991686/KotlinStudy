package washingmachine.model;

import washingmachine.model.intelligentmodel.*;

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
public class BaseModel {
    private String name;
    private String des;
    private WashingMode washingMode;
    private RinsingTimes rinsingTimes;
    private WashingTime washingTime;
    private SpinTime spinTime;
    private Temperature temperature;
    private RPM rpm;

    public BaseModel(String name, String des, WashingMode washingMode, RinsingTimes rinsingTimes, WashingTime washingTime, SpinTime spinTime, Temperature temperature, RPM rpm) {
        this.name = name;
        this.des = des;
        this.washingMode = washingMode;
        this.rinsingTimes = rinsingTimes;
        this.washingTime = washingTime;
        this.spinTime = spinTime;
        this.temperature = temperature;
        this.rpm = rpm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public WashingMode getWashingMode() {
        return washingMode;
    }

    public void setWashingMode(WashingMode washingMode) {
        this.washingMode = washingMode;
    }

    public RinsingTimes getRinsingTimes() {
        return rinsingTimes;
    }

    public void setRinsingTimes(RinsingTimes rinsingTimes) {
        this.rinsingTimes = rinsingTimes;
    }

    public WashingTime getWashingTime() {
        return washingTime;
    }

    public void setWashingTime(WashingTime washingTime) {
        this.washingTime = washingTime;
    }

    public SpinTime getSpinTime() {
        return spinTime;
    }

    public void setSpinTime(SpinTime spinTime) {
        this.spinTime = spinTime;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public RPM getRpm() {
        return rpm;
    }

    public void setRpm(RPM rpm) {
        this.rpm = rpm;
    }
}
