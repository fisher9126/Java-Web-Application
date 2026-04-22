package re.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwaSs12Hw3Application {
    static HospitalConfig hospitalConfig = new HospitalConfig();

    public JwaSs12Hw3Application(HospitalConfig hospitalConfig) {
        this.hospitalConfig = hospitalConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(JwaSs12Hw3Application.class, args);


        hospitalConfig.init();
    }

}
