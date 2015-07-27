package csh.dhsjms.Calculator1;
//工厂方法模式（可能应该把继承改成interface）
import java.util.Scanner;

public class Calculator1 {
	private static float operated=0;
	static float operating=0;
	static float result=0;
	private static char operate='+';
	public static void main(String[] args) {
		while(true){
			input();
			chooseRightFactory();
			output();
		}
	}
	@SuppressWarnings("resource")
	public static void input(){
		System.out.println("请输入浮点型数字A：");
		setOperated(new Scanner(System.in).nextFloat());
		System.out.println("请输入操作符：");
		String string=new Scanner(System.in).nextLine();
		char[] chars=string.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i]=='+'||chars[i]=='-'||chars[i]=='*'||chars[i]=='/') {
				setOperate(chars[i]);
				break;
			}
			continue;
		}
		System.out.println("请输入浮点型数字B：");
		operating=new Scanner(System.in).nextFloat();
	}
	public static void chooseRightFactory() {
		switch (getOperate()) {
		case '+':
			result=getResult(getOperated(), operating, new AddOperationFactory());
			break;
		case '-':
			result=getResult(getOperated(), operating, new SubOperationFactory());
			break;
		case'*':
			result=getResult(getOperated(), operating, new MulOperationFactory());
			break;
		case'/':
			result=getResult(getOperated(), operating, new DivOperationFactory());
			break;
		case'%':
			result=getResult(getOperated(), operating, new BaiOperationFactory());
		default:
			result=getResult(getOperated(), operating, new DivOperationFactory());
			break;
		}
	}
	public static float getResult(float operated,float operating,OperationFactory opFactory) {
			if(opFactory.getOperation(operated, operating).state){
//				System.out.println(opFactory.getOperation(operated, operating).state);
				return opFactory.getOperation(operated, operating).operate();
			}
			else {
				System.err.println(opFactory.getOperation(operated, operating).wrongMessage);
				return Float.MAX_VALUE;
			}
	}
	public static void output() {
		System.out.print(""+getOperated()+getOperate()+operating+"=");
		if (result!=Float.MAX_VALUE) {
			System.out.println(result);
		}
		else {
			System.out.println("nothing");
		}
	}
	public static char getOperate() {
		return operate;
	}
	public static void setOperate(char operate) {
		Calculator1.operate = operate;
	}
	public static float getOperated() {
		return operated;
	}
	public static void setOperated(float operated) {
		Calculator1.operated = operated;
	}
}

abstract class Operation{
	protected boolean state=true;
	protected String wrongMessage="";
	protected float operating,operated;
	public void operation(float operated,float operating) {
		this.operating=operating;
		this.operated=operated;
	}
	abstract float operate();
}
class BaiOperation extends Operation{
	public BaiOperation(float operated,float operating){
		super.operation(operated,operating);
	}

	@Override
	float operate() {
		return (operated/operating)*100;
	}
}
class AddOperation extends Operation{
	public AddOperation(float operated,float operating) {
		super.operation(operated,operating);
	}
	@Override
	float operate() {
		return operated+operating;
	}
}
class subOperation extends Operation{
	public subOperation(float operated,float operating) {
		super.operation(operated,operating);
	}
	@Override
	float operate() {
		return operated-operating;
	}
}
class MulOperation extends Operation{
	public MulOperation(float operated,float operating) {
		super.operation(operated,operating);
	}
	@Override
	float operate() {
		return operated*operating;
	}
}
class DivOperation extends Operation{
	public DivOperation(float operated,float operating) {
		super.operation(operated,operating);
		if (operating==0) {
			state=false;
			wrongMessage="被除数不能为0";
		}
	}
	@Override
	float operate() {
		return operated/operating;
	}
}
abstract class OperationFactory{
	abstract Operation getOperation(float operated,float operating);
}
class BaiOperationFactory extends OperationFactory{
	@Override
	Operation getOperation(float operated, float operating) {
		return new BaiOperation(operated, operating);
	}
	
}
class AddOperationFactory extends OperationFactory{
	@Override
	Operation getOperation(float operated, float operating) {
		return new AddOperation(operated, operating);
	}
}
class SubOperationFactory extends OperationFactory{
	@Override
	Operation getOperation(float operated, float operating) {
		return new subOperation(operated, operating);
	}
}
class MulOperationFactory extends OperationFactory{
	@Override
	Operation getOperation(float operated, float operating) {
		return new MulOperation(operated, operating);
	}
}
class DivOperationFactory extends OperationFactory{
	@Override
	Operation getOperation(float operated, float operating) {
		return new DivOperation(operated, operating);
	}
}