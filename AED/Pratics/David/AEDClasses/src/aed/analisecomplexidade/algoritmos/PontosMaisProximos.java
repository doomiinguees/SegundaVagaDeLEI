package aed.analisecomplexidade.algoritmos;

import aed.utils.Par;

import java.awt.geom.Point2D;
import java.util.Arrays;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class PontosMaisProximos {
    public static Par<Point2D, Point2D> execute(Point2D... pontos) {
        if (pontos == null || pontos.length < 2) {
            throw new IllegalArgumentException("São necessários pelo menos dois pontos.");
        }
        for (Point2D ponto : pontos) {
            if (ponto == null) {
                throw new IllegalArgumentException("Os pontos não podem ser null.");
            }
        }

        Point2D primeiro = pontos[0];
        Point2D segundo = pontos[1];
        double distanciaMinima = Double.POSITIVE_INFINITY;
        for (int i = 0; i < pontos.length - 1; i++) {
            for (int j = i + 1; j < pontos.length; j++) {
                double px = pontos[i].getX();
                px -= pontos[j].getX();
                double py = pontos[i].getY();
                py -= pontos[j].getY();
                double distancia = Math.sqrt(px * px + py * py);
                if (distancia < distanciaMinima) {
                    distanciaMinima = distancia;
                    primeiro = pontos[i];
                    segundo = pontos[j];
                }

            }
        }
        return new Par<>(primeiro, segundo);
    }

    public static void display(Point2D... points) {
        Par<Point2D, Point2D> par = execute(points);
        System.out.println(
                "\nSequência de " + points.length + " pontos: " +
                Arrays.stream(points)
                    .map(Point2D::toString)
                    .collect(java.util.stream.Collectors.joining())
        );
        System.out.println("Pontos mais próximos: " + par.toString().replace("\n\t(", "\n\t\t("));
        double px = par.getFirst().getX();
        px -= par.getSecond().getX();
        double py = par.getFirst().getY();
        py -= par.getSecond().getY();
        System.out.println("Distância => " + Math.sqrt(px * px + py * py));
        long comparacoes = (long) points.length * (points.length - 1) / 2;
        System.out.println("Comparações entre pontos = " + comparacoes + "\n");
        System.out.println();
    }
}
