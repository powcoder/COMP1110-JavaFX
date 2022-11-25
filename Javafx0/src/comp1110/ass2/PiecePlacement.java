https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package comp1110.ass2;

public class PiecePlacement {

    public static String separatePieceString(String piecePlacement) {
        return "";
        //  get rid of peg strings
    }

    public static boolean isPlacementWellFormed(String piecePlacement) {
        String first = "abcdefghi";
        String second = "12345678";
        String third = "ABCD";
        String fourth = "012345678";
        if (
                piecePlacement.length() == 4
                        && first.contains(piecePlacement.substring(0, 1))
                        && second.contains(piecePlacement.substring(1, 2))
                        && third.contains(piecePlacement.substring(2, 3))
                        && fourth.contains(piecePlacement.substring(3, 4))
        ) {
            return true;
        }
        return false;
    }

    public static boolean checkAlphabeticalOrder(String placement) {
        return true;
    }

    public static int countPieces(String placement) {
        return 0;
    }


    //task5
    public static String findValuesFromPlacement(String placement) {
        char p = placement.charAt(0);
        Integer x = Integer.parseInt(placement.substring(1, 2));
        Integer y = convertLetterToNumber(placement.substring(2, 3));
        switch (placement.charAt(0)) {
            case 'a':
                switch (placement.charAt(3)) {
                    case '0':
                        return "A" + (x) + (y) + "a" + (x + 1) + (y) + "A" + (x + 2) + (y) + "a" + (x + 2) + (y + 1);
                    case '1':
                        return "A" + (x + 1) + (y) + "a" + (x + 1) + (y + 1) + "A" + (x + 1) + (y + 2) + "a" + (x) + (y + 2);
                    case '2':
                        return "a" + (x) + (y) + "A" + (x) + (y + 1) + "a" + (x + 1) + (y + 1) + "A" + (x + 2) + (y + 1);
                    case '3':
                        return "A" + (x) + (y) + "a" + (x + 1) + (y) + "a" + (x) + (y + 1) + "A" + (x) + (y + 2);
                    case '4':
                        return "A" + (x) + (y + 1) + "a" + (x + 1) + (y + 1) + "A" + (x + 2) + (y + 1) + "a" + (x + 2) + (y);
                    case '5':
                        return "A" + (x) + (y) + "a" + (x) + (y + 1) + "A" + (x) + (y + 2) + "a" + (x + 1) + (y + 2);
                    case '6':
                        return "A" + (x) + (y) + "a" + (x + 1) + (y) + "A" + (x + 2) + (y) + "a" + (x) + (y + 1);
                    case '7':
                        return "a" + (x) + (y) + "A" + (x + 1) + (y) + "a" + (x + 1) + (y + 1) + "A" + (x + 1) + (y + 2);
                }
            case 'b':
                switch (placement.charAt(3)) {
                    case '0':
                        return "b" + (x) + (y) + "b" + (x + 1) + (y) + "B" + (x + 1) + (y + 1) + "b" + (x + 2) + (y + 1);
                    case '1':
                        return "b" + (x + 1) + (y) + "b" + (x + 1) + (y + 1) + "B" + (x) + (y + 1) + "b" + (x) + (y + 2);
                    case '2':
                        return "b" + (x) + (y) + "B" + (x + 1) + (y) + "b" + (x + 1) + (y + 1) + "b" + (x + 2) + (y + 1);
                    case '3':
                        return "b" + (x + 1) + (y) + "B" + (x + 1) + (y + 1) + "b" + (x) + (y + 1) + "b" + (x) + (y + 2);
                    case '4':
                        return "B" + (x + 1) + (y) + "b" + (x + 2) + (y) + "b" + (x) + (y + 1) + "b" + (x + 1) + (y + 1);
                    case '5':
                        return "b" + (x) + (y) + "b" + (x) + (y + 1) + "B" + (x + 1) + (y + 1) + "b" + (x + 1) + (y + 2);
                    case '6':
                        return "b" + (x + 1) + (y) + "b" + (x + 2) + (y) + "b" + (x) + (y + 1) + "B" + (x + 1) + (y + 1);
                    case '7':
                        return "b" + (x) + (y) + "B" + (x) + (y + 1) + "b" + (x + 1) + (y + 1) + "b" + (x + 1) + (y + 2);
                }
            case 'c':
                switch (placement.charAt(3)) {
                    case '0':
                        return "c" + (x) + (y) + "C" + (x + 1) + (y) + "c" + (x + 2) + (y) + "c" + (x + 3) + (y);
                    case '1':
                        return "c" + (x) + (y) + "C" + (x) + (y + 1) + "c" + (x) + (y + 2) + "c" + (x) + (y + 3);
                    case '2':
                        return "c" + (x) + (y) + "c" + (x + 1) + (y) + "C" + (x + 2) + (y) + "c" + (x + 3) + (y);
                    case '3':
                        return "c" + (x) + (y) + "c" + (x) + (y + 1) + "C" + (x) + (y + 2) + "c" + (x) + (y + 3);
                    case '4':
                        return "c" + (x) + (y) + "C" + (x + 1) + (y) + "c" + (x + 2) + (y) + "c" + (x + 3) + (y);
                    case '5':
                        return "c" + (x) + (y) + "C" + (x) + (y + 1) + "c" + (x) + (y + 2) + "c" + (x) + (y + 3);
                    case '6':
                        return "c" + (x) + (y) + "c" + (x + 1) + (y) + "C" + (x + 2) + (y) + "c" + (x + 3) + (y);
                    case '7':
                        return "c" + (x) + (y) + "c" + (x) + (y + 1) + "C" + (x) + (y + 2) + "c" + (x) + (y + 3);
                }
            case 'd':
                switch (placement.charAt(3)) {
                    case '0':
                        return "d" + (x) + (y) + "d" + (x + 1) + (y) + "d" + (x + 2) + (y) + "D" + (x + 1) + (y + 1) + "D" + (x + 2) + (y + 1);
                    case '1':
                        return "D" + (x) + (y + 1) + "D" + (x) + (y + 2) + "d" + (x + 1) + (y) + "d" + (x + 1) + (y + 1) + "d" + (x + 1) + (y + 2);
                    case '2':
                        return "D" + (x) + (y) + "D" + (x + 1) + (y) + "d" + (x) + (y + 1) + "d" + (x + 1) + (y + 1) + "d" + (x + 2) + (y + 1);
                    case '3':
                        return "d" + (x) + (y) + "d" + (x) + (y + 1) + "d" + (x) + (y + 2) + "D" + (x + 1) + (y) + "D" + (x + 1) + (y + 1);
                    case '4':
                        return "d" + (x) + (y + 1) + "d" + (x + 1) + (y + 1) + "d" + (x + 2) + (y + 1) + "D" + (x + 1) + (y) + "D" + (x + 2) + (y);
                    case '5':
                        return "d" + (x) + (y) + "d" + (x) + (y + 1) + "d" + (x) + (y + 2) + "D" + (x + 1) + (y + 1) + "D" + (x + 1) + (y + 2);
                    case '6':
                        return "d" + (x) + (y) + "d" + (x + 1) + (y) + "d" + (x + 2) + (y) + "D" + (x) + (y + 1) + "D" + (x + 1) + (y + 1);
                    case '7':
                        return "D" + (x) + (y) + "D" + (x) + (y + 1) + "d" + (x + 1) + (y) + "d" + (x + 1) + (y + 1) + "d" + (x + 1) + (y + 2);
                }
            case 'e':
                switch (placement.charAt(3)) {
                    case '0':
                        return "e" + (x) + (y) + "E" + (x + 1) + (y) + "E" + (x + 1) + (y + 1);
                    case '1':
                        return "e" + (x + 1) + (y) + "E" + (x) + (y + 1) + "E" + (x + 1) + (y + 1);
                    case '2':
                        return "E" + (x) + (y) + "E" + (x) + (y + 1) + "e" + (x + 1) + (y + 1);
                    case '3':
                        return "E" + (x) + (y) + "E" + (x + 1) + (y) + "e" + (x) + (y + 1);
                    case '4':
                        return "E" + (x + 1) + (y) + "E" + (x + 1) + (y + 1) + "e" + (x) + (y + 1);
                    case '5':
                        return "e" + (x) + (y) + "E" + (x + 1) + (y + 1) + "E" + (x) + (y + 1);
                    case '6':
                        return "E" + (x) + (y) + "e" + (x + 1) + (y) + "E" + (x) + (y + 1);
                    case '7':
                        return "E" + (x) + (y) + "E" + (x + 1) + (y) + "e" + (x + 1) + (y + 1);
                }
            case 'f':
                switch (placement.charAt(3)) {
                    case '0':
                        return "f" + (x) + (y) + "f" + (x + 1) + (y) + "F" + (x + 2) + (y) + "F" + (x + 1) + (y + 1);
                    case '1':
                        return "f" + (x + 1) + (y) + "F" + (x) + (y + 1) + "f" + (x + 1) + (y + 1) + "F" + (x + 1) + (y + 2);
                    case '2':
                        return "F" + (x + 1) + (y) + "F" + (x) + (y + 1) + "f" + (x + 1) + (y + 1) + "f" + (x + 2) + (y + 1);
                    case '3':
                        return "F" + (x) + (y) + "f" + (x) + (y + 1) + "f" + (x) + (y + 2) + "F" + (x + 1) + (y + 1);
                    case '4':
                        return "F" + (x + 1) + (y) + "f" + (x) + (y + 1) + "f" + (x + 1) + (y + 1) + "F" + (x + 2) + (y + 1);
                    case '5':
                        return "f" + (x) + (y) + "f" + (x) + (y + 1) + "F" + (x + 1) + (y + 1) + "F" + (x) + (y + 2);
                    case '6':
                        return "F" + (x) + (y) + "F" + (x + 1) + (y + 1) + "f" + (x + 1) + (y) + "f" + (x + 2) + (y);
                    case '7':
                        return "F" + (x + 1) + (y) + "F" + (x) + (y + 1) + "f" + (x + 1) + (y + 1) + "f" + (x + 1) + (y + 2);
                }
            case 'g':
                switch (placement.charAt(3)) {
                    case '0':
                        return "G" + (x) + (y) + "G" + (x) + (y + 1) + "g" + (x + 1) + (y + 1) + "g" + (x + 2) + (y + 1) + "G" + (x + 1) + (y + 2);
                    case '1':
                        return "G" + (x + 1) + (y) + "G" + (x + 2) + (y) + "G" + (x) + (y + 1) + "g" + (x + 1) + (y + 1) + "g" + (x + 1) + (y + 2);
                    case '2':
                        return "g" + (x) + (y + 1) + "g" + (x + 1) + (y + 1) + "G" + (x + 1) + (y) + "G" + (x + 2) + (y + 1) + "G" + (x + 2) + (y + 2);
                    case '3':
                        return "g" + (x + 1) + (y) + "g" + (x + 1) + (y + 1) + "G" + (x + 2) + (y + 1) + "G" + (x) + (y + 2) + "G" + (x + 1) + (y + 2);
                    case '4':
                        return "g" + (x + 1) + (y + 1) + "g" + (x + 2) + (y + 1) + "G" + (x + 1) + (y) + "G" + (x) + (y + 1) + "G" + (x) + (y + 2);
                    case '5':
                        return "G" + (x) + (y) + "G" + (x + 1) + (y) + "g" + (x + 1) + (y + 1) + "G" + (x + 2) + (y + 1) + "g" + (x + 1) + (y + 2);
                    case '6':
                        return "g" + (x) + (y + 1) + "g" + (x + 1) + (y + 1) + "G" + (x + 2) + (y) + "G" + (x + 2) + (y + 1) + "G" + (x + 1) + (y + 2);
                    case '7':
                        return "g" + (x + 1) + (y) + "g" + (x + 1) + (y + 1) + "G" + (x) + (y + 1) + "G" + (x + 1) + (y + 2) + "G" + (x + 2) + (y + 2);
                }
            case 'h':
                switch (placement.charAt(3)) {
                    case '0':
                        return "H" + (x) + (y) + "h" + (x + 1) + (y) + "h" + (x + 2) + (y);
                    case '1':
                        return "H" + (x) + (y) + "h" + (x) + (y + 1) + "h" + (x) + (y + 2);
                    case '2':
                        return "h" + (x) + (y) + "h" + (x + 1) + (y) + "H" + (x + 2) + (y);
                    case '3':
                        return "h" + (x) + (y) + "h" + (x) + (y + 1) + "H" + (x) + (y + 2);
                    case '4':
                        return "H" + (x) + (y) + "h" + (x + 1) + (y) + "h" + (x + 2) + (y);
                    case '5':
                        return "H" + (x) + (y) + "h" + (x) + (y + 1) + "h" + (x) + (y + 2);
                    case '6':
                        return "h" + (x) + (y) + "h" + (x + 1) + (y) + "H" + (x + 2) + (y);
                    case '7':
                        return "h" + (x) + (y) + "h" + (x) + (y + 1) + "H" + (x) + (y + 2);

                }
            case 'i':
                return "i" + x + y;
            case 'j':
                return "j" + x + y;
            case 'k':
                return "k" + x + y;
            case 'l':
                return "l" + x + y;
            default:
                return "";

        }
    }

