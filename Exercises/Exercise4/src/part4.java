import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class part4 {

	//generates an array of random doubles
	public static double[] generateRandomArray (int size) {
		double[] rands = new double[size];
		for (int i = 0; i < size; i++) {
			rands[i] = Math.random();	
		}
		return rands;
	}
	
	//obtains the size in bytes of the provided file
	public static long getFileSize(String filename) {
		Path file = Paths.get(filename);
		long fileSize = 0;
		try {
			fileSize = Files.size(file);
		} catch (IOException err){
			System.out.println("IO Exception " + err);
		}
		return fileSize;
	}
	
	//Display results
	public static void displayResults(String filename, long runTimeNanoSeconds) {
		System.out.printf("\n%-34s", filename);
		System.out.printf("%8d bytes, saved in:", getFileSize(filename.trim()));
		System.out.printf("%7.2f milliseconds. \n", runTimeNanoSeconds * 1e-6);
	}
	
	public static void main(String[] args) {
		

		
	}

}
