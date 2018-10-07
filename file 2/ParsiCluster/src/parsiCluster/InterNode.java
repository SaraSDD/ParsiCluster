package parsiCluster;

import java.util.Random;
import java.util.Stack;

import javax.xml.transform.Templates;
public class InterNode {
	private int data[][];
	private String name[];
	private int dis[][];
	private Stack<String> resultStack = new Stack<String>();
	private String random[];
	private int relation[][];
	private int out[];
	
	private int n;

	public InterNode(int relation[][], int out[], int data[][], String name[], int dis[][]) {
		this.data = data;
		this.name = name;
		this.dis = dis;
		this.relation = relation;
		this.out = out;
	}

	public int[][] getData() {
		return data;
	}

	public String[] getName() {
		return name;
	}

	public void Do(int Max) {// ����������ֵ
		int row = data.length;
		int col = data[0].length;
		int max_same = 0;// Ϊͬһ������Ŀ

		for (int x = 0; x < row; x++) {
			for (int y = 0; y < row; y++) {
				if (dis[x][y] == Max) {
					if (dis[x][y] > max_same)
						max_same = dis[x][y];

				}
			}
		}

		OUT: for (int x = 0; x < row; x++) {
			for (int y = 0; y < row; y++) {
				if (dis[x][y] == Max && dis[x][y] == max_same) {
					//��X��Y���ж��ٸ�����ֵ
					int s = 0;
					int t = 0;
					for (int i = 0; i < data[0].length; i++) {
						if (data[x][i] != out[i] && data[x][i] > 0) {
							s++;
						}
						if (data[y][i] != out[i] && data[y][i] > 0) {
							t++;
						}
					}
					
				    int[] temp = new int[col];
				    int k = 0;
					for (int i = 0; i < col; i++) {
						if(data[x][i] == data[y][i] && data[y][i]!= out[i])
							temp[i] = data[x][i];
						else if (data[x][i] < 0 || data[y][i] < 0)
						{
							while(k < temp.length && relation[k][i] < 0)
								k++;
							if(k < temp.length)
							{
								if(data[x][k] == temp[k])
									temp[i] = data[x][i];
								if(data[y][k] == temp[k])
									temp[i] = data[y][i];
							}
						}
						else if((data[x][i] == out[i] && data[y][i] >= 0) || (data[y][i] == out[i] && data[x][i] >= 0))
							temp[i] = out[i];
						else
							temp[i] = -1;

					}
					data[x] = temp;
					//***************************����ϲ����ж��ٸ�����ֵ
					int r=0;
					for (int i = 0; i < data[0].length; i++) {
						if (data[x][i] != out[i] && data[x][i] > 0) {
							r++;
						}
					}
					int p = s + t -2*r;
					this.setN(p);
					System.out.println("**************");
					System.out.println(s);
					System.out.println(t);
					System.out.println(r);
					System.out.println(p);
					for (int i = 0; i < col; i++)
						data[y][i] = -1;// ��y����Ϊ-1���
					name[x] = "(" + name[x] + "," + name[y] + ")";
					name[y] = "null";
//					resultStack.push(x + "," + y);
					break OUT;

				}
			}
		}
		
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

}
