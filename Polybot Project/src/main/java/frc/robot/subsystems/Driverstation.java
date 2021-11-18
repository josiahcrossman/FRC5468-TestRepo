// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Driverstation extends SubsystemBase {
  private XboxController xboxController = new XboxController(Constants._xboxcontrollerportid);
  /** Creates a new Driverstation. */
  public Driverstation() {
    
  }

  /**Provides current left joystick values for main xboxcontroller
   * @param xaxis set to true to get x axis for left stick, or false for y axis values
  */
  public double leftStick(boolean xaxis)
  {
    if (xaxis)
    {
      return xboxController.getX(Hand.kLeft);
    } else {
      return xboxController.getY(Hand.kLeft);
    }
  }

  /**Provides current right joystick values for main xboxcontroller
   * @param xaxis set to true to get x axis for right stick, or false for y axis values
  */
  public double rightStick(boolean xaxis)
  {
    if (xaxis)
    {
      return xboxController.getX(Hand.kRight);
    } else {
      return xboxController.getY(Hand.kRight);
    }
  }
  
  public boolean getButton(XboxButton button) 
  {
    return xboxController.getRawButton(button.value);
  }

  public double leftTrigger()
  {
    return xboxController.getTriggerAxis(Hand.kLeft);
  }

  public double rightTrigger()
  {
    return xboxController.getTriggerAxis(Hand.kRight);
  }

  public XboxButton quickButton()
  {
    for (XboxButton x: XboxButton.values())
    {
      if (getButton(x))
      {
        return x;
      }
    }
    return null;
  }

  public int dPad()
  {
    return xboxController.getPOV();
  }

  public static enum XboxButton
  {
    a(1),
    b(2),
    x(3),
    y(4),
    lb(5),
    leftBumper(lb.value),
    rb(6),
    rightBumper(rb.value),
    select(7),
    back(select.value),
    start(8),
    ls(9),
    leftStick(ls.value),
    rs(10),
    rightStick(rs.value);

    public final int value;
    XboxButton(int value) 
    {
      this.value = value;
    }
  }
}
