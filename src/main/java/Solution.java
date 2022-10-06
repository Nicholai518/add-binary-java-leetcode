public class Solution {
    public String addBinary(String a, String b) {

        StringBuilder stringBuilder = new StringBuilder();

        // iterate from the back to front
        // from least significant to most significant
        int i = a.length() - 1;
        int j = b.length() - 1;

        // there can only be 0 or 1, if we have a scenario where:
        // 1 + 1
        // set the index = 0
        // set carry = 1
        int carry = 0;

        // a may be "longer" than b, or vice versa
        // if there is still an available index for either a or b, keep looping
        while( i >= 0 || j >= 0 ){
            // set some equal to carry which may exist from previous calculation
            int sum = carry;
            // converts char to an int
            if(i >= 0) {
                sum += a.charAt(i) - '0';
            }
            if(j >= 0){
                sum += b.charAt(j) - '0';
            }

            // if 1 + 1
            // % 2 will return a 0 for this index

            // if 1 + 0
            // % 2 will return a 1 for this index
            stringBuilder.append(sum % 2);

            // if the sum is 2, this means we must "carry" a 1 for the next iteration
            carry = sum / 2;

            // decrement pointers
            i--;
            j--;
        }

        // if there is a "carry" left, we need to append it
        if(carry != 0){
            stringBuilder.append(carry);
        }
        // because append() adds to the END of string builder, our answer is backwards
        // we need to return the reverse
        return stringBuilder.reverse().toString();
    }
}
