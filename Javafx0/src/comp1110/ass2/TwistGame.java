https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package comp1110.ass2;

import comp1110.ass2.gittest.A;

import java.util.*;


import static comp1110.ass2.PiecePlacement.checkOnBoard;
import static comp1110.ass2.PiecePlacement.checkOverlap;

/**
 * This class provides the text interface for the Twist Game
 * <p>
 * The game is based directly on Smart Games' IQ-Twist game
 * (http://www.smartgames.eu/en/smartgames/iq-twist)
 */
public class TwistGame {

    /**
     * Determine whether a piece or peg placement is well-formed according to the following:
     * - it consists of exactly four characters
     * - the first character is in the range a .. l (pieces and pegs)
     * - the second character is in the range 1 .. 8 (columns)
     * - the third character is in the range A .. D (rows)
     * - the fourth character is in the range 0 .. 8 (if a piece) or is 0 (if a peg)
     *
     * @param piecePlacement A string describing a single piece or peg placement
     * @return True if the placement is well-formed
     */
    public static boolean isPlacementWellFormed(String piecePlacement) {
        String first = "abcdefgh";
        String second = "12345678";
        String third = "ABCD";
        String fourth = "01234567";
        String peg = "ijkl";
        if (peg.contains(piecePlacement.substring(0, 1))) {
            return piecePlacement.length() == 4
                    && second.contains(piecePlacement.substring(1, 2))
                    && third.contains(piecePlacement.substring(2, 3))
                    && piecePlacement.substring(3, 4).equals("0");
        } else {
            return piecePlacement.length() == 4
                    && first.contains(piecePlacement.substring(0, 1))
                    && second.contains(piecePlacement.substring(1, 2))
                    && third.contains(piecePlacement.substring(2, 3))
                    && fourth.contains(piecePlacement.substring(3, 4));
        }
        // FIXME Task 2: determine whether a piece or peg placement is well-formed

    }

    /**
     * Determine whether a placement string is well-formed:
     * - it consists of exactly N four-character piece placements (where N = 1 .. 15);
     * - each piece or peg placement is well-formed
     * - each piece or peg placement occurs in the correct alphabetical order (duplicate pegs can be in either order)
     * - no piece or red peg appears more than once in the placement
     * - no green, blue or yellow peg appears more than twice in the placement
     *
     * @param placement A string describing a placement of one or more pieces and pegs
     * @return True if the placement is well-formed
     */
    public static boolean isPlacementStringWellFormed(String placement) {
        if (placement.length() % 4 == 0 && placement.length() != 0) {
            for (int i = 0; i < placement.length(); i = i + 4) {
                if (!isPlacementWellFormed(placement.substring(i, i + 4))) return false;
            }
            for (int i = 0; i < placement.length() - 4; i = i + 4) {
                if (placement.substring(i, i + 1).compareTo(placement.substring(i + 4, i + 5)) > 0) return false;
            }
        } else {
            return false;
        }
        // FIXME Task 3: determine whether a placement is well-formed
        return checkPieceAndRedPeg(placement) && checkotherpegs(placement);
    }


    public static boolean checkPieceAndRedPeg(String placement) {
        String pstag = "abcdefghi";
        for (int i = 0; i < placement.length(); i = i + 4) {
            if (pstag.contains(placement.substring(i, i + 1))) {
                int a = i + 4;
                String c = placement.substring(i, i + 1);
                while (a < placement.length()) {
                    if (c.equals(placement.substring(a, a + 1))) {
                        return false;
                    } else {
                        a = a + 4;
                    }
                }
            }
        }
        return true;
    }

