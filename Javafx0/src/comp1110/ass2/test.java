https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package comp1110.ass2;

public class test {
    public static void main(String[] args) {
        String placement="a9A7b6A7c1A3d2A6e2C3f3C2g4A7h6D0i6B0j2B0j1C0k3C0l4B0l5C0";
        String location=PiecePlacement.getlocation(placement);
        boolean b= PiecePlacement.checkOnBoard(location);
        boolean c=PiecePlacement.checkOverlap(PiecePlacement.overlap(location));
        System.out.println(b);
        System.out.println(c);
    }
    public static boolean isPlacementStringValid(String placement) {
            String location=PiecePlacement.getlocation(placement);
            boolean b= PiecePlacement.checkOnBoard(location)&&
                    PiecePlacement.checkOverlap(PiecePlacement.overlap(location));
            return b;
    }
}
