package com.mygdx.conquerors.maps.pathfinding.algorithms;

import com.mygdx.conquerors.maps.grid.Cell;
import com.mygdx.conquerors.maps.grid.Grid;
import com.mygdx.conquerors.maps.pathfinding.Pathable;
import com.mygdx.conquerors.maps.pathfinding.Pathfinder;

import java.util.*;

/**
 * The Breadth First Search algorithm, implemented with cycle detection, will find
 * the shortest path from the start to the destination if it exists. It does not take
 * into account the weights of cells during the calculation.
 */
public class BFS extends Pathfinder {

    public BFS(Pathable pathable) {
        super(pathable);
    }

    @Override
    public Collection<Cell> findPath(int startX, int startY, int endX, int endY) {

        final Grid grid = pathable.getCollisionGrid();
        final Cell start = grid.getCell(startX, startY);

        if(start == null) {
            System.out.println("Invalid start location...");
            return null;
        }

        final Cell end = grid.getCell(endX, endY);

        if(end == null) {
            System.out.println("Invalid end location...");
            return null;
        }

        LinkedList<Cell> queue = new LinkedList<Cell>();
        HashMap<Cell, Cell> parentMap = new HashMap<Cell, Cell>();
        HashSet<Cell> frontier = new HashSet<Cell>();
        HashSet<Cell> visited = new HashSet<Cell>();
        boolean found = false;

        queue.push(start);
        visited.add(start);
        frontier.add(start);

        while(!queue.isEmpty() && !found) {
            Cell current = queue.pop();
            frontier.remove(current);
            visited.add(current);

            if(current.equals(end)) {
                found = true;
                break;
            }

            for(Cell neighbor : grid.getNeighbors(current)) {
                if(visited.contains(neighbor))
                    continue;

                if(frontier.contains(neighbor))
                    continue;

                parentMap.put(neighbor, current);
                frontier.add(neighbor);
                queue.push(neighbor);
            }
        }

        if(!found) {
            System.out.println("Couldn't find path...");
            return null;
        }

        ArrayList<Cell> reversePath = new ArrayList<Cell>();
        Cell current = end;
        while(current != start) {
            reversePath.add(current);
            current = parentMap.get(current);
        }

        Collection<Cell> path = new LinkedList<Cell>();
        for(int i = reversePath.size() - 1; i >= 0; i--) {
            path.add(reversePath.get(i));
        }

        return path;
    }
}
