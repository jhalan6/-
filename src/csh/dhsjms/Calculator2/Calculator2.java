package csh.dhsjms.Calculator2;
//简单工厂模式
import java.util.Scanner;

public class Calculator2{
	static float operated,operating,result;
	static char operate='+';
	public static void main(String[] args) {
		while(true){
			input();
			result=getResult(operated, operating, new OperationFactory());
			output();
		}
	}
	@SuppressWarnings("resource")
	public static void input(){
		System.out.println("请输入浮点型数字A：");
		operated=new Scanner(System.in).nextFloat();
		System.out.println("请输入操作符：");
		String string=new Scanner(System.in).nextLine();
		char[] chars=string.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i]=='+'||chars[i]=='-'||chars[i]=='*'||chars[i]=='/') {
				operate=chars[i];
				break;
			}
			continue;
		}
		System.out.println("请输入浮点型数字B：");
		operating=new Scanner(System.in).nextFloat();
	}
	public static float getResult(float operated,float operating,OperationFactory opFactory) {
			if(opFactory.getOperation(operated, operating,operate).state){
//				System.out.println(opFactory.getOperation(operated, operating).state);
				return opFactory.getOperation(operated, operating,operate).operate();
			}
			else {
				System.err.println(opFactory.getOperation(operated, operating,operate).wrongMessage);
				return Float.MAX_VALUE;
			}
	}
	public static void output() {
		System.out.print(""+operated+operate+operating+"=");
		if (result!=Float.MAX_VALUE) {
			System.out.println(result);
		}
		else {
			System.out.println("nothing");
		}
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
class AddOperation extends Operation{
	public AddOperation(float operated,float operating) {
		super.operation(operated,operating);
	}
	@Override
	float operate() {
		return operated+operating;
	}
}
class SubOperation extends Operation{
	public SubOperation(float operated,float operating) {
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
class OperationFactory{
	Operation getOperation(float operated,float operating,char operate){
		switch (operate)
		{
		case '+':
			return new AddOperation(operated, operating);
		case '-':
			return new SubOperation(operated, operating);
		case'*':
			return new MulOperation(operated, operating);
		case'/':
			return new DivOperation(operated, operating);
		default:
			return new AddOperation(operated, operating);
		}
	}
}