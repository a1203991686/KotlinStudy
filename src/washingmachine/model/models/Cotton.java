package washingmachine.model.models;

import washingmachine.model.BaseModel;
import washingmachine.model.intelligentmodel.*;

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
public class Cotton extends BaseModel {

    public Cotton(String name, String des, WashingMode washingMode, RinsingTimes rinsingTimes, WashingTime washingTime, SpinTime spinTime, Temperature temperature, RPM rpm) {
        super(name, des, washingMode, rinsingTimes, washingTime, spinTime, temperature, rpm);
    }

    public void test() {

    }


}
