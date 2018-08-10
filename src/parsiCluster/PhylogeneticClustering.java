package parsiCluster;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class PhylogeneticClustering {
	
	public DiscribeTree BuildTree(int[][] relation, int[] out, int[][] data) {
		String name[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42" };
		int max;
		Map resultMap = new HashMap();
		String result = "";
		Index index = new Index();
		int num = index.getMinLength(data);

		
		GIndex gIndex = new GIndex();
		int gnum = gIndex.GetG(data);
//		System.out.println(gnum);		
		int length = 0;
		Reconstruction tree = new Reconstruction();
		tree.setDataMat(data);
		tree.setName(name);
		tree.setRelation(relation);
		tree.setOut(out);
		
		resultMap = tree.Do();
		length = length + (Integer) resultMap.get("P");
		data = tree.getNewData();
		name = tree.getNewName();

		while (tree.getMax() != 0) {

			tree.setDataMat(data);
			tree.setName(name);
			resultMap.clear();
			resultMap = tree.Do();
			length = length + (int) resultMap.get("P");
			
			data = tree.getNewData();
			name = tree.getNewName();

		}

//		System.out.println("Num£º"+num); 
//		System.out.println("Gnum£º"+gnum); 
		double CI = (double)num/length;
		double HI = 1 - CI;
		double RI = (double)(gnum-length)/(gnum-num);
		double RC = CI * RI;
		
		if (resultMap.containsKey("result")) {
			result = resultMap.get("result").toString();
			
		}
		DiscribeTree discribeTree = new DiscribeTree(result,CI,HI,RI,RC,length);
		
		return discribeTree;
	}

}
