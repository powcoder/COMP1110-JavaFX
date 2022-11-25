https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package comp1110.ass1;



/**
 * This class represents a node.
 * <p>
 * Nodes consist of the ten fixed nodes (the ten icons on the perimeter of the
 * board), and nine tiles (the nine tiles that may be placed in the center of
 * board.
 * <p>
 * The 25 positions with their position numbers:
 * <p>
 *   0  1  2  3  4
 *   5  6  7  8  9
 *   10 11 12 13 14
 *   15 16 17 18 19
 *   20 21 22 23 24
 * <p>
 * Tiles may be placed in any of the nine positions depicted below:
 * <p>
 * <p>
 *   6  7  8
 *   11 12 13
 *   16 17 18
 * <p>
 * <p>
 * The 10 fixed icons are located at positions 1, 2, 3, 5, 9, 10, 15, 19, 21 and 23.
 * The four corner positions (0, 4, 20, 24) are unoccupied, as are positions 14 and
 * 22.   The following diagram illustrates the locations of the 10 fixed icons,
 * which have character codes 'Q' ... 'Z' (see the Icon class for more info).
 * Permanently unoccupied positions are marked '.'.
 * <p>
 *   .  Z  Y  X  .
 *   Q  6  7  8  W
 *   R 11 12 13  .
 *   S 16 17 18  V
 *   .  T  .  U  .
 */
public class Node {
  private int[] reachable; // The list of positions of all icons reachable from this node
  Icon icon;               // The icon associated with this node, if any
  Tile tile;               // The tile associated with this node, if any

  /**
   * Construct a node from a fixed icon (any icon except the cat, which is also a tile)
   *
   * @param icon The icon associated with this node (any fixed icon)
   */
  Node(Icon icon) {
    assert !(icon == null || icon == Icon.CAT);
    this.icon = icon;
  }

  /**
   * Construct a node for a tile at a particular position
   *
   * @param tileID   The tile ID for the tile (0 .. 8)
   * @param tileCode An encoding of the tile's location
   */
  Node(int tileID, int tileCode) {
    this.tile = new Tile(tileID, tileCode);
    if (tile.isCat()) // the cat is both an icon and a tile
      this.icon = Icon.CAT;
  }

  /**
   * @return the position (0 .. 24) of this tile.
   */
  int getPosition() {
    assert tile != null || icon != null;

    if (tile != null)
      return tile.getPosition();
    else
      return icon.getPosition();
  }

  /**
   * The start of a path.
   * <p>
   * Find the set positions that can be reached from this node.
   * This applies to icons only (since paths can only start at
   * icons).
   *
   * @return An array of positions which this node is connected to.
   */
  int[] nextPosition() {
    assert icon != null;  // can only start at an icon node

    if (tile != null)    // the CAT is the only one that is both an icon and a tile
      return getNeighbours(tile.getPosition());
    else
      return icon.getFixedConnections();
  }

  /**
   * The next step in a path.
   * <p>
   * Find the set of positions that can be reached from this node,
   * having arrived from position 'from'.
   *
   * @param from The position from which the node was visited
   * @return An array of positions to which this node can move next.
   */
  int[] nextPosition(int from) {
    if (tile != null)
      return tile.nextPositions(from);
    else
      return icon.nextPosition(from);
  }

  /**
   * Return true if the position is on the central board, where
   * tiles may be placed.   Tiles may be placed in the following
   * positions:
   * <p>
   *   6  7  8
   *   11 12 13
   *   16 17 18
   *
   * @param position A position (0 .. 24)
   * @return true if the position is one of the nine central positions.
   */
  static boolean isOnBoard(int position) {
    assert position >= 0 && position <= 24;
    boolean b;
    if(position>=6&&position<=18){
      b=true;
    }else{
      b=false;
    }
    return b; // TODO Task 5
  }

  /**
   * Return the four neighbours of a given position.  The input position must be
   * on the board:
   * <p>
   *   6  7  8
   *   11 12 13
   *   16 17 18
   * <p>
   * Neighbours are defined to be adjacent positions in the four
   * cardinal directions (NORTH, EAST, SOUTH, WEST).
   *
   * @param position The position whose neighbours are to be returned
   * @return An array of integers reflecting the neighbours of the given position
   */
  static int[] getNeighbours(int position) {
    assert isOnBoard(position);
    int[] a =  new int[4];
    if(position==6){
         a[0]= 1;a[1]=5;a[2]=7;a[3]=11;
    }else if(position==7){
        a[0]=2;a[1]=6;a[2]=8;a[3]=12;
    }else if(position==8){
        a[0]=3;a[1]=7;a[2]=9;a[3]=13;
    }else if(position==11){
        a[0]=6;a[1]=10;a[2]=12;a[3]=16;
    }else if(position==12){
        a[0]=7;a[1]=11;a[2]=13;a[3]=17;
    }else if(position==13){
        a[0]=8;a[1]=12;a[2]=14;a[3]=18;
    }else if(position==16){
        a[0]=11;a[1]=15;a[2]=17;a[3]=21;
    }else if(position==17){
        a[0]=12;a[1]=16;a[2]=18;a[3]=22;
    }else if(position==18){
        a[0]=13;a[1]=17;a[2]=19;a[3]=23;
    }
    return a;  // TODO Task 7
  }

