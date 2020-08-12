import exceptions.BigNum;

public class Convert {

    public static String con(int num){
        switch (num){
            case(0): return "0";
            case(1): return "I";
            case(2): return "II";
            case(3): return "III";
            case(4): return "IV";
            case(5): return "V";
            case(6): return "VI";
            case(7): return "VII";
            case(8): return "VIII";
            case(9): return "IX";
            case(10): return "X";
            default:
                try {
                    throw new BigNum("СЛИШКОМ БОЛЬШОЕ ЧИСЛО");
                } catch (BigNum bigNum) {
                    System.err.println(bigNum.getMessage());
                }
        }
        return " ";
    }
}
