package ch.hslu.ad.sw14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class RailwayNet {
    private int numberOfStations;
    private String[] stations;
    private final int[][] adjaMx;
    private static final int MAX = Integer.MAX_VALUE;
    private final int numberOfEdges;
    private final int[][] bestConnectionMatrix;

    RailwayNet(final String[] stations, final int[][] adjaMx) {
        this.numberOfStations = stations.length;
        this.stations = stations;
        this.adjaMx = adjaMx;
        this.numberOfEdges = this.calcNumberOfEdges(adjaMx);
        this.bestConnectionMatrix = this.floydWarshall(adjaMx);
    }

    public String getStationName(final int k) {
        return stations[k];
    }

    public int getNumberOfStations() {
        return numberOfStations;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public boolean checkConnection(final String station1, final String station2) {
        int index1 = Arrays.asList(stations).indexOf(station1);
        int index2 = Arrays.asList(stations).indexOf(station2);
        if (index1 == -1 || index2 == -1) {
            throw new InputMismatchException("Incorrect stations were given");
        }
        if (index1 == index2) {
            throw new InputMismatchException("The station both input stations are the same");
        }
        return adjaMx[index1][index2] != MAX;
    }

    public List<String> findDirectConnections(final String station) {
        int index = Arrays.asList(stations).indexOf(station);
        if (index == -1) {
            throw new InputMismatchException("Incorrect station were given");
        }
        List<String> result = new ArrayList<String>();
        int[] connections = adjaMx[index];
        for (int i = 0; i < connections.length; i++) {
            if (connections[i] != MAX) {
                result.add(stations[i]);
            }
        }
        return result;
    }

    public int getConnectionTime(final String station1, final String station2) {
        int index1 = Arrays.asList(stations).indexOf(station1);
        int index2 = Arrays.asList(stations).indexOf(station2);
        if (index1 == -1 || index2 == -1) {
            throw new InputMismatchException("Incorrect stations were given");
        }
        if (index1 == index2) {
            throw new InputMismatchException("The station both input stations are the same");
        }
        int connection = adjaMx[index1][index2];
        if (connection == MAX) {
            throw new InputMismatchException("The connection does not exist");
        }
        return connection;
    }

    public int getBestConnectionTime(final String station1, final String station2) {
        int index1 = Arrays.asList(stations).indexOf(station1);
        int index2 = Arrays.asList(stations).indexOf(station2);
        if (index1 == -1 || index2 == -1) {
            throw new InputMismatchException("Incorrect stations were given");
        }
        if (index1 == index2) {
            throw new InputMismatchException("The station both input stations are the same");
        }
        return bestConnectionMatrix[index1][index2];
    }

    private static int[][] floydWarshall(int[][] adja) {
        int nodeCount = adja.length;
        int[][] distance = deepCopy(adja);
        for (int k = 0; k < nodeCount; k++) {
            for (int i = 0; i < nodeCount; i++) {
                for (int j = 0; j < nodeCount; j++) {
                    if (distance[i][k] < Integer.MAX_VALUE &&
                            distance[k][j] < Integer.MAX_VALUE &&
                            distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        return distance;
    }

    private int calcNumberOfEdges(final int[][] matrix) {
        int count = 0;
        for (int i = 0; i < numberOfStations; i++) {
            for (int j = 0; j < numberOfStations; j++) {
                if (matrix[i][j] != MAX) {
                    count++;
                }
            }
        }
        return count / 2;
    }

    private static int[][] deepCopy(final int[][] original) {
        if (original == null) {
            return null;
        }
        final int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }
}