    public static int convertLetterToNumber(String c) {
        switch (c) {
            case "A":
                return 1;
            case "B":
                return 2;
            case "C":
                return 3;
            case "D":
                return 4;
            default:
                return -100;
        }
    }

    public static String getlocation(String placement) {
        String a = "";
        for (int i = 0; i < placement.length(); i = i + 4) {
            a = a + findValuesFromPlacement(placement.substring(i, i + 4));
        }
        return a;
    }

    public static String overlap(String location) {
        String a = "";
        for (int i = 0; i < location.length(); i = i + 3) {
            String b = location.substring(i + 1, i + 3);
            for (int k = i + 3; k < location.length(); k = k + 3) {
                String c = location.substring(k + 1, k + 3);
                if (b.equals(c)) {
                    a = a + location.substring(i, i + 1) + location.substring(k, k + 1);
                }
            }
        }
        return a;
    }

    public static boolean checkOverlap(String overlap) {
        for (int i = 0; i < overlap.length(); i = i + 2) {
            if (overlap.substring(i, i + 2).equals("Ai")
                    || overlap.substring(i, i + 2).equals("Bi")
                    || overlap.substring(i, i + 2).equals("Cj")
                    || overlap.substring(i, i + 2).equals("Dj")
                    || overlap.substring(i, i + 2).equals("Ek")
                    || overlap.substring(i, i + 2).equals("Fk")
                    || overlap.substring(i, i + 2).equals("Gl")
                    || overlap.substring(i, i + 2).equals("Hl")
                    || overlap.substring(i, i + 2).equals("iA")
                    || overlap.substring(i, i + 2).equals("iB")
                    || overlap.substring(i, i + 2).equals("jC")
                    || overlap.substring(i, i + 2).equals("jD")
                    || overlap.substring(i, i + 2).equals("kE")
                    || overlap.substring(i, i + 2).equals("kF")
                    || overlap.substring(i, i + 2).equals("lG")
                    || overlap.substring(i, i + 2).equals("lH")
            ) {
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean checkOnBoard(String location) {
        String x = "12345678";
        String y = "1234";
        if (location.length() % 3 == 0) {
            for (int i = 0; i < location.length(); i = i + 3) {
                if (x.contains(location.substring(i + 1, i + 2)) && y.contains(location.substring(i + 2, i + 3))) {
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
