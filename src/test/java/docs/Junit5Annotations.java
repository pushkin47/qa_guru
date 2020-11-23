package docs;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Junit5Annotations {

    @BeforeAll
    static void Before() {
        System.out.println("Я выполняюсь один раз перед всеми тестами. Например, проверяю роли пользователя и получаю токены.");
    }

        @BeforeEach
        void BeforeEach() {
            System.out.println("Я выполняюсь перед каждым тестом");
        }

            @Test
            @DisplayName("First test")
            @Order(1)
            void SomeTest() {
                System.out.println("Первый тест");
                assertTrue(true);
            }

            @Test
            @DisplayName("Another test")
            @Order(2)
            void AnotherTest() {
                System.out.println("Второй тест!");
                assertTrue(true);
            }

        @AfterEach
        void AfterEach() {
            System.out.println("Я выполняюсь после каждого теста");
        }

    @AfterAll
    static void ShutDown() {
        System.out.println("Я выполняюсь один раз после всех тестов. Например, удаляю созданные вызовы");
    }
}
