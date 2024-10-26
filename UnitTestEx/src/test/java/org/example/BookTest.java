package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class BookTest {

    @Test
    public void testBookEqual() {
        Book b1 = new Book("1984", "George Orwell", 1949);
        Book b2 = new Book("1984", "George Orwell", 1949);
        Book b3 = new Book("Brave New World", "Aldous Huxley", 1932);

        //books with same content
        assertEquals(b1, b2, "Books with identical properties should be equal");

        //different content are not equal
        assertNotEquals(b1, b3, "Books with different properties should not be equal");
    }

    @Test
    public void testBookEqualHamcrest() {
        Book b1 = new Book("1984", "George Orwell", 1949);
        Book b2 = new Book("1984", "George Orwell", 1949);

        //Hamcrest compare
        assertThat(b1, samePropertyValuesAs(b2));
    }
}
