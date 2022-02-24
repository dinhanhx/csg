package usth.based.csg;

import javafx.scene.shape.TriangleMesh;

public class Operation {
    /**
     * Union operator
     * @param tm1 TriangleMesh
     * @param tm2 TriangleMesh
     * @return TriangleMesh
     */
    public static TriangleMesh union(TriangleMesh tm1, TriangleMesh tm2) {
        TriangleMesh um = new TriangleMesh(); // UnionMesh

        // Add all Points
        um.getPoints().addAll(tm1.getPoints());
        um.getPoints().addAll(tm2.getPoints());

        // Add all TexCoords
        um.getTexCoords().addAll(tm1.getTexCoords());
        um.getTexCoords().addAll(tm2.getTexCoords());
        // Add all Faces
        // https://stackoverflow.com/a/30334473/13358358
        um.getFaces().addAll(tm1.getFaces());
        int num_points = tm1.getPoints().size() / 3;
        for (int i = 0; i < tm2.getFaces().size(); i++) {
            if (i % 2 == 0) {
                tm2.getFaces().set(i, num_points+tm2.getFaces().get(i));
            }
        }
        um.getFaces().addAll(tm2.getFaces());
        return um;
    }
}
