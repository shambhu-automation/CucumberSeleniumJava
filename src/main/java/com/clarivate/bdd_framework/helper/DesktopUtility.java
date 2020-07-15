package com.clarivate.bdd_framework.helper;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;



public class DesktopUtility {
	Logger logger = LoggerHelper.getLogger(Utility.class);
	public static WiniumDriver winiumDriver;

    /**
     * This  method is used to initialize a winium driver object based on the Desktop application
     * @param desktopApp This is the enum DesktopApps to map the path of the application
     * @param hostServer This is the server - host:port to host the winium driver ex. locslhost:9999
     * @return WiniumDriver object after initializing it.
     */
    public WiniumDriver initDriver(String hostServer) throws MalformedURLException {
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath("C:\\Windows\\System32\\calc.exe");
        winiumDriver = new WiniumDriver(new URL(hostServer),options);
        return winiumDriver;
    }
}
