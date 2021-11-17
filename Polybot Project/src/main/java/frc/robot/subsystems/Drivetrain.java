// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class drivetrain extends SubsystemBase {
  /** Creates a new drivetrain. */
  
  private CANSparkMax left = new CANSparkMax(Constants._leftdrivetrainportid, MotorType.kBrushless);
  private CANSparkMax right = new CANSparkMax(Constants._rightdrivetrainportid, MotorType.kBrushless);

  private DifferentialDrive drivetrain = new DifferentialDrive(left, right);

  public drivetrain() 
  {
    left.setInverted(false);
    right.setInverted(false);
  }

  public void arcadeDrive(double forward, double turn)
  {
    drivetrain.arcadeDrive(forward, turn);
  }

  public void tankDrive(double leftPower, double rightPower)
  {
    drivetrain.tankDrive(leftPower, rightPower);
  }

  public void stop()
  {
    drivetrain.stopMotor();
  }

  // @Override
  // public void periodic() 
  // {
  //   // This method will be called once per scheduler run
  // }
}
