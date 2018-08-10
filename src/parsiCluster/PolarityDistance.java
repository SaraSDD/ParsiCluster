package parsiCluster;

import java.util.Random;
import java.util.Stack;

public class PolarityDistance {
	private int data[][];
	private int dis[][];
	private int out[];

	public PolarityDistance(int[] out, int data[][]) {
		this.data = data;
		this.out = out;
	}

	public int[][] getData() {
		return dis;
	}

	public void Do() {
		int row = data.length;
		int col = data[0].length;
		this.dis = new int[row][row];
		for (int i = 0; i < row; i++)
			for (int j = i + 1; j < row; j++) {
				int count1 = 0;// ÏàÍ¬ÑÜÕ÷Êý
				for (int k = 0; k < col; k++) {
					if (data[i][k] == data[j][k] && data[i][k] != out[k] && data[i][k] > 0 && data[j][k] > 0) {
						count1++;
					}

				}
				dis[i][j] = count1  ;
			}

	}
	
}