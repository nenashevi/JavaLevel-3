package hw_1;

public class B {
    @BeforeSuite
    public void mFirst () {
        System.out.println("Метод mFirst в классе B выполнился");
    }

    @BeforeSuite
    public void mFirst2 () {
        System.out.println("Метод mFirst выполнился");
    }

    @Test (runPriority = 2)
    public void m_1 () {
        System.out.println("Метод m_1 в классе B выполнился");
    }
    @Test (runPriority = 3)
    public void m_2 () {
        System.out.println("Метод m_2 в классе B выполнился");
    }

    @Test (runPriority = 1)
    public void m_3 () {
        System.out.println("Метод m_3 в классе B выполнился");
    }

    @AfterSuite
    public void mLast () {
        System.out.println("Метод mLast в классе B выполнился");
    }
}
