package filecopyer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
public class Main {

	public static void main(String[] args) throws IOException{
		if(args.length>=2) {
			String mode = args[0];
			String srcPath = args[1]; 
			String destPath = args[2];
			switch(mode) {
			case "a": fileCopyAsync(srcPath,destPath);
			break;
			case "s": fileCopySync(srcPath,destPath);
			break;   
			default : System.out.println("No matching mode specified");
			}

		}
	}

	public static void fileCopyAsync(String srcPath ,String destPath) throws IOException {
		File inpFile = new File(srcPath);
		System.out.println("async before copy" + System.currentTimeMillis());
		if(inpFile.exists() && inpFile.isFile()) {
			File destFile = new File(destPath);
			FileUtils.copyFile(inpFile, destFile);
		}
		System.out.println("async after copy" + System.currentTimeMillis());
	}

	public static void fileCopySync(String srcPath ,String destPath) throws IOException {
		File inpFile = new File(srcPath);
		File outFile = new File(destPath);
		System.out.println("sync before copy" + System.currentTimeMillis());
		if(inpFile.exists() && inpFile.isFile()) {
			FileInputStream inputStream = new FileInputStream(inpFile);
			FileOutputStream outputStream = new FileOutputStream(outFile);
			BufferedInputStream bis = new BufferedInputStream(inputStream);
			BufferedOutputStream bos = new BufferedOutputStream(outputStream);
			int len =  (1024*1024);
			while(bis.available() > 0) {
				byte[] buffer = new byte[1024*1024];
				int read = bis.readNBytes(buffer, 0, len);
				bos.write(buffer,0,read);
			}
			bos.flush();
			bis.close();
			bos.close();
			System.out.println("sync after copy" + System.currentTimeMillis());
		}
	}



}
