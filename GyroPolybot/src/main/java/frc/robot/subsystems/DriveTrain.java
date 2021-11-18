package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class DriveTrain extends SubsystemBase{
    public static CANSparkMax leftMotor, rightMotor;
    
    public void driveTrain(){
        leftMotor = new CANSparkMax(Constants.leftSparkMax, MotorType.kBrushless);
        rightMotor = new CANSparkMax(Constants.rightSparkMax, MotorType.kBrushless);
        leftMotor.setInverted(true);
    }

    public void Drive(double power){
        leftMotor.set(power);
        rightMotor.set(power);
    }
    
    public void Stop(){
        leftMotor.set(0);
        rightMotor.set(0);
    }
}