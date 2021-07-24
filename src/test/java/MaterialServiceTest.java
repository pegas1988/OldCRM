import dao.MaterialDao;
import entity.Material;
import org.junit.Before;
import org.junit.Test;
import service.MaterialService;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;

public class MaterialServiceTest {

    private MaterialDao materialDao = mock(MaterialDao.class);
    MaterialService materialService;

    @Before
    public void init() {
        materialService = new MaterialService(materialDao);
    }

    @Test
    public void create_ifNormalDataPasesed() {
        Material material = new Material("Rubber");
        Material material2 = new Material("Iron");

        materialService.createMaterial(material);

        verify(materialDao, times(1)).createNewMaterial(material);
    }

    @Test
    public void delete_ifMaterialEquals() {
        Material material1 = new Material("Wood");
        Material material2 = new Material("Cooper");
        Material material3 = new Material("Glass");

        List<Material> materialList = Arrays.asList(material1, material2, material3);

        when(materialDao.findAll()).thenReturn(materialList);

        materialService.deleteFromMaterial(material1);

        verify(materialDao, times(1)).deleteFromMaterialByName(material1);
    }
}
