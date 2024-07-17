package Strings;

public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while(num>0){
            if(num >= 1000){
                sb.append("M");
                num -= 1000;
            }
            else if(num >= 500){
                if(num < 900){
                    sb.append("D");
                    num -= 500;
                }
                else{
                    sb.append("CM");
                    num -= 900;
                }
            }
            else if(num >= 100){
                if(num < 400){
                    sb.append("C");
                    num -= 100;
                }
                else{
                    sb.append("CD");
                    num -= 400;
                }
            }
            else if(num >= 50){
                if(num < 90){
                    sb.append("L");
                    num -= 50;
                }
                else{
                    sb.append("XC");
                    num -= 90;
                }
            }
            else if(num >= 10){
                if(num < 40){
                    sb.append("X");
                    num -= 10;
                }
                else{
                    sb.append("XL");
                    num -= 40;
                }
            }
            else if(num >= 5){
                if(num < 9){
                    sb.append("V");
                    num -= 5;
                }
                else{
                    sb.append("IX");
                    num -= 9;
                }
            }
            else{
                if(num < 4){
                    sb.append("I");
                    num -= 1;
                }
                else{
                    sb.append("IV");
                    num -= 4;
                }
            }
        }
        return sb.toString();
    }
}
