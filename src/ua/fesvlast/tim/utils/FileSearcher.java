package ua.fesvlast.tim.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 28.09.2014.
 */
public class FileSearcher {
    private int countFiles =0;
    private int countDir=0;
    private int countTotalFiles=0;
    private int countNPE=0;

    private File dir;
    private String extension;
    private List<File> listFiles =new ArrayList<File>();

    public FileSearcher(File dir, String extension){
        this.dir=dir;
        this.extension=extension;
    }

    public int getCountTotalFiles() {
        return countTotalFiles;
    }

    public int getCountFiles() {
        return countFiles;
    }

    public int getCountDir() {
        return countDir;
    }
    public int getCountNPE() {
        return countNPE;
    }

    public File getDir() {
        return dir;
    }

    public String getExtension() {
        return extension;
    }


    public List<File> findFiles(){
        scanDirectory(dir);
        return listFiles;
    }

    private void scanDirectory(File rootDir){
        File[] list =rootDir.listFiles();

        for(int i=0; i<list.length; i++){
            if(list[i].isDirectory()){
                countDir++;
               // System.out.println(list[i]);
                   try{
                       scanDirectory(list[i]);
                   }catch (NullPointerException e){
                       countNPE++;
                       System.out.println("Forbidden to read this directory!");
                       System.out.println("Searching is going on.....");
                       continue;
                   }
            }else{
                countTotalFiles++;
                String fileStr =list[i].getName().toLowerCase();
                if(fileStr.endsWith(extension)){
                    countFiles++;
                    listFiles.add(list[i]);
                }
            }
        }
    }



}
