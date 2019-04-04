/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Gamepad;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.ReverseCargo;

public class Intakes extends Command {
  private Intake intake = Robot.sIntake;
  private ReverseCargo reverse = Robot.sReverese;
  private boolean forward;
  private OI oi = Robot.mOI;
  Gamepad gamepad = oi.gamepad;
  public Intakes(boolean forward) {
    requires(intake);
    this.forward = forward;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    /*if (forward) {
      intake.setIntakePower(.4);
    }
    else {
      reverse.setEjectPower(-1 * .4);
    }*/
    intake.setIntakePower(oi.getTriggerSum());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    intake.stopIntake();
    reverse.stopEject();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    intake.stopIntake();
    reverse.stopEject();
  }
}
