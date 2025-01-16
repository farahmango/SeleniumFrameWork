package utils;

import helpers.ActionHelper;
import interfaces.FilesPath;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.Base;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class FileUtils extends Base {

    /**
     * <write in a text file>
     * @param filePath       file path to write in
     * @param data           to write data
     **/
    public static void writeIntoFile(String filePath, String data) {
        try {
            FileWriter writer = new FileWriter(filePath, false);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <read from a text file>
     * @param filePath       file path to read from
     * return data as a string
     **/
    public static String readFromFile(String filePath) {
        String data;
        try {
            data = Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    /**
     * <read from file>
     * @param filePath       file path to read from
     * return the file input as FileInputStream
     **/
    public static FileInputStream readFile(String filePath) {
        File file = new File(filePath);
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (Throwable e) {
            e.printStackTrace(System.out);
        }
        return fileInput;
    }

    /**
     * <read from properties file>
     * @param filePath       file path to read from
     * @param param          the value that you want to red
     * return the data as string
     **/
    public static String readPropertiesFile(String filePath, String param) {
        FileInputStream file = readFile(filePath);
        Properties pro = new Properties();
        try {
            pro.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String data = pro.getProperty(param);
        return data;
    }

    /**
     * <upload file from your home directory>
     * @param button            file upload button
     * @param filePath          the file that you want to download
     **/
    public static void uploadLocalFile(By button, String filePath) {
        ActionHelper.clickAction(button);
        ActionHelper.driverWait(2000);
        StringSelection strSelection = new StringSelection(filePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(strSelection, null);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    /**
     * <check that the file is downloaded successfully>
     * @param File            file that you want to check
     * return boolean true or false
     **/
    public static boolean isFileDownloaded(String File) {
        String filepath = FilesPath.homeDir + "\\Downloads";
        String fileName = File;
        File dir = new File(filepath);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    System.out.println(file.getName());
                    System.out.println(fileName);
                    System.out.println("The file downloaded successfully");
                    return true;
                }
            }
        }
        return false;
    }


    /***
     * copy file to a new file
     * @param sourceFile                file that you want to copy
     * @param destinationFile           destination File to paste
     ***/
    public static void copyFile(File sourceFile, String destinationFile) {
        try {
            org.apache.commons.io.FileUtils.copyFile(sourceFile, new File(destinationFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String encodeFileToBase64Binary()  {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileInputStream fileInputStreamReader = null;
        try {
            fileInputStreamReader = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] bytes = new byte[(int) file.length()];
        try {
            fileInputStreamReader.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(Base64.encodeBase64(bytes), StandardCharsets.UTF_8);
    }
}
