// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Driverstation;
import frc.robot.subsystems.Drivetrain;

public class DriveBasicAcceleration extends CommandBase {

  private Drivetrain drivetrain;
  private Driverstation driverstation;

  /** Creates a new driveBasicAcceleration. */
  public DriveBasicAcceleration(Drivetrain drivetrain, Driverstation driverstation) 
  {
    this.drivetrain = drivetrain;
    this.driverstation = driverstation;
    drivetrain.maxAccel = 0.05;
    drivetrain.minAccel = -0.05;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    drivetrain.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    drivetrain.arcadeDrive(driverstation.leftStick(false), driverstation.rightStick(true));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
