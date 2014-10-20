package ua.fesvlast.tim.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Tim on 29.09.2014.
 */
public class EnterData {
    private BufferedReader reader =null;

    public EnterData(){
        reader =new BufferedReader(new InputStreamReader(System.in));
    }

    public File inputDirectoryPath() throws IOException {
        File dir =null;
        while(true){
            System.out.println("Input the absolute folder's path for searching files: ");
            String str=reader.readLine();
            if(str.equalsIgnoreCase("exit")) break;
            dir =new File(str);
            System.out.println(dir);
            if(dir.isDirectory()){
                break;
            }else{
                System.out.println("Wrong path for searching files");
            }
        }
        System.out.println("OK");
        return dir;
    }

    public String inputFileExtension() throws IOException {
        StringTokenizer token=null;
        String extention =null;
        while(true){
            System.out.println("Input file's extension, that you are looking for: ");
            String str=reader.readLine();
            if(str.equalsIgnoreCase("exit")) break;
            token=new StringTokenizer(str, ",.\\/ ;:-!$#&^{[}]|~'\"");
            extention =token.nextToken();
            if(extention!=null && !extention.isEmpty() && token.countTokens()==0){
                break;
            }else{
                System.out.println("Wrong extension for searching files");
            }
        }
        System.out.println("OK");
        return extention;
    }
}
