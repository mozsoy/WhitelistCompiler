
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Metehan
 */
public class MainWhitelistCompiler {

    // Whitelist providers flags
    static boolean top1000flag = false;
    static boolean alexa500flag = true;

    public static void main(String[] args) {
        if (top1000flag) {
            Top1000Compiler top1000compiler = new Top1000Compiler();
            ArrayList<String> top1000whitelist
                    = top1000compiler.downloadTOP1000Whitelist();
            System.out.println(top1000whitelist);
        }
        if (alexa500flag) {
            Alexa500Compiler alexa500compiler = new Alexa500Compiler();
            String zipFile = alexa500compiler.downloadAlexaZipFile();
            ArrayList<String> csvFiles
                    = ZipUtil.unZipIt(zipFile, alexa500compiler.OUTPUT_FOLDER);
            System.out.println(csvFiles.get(0));
            ArrayList<String> alexaWhitelist
                    = alexa500compiler.readAlexaWhitelistFromCsvFile(
                            alexa500compiler.OUTPUT_FOLDER + csvFiles.get(0));
            for (int i = 0; i < 30; i++) {
                System.out.println(alexaWhitelist.get(i));
            }
        }
    }
}
