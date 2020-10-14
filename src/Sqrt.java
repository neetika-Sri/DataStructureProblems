public class Sqrt {
    public static void main(String[] args) {
        System.out.println(getSqrt(10) * getSqrt(10));
        System.out.println(Math.sqrt(10));
        System.out.println(getSqrt(0.025));
        System.out.println(Math.sqrt(0.025));
        System.out.println(getSqrt(1.0));
        System.out.println(Math.sqrt(1.0));
        System.out.println(getSqrt(9));
        System.out.println(Math.sqrt(9));

    }
    public static double getSqrt(double inp){
        double l = 1;
        double r = inp;
        if(inp <= 1){
            l = inp;
            r = 1;
        }
        while(compare(l,r) == Diff.Small){
            double midPoint = l + (r -l)/2;
            Diff diff = compare((midPoint * midPoint),inp);
            if( diff == Diff.Equal){
                return midPoint;
            }
            if(diff == Diff.Small){
                l = midPoint;
            }
            else {
                r = midPoint;
            }
        }
        return r;
    }
    private static Diff compare(double l, double r){
        final double TOL = 0.00001;
        double deviation = (r - l)/r;
        if(deviation > TOL){
            return Diff.Small;
        }
        if(deviation >= 0 && deviation <= TOL){ // || deviation > 0 && deviation < TOL no difference
            return Diff.Equal;
        }
        else
            return Diff.Large;
    }
}
enum Diff{
    Small,// l is Smaller
    Equal, // Difference is in tolerance
    Large, // l is larger
}
