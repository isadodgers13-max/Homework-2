@DataJpaTest
public class StudentRepositoryTest {
    @Autowired StudentRepository repo;
    @Test
    void savesAndFindsStudent() {
        Student s = new Student();
        s.setFirstName("Test");
        s.setLastName("User");
        repo.save(s);
        assertThat(repo.findAll()).isNotEmpty();
    }
}
