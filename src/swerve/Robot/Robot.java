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

import swerve.subsystems.DriveTrain;
import swerve.subsystems.Swerve;
import swerve.commands.Drive;
import swerve.commands.SwerveWheels;
import com.sun.squawk.microedition.io.FileConnection;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.io.DataInputStream;
import swerve.subsystems.CANJags;

import javax.microedition.io.Connector;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;
    public static Swerve swerve;
    //public static ShooterAngleControl shooterAngleControl;
    //public static Acquisition acquisition;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public static SwerveWheels swerveWheels;
    private Drive drive;
    public static int m_total_ticks = 0;
    public static boolean m_shooter_enable = false;
    
    // This constant is used to define how many cycles we need to go to make
    // sure that the cam has cleared the limit switch
   /* public static final String OVERSHOOT_FILE = "file:///overshoot.txt";
    public static int OVERSHOOT_AMOUNT_UP = 3;
    public static int OVERSHOOT_AMOUNT_DOWN = 1;
    
    //public static boolean m_lift_emergency_stop = false;
    */

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
	RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new DriveTrain();
        swerve = new Swerve();
        //shooterAngleControl = new ShooterAngleControl();
       // acquisition = new Acquisition();
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drive = new Drive();
        //readOvershoot();

        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
        updateDashboard();
        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        //autonomousCommand = new AutonomousCommand();
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null)
        {
            autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        commonPeriodic();
     }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        System.out.println("teleopInit");
        if (autonomousCommand != null) { autonomousCommand.cancel(); }
        // start the drive command.  This will remain active during teleop
        drive.start();
        // create and start the shooterElevationControl command 
       // shooterAngleCommand.start();
        // The initialize method of the acquisition roller will toggle it on
        //oi.roller.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        commonPeriodic();
    }
    
    private void commonPeriodic() {
        m_total_ticks++;
        
        updateDashboard();
    }

    /**
     * This function called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    // update frequency in times per second
    public static final int FREQUENCY = 10;
    public static final int TICKS_PER_SECOND = 50;
    public static int m_count = TICKS_PER_SECOND/FREQUENCY;
    public static void updateDashboard()
    {
         
        if (--m_count==0)
        {
            m_count = TICKS_PER_SECOND/FREQUENCY;
            SmartDashboard.putNumber("Ticks", m_total_ticks);
            try{
                if (RobotMap.swerveLeft != null) {
                    SmartDashboard.putNumber("encoder Left pos: ", RobotMap.swerveLeft.getPosition());
                    SmartDashboard.putNumber("encoder Right pos: ", RobotMap.swerveRight.getPosition());
                }
            } catch (CANTimeoutException ex) {
                ex.printStackTrace();
        }

        RobotMap.jags.UpdateDashboard();
                
        }
  
        
    }
    
    public static void debugOut(String label, String value)
    {
        System.out.println(label + " " + value);
        SmartDashboard.putString(label, value);
    }
    
    public static void debugOutBoolean(String label, boolean value)
    {
        System.out.println(label + " " + (value ? "true" : "false"));
        SmartDashboard.putBoolean(label, value);
    }

    public static void debugOutNumber(String label, double number)
    {
        System.out.println(label + " " + number);
        SmartDashboard.putNumber(label, number);
    }

}