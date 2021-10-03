package service;


import dao.MaterialDao;
import entity.Material;

import java.util.List;

public class MaterialService {
    MaterialDao materialDao = new MaterialDao();

    public MaterialService() {
    }

    public MaterialService(MaterialDao materialDao) {
        this.materialDao = materialDao;
    }


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

    public void updateMaterial(Material material, int id) {
        materialDao.updateMaterial(material, id);
    }

    public int getMaterialIDByName(Material material) {
        return materialDao.materialID(material);
    }
}
