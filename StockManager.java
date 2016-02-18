import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        if(findProduct(item.getID())==null)
        {
            stock.add(item);
        }
        else
        {
            System.out.println("Error! Ya existe un item con ese ID");
        }
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product producto = findProduct(id);
        if(producto != null) {
            producto.increaseQuantity(amount);
        }
        else
        {
            System.out.println("El ID introducido no se corresponde con ningun producto.");
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        boolean encontrado = false;
        int index = 0;
        Product producto = null;
        while(index < stock.size() && !encontrado) {
            if(stock.get(index).getID() == id) {
                producto = stock.get(index);
                encontrado = true;
            }
            index ++;
        }
        return producto;

    }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        Product producto = findProduct(id);
        int stockDelItem = 0;
        if(producto != null) {
            stockDelItem = producto.getQuantity();
        } 
        return stockDelItem;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        if(stock.size() > 0)
        {
            for(Product product : stock) 
            {
                System.out.println(product);
            }
        }
        else
        {
            System.out.println("No hay ningun producto.");
        }
    }

    /**
     * Metodo que imprime por pantalla los detalles de los productos que estan por debajo del stock limite pasado por parametro
     */
    public void underGivenNumberInStock(int limite)
    {
        for(Product producto : stock) 
        {
            if(producto.getQuantity() < limite)
            {
                System.out.println(producto);
            }
        }
    }
    
    /**
     * Metodo para buscar un producto de todos los que tenemos pasando como parametro el nombre del producto.
     */
    public Product findProduct(String name)
    {
        boolean encontrado = false;
        int index = 0;
        Product producto = null;
        while(index < stock.size() && !encontrado) {
            if(stock.get(index).getName().equals(name)) {
                producto = stock.get(index);
                encontrado = true;
            }
            index ++;
        }
        return producto;
    }
}
