package com.j.u.r;

public class RepositoryTest {
    public static void main(String[] args) {
        Repository repository = new Repository();
        repository.process(process -> {
            TestEntity testEntity = new TestEntity();
            process.addInsert(TestTableOperation.class, testEntity);

            return null;
        });
    }
}
