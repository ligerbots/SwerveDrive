// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.


package swerve.Robot;

import swerve.commands.SwerveWheels;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
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
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick joystick1;
    public Joystick joystick2;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton rotationalSwerveRight;
    public JoystickButton rotationalSwerveLeft;
    public JoystickButton encodedSwerveRight;
    public JoystickButton encodedSwerveLeft;
    public JoystickButton calibrationRight;
    public JoystickButton calibrationLeft;
    public JoystickButton zero;
    
    
    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystick1 = new Joystick(1);  
       /*
        rotationalSwerveLeft = new JoystickButton(joystick1, 5);
        rotationalSwerveLeft.whileHeld(new SwerveWheels(0.1));
        //rotationalSwerveLeft.whenReleased(new SwerveWheels(0));
        rotationalSwerveRight = new JoystickButton(joystick1, 6);
        rotationalSwerveRight.whileHeld(new SwerveWheels(-0.1));
        //rotationalSwerveRight.whenReleased(new SwerveWheels(0));
        
        //single side movement for calibration on A button for xboxOne controller
        calibrationRight = new JoystickButton(joystick1, 1);
        calibrationRight.whileHeld(new SwerveWheels(2));
        calibrationRight.whenReleased(new SwerveWheels(3));
        
        
     //single side movement for calibration on Y button for xboxOne controller
        calibrationLeft = new JoystickButton(joystick1, 4);
        calibrationLeft.whenPressed(new SwerveWheels(-2));
        calibrationLeft.whenReleased(new SwerveWheels(3));
        //calibrationLeft.whenReleased(new SwerveWheels(0));
        
        
        //turn encoders to zero, behavior unkown; push in right joystick
        zero = new JoystickButton(joystick1, 10);
        zero.whenReleased(new SwerveWheels(3));
        zero.whenPressed(new SwerveWheels(2));
        */
        calibrationRight = new JoystickButton(joystick1, 5);
        calibrationRight.whileHeld(new SwerveWheels(2));
        calibrationRight.whenReleased(new SwerveWheels(3));
        
        
     //single side movement for calibration on Y button for xboxOne controller
        calibrationLeft = new JoystickButton(joystick1, 6);
        calibrationLeft.whenPressed(new SwerveWheels(-2));
        calibrationLeft.whenReleased(new SwerveWheels(3));
        //calibrationLeft.whenReleased(new SwerveWheels(0));
        
        //dual side movement on X button for xboxOne controller
        encodedSwerveRight = new JoystickButton(joystick1, 3);
        //encodedSwerveRight.whileHeld(new SwerveWheels(5));
        encodedSwerveRight.whenReleased(new SwerveWheels(3));
        encodedSwerveRight.whenPressed(new SwerveWheels(5));
        
        //single side movement on B button for xboxOne controller
        encodedSwerveLeft = new JoystickButton(joystick1, 2);
        //encodedSwerveLeft.whileHeld(new SwerveWheels(-5));
        encodedSwerveLeft.whenReleased(new SwerveWheels(3));
        encodedSwerveLeft.whenPressed(new SwerveWheels(-5));
    }
    
    
    public Joystick getJoystick1() {
        return joystick1;
    }
    
}

