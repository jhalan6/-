package csh.dhsjms.Calculator3;

public class SimpleCalculator {
	private float operated,operating;
	private String operate=null;
	private float cal() {
		if (operate=="+") {
			return operated+operating;
		}
		else if (operate=="-") {
			return operated-operating;
		}
		else if (operate=="*") {
			return operated*operating;
		}
		else if (operate=="/") {
			return operated/operating;
		}
		else {
			return 0;
		}
	}
	public String getErrorMessage() {
		return null;
	}
	public float run(float operated,String operate,float operating){
		this.operated=operated;
		this.operating=operating;
		this.operate=operate;
		return cal();
	}
}
