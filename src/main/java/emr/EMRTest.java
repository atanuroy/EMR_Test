package emr;
import org.apache.commons.cli.*;

import java.io.*;

public class EMRTest {
    public static void main(String[] args) throws ParseException, IOException {
        CommandLineParser parser = new DefaultParser();

        Options options = new Options();
        options.addOption( "o", "output", true, "output file" );
        options.addOption( "i", "input", true, "input directory" );
        CommandLine line = parser.parse( options, args );
        String inLoc = line.getOptionValue("i", "/mnt/DataTest");
        String outLoc = line.getOptionValue("o", "/mnt/ResultTest/results.txt");
        File para_dir = new File(inLoc);
        String[] fileList = para_dir.list();
        BufferedWriter out = new BufferedWriter(new FileWriter(outLoc));
        for(String f: fileList) {
            BufferedReader in = new BufferedReader(new FileReader(inLoc + "/" + f));
            String l = "";
            int lc = 0;
            while((l = in.readLine()) != null){
                lc++;
            }
            out.write("File: " + f + " has " + lc + " lines\n");
            in.close();
        }
        out.flush();
        out.close();
        System.out.println("Run Done");
    }
}
