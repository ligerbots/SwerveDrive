/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swerve.commands;

import com.sun.squawk.util.MathUtils;
import java.lang.Math;
import edu.wpi.first.wpilibj.command.Command;
import swerve.Robot.Robot;
import swerve.Robot.RobotMap;
import swerve.subsystems.Swerve;

/**
 *
 * turnSwerveWheels
 */
public class SwerveWheels extends Command {
    Swerve swerver = Robot.swerve;
    double direction;
    
    public SwerveWheels(double dir) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        //m_initial_enable = enable;
        direction = dir;
        requires(Robot.swerve);
    }

    // Called just before this Command runs the first time
    public void initialize() {
        System.out.println("Swerve constructor called");
        //Robot.m_shooter_enable = m_initial_enable;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //Robot.m_shooter_enable = m_initial_enable;
        //Robot.debugOutBoolean("Shooter enable", Robot.m_shooter_enable);
        //MAKE SWITCH LATER CAUSE THIS IS DUMB
        if (direction == 10) 
            swerver.turnSwerveWheel(-0.1);
        else if (direction == -10)
            swerver.turnSwerveWheel(0.1);
        else if (direction == 5)
            swerver.turnSwerveWheel(1);
        else if (direction == -5)
            swerver.turnSwerveWheel(-1);
        else if (direction == -5)
            swerver.encodedTurn(-1);
        else if (direction == 2)
            swerver.turnSwerveWheels(1);
        else if (direction == -2)
            swerver.turnSwerveWheels(-1);
         else if (direction == 3)
            swerver.disableSwerve();
        else
            swerver.turnSwerveWheels(direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // finishes immediately
        //Robot.debugOut("Shooter enable ", "Finished");
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
    //return angle in degrees
    public double getJoystickAngle() {
        double X = Robot.oi.joystick1.getRawAxis(4);
        double Y = -1*Robot.oi.joystick1.getRawAxis(5);
        double D = Math.toDegrees(MathUtils.atan(Math.abs(Y/X)));
        if (X > 0.09 || Y > 0.09) {
            if (X<0){
                if(Y>0)D = 180-D;
                else D+=180;
            } else if (Y <0) D=360-D;
        } else return 0;
        return D;
    }
}
