package frc.robot.subsystems;

import com.kauailabs.navx.frc.*;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SPI;
import frc.robot.Constants;
public class Gyro {
    AHRS gyro;
    public void GyroMake(){
        gyro = new AHRS(SPI.Port.kMXP);
    }

    public void barf(){
        System.out.println("The Angle is"+gyro.getAngle());
        System.out.println("The Pitch (Tippy) is "+gyro.getPitch());
    }
}
