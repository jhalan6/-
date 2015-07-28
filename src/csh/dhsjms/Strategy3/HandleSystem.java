package csh.dhsjms.Strategy3;

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
			setErrorMessage("这也不是数啊！\n");;
			return 0;
		}
		return Float.parseFloat(floatString);
	}
	private void check() {
		if(getCount()<=0){
			setErrorMessage(getErrorMessage()+"数量不对\n");
		}
		if (getPrice()<=0) {
			setErrorMessage(getErrorMessage()+"价格不对\n");
		}
	}
	private void calculate() {
		setResult(getCount()*getPrice()); 
	}
	public void discount(String string) {
		DiscountFactory discountFactory=new DiscountFactory();
		if (string=="九折") {
			setResult(discountFactory.getDiscount("DaZhe").disCountResult(result, new String[]{"0.9"}));
		}
		else if (string=="八折") {
			setResult(discountFactory.getDiscount("DaZhe").disCountResult(result, new String[]{"0.8"}));
		}
		else if (string=="七折") {
			setResult(discountFactory.getDiscount("DaZhe").disCountResult(result, new String[]{"0.7"}));
		}
		else if (string=="六折") {
			setResult(discountFactory.getDiscount("DaZhe").disCountResult(result, new String[]{"0.6"}));
		}
		else if (string=="五折") {
			setResult(discountFactory.getDiscount("DaZhe").disCountResult(result, new String[]{"0.5"}));
		}
		else if (string=="满300减100") {
			setResult(discountFactory.getDiscount("").disCountResult(result, new String[]{"300","100"}));
		}
		else if(string=="满100减50"){
			setResult(discountFactory.getDiscount("").disCountResult(result, new String[]{"100","50"}));
		}
	}
}
abstract class Discount{
	abstract float disCountResult(float now,String[] args);
}
class DaZhe extends Discount{
	@Override
	float disCountResult(float now,String[] args) {
		return now*Float.parseFloat(args[0]);
	}
}
class ManJian extends Discount{
	@Override
	float disCountResult(float now, String[] args) {
		return (now-(int)now/Integer.parseInt(args[0])*Integer.parseInt(args[1]));
	}
	
}

class DiscountFactory{
	public Discount getDiscount(String string) {
		if (string=="DaZhe") {
			return new DaZhe();
		}
		else {
			return new ManJian();
		}
	}
}