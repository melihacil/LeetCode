class Result {

    public static void plusMinus(List<Integer> arr) {
    // Write your code here
        int n = arr.size();
        int pos = 0, neg = 0, zero = 0;
        for (int i = 0; i < n ; i++) {
            if (arr.get(i) > 0)
                pos++;
            else if (arr.get(i) < 0)
                neg++;
            else
                zero++;          
        }
        float ne,p,z;
        ne = ((float)neg)/n;
        p = ((float)pos)/n;
        z = ((float)zero)/n;
        System.out.printf("%.6f\n", p);
        System.out.printf("%.6f\n", ne);
        System.out.printf("%.6f\n", z);
    }

}