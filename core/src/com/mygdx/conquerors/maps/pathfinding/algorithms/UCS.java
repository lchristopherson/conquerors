package com.mygdx.conquerors.maps.pathfinding.algorithms;

import com.mygdx.conquerors.maps.grid.Cell;
import com.mygdx.conquerors.maps.grid.PathingGrid;
import com.mygdx.conquerors.maps.grid.TerrainGrid;
import com.mygdx.conquerors.maps.pathfinding.Pathable;
import com.mygdx.conquerors.maps.pathfinding.Pathfinder;

import java.util.*;

/**
 * Created by Lucas on 12/7/2014.
 */
public class UCS extends Pathfinder {

    public UCS(Pathable pathable) {
        super(pathable);
    }

    @Override
    public Collection<Cell> findPath(int startX, int startY, int endX, int endY) {

        final PathingGrid pathingGrid = pathable.getCollisionGrid();
        final TerrainGrid terrainGrid = pathable.getWeightedGrid();
        final Cell start = pathingGrid.getCell(startX, startY);

        if(start == null) {
            System.out.println("Invalid start location...");
            return null;
        }

        final Cell end = pathingGrid.getCell(endX, endY);

        if(end == null) {
            System.out.println("Invalid end location...");
            return null;
        }

        PriorityQueue<CellWeightPair> queue = new PriorityQueue<CellWeightPair>();
        HashSet<Cell> visited = new HashSet<Cell>();
        HashSet<Cell> frontier = new HashSet<Cell>();
        HashMap<Cell, Cell> parentMap = new HashMap<Cell, Cell>();
        //HashMap<Cell, Float> costMap = new HashMap<Cell, Float>();

        Cell currentCell = null;
        int currentWeight = 0;
        CellWeightPair currentPair = null;
        boolean found = false;

        queue.add(new CellWeightPair(start, 0));
        frontier.add(start);
        //costMap.put(start, 0f);

        while(!queue.isEmpty() && !found) {
            CellWeightPair current = queue.poll();
            currentCell = current.cell;
            currentWeight = current.weight;
            frontier.remove(currentCell);
            visited.add(currentCell);

            if(currentCell.equals(end)) {
                found = true;
                break;
            }

            for(Cell neighbor : pathingGrid.getNeighbors(currentCell)) {
                if(visited.contains(neighbor))
                    continue;

                int weight = currentWeight + terrainGrid.getWeight(currentCell.x(), currentCell.y(),
                                                                            neighbor.x(), neighbor.y());

                if(frontier.contains(neighbor) && weight > currentWeight)
                    continue;

                currentPair = new CellWeightPair(neighbor, weight);
                queue.remove(currentPair);
                queue.add(currentPair);
                frontier.add(neighbor);
                parentMap.put(neighbor, currentCell);
            }
        }

        if(!found) {
            System.out.println("No path found...");
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

    private class CellWeightPair implements Comparable {

        public final Cell cell;
        public final int weight;

        public CellWeightPair(Cell cell, int weight) {
            this.cell = cell;
            this.weight = weight;
        }


        @Override
        public int compareTo(Object o) {

            if(o == null)
                throw new NullPointerException();

            if(!(o instanceof CellWeightPair))
                throw new ClassCastException();

            CellWeightPair pair = (CellWeightPair)o;

            return weight - pair.weight;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CellWeightPair that = (CellWeightPair) o;

            if (!cell.equals(that.cell)) return false;

            return true;
        }
    }
}
