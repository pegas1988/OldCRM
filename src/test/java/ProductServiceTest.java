import dao.ProductDao;
import entity.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.MockitoJUnitRunner;
import service.ProductService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    private ProductDao productDao = mock(ProductDao.class);
    private ProductService productService;

    @Captor
    private ArgumentCaptor<Product> argumentCaptor;

    @Before
    public void init() {
        productService = new ProductService(productDao);
    }

    @Test
    public void save_withArgumentCaptor() {
        Product product = new Product("Car", 5);
        Product product1 = new Product("Car", 3);
        Product product2 = new Product("Motorcycle", 4);

        productService.createProduct(product);

        verify(productDao, times(1)).create(argumentCaptor.capture());
        Product testedProduct = argumentCaptor.getValue();

        assertEquals("Car", testedProduct.getProductName());
        assertEquals(5, testedProduct.getTimeToProduce());
    }

    @Test
    public void findByID_DifferentIds() {
        Product product1 = new Product("Car", 5);
        Product product2 = new Product("Car", 3);
        Product product3 = new Product("Motorcycle", 4);

        when(productDao.findById(eq(1))).thenReturn(product1);
        when(productDao.findById(eq(2))).thenReturn(product2);
        when(productDao.findById(eq(3))).thenReturn(product3);

        Product productTest1 = productDao.findById(1);
        Product productTest2 = productDao.findById(2);
        Product productTest3 = productDao.findById(3);

        assertEquals(product1, productTest1);
        assertEquals(product2, productTest2);
        assertEquals(product3, productTest3);

    }
}
