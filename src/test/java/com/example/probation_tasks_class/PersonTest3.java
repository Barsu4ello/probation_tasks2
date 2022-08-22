package com.example.probation_tasks_class;

import com.example.probation_tasks.test_class.Calculator;
import com.example.probation_tasks.test_class.Person;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.ArgumentMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.spy;


@ExtendWith(MockitoExtension.class)
public class PersonTest3 {

    static int testCount;
    @Mock
    static List<Person> list;

    @BeforeAll
//    @BeforeClass
    static void createPersonList() {
        System.out.println("Tests is started");
//        list = Mockito.mock(ArrayList.class);
    }

    @BeforeEach
    //@Before
    void improveTestCount9() {
        testCount++;
    }

    @AfterEach
        //@After
    void showTestCount(){
        System.out.println(testCount);
    }

    @AfterAll
    //@AfterClass
    static void showEndMessage() {
        System.out.println("Tests finished");
    }

    @Test
    void shouldCheckFirstPersonName() {
        Mockito.when(list.get(0)).thenReturn(new Person(12,"Vasya"));
        Assertions.assertEquals("Vasya", list.get(0).getName());
    }

    @Test
    void shouldCheckFirstPersonAge() {
        System.out.println(list.get(0));
        Mockito.when(list.get(0)).thenReturn(new Person(12,"Vasya"));
        Assertions.assertEquals(12, list.get(0).getAge());
    }

    @Test
    void shouldCheckCallListGetMethod() {
        Mockito.when(list.get(anyInt())).thenReturn(new Person(12,"Vasya"));
        Assertions.assertEquals("Vasya", list.get(5).getName());
        Mockito.verify(list).get(anyInt());
    }

    @Test
    void shouldCheckDataAllPersons() {
        Mockito.when(list.get(anyInt())).thenReturn(new Person(12,"Vasya"));
        for (int i = 0; i < 4; i++) {
            Assertions.assertEquals("Vasya", list.get(i).getName());
        }
//        Mockito.verify(list).get(anyInt());
//        Mockito.verify(list,Mockito.times(100)).get(anyInt());
    }

    @Test
    void shouldThrowRuntimeException() {
        Mockito.when(list.get(anyInt())).thenThrow(RuntimeException.class);
        Assertions.assertThrows(RuntimeException.class,
                () -> list.get(2));
    }

    @Test
    void shouldThrowRuntimeException1() {
//        Person person = Mockito.mock(Person.class);
//        Mockito.when(person.age).thenReturn(5);
//        System.out.println(person.age);
    }

    @Test
    void shouldCheckFirstPersonAgeWithSpy() {
       Person person = spy(new Person(11,"Vlad"));
       Mockito.when(person.getAge()).thenReturn(10);
       Assertions.assertEquals(10, person.getAge());
       Assertions.assertEquals(11, person.age);
    }
}
