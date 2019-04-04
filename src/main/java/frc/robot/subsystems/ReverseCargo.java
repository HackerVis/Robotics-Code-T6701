/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ReverseCargo extends Subsystem {
  private Spark ejectMotor;
  public ReverseCargo() {
    ejectMotor = new Spark(RobotMap.INTAKE_MOTOR);
  }
  public void setEjectPower(double power) {
    power = safetyCheck(power);
    ejectMotor.set(power);
}

private double safetyCheck(double power) {
    power = Math.min(1.0, power);
    power = Math.max(-1.0, power);
    /*
     * if((!topSwitch.get() && power > 0) || (!bottomSwitch.get() && power < 0)) {
     * return power; } else { return 0.0; }
     */
    return power;
}



  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public void initDefaultCommand() {
      // Set the default command for a subsystem here.
      // setDefaultCommand(new MySpecialCommand());
  }

  public void stopEject() {
      ejectMotor.set(0);
  }

  public void stop() { 
      stopEject();
  }
}
