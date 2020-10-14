import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

/**
 * Created by neetikasrivastava on 3/09/20.
 */
public class ReadWrite {

    public static void main(String[] args){

        String loc = "readme.txt";

        ReadWrite rw = new ReadWrite();
        rw.read(loc);

    }

    public void read(String path){
        String writeLoc = "writeInMe.txt";
        String writeLoc2 = "writeInMe.txt";
        StringBuilder st = new StringBuilder();


        try(Stream<String> lines = Files.lines(Paths.get(path))){
            //lines.forEach(System.out::println);
            lines.forEach(x -> st.append(x+"\n"));
            //lines.forEach(x -> fileWrite(writeLoc2, x));
            System.out.println("End of file");


        }catch(IOException io){
            io.printStackTrace();
        }
        fileWrite(writeLoc,st.toString());

    }


    public Path getPath(String s){
        return Paths.get(s);
    }

    public  void write(String path, String s){
        try(BufferedWriter wr = Files.newBufferedWriter(Paths.get(path))){
            wr.write(s);
        }catch(IOException io){
            io.printStackTrace();
        }
    }
    public  void fileWrite(String path, String s){
        try{
            Files.write(Paths.get(path),s.getBytes(), StandardOpenOption.CREATE);
        }catch(IOException io){
            io.printStackTrace();
        }
    }

}
