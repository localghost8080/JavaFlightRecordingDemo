package filecopyer;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
public class Main {

	public static void main(String[] args) throws IOException{
	   if(args.length>=2) {
		   String srcPath = args[0]; 
		   String destPath = args[1];		   
		   fileCopy(srcPath,destPath);
	   }
	}
	
	public static void fileCopy(String srcPath ,String destPath) throws IOException {
		File inpFile = new File(srcPath);
		if(inpFile.exists() && inpFile.isFile()) {
			File destFile = new File(destPath);
			FileUtils.copyFile(inpFile, destFile);
		}
	}

}
