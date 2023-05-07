package ru.netology.project;

public class ShopRepository {
    private Product[] products = new Product[0];

    //    Вспомогательный метод для имитации добавления элемента в массив
    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    // Метод добавления товара в репозиторий, param product — добавляемый товар
    public void add(Product product, int id) {
        if (findById(id) != null) {
            throw new NotFoundException(
                    "ID уже существует: " + id
            );
        }
        products = addToArray(products, product);
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "ID не найден: " + id
            );
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
            products = tmp;
        }
    }
}
