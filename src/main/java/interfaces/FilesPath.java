package interfaces;

public interface FilesPath {
    String userDir = System.getProperty("user.dir") ;
    String homeDir = System.getProperty("user.home") ;
    String  excelFilePath = userDir + "//src//main//resources//dataProviders//excelFiles//";
    String  textFilePath = userDir + "//src//main//resources//dataProviders//textFiles//";
    String  jsonFilePath = userDir + "//src//main//resources//dataProviders//jsonFiles//";
    String  resourcesFilePath = userDir + "//src//main//resources//";
    String  reportsFilePath = userDir + "//src//main//resources//reports//";
    String  screenShotPath = userDir + "//src//main//resources//screenShots//";

}
