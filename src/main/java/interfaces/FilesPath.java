package interfaces;

public interface FilesPath {
    String userDir = System.getProperty("user.dir") ;
    String homeDir = System.getProperty("user.home") ;
    String  resourcesFilePath = userDir + "//src//main//resources//";
    String  reportsFilePath =resourcesFilePath + "reports//";
    String  excelFilePath =  resourcesFilePath +"dataProviders//excelFiles//";
    String  textFilePath = resourcesFilePath +"dataProviders//textFiles//";
    String  jsonFilePath = resourcesFilePath+"dataProviders//jsonFiles//";
    String  screenShotPath = resourcesFilePath +"screenShots//";

}
