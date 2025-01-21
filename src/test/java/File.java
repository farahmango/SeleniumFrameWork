import interfaces.FilesPath;
import org.testng.annotations.Test;
import utils.FileUtils;


public class File {


    @Test
    public void writeIntoFile() {
        FileUtils.writeIntoFile(FilesPath.textFilePath+ "Data.text", "Farah");
    }
    @Test
    public void readFromFile() {
       String data =  FileUtils.readFromFile(FilesPath.textFilePath+ "Data.text");
       System.out.println(data);
    }
    @Test
    public void isFileDownloaded() {
       boolean data =  FileUtils.isFileDownloaded("Flight Booking Websites.pdf");
       System.out.println(data);
    }
}
