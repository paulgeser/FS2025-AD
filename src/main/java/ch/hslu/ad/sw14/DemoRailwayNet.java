package ch.hslu.ad.sw14;

public class DemoRailwayNet {

    public static void main(String[] args) {
        String[] nodes = {"Olten", "Aarau", "Brugg", "Lenzburg", "Dietikon", "Zürich", "Wohlen", "Zoffingen", "Luzern", "Rotkreuz", "Arth-Goldau", "Zug", "Pfäffikon"};
        int m = Integer.MAX_VALUE;
        int[][] adjaMX = {
                {m, 13, m, m, m, 36, m, 7, m, m, m, m, m},
                {13, m, 13, 8, m, m, m, m, m, m, m, m, m},
                {m, 13, m, 16, 16, m, m, m, m, m, m, m, m},
                {m, 8, 16, m, 19, 19, 9, 34, 80, m, m, m, m},
                {m, m, 16, 19, m, 12, 30, m, m, m, m, m, m},
                {36, m, m, 19, 12, m, m, m, m, m, m, 25, 30},
                {m, m, m, 9, 30, m, m, m, m, 23, m, m, m},
                {7, m, m, 34, m, m, m, m, 35, m, m, m, m},
                {m, m, m, 80, m, m, m, 35, m, 16, 30, m, m},
                {m, m, m, m, m, m, 23, m, 16, m, 15, 12, m},
                {m, m, m, m, m, m, m, m, 30, 15, m, 20, 39},
                {m, m, m, m, m, 25, m, m, m, 12, 20, m, m},
                {m, m, m, m, m, 30, m, m, m, m, 39, m, m}
        };
        RailwayNet network = new RailwayNet(nodes, adjaMX);

        System.out.println(network.getNumberOfStations());
        System.out.println(network.getNumberOfEdges());
        System.out.println(network.checkConnection("Olten", "Aarau"));
        System.out.println(network.checkConnection("Olten", "Brugg"));
        System.out.println(network.checkConnection("Olten", "Lenzburg"));
        System.out.println(network.findDirectConnections("Lenzburg"));
        System.out.println(network.getBestConnectionTime("Zürich", "Luzern"));
    }
}
