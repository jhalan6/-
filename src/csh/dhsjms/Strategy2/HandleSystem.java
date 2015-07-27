package csh.dhsjms.Strategy2;

public class HandleSystem {
	private float price,count,result;
	private String errorMessage=null;
	public HandleSystem(String price,String count,String string) {
		setCount(checkAndExchange(count));
		setPrice(checkAndExchange(price));
		check();
		calculate();
		discount(string);
	}
	
	
	public float getCount() {
		return count;
	}
	public void setCount(float count) {
		this.count = count;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public float getResult(){
		return this.result;
	}
	public void setResult(float result) {
		this.result = result;
	}
	private float checkAndExchange(String floatString) {

		try {
			Float.parseFloat(floatString);
		} catch (Exception e) {
			setErrorMessage("这也不是数啊！");;
			return 0;
		}
		return Float.parseFloat(floatString);
	}
	
	private void check() {
		if(getCount()<=0){
			setErrorMessage(getErrorMessage()+"\n"+"数量不对");
		}
		if (getPrice()<=0) {
			setErrorMessage(getErrorMessage()+"\n"+"价格不对");
		}
	}
	private void calculate() {
		setResult(getCount()*getPrice()); 
	}
	
	public void discount(String string) {
		if (string=="0.8") {
			setResult((float) (getResult()*0.8));
		}
	}


}