  /**
   * Get the neighbour of a position in a particular direction, and
   * return -1 if the answer is off the board.   For example, if the
   * position was 1 and the direction was EAST, the neighbour would be
   * 2, but if the direction was SOUTH, the neighbour would be 6, and
   * if the direction was NORTH, the result would be -1 (off the board).
   *
   * @param position  The reference position
   * @param direction The direction of the neighbour
   * @return The position of the neighbour in the given direction or -1 if it is off the board.
   */
  static int getNeighbour(int position, Direction direction) {
    assert position >= 0 && position <= 24;
    int d =0;
    if(position==0){
      if(direction==Direction.EAST){
        d=1;
      }else if(direction==Direction.WEST||direction==Direction.NORTH){
        d=-1;
      }else if(direction==Direction.SOUTH){
        d=5;
      }
    }else if(position==1||position==2||position==3){
      if(direction== Direction.NORTH){
        d=-1;
      }else if(direction==Direction.SOUTH){
        d=position+5;
      }else if(direction==Direction.WEST){
        d=position-1;
      }else if(direction==Direction.EAST){
        d=position+1;
      }
    }else if(position==4){
      if(direction==Direction.NORTH||direction==Direction.EAST){
        d=-1;
      }else if(direction==Direction.SOUTH){
        d=position+5;
      }else if(direction==Direction.WEST){
        d=position-1;
      }
    }else if(position==5||position==10||position==15){
      if(direction==Direction.WEST){
        d=-1;
      }else if(direction==Direction.SOUTH){
        d=position+5;
      }else if(direction==Direction.NORTH){
        d=position-5;
      }else if(direction==Direction.EAST){
        d=position+1;
      }
    }else if(position==9||position==14||position==19){
      if (direction==Direction.EAST){
        d=-1;
      }else if(direction==Direction.NORTH){
        d=position-5;
      }else if(direction==Direction.SOUTH){
        d=position+5;
      }else if(direction==Direction.WEST){
        d=position-1;
      }
    }else if(position==21||position==22||position==23){
      if(direction==Direction.WEST){
        d=position-1;
      }else if(direction==Direction.SOUTH){
        d=-1;
      }else if(direction==Direction.NORTH){
        d=position-5;
      }else if(direction==Direction.EAST){
        d=position+1;
      }
    }else if(position==20){
      if(direction==Direction.EAST){
        d=21;
      }else if(direction==Direction.NORTH){
        d=15;
      }else if(direction==Direction.SOUTH||direction==Direction.WEST){
        d=-1;
      }
    }else if(position==24){
      if(direction==Direction.NORTH){
        d=19;
      }else if(direction==Direction.WEST){
        d=23;
      }else if(direction==Direction.SOUTH||direction==Direction.EAST){
        d=-1;
      }
    }else if(position==6||position==7||position==8||position==11||position==12||position==13||position==16||position==17||position==18){
      if(direction==Direction.EAST){
        d=position+1;
      }else if(direction==Direction.WEST){
        d=position-1;
      }else if(direction==Direction.NORTH){
        d=position-5;
      }else if(direction==Direction.SOUTH){
        d=position+5;
      }
    }
    return d; // TODO Task 8
  }

  /**
   * Return true if positions a and b are neighbours, meaning that
   * they can be reached by one horizontal or one vertical move on
   * the board.
   *
   * @param a A position
   * @param b Another position
   * @return true if the positions are neighbours
   */
  static boolean areNeighbours(int a, int b) {
    boolean bool =true;
    if(a == getNeighbour(b,Direction.SOUTH)||a==getNeighbour(b,Direction.WEST)||a==getNeighbour(b,Direction.EAST)||a==getNeighbour(b,Direction.NORTH)){
      bool = true;
    }else if(a != getNeighbour(b,Direction.SOUTH)||a!=getNeighbour(b,Direction.WEST)||a!=getNeighbour(b,Direction.EAST)||a!=getNeighbour(b,Direction.NORTH)){
      bool=false;
    }
    return bool;// TODO Task 9
  }

  /**
   * Get the direction required to move between neighboring positions
   * src and dst.   For example, if src is 12 and dst is 7, then the
   * direction is NORTH, but if the src is 7 and dst is 12 then direction
   * is SOUTH.
   *
   * @param src The source position (where the movement is from)
   * @param dst The destination position (where the move is to)
   * @return
   */
  static Direction getHeading(int src, int dst) {
    assert areNeighbours(src, dst);
    Direction d = Direction.NORTH.WEST.EAST.SOUTH;
    if(src>dst){
      if(src==dst+1){
        d = Direction.WEST;
      }else if(src==dst+5){
        d= Direction.NORTH;
      }
    }else if(src<dst){
      if(src==dst-1){
        d=Direction.EAST;
      }else if(src==dst-5){
        d=Direction.SOUTH;
      }
    }
    return d; // TODO Task 10
  }

  /**
   * Set the list of positions of all icons reachable from this node
   *
   * @param reachable A list of positions of icons reachable from this node
   */
  public void setReachable(int[] reachable) {
    assert this.icon != null;
    this.reachable = reachable;
  }

  /**
   * Determine whether the given icon is reachable from this node (where
   * this node is an icon).
   *
   * @param other The node whose reachability needs to be determined.
   * @return true if this node is connected to other
   */
  public boolean isConnected(Node other) {
    assert this.icon != null && other.icon != null;
    if (reachable != null) {
      for (int i : reachable) {
        if (i == other.getPosition())
          return true;
      }
    }
    return false;
  }
}
