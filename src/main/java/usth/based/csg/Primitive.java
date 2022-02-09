package usth.based.csg;

import javafx.scene.shape.MeshView;

/**
 * Primitive interface provides methods to get and set MeshView
 * CSG operations will work via MeshView
 */
public interface Primitive {
    void setMeshView(MeshView meshView);
    MeshView getMeshView();
}
