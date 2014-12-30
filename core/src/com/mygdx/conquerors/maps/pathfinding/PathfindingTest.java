package com.mygdx.conquerors.maps.pathfinding;

import com.mygdx.conquerors.maps.gameMap.ConquerorsMap;
import com.mygdx.conquerors.maps.grid.Cell;
import com.mygdx.conquerors.maps.pathfinding.algorithms.BFS;
import com.mygdx.conquerors.maps.pathfinding.algorithms.UCS;
import com.mygdx.conquerors.utils.PathPrinter;

import java.util.Collection;

/**
 * Created by Lucas on 12/7/2014.
 */
public class PathfindingTest {

    public static void main(String[] args) {
        ConquerorsMap map = new ConquerorsMap(8, 8);
        //BFS algorithm = new BFS(map);
        UCS algorithm = new UCS(map);
        Collection<Cell> path = algorithm.findPath(0, 0, 2, 7);

        //for(Cell cell : path) {
        //    System.out.println(cell);
        //}

        //PathPrinter.printPath(map, path, new Cell(0, 0));
    }

}
