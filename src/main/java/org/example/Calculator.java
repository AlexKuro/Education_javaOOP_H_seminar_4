package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calculator<T extends Number> {
    private T num1;
    private T num2;
    private int value = 3;

    private Boolean flag;


    public Double sum() {
        Double result = num1.doubleValue() + num2.doubleValue();
        BigDecimal bD = new BigDecimal(result);
        RoundingMode halfUp = RoundingMode.HALF_UP;
        result = (bD.setScale(value, RoundingMode.HALF_UP)).doubleValue();
        return result;
    }

    public Double subtraction() {
        Double result = num1.doubleValue() - num2.doubleValue();
        BigDecimal bD = new BigDecimal(result);
        RoundingMode halfUp = RoundingMode.HALF_UP;
        result = (bD.setScale(value, RoundingMode.HALF_UP)).doubleValue();
        return result;
    }


    public Double multiplications() {
        Double result = num1.doubleValue() * num2.doubleValue();
        BigDecimal bD = new BigDecimal(result);
        RoundingMode halfUp = RoundingMode.HALF_UP;
        result = (bD.setScale(value, RoundingMode.HALF_UP)).doubleValue();
        return result;
    }

    public Double division() {
        Double result = num1.doubleValue() / num2.doubleValue();
        BigDecimal bD = new BigDecimal(result);
        RoundingMode halfUp = RoundingMode.HALF_UP;
        result = (bD.setScale(value, RoundingMode.HALF_UP)).doubleValue();
        return result;
    }

    public String bin(Integer num) {
        List<Integer> result = new ArrayList<>();
        List<Integer> reverse = new ArrayList<>();
        String st = "";

        Integer x;
        Integer t = num.intValue();
        while (t > 0) {
            x = t % 2;
            result.add(x);
            t = t / 2;
        }

        ListIterator<Integer> itr = result.listIterator(result.size());
        while (itr.hasPrevious()) {
            reverse.add(itr.previous());
        }

        for (int i = 0; i < reverse.size(); i++) {
            st += String.valueOf(reverse.get(i));
        }

        return st;
    }

    public StringBuilder binPoint(Double num) {
        StringBuilder stInt = new StringBuilder();
        stInt.append(num.doubleValue());
        int sInt = stInt.indexOf(".");
        stInt.delete(sInt, stInt.length());
        Integer number = Integer.valueOf(stInt.toString());
        StringBuilder result = new StringBuilder();

        StringBuilder st = new StringBuilder();
        StringBuilder str = new StringBuilder();
        Double d = pointDouble(num);
        Boolean fl = true;
        int count = 0;
        str.append(".");
        while (fl) {
            count++;
            d = d * 2;
            st.append(d.doubleValue());
            int s = st.indexOf(".") - 1;
            if (st.charAt(s) == '0') {
                str.append("0");
            } else {
                str.append("1");
            }
            d = pointDouble(d);
            if (d == 0 | count == 12) {
                fl = false;
            }
            st.delete(0, st.length());
        }
        result.append(bin(number));
        result.append(str);

        return result;
    }

    public Double pointDouble(Double a) {
        StringBuilder st = new StringBuilder();
        st.append(a.doubleValue());
        int s = st.indexOf(".");
        st.insert(s, "0");
        st.delete(0, s);
        Double aDouble = Double.valueOf(String.valueOf(st));
        return aDouble;
    }

    public Object binObg(Object obg) {
        if (obg instanceof Integer) {
            return bin((Integer) obg);
        }
        if (obg instanceof Double) {
            return binPoint((Double) obg);
        }
        if (obg instanceof String) {
            StringBuilder res = new StringBuilder();

            for (int i = 0; i < ((String) obg).length(); i++) {
                String st = String.valueOf(((String) obg).charAt(i));
                Integer a = st.codePointAt(0);
                res.append(bin(a));
                res.append(" ");
            }

            return res;
        }

        return null;
    }

}
