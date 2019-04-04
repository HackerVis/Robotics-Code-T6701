/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.Timer;

public class Drive extends Command {
  private DriveTrain s_Drivetrain = Robot.sDrivetrain;
  private OI m_oi = Robot.mOI;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  private Timer timer = new Timer();
  public Drive() {
     // Use requires() here to declare subsystem dependencies
    requires(s_Drivetrain);
  } 

  // Called just before this Command runs the first time
  @Override
    protected void initialize() {
    }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double throttle = m_oi.getLeftY();
    double turn = m_oi.getRightX();
        /*
         * if (imu != null) { if (turn == 0 && !hasHeading && Math.abs(imu.getAngleZ() -
         * angleOld) < RobotMap.TURN_RATE_THRESHOLD) { hasHeading = true; heading =
         * imu.getAngleZ(); } angleOld = imu.getAngleZ();
         * 
         * if (turn == 0 && throttle != 0) { driveStraight(throttle, heading); } else {
         * hasHeading = false; execute(throttle, turn); } } else { execute(throttle,
         * turn); }
         */
    execute(throttle, turn);
  }
  private void execute(double throttle, double turn) {
    double dt = timer.get();
    timer.reset();
    s_Drivetrain.setDrive(throttle, turn);
}

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    s_Drivetrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    s_Drivetrain.stop();
  }
}
