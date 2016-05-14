package csh.dhsjms.Calculator3;

public class BufferCalcutalor {
    private float operated = 0, operating = 0, result = 0;
    private String operate = null;
    SimpleCalculator simpleCalculator = new SimpleCalculator();

    public void setNext(String next) {
        try {
            if (operated == 0) {
                result = operated = Float.parseFloat(next);
            } else {
                operated = result;
                operating = Float.parseFloat(next);
            }
        } catch (Exception e) {
            result = operated = 0;
        }
    }

    public void setOperate(String operate) {
        cal();
        this.operate = operate;
    }

    public void reset() {
        operate = null;
        operated = operating = result = 0;
    }

    public float getResult() {
        return result;
    }

    private void cal() {
        System.out.print("" + operated + operate + operating);
        if (operate != null) {
            result = simpleCalculator.run(operated, operate, operating);
            System.out.println("=" + result);
            operated = result;
            operating = 0;
        } else {
            result = operated;
        }
    }
//	private float result=0,next=0;
//	private String errorMessage=null;
//	private String operate=null;
//	SimpleCalculator calculator=new SimpleCalculator();
//	public void setNext(String next){
//		if (next==null) {
//			this.next=0;
//		}
//		else {
//			this.next=Float.parseFloat(next);
//		}
//	}
//	public void setOperate(String operate){
//		this.operate=operate;
//		if (result!=0) {
//			next=result;
//		}
//	}
//	public String getErrorMessage(){
//		return errorMessage;
//	}
//	public float getResult(){
//		System.out.println(result==0);
//		if(result==0){
//			System.out.println("next"+this.next);
//			return this.next;
//			}
//		else {
//			return result;
//		}
//	}
//	public void reset(){
//		result=0;
//		next=0;
//		operate=null;
//	}
//	private void cal(float operating){
//		result=calculator.run(next, operate ,operating);
//	}
//	public void equal() {
//		cal();
//	}
}


//每次的运算均先进行equal操作，即计算其结果
//5+6+
//5，进入operated
//+，操作=，result=operated=5，operating=0
//+，进入operate
//6，进入operating
//+，操作=，result=operated=11,operating=0
