package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.XboxController;

public class GyroRead extends CommandBase {
    private static Gyro gyro;
    private static XboxController controller;

    public GyroRead(Gyro readGyro, XboxController Control){
        readGyro = gyro;
    }

    @Override
    public void initialize(){
        System.out.println("It should print data");
    } 

    @Override
    public void execute(){
        gyro.barf();
    }

    @Override
    public void end(boolean interrupted){
        System.out.println("It should stop");
    }

    @Override
    public boolean isFinished(){
        System.out.println("Extra end");
        return false;
    }
}
