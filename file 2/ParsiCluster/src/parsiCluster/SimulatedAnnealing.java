package parsiCluster;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SimulatedAnnealing {
	
	public static void main(String[] args) throws Exception {
		List<DiscribeTree> describeTreeList = new ArrayList<DiscribeTree>();
		// TODO Auto-generated method stub
		read r = new read();
		File dataFileReal = new File("./res/d.txt");
		File dataMatrix = new File("./res/r.txt");
		int data[][] = read.loadData(dataFileReal);
		int relation[][] = read.loadData(dataMatrix);
		int out[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};//指定外类群
		DiscribeTree discribeTree = new DiscribeTree();
		PhylogeneticClustering  method = new PhylogeneticClustering();
		int[][] Datanew = new int[data.length][data[0].length];
		for (int i = 0; i < Datanew.length; i++) {
			Datanew[i] = data[i].clone();
		}
		discribeTree = method.BuildTree(relation, out, Datanew);
		discribeTree.toString();
		
		int[] bestout = out.clone();
		DiscribeTree bestTree = discribeTree.Clone(discribeTree);
		bestTree.toString();
		
		double TreeLength = 5;
		int bestTnum = 1;
		int Tnum = 1;
		while (Tnum < bestTnum ) {
			int MaxGen = 1; 
		    int generate = 0;
		    while(generate < MaxGen) {
		         
		        Polarization polar = new Polarization();
		        int[][] dataCopy = new int[data.length][data[0].length];
		        for (int i = 0; i < dataCopy.length; i++) {
		        	dataCopy[i] = data[i].clone();
	    		}
				for (int i = 0; i < dataCopy.length; i++) {
					System.arraycopy(data[i], 0, dataCopy[i], 0, data.length);
				}
		        int[] newout = polar.polar(dataCopy);
		        while (Math.random() < 0.5) {
		        	dataCopy = new int[data.length][data[0].length];
		        	for (int i = 0; i < dataCopy.length; i++) {
		        		dataCopy[i] = data[i].clone();
		    		}
//					for (int i = 0; i < dataCopy.length; i++) {
//						System.arraycopy(data[i], 0, dataCopy[i], 0, data.length);
//					}
			        newout = polar.polar(dataCopy);
		        	}
		        DiscribeTree discribeTreenew = new DiscribeTree();
		        int[][] datanew = new int[data.length][data[0].length];
		        for (int i = 0; i < datanew.length; i++) {
		        	datanew[i] = data[i].clone();
	    		}
		        for (int i = 0; i < datanew.length; i++) {
					System.arraycopy(data[i], 0, datanew[i], 0, data.length);
				}
		        discribeTreenew = method.BuildTree(relation, newout, datanew);
				double diertaF = discribeTreenew.getLength() - discribeTree.getLength();
			    if (diertaF > 0) {
					bestout = newout.clone();
					bestTree = discribeTree.Clone(discribeTreenew);
				}
			    else {
			    	if (Math.exp(diertaF/TreeLength) > Math.random()) {
			    		bestout = newout.clone();
			    		bestTree = discribeTree.Clone(discribeTreenew);;
					}
			    }
			    generate = generate+1; 
		    }
//		   List describeTreeLisr = new ArrayList<DiscribeTree>(); 
		   String isEqual = "";
		    if (!isEqual.contains(bestTree.isStringEqual())) {
				   describeTreeList.add(bestTree);
				   isEqual = isEqual + bestTree.isStringEqual();
			}
//		   System.out.println(Arrays.toString(bestout));
		   Tnum ++;
		}
		for (DiscribeTree i : describeTreeList) {
//			System.out.println(i.getTopology());
			i.toString();
		}
	}


}
