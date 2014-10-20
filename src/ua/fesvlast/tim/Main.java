package ua.fesvlast.tim;

import ua.fesvlast.tim.utils.EnterData;
import ua.fesvlast.tim.utils.FileSearcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	    System.out.println("Console File Searcher.");
        List<File> list =null;
        EnterData enter =new EnterData();
        File dir =enter.inputDirectoryPath();
        String extention =enter.inputFileExtension();
        System.out.println("Directory: "+dir+" Extension: "+extention);
        System.out.println("-------------------------------------------------------------------------------");
        FileSearcher searcher =new FileSearcher(dir,extention);

        list=searcher.findFiles();
        if(list.isEmpty()){
            System.out.println("Application hasn't found  files in this folder.");
        }else {
            for(File file :list){
                System.out.println(file);
            }
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("TOTAL FILES IN DIRECTORY: "+searcher.getCountTotalFiles());
            System.out.println("COUNT FOUND FILES["+extention+"] "+searcher.getCountFiles());
            System.out.println("COUNT FOUND DIRECTORIES: "+searcher.getCountDir());
            System.out.println("COUNT NPE: "+searcher.getCountNPE());
        }
    }


}
