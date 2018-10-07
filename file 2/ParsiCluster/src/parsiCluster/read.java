package parsiCluster;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class read {

	static int[][] loadData(File file) throws FileNotFoundException{
		Scanner fileScanner = new Scanner(file);
		
		int rows = fileScanner.nextInt();
		int cols = fileScanner.nextInt();
		
		int[][] data = new int[rows][cols];
		
		for(int i =0; i<rows; i++) {
			for(int j=0;j<cols;j++) {
				data[i][j] = fileScanner.nextInt();
			}
		}
		return data;

	}
}