    public static boolean checkotherpegs(String placement) {
        String pstag = "jkl";
        for (int i = 0; i < placement.length(); i = i + 4) {
            if (pstag.contains(placement.substring(i, i + 1))) {
                int a = i + 4;
                int b = 1;
                String c = placement.substring(i, i + 1);
                while (a < placement.length()) {
                    if (c.equals(placement.substring(a, a + 1))) {
                        b++;
                        a = a + 4;
                    } else {
                        a = a + 4;
                    }
                }
                if (b > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Determine whether a placement string is valid.  To be valid, the placement
     * string must be well-formed and each piece placement must be a valid placement
     * according to the rules of the game.
     * - pieces must be entirely on the board
     * - pieces must not overlap each other
     * - pieces may only overlap pegs when the a) peg is of the same color and b) the
     * point of overlap in the piece is a hole.
     *
     * @param placement A placement sequence string
     * @return True if the placement sequence is valid
     */
    public static boolean isPlacementStringValid(String placement) {
        if (isPlacementStringWellFormed(placement)) {
            String location = PiecePlacement.getlocation(placement);
            boolean b = PiecePlacement.checkOnBoard(location) &&
                    PiecePlacement.checkOverlap(PiecePlacement.overlap(location));
            return b;
        } else {
            return false;
        }
        // FIXME Task 5: determine whether a placement string is valid
    }

    /**
     * Given a string describing a placement of pieces and pegs, return a set
     * of all possible next viable piece placements.   To be viable, a piece
     * placement must be a valid placement of a single piece.  The piece must
     * not have already been placed (ie not already in the placement string),
     * and its placement must be valid.   If there are no valid piece placements
     * for the given placement string, return null.
     *
     * @param placement A valid placement string (comprised of peg and piece placements)
     * @return An set of viable piece placements, or null if there are none.
     */
    public static Set<String> getViablePiecePlacements(String placement) {
        // Code written by Jonathan Wu, u6650422

        Set<String> viablePlacements = new HashSet<String>();

        char[] piece = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] column = {'1', '2', '3', '4', '5', '6', '7', '8'};
        char[] row = {'A', 'B', 'C', 'D'};
        char[] orientation = {'0', '1', '2', '3', '4', '5', '6', '7'};

        for (char p : piece) {

            String placementFirst = placement;
            String placementSecond = "";

            for (int i = 0; i < placement.length(); i = i + 4) {
                if (placement.charAt(i) > p) {
                    placementFirst = placement.substring(0, i);
                    placementSecond = placement.substring(i, placement.length());
                    break;
                }
            }

            for (char c : column) {
                for (char r : row) {
                    for (char o : orientation) {
                        String x = Character.toString(p) + Character.toString(c) + Character.toString(r) + Character.toString(o);
                        String newPlacement = placementFirst + x + placementSecond;

                        Boolean contains = false;

                        for (String s : viablePlacements) {
                            if ((s.charAt(0) == 'h' || s.charAt(0) == 'f' || s.charAt(0) == 'c' || s.charAt(0) == 'e'
                                    || (s.charAt(0) == 'b' && ((s.charAt(3) == '0' && x.charAt(3) == '2')
                                    || (s.charAt(3) == '4' && x.charAt(3) == '6') || (s.charAt(3) == '1' && x.charAt(3) == '3')
                                    || (s.charAt(3) == '5' && x.charAt(3) == '7'))))
                                    && s.substring(0, 3).equals(x.substring(0, 3))) {
                                contains = true;
                            }
                        }
                        if (isPlacementStringValid(newPlacement) && !contains) {
                            viablePlacements.add(x);
                        }
                    }
                }
            }
        }

        if (viablePlacements.isEmpty()) return null;
        // FIXME Task 6: determine the set of valid next piece placements
        return viablePlacements;
    }

    /**
     * Return an array of all unique solutions to the game, given a starting placement.
     * A given unique solution may have more than one than
     * one placement sequence, however, only a single (unordered) solution should
     * be returned for each such case.
     *
     * @param placement A valid piece placement string.
     * @return An array of strings, each describing a unique unordered solution to
     * the game given the starting point provided by placement.
     */
    public static String[] getSolutions(String placement) {
        // FIXME Task 9: determine all solutions to the game, given a particular starting placement
        // Code written by Shuning Ma, u6151029

        /*Object[] str = getViablePiecePlacements(placement).toArray();
        Arrays.sort(str);

        String pieceplacement = placement + str;
        String piecePlacement = " ";
        /*if (pieceplacement.length() % 4 == 0) {
            int n = pieceplacement.length() / 4;
            for (int i = 0; i < n; i++) {
                int index = i * 4;
                piecePlacement = pieceplacement.substring(index, index + 4);
            }
        }
        //ArrayList<String> list = new ArrayList<String>();
        //list.add(str);
        String[] solution=Arrays.copyOf(str, str.length, String[].class);
        return solution;*/

      String validPiecesAndPlacement = "";
      String str = " ";
      //Solution Array.
        List<String> solutionAL = new ArrayList<>();
      ArrayList<Character> Pieces = new ArrayList<>();

      //Remove all existed pieces.
      for (char p = 'a'; p <= 'h'; p++)
          Pieces.add(p);
      if (placement.length() % 4 == 0) {
          int n = placement.length() / 4;
          for (int i = 0; i < n; i++) {
              int index = i * 4;
              String piecePlacement = placement.substring(index, index + 4);
              //Remove all pieces existed already.
              char Piece = piecePlacement.charAt(0);
              if (Pieces.contains(Piece))
                  Pieces.remove(Character.valueOf(Piece));
          }
      }

      //Get all possible piece placements.
      if (Pieces.size() > 0) {
          ArrayList<String> chances = new ArrayList<>();
          ArrayList<String> rest = new ArrayList<>();
          String s = " ";

          for (char c0 : Pieces) {
              for (char c1 = '0'; c1 <= '7';c1++) {
                  for (char c2 = 'A'; c2 <= 'D'; c2++) {
                      for (char c3 = '0'; c3 <= '7'; c3++) {
                          s = new StringBuilder().append(c0).append(c1).append(c2).append(c3).toString();
                          chances.add(s);
                          }
                  }
              }
          }


          HashMap<Character, ArrayList<String>> map = new HashMap<>();
          for (String r : chances) {
              if (!map.containsKey(r.charAt(0))) {
                  map.put(r.charAt(0), new ArrayList<String>());
              }
              map.get(r.charAt(0)).add(r);
          }

          /*for (Map.Entry<Character, ArrayList<String>> en : map.entrySet()) {
              System.out.println(en.getKey());
              System.out.println(en.getValue());
          }*/

          List<String> list = comb(map);
          for (int i = 0; i < list.size(); i++) {
              validPiecesAndPlacement = list.get(i);
              str = validPiecesAndPlacement + placement;
              //Get all possible glued solutions, filter the correct answer with task 6.
              //if (getViablePiecePlacements(str)==null) {
                  System.out.println(str);
                  solutionAL.add(str);
              //}
          }
      }

      Object[] oList = solutionAL.toArray();
      String[] solutionStr = Arrays.copyOf(oList, oList.length, String[].class);


      return solutionStr;

  }

  //Map and glue solutions.
    static List<String> comb (Map<Character, ArrayList<String>> m){
        List<String> list = new ArrayList<>();
        for (Map.Entry<Character, ArrayList<String>> entry: m.entrySet()){
            list = entry.getValue();
            m.remove(entry.getKey());
            break;
        }
        if(m.size()==0)
            return  list;
        List <String> finalresult = new ArrayList<>();
        List <String> others = comb(m);
        for(String st: list){
            for(String st1: others){
                    finalresult.add(st + st1);
            }
        }
        System.out.println(finalresult);
        return finalresult;
    }

    }

