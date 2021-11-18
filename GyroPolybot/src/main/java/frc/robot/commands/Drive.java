package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class Drive extends CommandBase{
    private static DriveTrain driveTrain;
    XboxController controller;

    public Drive(DriveTrain drive, XboxController control){
        driveTrain = drive;
        addRequirements(driveTrain);
        control = controller;
    } 

    @Override
    public void initialize(){
        driveTrain.Stop();
        System.out.println("Started");
    }

    @Override
    public void execute(){

        driveTrain.Drive(controller.getY(Hand.kLeft) * .1);
    }

    @Override
    public void end(boolean interrupted){
        driveTrain.Stop();
        System.out.println("End");
    }

    @Override
    public boolean isFinished(){
        System.out.println("endier");
        return false;
    }
    
}
