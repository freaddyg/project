import exceptions.NullDivException;

public class Action {


    public static int sum(int firstValue, int secondValue){
       return firstValue + secondValue;
    }

    public static int diff(int firstValue, int secondValue){
        return firstValue - secondValue;
    }

    public static int multi(int firstValue, int secondValue){
        return firstValue * secondValue;
    }

    public static int div(int firstValue, int secondValue) throws NullDivException {
        if(secondValue == 0){
            throw new NullDivException("НА НОЛЬ ДЕЛИТЬ НЕЛЬЗЯ !");
        }
        return firstValue / secondValue;
    }
}
