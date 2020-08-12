import exceptions.CheckNumberException;
import exceptions.NullDivException;
import exceptions.WrongOperationException;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Calc {

    private Calc(){

        while (true){
            System.out.println("ВВЕДИТЕ ОПРЕАЦИЮ ЧЕРЕЗ ПРОБЕЛ:");
            Scanner scan = new Scanner(System.in);

            String[] str = scan.nextLine().split(" ");
            if(str[0].equals("exit")){
                System.exit(0);
            }
            int first = 0;
            int second = 0;
            String op = str[1];

            for(Roma r : Roma.values()){

                if(str[0].equals(r.getKey())){
                    first = r.getValue();
                }
                if(str[2].equals(r.getKey())){
                    second = r.getValue();
                    try {
                       String res = Convert.con(operation(first, second, op));
                       if(res.equals(null)){
                           continue;
                       }
                       System.out.println(res);
                    } catch (WrongOperationException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }

            if(first == 0 && second == 0){
                first = Integer.parseInt(str[0]);
                second = Integer.parseInt(str[2]);
            }

            try {
                checkNumber(first, second);

            } catch (CheckNumberException e) {
                System.err.println(e.getMessage());
                continue;
            }

            try {
                int res = operation(first, second, op);
                System.out.println(res);
                continue;
            } catch (WrongOperationException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private int operation(int first, int second, String op) throws WrongOperationException {
        switch (op){
            case("+"): return Action.sum(first,second);
            case("-"): return Action.diff(first,second);
            case("*"): return Action.multi(first,second);
            case("/"):
                try {
                   return Action.div(first,second);
                } catch (NullDivException e) {
                    System.err.println(e.getMessage());
                }
            default: throw new WrongOperationException("НЕВЕРНАЯ ОПЕРАЦИЯ !");
        }
    }

    private void checkNumber(int first, int second) throws CheckNumberException {
        if((first < 0 || first > 10) || (second <0 || second > 10)){
            throw new CheckNumberException("ЧИСЛО НЕ ДОЛЖНО БЫТЬ БОЛЬШЕ 10 И МЕНЬШЕ ЧЕМ 0");
        }
    }



    public static void main(String[] args) {

            new Calc();

    }
}
