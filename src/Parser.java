import java.util.*;
import java.io.*;

public class Parser {

    Map result;

    public Parser() {
        this.result = new HashMap<String, Integer>();
    }

    public void read(String file) {
        StringBuilder buffer = new StringBuilder();
        int maxBufferSize = 500;
        try {
            FileReader reader = new FileReader(file);
            int character;
            while ((character = reader.read()) != -1) {
                buffer.append((char) character);
                if (buffer.length() == maxBufferSize) {
                    parse(buffer,false);
                }
                                //System.out.print((char)character);
                //
            }
            if (buffer.length() > 0){
                parse(buffer,true);
            }
        } catch (IOException ex) {
            ex.printStackTrace();

        }
        result.entrySet().stream().forEach(System.out::println);
    }

    private void parse(StringBuilder buffer, boolean isLastBuffer) {
        String[] words = buffer.toString().split("[ –—\n\r\t\\(\\)\\[\\]:;\"\\?!\\., ><\\{\\}\\\\|/\\\\\\$#=_\\+'`~@%&*-]");
        if(isLastBuffer){
            for (int i = 0; i< words.length; i++) {
               if(!words[i].equals("")) {
                   //System.out.println(words[i]);
               }
            }
        }else {
            for (int i = 0; i< words.length-1; i++) {
                if(!words[i].equals("")) {
                    //System.out.println(words[i]);
                    }
            }
            buffer.delete(0, buffer.length());
            buffer.append(words[words.length-1]);
        }
        for (int i = 0; i< words.length; i++) {
            if (result.containsKey(words[i])) {
                result.put(words[i],(Integer)result.get(words[i]) + 1);
            }else {
                result.put(words[i],1);
            }
        }

    }
}
