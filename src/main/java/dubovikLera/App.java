package dubovikLera;

import dubovikLera.dao.FavoritesDao;
import dubovikLera.dao.ProductsDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FavoritesDao favoritesDao = FavoritesDao.getInstance();
        System.out.println(favoritesDao.getAll());

        System.out.println();
        ProductsDao productsDao = ProductsDao.getInstance();
        System.out.println(productsDao.findById(2));
    }
}
