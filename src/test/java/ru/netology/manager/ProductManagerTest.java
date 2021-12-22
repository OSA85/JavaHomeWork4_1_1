package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);


    Book book1 = new Book(1, "Стихи", 100, "Ахматова");
    Book book2 = new Book(2, "Стихи", 150, "Пушкин");
    Book book3 = new Book(3, "Проза", 150, "Пушкин");
    Book book4 = new Book(4, "Война и мир", 500, "Толстой");
    Book book5 = new Book(5, "Мастер и Маргарита", 2000, "Булгаков");
    Book book6 = new Book(11, "Путь Samsung. Стратегии управления изменениями...",
            2000, "Сонг Дж., Ли К.");
    Smartphone phone1 = new Smartphone(6, "Iphone 13", 100000, "Apple");
    Smartphone phone2 = new Smartphone(7, "Galaxy S21", 90000, "Samsung");
    Smartphone phone3 = new Smartphone(8, "Iphone 12", 80000, "Apple");
    Smartphone phone4 = new Smartphone(9, "Poco M3 Pro", 20000, "Xiaomi");
    Smartphone phone5 = new Smartphone(10, "Nova 8i 6", 20000, "Huawei");


    @Test
    public void shouldEmptySearchForSmartphoneCompany() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(book5);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);
        repository.save(phone4);
        repository.save(phone5);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Motorola");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldEmptySearchForBookAuthor() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(book5);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);
        repository.save(phone4);
        repository.save(phone5);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Лермонтов");

        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldOneSmartphoneForCompany() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(book5);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);
        repository.save(phone4);
        repository.save(phone5);

        Product[] expected = {phone4};
        Product[] actual = manager.searchBy("Xiaomi");

        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFewSmartphoneForCompany() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(book5);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);
        repository.save(phone4);
        repository.save(phone5);

        Product[] expected = {phone1, phone3};
        Product[] actual = manager.searchBy("Apple");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFewSmartphoneForName() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(book5);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);
        repository.save(phone4);
        repository.save(phone5);

        Product[] expected = {phone1, phone3};
        Product[] actual = manager.searchBy("Iphone");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFewBookForName() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(book5);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);
        repository.save(phone4);
        repository.save(phone5);

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("Стихи");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOneBookForAuthor() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(book5);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);
        repository.save(phone4);
        repository.save(phone5);

        Product[] expected = {book5};
        Product[] actual = manager.searchBy("Булгаков");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchForSamsung() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(book5);
        repository.save(book6);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);
        repository.save(phone4);
        repository.save(phone5);

        Product[] expected = {book6, phone2};
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
    }

}