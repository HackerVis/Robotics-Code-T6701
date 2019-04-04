/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.Drive;
import frc.robot.RobotMap;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;



/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  DifferentialDrive m_drive;
  double leftPowerOld, rightPowerOld;
  Timer timer = new Timer();
  private Spark leftSpeed, rightSpeed;
  

  public DriveTrain() {
    // log.add("Constructor", LOG_LEVEL);

    // if (Robot.currentBot == BOT.MAINBOT) {
    leftSpeed = new Spark(RobotMap.LEFT_MOTOR);
    rightSpeed = new Spark(RobotMap.RIGHT_MOTOR);
  }


  private void initMotor(Spark motor, boolean reverse) {
    motor.setInverted(reverse); // affects percent Vbus mode???
  }

  public void setDrive(double forward, double turn) {
        m_drive.arcadeDrive(forward, turn);
    }

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Drive());
  }
  public void stop() {
    setDrive(0.0, 0.0);
  }


}
