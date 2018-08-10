package parsiCluster;

public class DiscribeTree implements Cloneable {
	private String  Topology;
	private double CI;
	private double HI;
	private double RI;
	private double RC;
	private int Length;
	
	public DiscribeTree() {
		
	}
	
	public DiscribeTree(String topology , double ci , double hi , double ri , double rc , int length) {
		this.setTopology(topology);
		this.setCI(ci);
		this.setHI(hi);
		this.setRI(ri);
		this.setRC(rc);
		this.setLength(length);
	}
	public String toString() {
		System.out.println("ÍØÆË½á¹¹£º"+ Topology);
		System.out.println("Ê÷³¤£º"+ Length);
//		System.out.println("CI:" +String.format("%.2f", CI));
//		System.out.println("HI:" +String.format("%.2f", HI));
//		System.out.println("RI:" +String.format("%.2f", RI));
//		System.out.println("RC:" +String.format("%.2f", RC));
		return Topology + Length + CI + HI + RI + RC;
	}
	
	public String isStringEqual() {
		return Topology + Length + CI + HI + RI + RC;
	}
	
	public DiscribeTree Clone(DiscribeTree tree) {
		DiscribeTree newtree = new DiscribeTree();
		String  Topology = tree.getTopology();
		double CI = tree.getCI();
		double HI = tree.getHI();
		double RI = tree.getRI();
		double RC = tree.getRC();
		int Length = tree.getLength();
		newtree.setTopology(Topology);
		newtree.setCI(CI);
		newtree.setHI(HI);
		newtree.setRI(RI);
		newtree.setRC(RC);
		newtree.setLength(Length);
		return newtree;
	}
	
	@Override  
    protected Object clone() throws CloneNotSupportedException {  
        return super.clone();  
    } 
	
	public String getTopology() {
		return Topology;
	}
	public void setTopology(String topology) {
		Topology = topology;
	}
	public double getCI() {
		return CI;
	}
	public void setCI(double cI) {
		CI = cI;
	}
	public double getHI() {
		return HI;
	}
	public void setHI(double hI) {
		HI = hI;
	}
	public double getRI() {
		return RI;
	}
	public void setRI(double rI) {
		RI = rI;
	}
	public double getRC() {
		return RC;
	}
	public void setRC(double rC) {
		RC = rC;
	}
	public int getLength() {
		return Length;
	}
	public void setLength(int length) {
		Length = length;
	}

}
