// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new drivetrain. */
  
  private CANSparkMax left = new CANSparkMax(Constants._leftdrivetrainportid, MotorType.kBrushless);
  private CANSparkMax right = new CANSparkMax(Constants._rightdrivetrainportid, MotorType.kBrushless);

  private double lastFwd = 0;

  private DifferentialDrive drivetrain = new DifferentialDrive(left, right);

  /** Note: robot acceleration values are absolute, a minAccel of -1 and a maxAccel of 0 can still move the robot backwards*/
  public double minAccel = -1;
  /** Note: robot acceleration values are absolute, a minAccel of -1 and a maxAccel of 0 can still move the robot backwards*/
  public double maxAccel = 1;

  public Drivetrain() 
  {
    left.setInverted(false);
    right.setInverted(false);
  }

  /**
   * Uses arcadeDrive to drive the robot.
   * Has built-in acceleration which can be changed with the drivetrains minAccel and maxAccel values.
   */
  public void arcadeDrive(double forward, double turn)
  {
    double alteredfwd = forward;
    double givenaccel = forward - lastFwd;

    if (givenaccel > maxAccel)
    {
      alteredfwd = forward + maxAccel;
    } 
    else if (givenaccel < minAccel) 
    {
      alteredfwd = forward + minAccel;
    }
    drivetrain.arcadeDrive(alteredfwd, turn);
    lastFwd = alteredfwd;
  }

  /** 
   * Sets the left wheels power to leftPower, and the right wheels power to rightPower
   * !!! Due to the way I have it set up, tankDrive will not be accelerated properly!
  **/
  public void tankDrive(double leftPower, double rightPower)
  {
    drivetrain.tankDrive(leftPower, rightPower);
  }

  public void stop()
  {
    drivetrain.stopMotor();
  }
}
