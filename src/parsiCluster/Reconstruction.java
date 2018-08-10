package parsiCluster;

import java.util.HashMap;
import java.util.Map;

public class Reconstruction {
	private int dataMat[][];
	private String name[];
	private int newData[][];
	private String newName[];
	int max;
	private int out[];
	private int relation[][];

	public int[][] getRelation() {
		return relation;
	}

	public void setRelation(int[][] relation) {
		this.relation = relation;
	}

	public int[] getOut() {
		return out;
	}

	public void setOut(int[] out) {
		this.out = out;
	}

	public void setDataMat(int newMat[][]) {
		dataMat = newMat;
	}

	public void setName(String[] newName) {
		name = newName;
	}

	public int[][] getNewData() {
		return newData;
	}

	public String[] getNewName() {
		return newName;
	}

	public int getMax() {
		return max;
	}

	public Map Do() {
		int p = 0;;
		int row = dataMat.length;
		int col = dataMat[0].length;
		Map resultMap = new HashMap();
		System.out.println("Original Matrix");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				System.out.print(dataMat[i][j] + " ");
			System.out.println();
		}

		PolarityDistance dis = new PolarityDistance(out,dataMat);
		dis.Do();
		int b[][] = dis.getData();
		System.out.println("Distance Matrix");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++)
				System.out.print(String.format("%-6s", b[i][j] + " "));
			System.out.println();
		}
		this.max = 0;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < row; j++)
				if (b[i][j] > this.max)
					this.max = b[i][j];
		System.out.println("Max Distance");
		System.out.println(max);
		if (max == 0) {
			for (int i = 0; i < dataMat.length; i++) {
				for (int j = 0; j < dataMat[0].length; j++) {
					if (dataMat[i][j] != out[j] && dataMat[i][j] > 0) {
						 p++;//当无共同衍征时，统计各个种群独有衍征的数目
					}
				}
				
			}
			StringBuffer result = new StringBuffer() ;
			System.out.println("Tree Diagram");
			System.out.println("(" + newName[0] + "," + newName[1] + ")");
			
			result.append("(");
			
			
			for (int i = 0; i < newName.length; i++) {
				if (i == newName.length - 1) {
					result.append(newName[i]);
				}else {
					result.append(newName[i] + ",");
				}
				
			}
			result.append(")");
			System.out.println(result.toString());
			
			resultMap.put("result", result);
			resultMap.put("P", p);
			
		} else {

			InterNode mer = new InterNode(relation,out,dataMat, name, b);
			mer.Do(max);
			p = mer.getN();
		
			int c[][] = mer.getData();
			name = mer.getName();

			int count = 0;
			for (int i = 0; i < row; i++)
				if (name[i] == "null")
					count++;
			int newLine = row - count;
			this.newName = new String[newLine];
			this.newData = new int[newLine][col];
			int lin = 0;
//			System.out.println("row: " + row + ";" + "name.length: " + name.length);
			for (int i = 0; i < row; i++) {
				if (name[i] != "null") {
					newName[lin] = name[i];
					for (int k = 0; k < col; k++)
						newData[lin][k] = c[i][k];
					lin++;
				}
			}

			System.out.println("New Matrix");
			for (int i = 0; i < newLine; i++) {
				for (int j = 0; j < col; j++)
					System.out.print(newData[i][j] + " ");
				System.out.println();
			}
			System.out.println("Tree Diagram");
			for (int i = 0; i < newLine; i++)
				System.out.println(newName[i]);
			
			resultMap.put("P", p);

		}
		return resultMap;
	}

}
