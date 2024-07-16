package Mathematical;

class Solution {
    StringBuilder sb;
    Solution(){
        sb = new StringBuilder();
    }
    public String convertToTitle(int columnNumber) {
        if (columnNumber == 0) return "";
        columnNumber--;
        convertToTitle(columnNumber/26);
        sb.append(String.valueOf((char)('A' + columnNumber % 26)));

        return sb.toString();
    }
}
