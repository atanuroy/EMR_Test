package emr;
import org.apache.commons.cli.*;

import java.io.*;

public class EMRTest {
    public static void main(String[] args) throws IOException {
        try{
            BufferedWriter out1 = new BufferedWriter(new FileWriter("/mnt/ResultTest/1.txt"));
            for(String arg: args){
                out1.write(arg + "\n");
            }
            out1.flush();
            out1.close();

            CommandLineParser parser = new DefaultParser();
            OptionGroup og = new OptionGroup();
            Option option = new Option("o", "output", true, "output file");

            og.addOption(option);
            org.apache.commons.cli.Options options = new org.apache.commons.cli.Options();
//            options.addOption( "o", "output", true, "output file" );
            options.addOptionGroup(og);


//        options.addOption( "i", "input", true, "input directory" );
            CommandLine line = parser.parse( options, args );
//        String inLoc = line.getOptionValue("i", "/mnt/DataTest");
//        String inLoc = "/mnt/DataTest";
//        String inLoc = "H:\\Test\\DataTest";
            String outLoc = line.getOptionValue("o", "/mnt/ResultTest/results.txt");
//        String outLoc = "/mnt/ResultTest/results.txt";
            String inLoc = args[0];
//        String outLoc = args[1];
//        String outLoc = "H:\\Test\\ResultTest\\Res1.txt";
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
//        out.write("test file");
            out.flush();
            out.close();
            System.out.println("Run Done");
        }
        catch(IOException e){
            BufferedWriter out = new BufferedWriter(new FileWriter("/mnt/Exception/IO.txt"));
            StackTraceElement[] se = e.getStackTrace();
            for(StackTraceElement s : se){
                out.write(s.toString() + "\n");
            }
            out.flush();
            out.close();
        }
        catch(ParseException pe){
            BufferedWriter out = new BufferedWriter(new FileWriter("/mnt/Exception/PE.txt"));
            StackTraceElement[] se = pe.getStackTrace();
            for(StackTraceElement s : se){
                out.write(s.toString() + "\n");
            }
            out.flush();
            out.close();
        }
        catch(Exception ex){
            BufferedWriter out = new BufferedWriter(new FileWriter("/mnt/Exception/Ex.txt"));
            StackTraceElement[] se = ex.getStackTrace();
            for(StackTraceElement s : se){
                out.write(s.toString() + "\n");
            }
            out.flush();
            out.close();
        }
        catch(Throwable th){
            BufferedWriter out = new BufferedWriter(new FileWriter("/mnt/Exception/Th.txt"));
            StackTraceElement[] se = th.getStackTrace();
            for(StackTraceElement s : se){
                out.write(s.toString() + "\n");
            }
            out.flush();
            out.close();
        }

        finally{
            BufferedWriter out1 = new BufferedWriter(new FileWriter("/mnt/ResultTest/2.txt"));
            out1.write("Jestin John \n");
            out1.flush();
            out1.close();
        }


    }
}
