package ch.g_7.grid_runner.game_objects;

import ch.g_7.graphite.base.mesh.IMesh;
import ch.g_7.graphite.base.mesh.MeshBuilder2d;
import ch.g_7.graphite.base.mesh.MeshFactory2d;
import ch.g_7.graphite.entity.Entity;

public class GameObject extends Entity {

    private static final IMesh SQUARE_MASH = MeshFactory2d.getSquare(1).setCenter(MeshBuilder2d.CENTER_TOP_LEFT).build();

    public GameObject() {
        getViewModel().setMesh(SQUARE_MASH);
    }


}
