class Solution {
    public String largestNumber(int[] nums) {
        ArrayList<String> arrList = new ArrayList<>();
        for (int num : nums) {
            arrList.add(String.valueOf(num));
        }

        Collections.sort(arrList, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });

        if (arrList.get(0).equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : arrList) {
            sb.append(str);
        }

        return sb.toString();
    }
}
