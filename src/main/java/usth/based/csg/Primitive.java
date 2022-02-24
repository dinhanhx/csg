package usth.based.csg;

import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

/**
 * Primitive interface provides methods to get and set MeshView
 * CSG operations will work via MeshView
 */
public interface Primitive {
    TriangleMesh getTriangleMesh();
}
