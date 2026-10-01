class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                depth++;

                if(depth > 1){
                    result.append(ch);
                }
            }else{
                depth--;
                if(depth > 0){
                    result.append(ch);
                }
            }
           
        }
        return result.toString();
        
    }
}