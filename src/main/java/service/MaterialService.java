package service;

import dao.MaterialDao;
import entity.Material;

import java.util.List;

public class MaterialService {
    MaterialDao materialDao = new MaterialDao();

    public void createMaterial(Material material) {
        materialDao.createNewMaterial(material);
    }

    public void deleteFromMaterial(Material material) {
        materialDao.deleteFromMaterialByName(material);
    }

    public List<Material> findAllMaterials() {
        return materialDao.findAll();
    }

    public List<Material> findByType(String type) {
        return materialDao.findByType(type);
    }

    public int getMaterialIDByName(Material material) {
        return materialDao.materialID(material);
    }
}
