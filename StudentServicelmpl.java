@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repo;

    public StudentServiceImpl(StudentRepository repo) { this.repo = repo; }

    @Override public Student save(Student s) { return repo.save(s); }
    @Override public List<Student> findAll() { return repo.findAll(); }
    @Override public Student findById(Long id) { return repo.findById(id).orElse(null); }
    @Override public void delete(Long id) { repo.deleteById(id); }
}
