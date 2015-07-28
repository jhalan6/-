package csh.dhsjms.Strategy4;

public class HandleSystem {
	private float price,count,result;
	private String errorMessage=null;
	public HandleSystem(String price,String count,String string) {
		this.count=checkAndExchange(count);
		this.price=checkAndExchange(price);
		check();
		calculate();
		discount(string);
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public float getResult(){
		return this.result;
	}
	private float checkAndExchange(String floatString) {

		try {
			Float.parseFloat(floatString);
		} catch (Exception e) {
			errorMessage="这也不是数啊！\n";
			return 0;
		}
		return Float.parseFloat(floatString);
	}
	private void check() {
		if(count<=0){
			errorMessage=getErrorMessage()+"数量不对\n";
		}
		if (price<=0) {
			errorMessage=getErrorMessage()+"价格不对\n";
		}
	}
	private void calculate() {
		result=count*price; 
	}
	private void discount(String string) {
	DiscountContext discountContext=new DiscountContext(string);
	result=discountContext.returnResult(getResult());
}
}
abstract class Discount{
	abstract float disCountResult(float now);
}
class DaZhe extends Discount{
	private float discount=1;
	DaZhe(float discount) {
		this.discount=discount;
	}
	@Override
	float disCountResult(float now) {
		return now*discount;
	}
}
class ManJian extends Discount{
	private int argument1,argument2;
	ManJian(int arg1,int arg2) {
		argument1=arg1;
		argument2=arg2;
	}
	@Override
	float disCountResult(float now) {
		return (now-(int)now/argument1*argument2);
	}
	
}
class Wu extends Discount{
	@Override
	float disCountResult(float now) {
		return now;
	}
	
}
class DiscountContext{
	private Discount discount=null;
	DiscountContext(String string) {
		if (string=="九折") {
			discount=new DaZhe(0.9f);
		}
		else if (string=="八折") {
			discount=new DaZhe(0.8f);
		}
		else if (string=="七折") {
			discount=new DaZhe(0.7f);
		}
		else if (string=="六折") {
			discount=new DaZhe(0.6f);
		}
		else if (string=="五折") {
			discount=new DaZhe(0.5f);
		}
		else if (string=="满300减100") {
			discount=new ManJian(300,100);
		}
		else if(string=="满100减50"){
			discount=new ManJian(100,50);
		}
		else if(string=="无") {
			discount=new Wu();
		}
	}
	float returnResult(float now) {
		return discount.disCountResult(now);
		
	}
}