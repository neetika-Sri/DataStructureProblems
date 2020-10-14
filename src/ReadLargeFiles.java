import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
/*
public class ReadLargeFiles {
    public static void main(String[] args) {

    }
    public void readFile() {
        try {
            RandomAccessFile aFile = new RandomAccessFile("readMe.txt","r");
            FileChannel inChannel = aFile.getChannel();
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());

            buffer.load();
            CharBuffer



        }catch(IOException io){

        }
    }
}*/
/*import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

    public class ByteBufferRead {

        public static void main(String[] args) {

            long startTime = System.nanoTime();

            try {
                RandomAccessFile aFile = new RandomAccessFile("c:/temp/my-large-file.csv", "r");
                FileChannel inChannel = aFile.getChannel();
                MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());

                buffer.load();

                CharBuffer charBuffer = StandardCharsets.US_ASCII.decode(buffer);
                String read = charBuffer.toString();

                //System.out.println(read);

                buffer.clear(); // do something with the data and clear or compact it.
                inChannel.close();
                aFile.close();

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

            long endTime = System.nanoTime();
            long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
            System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
        }
    }
}*/
