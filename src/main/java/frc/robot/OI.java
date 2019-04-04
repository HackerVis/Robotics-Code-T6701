/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import frc.robot.RobotMap;
import frc.robot.commands.Intakes;
import frc.robot.subsystems.ReverseCargo;
import frc.robot.subsystems.Intake;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    //// joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    public Gamepad gamepad;

    public OI() {

        gamepad = new Gamepad(RobotMap.USB_GAMEPAD);
        gamepad.LB.whileHeld(new Intakes(false));
        // controlStick.button5.whenPressed(new GrabPanel(true));
        // controlStick.button3.whenPressed(new GrabPanel(false));
        // controlStick.button6.whenPressed(new PopPanel());
        gamepad.RB.whileHeld(new Intakes(true));

    }

    // Gamepad Functions
    public double getLeftY() {
        double joystickValue = gamepad.getRawAxis(Gamepad.LEFT_JOY_Y_AXIS);
        // joystickValue = checkDeadZone(joystickValue);
        // log.add("getLeftY (" + joystickValue + ")", LOG_LEVEL);
        // log.add("Deadzone = " + RobotMap.JOYSTICK_DEADZONE, LOG_LEVEL);
        return -1 * joystickValue;
    }

    public double getRightX() {
        double joystickValue = gamepad.getRawAxis(Gamepad.RIGHT_JOY_X_AXIS);
        // joystickValue = checkDeadZone(joystickValue);
        // log.add("getRightX (" + joystickValue + ")", LOG_LEVEL);
        return joystickValue;
    }

    public double getLeftTrigger() {
        return gamepad.getRawAxis(Gamepad.LEFT_TRIGGER);
    }

    public double getTriggerSum() {
      return gamepad.getRawAxis(Gamepad.LEFT_TRIGGER) - gamepad.getRawAxis(Gamepad.RIGHT_TRIGGER);
    }
  }
