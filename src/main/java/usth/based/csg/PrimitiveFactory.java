package usth.based.csg;

import javafx.geometry.Point3D;

import java.util.ArrayList;

public class PrimitiveFactory {
    public Primitive makePrimitive(String type) {
        if (type.equalsIgnoreCase("SPHERE")) {
            return new Sphere(1, Point3D.ZERO);
        }

        if (type.equalsIgnoreCase("CUBE")) {
            return new Cube(1, Point3D.ZERO);
        }

        if (type.equalsIgnoreCase("CYLINDER")) {
            return new Cylinder(1, 1, Point3D.ZERO);
        }

        if (type.equalsIgnoreCase("PYRAMID")) {
            return new Pyramid(1, Point3D.ZERO);
        }

        if (type.equalsIgnoreCase("PARALLELEPIPED")) {
            ArrayList<Point3D> vertices = new ArrayList<>();
            vertices.add(Point3D.ZERO);
            vertices.add(new Point3D(1, 0, 0));
            vertices.add(new Point3D(0, 1, 0));
            vertices.add(new Point3D(0, 0, 1));
            return new Parallelepiped(vertices);
        }
        return null;
    }
}
